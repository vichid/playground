package com.example.uicompose.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

open class PreviewParameterPairPermutation<TFirst, TSecond>(
    first: PreviewParameterProvider<TFirst>,
    private val second: PreviewParameterProvider<TSecond>,
) : PreviewParameterProvider<Pair<TFirst, TSecond>> {
    override val values = first.values.flatMap { firstValue ->
        second.values.map { secondValue ->
            firstValue to secondValue
        }
    }
}

open class PreviewParameterTriplePermutation<TFirst, TSecond, TThird>(
    first: PreviewParameterProvider<TFirst>,
    private val second: PreviewParameterProvider<TSecond>,
    private val third: PreviewParameterProvider<TThird>,
) : PreviewParameterProvider<Triple<TFirst, TSecond, TThird>> {
    override val values = first.values.flatMap { firstValue ->
        second.values.flatMap { secondValue ->
            third.values.map { thirdValue ->
                Triple(firstValue, secondValue, thirdValue)
            }
        }
    }
}
