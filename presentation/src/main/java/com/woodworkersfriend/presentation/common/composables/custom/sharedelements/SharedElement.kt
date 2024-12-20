package com.woodworkersfriend.presentation.common.composables.custom.sharedelements

/*
This file is taken from https://github.com/mxalbert1996/compose-shared-elements
which has been released under the following license:

MIT License
Copyright (c) 2021 Albert Chang

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */

import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.round
import androidx.compose.ui.zIndex

@Composable
fun SharedElement(
    key: Any,
    screenKey: Any,
    isFullscreen: Boolean = false,
    transitionSpec: SharedElementsTransitionSpec = DefaultSharedElementsTransitionSpec,
    onFractionChanged: ((Float) -> Unit)? = null,
    placeholder: @Composable (() -> Unit)? = null,
    content: @Composable () -> Unit
) {
    val elementInfo = remember(key, screenKey, transitionSpec, onFractionChanged) {
        SharedElementInfo(key, screenKey, transitionSpec, onFractionChanged)
    }
    val realPlaceholder = placeholder ?: content
    BaseSharedElement(
        elementInfo,
        isFullscreen,
        realPlaceholder,
        { Placeholder(it) },
        { ElementContainer(modifier = it, content = content) }
    )
}

@Composable
private fun Placeholder(state: SharedElementsTransitionState) {
    with(LocalDensity.current) {
        val fraction = state.fraction
        val startBounds = state.startBounds
        val endBounds = state.endBounds

        val fadeFraction = state.spec?.fadeProgressThresholds?.applyTo(fraction) ?: fraction
        val scaleFraction = state.spec?.scaleProgressThresholds?.applyTo(fraction) ?: fraction

        val startScale = if (startBounds == null) Identity else
            calculateScale(startBounds, endBounds, scaleFraction)
        val offset = if (startBounds == null) IntOffset.Zero else calculateOffset(
            startBounds, endBounds,
            fraction, state.pathMotion,
            startBounds.width * startScale.scaleX
        ).round()

        @Composable
        fun Container(
            compositionLocalValues: CompositionLocalValues,
            bounds: Rect?,
            scaleX: Float,
            scaleY: Float,
            isStart: Boolean,
            content: @Composable () -> Unit,
            zIndex: Float = 0f,
        ) {
            val alpha = if (bounds == null) 1f else
                calculateAlpha(state.direction, state.spec?.fadeMode, fadeFraction, isStart)
            if (alpha > 0) {
                val modifier = if (bounds == null) {
                    Fullscreen.layoutId(FullscreenLayoutId)
                } else {
                    Modifier.size(
                        bounds.width.toDp(),
                        bounds.height.toDp()
                    ).offset { offset }.graphicsLayer {
                        this.transformOrigin = TopLeft
                        this.scaleX = scaleX
                        this.scaleY = scaleY
                        this.alpha = alpha
                    }.run {
                        if (zIndex == 0f) this else zIndex(zIndex)
                    }
                }

                compositionLocalValues.Provider {
                    ElementContainer(
                        modifier = modifier,
                        content = content
                    )
                }
            }
        }

        for (i in 0..1) {
            val info = if (i == 0) state.startInfo else state.endInfo ?: break
            key(info.screenKey) {
                val (scaleX, scaleY) = if (i == 0) startScale else
                    calculateScale(endBounds!!, startBounds, 1 - scaleFraction)
                Container(
                    compositionLocalValues = if (i == 0) {
                        state.startCompositionLocalValues
                    } else {
                        state.endCompositionLocalValues!!
                    },
                    bounds = if (i == 0) startBounds else endBounds,
                    scaleX = scaleX,
                    scaleY = scaleY,
                    isStart = i == 0,
                    content = if (i == 0) state.startPlaceholder else state.endPlaceholder!!,
                    zIndex = if (i == 1 && state.spec?.fadeMode == FadeMode.Out) -1f else 0f
                )
            }
        }
    }
}
