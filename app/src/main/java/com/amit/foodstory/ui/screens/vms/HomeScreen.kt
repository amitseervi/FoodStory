package com.amit.foodstory.ui.screens.vms

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.amit.foodstory.ui.theme.FoodStoryTheme

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    val homeViewModel: HomeViewModel = viewModel()
    val uiState = homeViewModel.uiState.collectAsState()
    FoodStoryTheme {
        HomeScreenContent(
            modifier = modifier,
            uiState = uiState.value,
            onButtonClick = homeViewModel::onCounterButtonClicked
        )
    }

}


@Composable
fun HomeScreenContent(
    modifier: Modifier = Modifier,
    uiState: HomeUiState,
    onButtonClick: () -> Unit
) {
    Column(
        modifier = modifier.background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Counter Value is ${uiState.counterValue}",
            color = MaterialTheme.colorScheme.onBackground
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = onButtonClick) {
            Text(text = "Increase Counter")
        }
    }
}


@Composable
@Preview
fun PreviewHomeScreen() {
    FoodStoryTheme {
        HomeScreenContent(modifier = Modifier.fillMaxSize(),
            uiState = HomeUiState(2),
            onButtonClick = {})
    }
}