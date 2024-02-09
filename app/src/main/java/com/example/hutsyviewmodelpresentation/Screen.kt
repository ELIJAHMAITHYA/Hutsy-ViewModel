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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun Elements(
    modifier: Modifier = Modifier
        .padding(20.dp)
        .fillMaxWidth(),
    viewModel: ViewModel = viewModel(),
) {
    val vmPresentation by viewModel.uiState.collectAsState()
    Column(
        modifier = Modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "Hutsy ViewModel Dummy",
            fontSize = 25.sp,
        )
        animatedCounter(counter = vmPresentation.number)
        Button(
            onClick = {
                viewModel.add3()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp),
            shape = RoundedCornerShape(8.dp),
        ) {
            Text(text = "+ 3 ")
        }
        Button(
            onClick = {
                viewModel.minus3()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp),
            shape = RoundedCornerShape(8.dp),
        ) {
            Text(text = " -3 ")
        }
        Button(
            onClick = {
                viewModel.mutliply3()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp),
            shape = RoundedCornerShape(8.dp),
        ) {
            Text(text = "X3")
        }
        Button(
            onClick = {
                viewModel.reset()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp),
            shape = RoundedCornerShape(8.dp),
        ) {
            Text(text = "Reset")
        }
    }
}
