package igor.second.projectzero.activity

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import igor.second.projectzero.R
import igor.second.projectzero.ui.theme.ProjectZeroTheme

@Composable
fun WorkAction(navController: NavController){
    Box(modifier = Modifier){
        Column (modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            Card (modifier = Modifier.fillMaxSize()) {
                Box {
                    Image(
                        modifier = Modifier
                            .fillMaxSize()
                            .clickable { },
                        contentScale = ContentScale.FillBounds,
                        painter = painterResource(R.drawable.test),
                        contentDescription = "")
                    Row (
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .padding(bottom = 32.dp),
                    ) {
                        ElevatedButton(
                            modifier = Modifier.size(156.dp, 80.dp),
                            onClick = { /*TODO*/ },
                            colors = ButtonDefaults
                                .outlinedButtonColors(contentColor = Color.Red),
                            shape = CutCornerShape(20.dp),
                            border = BorderStroke(1.dp, Color.Red)
                        ) {
                            Text(
                                text = "CANSEL",
                                color = Color.DarkGray
                            )
                        }
                        Spacer(modifier = Modifier.padding(start = 32.dp))
                        ElevatedButton(
                            modifier = Modifier.size(156.dp, 80.dp),
                            onClick = { /*TODO*/ },
                            colors = ButtonDefaults
                                .outlinedButtonColors(contentColor = Color.Green),
                            shape = CutCornerShape(20.dp),
                            border = BorderStroke(1.dp, Color.Green)
                        ) {
                            Text(
                                text = "NEXT",
                                color = Color.DarkGray
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun WorkActionPreview() {
    ProjectZeroTheme {
        WorkAction(navController = rememberNavController())
    }
}