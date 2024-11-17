package com.woodworkersfriend.presentation.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

sealed interface Screen : Parcelable {

    @Parcelize
    object BoardFootCalculator : Screen

    @Parcelize
    object FunctionsList : Screen

//    @Parcelize
//    data class PortfolioDetail(val portfolioDetailMainData: PortfolioDetailUiItem) : Screen

//    @Parcelize
//    data class SecurityDetail(
//        val portfolioDetailMainUiData: PortfolioDetailUiItem,
//        val securityDetailMainData: SecurityDetailUiItem
//    ) : Screen

    @Parcelize
    object UnitConversion : Screen

    @Parcelize
    object Settings : Screen

//    @Parcelize
//    object Help : Screen

//    @Parcelize
//    object About : Screen

}