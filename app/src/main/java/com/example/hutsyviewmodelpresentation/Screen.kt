package com.example.hutsyviewmodelpresentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.hutsyviewmodelpresentation.ui.theme.HutsyViewModelPresentationTheme

@Composable
fun ElementsScreen(
    modifier: Modifier = Modifier,
    viewModel: EffectViewModel = viewModel(),
) {
    val elementScreenState by viewModel.uiState.collectAsState()
    ElementScreenContent(
        number = elementScreenState.number,
        onAdd3Clicked = viewModel::add3,
        onminus3Clicked = viewModel::minus3,
        onmultiply3Clicked = viewModel::mutliply3,
        onresetClicked = viewModel::reset,
    )
}

@Composable
fun ElementScreenContent(
    modifier: Modifier = Modifier,
    number: Float,
    onAdd3Clicked: () -> Unit,
    onminus3Clicked: () -> Unit,
    onmultiply3Clicked: () -> Unit,
    onresetClicked: () -> Unit,

) {
    Column(
        modifier = modifier
            .padding(20.dp)
            .fillMaxWidth()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "Hutsy ViewModel Dummy",
            fontSize = 25.sp,
        )
        animatedCounter(counter = number)
        Button(
            onClick = onAdd3Clicked,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp),
            shape = RoundedCornerShape(8.dp),
        ) {
            Text(text = "+ 3 ")
        }
        Button(
            onClick = onminus3Clicked,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp),
            shape = RoundedCornerShape(8.dp),
        ) {
            Text(text = " -3 ")
        }
        Button(
            onClick = onmultiply3Clicked,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp),
            shape = RoundedCornerShape(8.dp),
        ) {
            Text(text = "X3")
        }
        Button(
            onClick = onresetClicked,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp),
            shape = RoundedCornerShape(8.dp),
        ) {
            Text(text = "Reset")
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ElementScreenPreview() {
    HutsyViewModelPresentationTheme {
        ElementScreenContent(
            number = 3.0F,
            onAdd3Clicked = { },
            onminus3Clicked = {  },
            onmultiply3Clicked = { },
            onresetClicked = {},
        )
    }
}
