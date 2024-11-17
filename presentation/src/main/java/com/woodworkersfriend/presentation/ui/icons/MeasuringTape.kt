package com.woodworkersfriend.presentation.ui.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

public val Measuring_tape: ImageVector
    get() {
        if (_Measuring_tape != null) {
            return _Measuring_tape!!
        }
        _Measuring_tape = ImageVector.Builder(
            name = "Measuring_tape",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
            path(
                fill = SolidColor(Color.Black),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(200f, 800f)
                verticalLineToRelative(-340f)
                quadToRelative(0f, -142f, 99f, -241f)
                reflectiveQuadToRelative(241f, -99f)
                reflectiveQuadToRelative(241f, 99f)
                reflectiveQuadToRelative(99f, 241f)
                reflectiveQuadToRelative(-99f, 241f)
                reflectiveQuadToRelative(-241f, 99f)
                close()
                moveToRelative(80f, -80f)
                horizontalLineToRelative(260f)
                quadToRelative(108f, 0f, 184f, -76f)
                reflectiveQuadToRelative(76f, -184f)
                reflectiveQuadToRelative(-76f, -184f)
                reflectiveQuadToRelative(-184f, -76f)
                reflectiveQuadToRelative(-184f, 76f)
                reflectiveQuadToRelative(-76f, 184f)
                close()
                moveToRelative(260f, -120f)
                quadToRelative(58f, 0f, 99f, -41f)
                reflectiveQuadToRelative(41f, -99f)
                reflectiveQuadToRelative(-41f, -99f)
                reflectiveQuadToRelative(-99f, -41f)
                reflectiveQuadToRelative(-99f, 41f)
                reflectiveQuadToRelative(-41f, 99f)
                reflectiveQuadToRelative(41f, 99f)
                reflectiveQuadToRelative(99f, 41f)
                moveToRelative(0f, -80f)
                quadToRelative(-25f, 0f, -42.5f, -17.5f)
                reflectiveQuadTo(480f, 460f)
                reflectiveQuadToRelative(17.5f, -42.5f)
                reflectiveQuadTo(540f, 400f)
                reflectiveQuadToRelative(42.5f, 17.5f)
                reflectiveQuadTo(600f, 460f)
                reflectiveQuadToRelative(-17.5f, 42.5f)
                reflectiveQuadTo(540f, 520f)
                moveTo(80f, 800f)
                verticalLineToRelative(-200f)
                horizontalLineToRelative(80f)
                verticalLineToRelative(200f)
                close()
                moveToRelative(460f, -340f)
            }
        }.build()
        return _Measuring_tape!!
    }

private var _Measuring_tape: ImageVector? = null
