package com.example.hutsyviewmodelpresentation

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.scaleIn
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.with
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun animatedCounter(
    counter: Float,
    modifier: Modifier = Modifier,
) {
    var oldCount by remember {
        mutableStateOf(counter)
    }
    SideEffect {
        oldCount = counter
    }
    Row(modifier = modifier) {
        val countString = counter.toString()
        val oldCountString = oldCount.toString()

        for (i in countString.indices) {
            val oldChar = oldCountString.getOrNull(i)
            val newChar = countString[i]
            val char = if (oldChar == newChar) {
                oldCountString[i]
            } else {
                countString[i]
            }
            AnimatedContent(
                targetState = char,
                transitionSpec = {
//                    slideInVertically { it }
                    scaleIn(animationSpec = tween(durationMillis = 500)) with slideOutVertically { it }
                },
                label = "",
            ) { char ->
                Text(
                    text = char.toString(),
                    style = MaterialTheme.typography.titleLarge,
                    softWrap = false,
                    color = Color.Blue,
                    fontSize = 50.sp,

                )
            }
        }
    }
}
