package com.example.laplato.presentation.mealHome



import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.example.laplato.domain.model.MealItem
import com.example.laplato.presentation.mealViewModel.MealViewModel

@Composable
fun HomeScreen() {

    val homeViewModel = viewModel(modelClass = MealViewModel::class.java )
    val state by homeViewModel.state.collectAsState()



    LazyColumn(
        modifier = Modifier.padding(5.dp)
    ){
        if (state.isEmpty()){
            item {
                CircularProgressIndicator(
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(align = Alignment.Center)
                )
            }
        }else{

            items(state){ mealItem: MealItem ->
                MealCardItem(mealItem = mealItem)
            }

        }
    }




}

@Composable
fun MealCardItem(mealItem: MealItem) {

    val imagePainter = rememberAsyncImagePainter(model = mealItem.strCategoryThumb)

    Card (
        modifier = Modifier.padding(16.dp),
        shape = RoundedCornerShape(15.dp)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {

            AsyncImage(
                model = imagePainter,
                contentDescription = "${mealItem.strCategory} image"
            )

            Column(modifier = Modifier.padding(10.dp)) {
                Text(text = mealItem.strCategory, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = mealItem.strCategoryDescription)
            }

        }
    }
    Spacer(modifier = Modifier.height(10.dp))
}