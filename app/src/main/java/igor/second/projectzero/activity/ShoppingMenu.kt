package igor.second.projectzero.activity

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import igor.second.projectzero.R

@Composable
fun ShoppingMenu(navController: NavController){
    Box(modifier = Modifier){
        Column (modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
            .padding(top = 64.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            ShoppingMenuFromYour()
        }
    }
}

@Composable
fun ShoppingMenuFromYour(){
    Card(modifier = Modifier
        .clickable { }
        .padding(start = 8.dp, end = 8.dp, bottom = 8.dp)){
        Column (modifier = Modifier.fillMaxWidth(1F),
            horizontalAlignment = Alignment.CenterHorizontally){
            Text(
                text = "ShoppingInfo",
                style = MaterialTheme.typography.displaySmall,
                modifier = Modifier.padding(top = 8.dp))
            Image(modifier = Modifier
                    .fillMaxWidth()
                    .clip(MaterialTheme.shapes.extraLarge)
                    .padding(start = 8.dp, end = 8.dp),
                contentScale = ContentScale.Crop,
                painter = painterResource(R.drawable.test),
                contentDescription = null)
            Text(
                text = "ShoppingInfo",
                style = MaterialTheme.typography.bodyLarge)
        }
    }
}


@Preview
@Composable
fun ShoppingMenuPreview(){
    ShoppingMenu(navController = rememberNavController())
}