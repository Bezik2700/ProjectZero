package igor.second.projectzero.activity

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import igor.second.projectzero.R

@Composable
fun YourLikes(navController: NavController) {
    Box(modifier = Modifier){
        Column (modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(top = 64.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top) {
            LikesMenuFromYour(userName = "Inna", userMessage = "Hello Igor!")
        }
    }
}

@Composable
fun LikesMenuFromYour(userName: String, userMessage: String){

    Card(modifier = Modifier
        .clickable { }
        .padding(start = 8.dp, end = 8.dp, bottom = 8.dp)){
        Row (modifier = Modifier){
            Image(modifier = Modifier
                .size(120.dp)
                .padding(16.dp)
                .clip(MaterialTheme.shapes.extraLarge),
                contentScale = ContentScale.Crop,
                painter = painterResource(R.drawable.test),
                contentDescription = null
            )
            Column(modifier = Modifier) {
                Text(
                    text = userName,
                    style = MaterialTheme.typography.displaySmall,
                    modifier = Modifier.padding(top = 8.dp)
                )
                Text(
                    text = userMessage,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            Spacer(modifier = Modifier.weight(1F))
            IconButton(onClick = {  }) {
                Icon(
                    Icons.Outlined.Favorite,
                    contentDescription = null
                )
            }
        }
    }
}
