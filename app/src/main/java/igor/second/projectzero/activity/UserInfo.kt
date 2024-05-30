package igor.second.projectzero.activity

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage

@Composable
fun UserInfo(navController: NavController) {

    var checkedState1 by remember { mutableStateOf(true) }

    Box(modifier = Modifier){
        Column (modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(top = 72.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top) {
            if (checkedState1){
                UserInfoForFirstStart()
            }else{
                UserInfoForSecondStart()
            }
        }
    }
}

@Composable
fun UserInfoForSecondStart(){
    
}

@Composable
fun UserInfoForFirstStart(){

    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var infoCheck by remember { mutableStateOf("") }

    var imageUri by remember { mutableStateOf<Uri?>(null) }
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()) { uri: Uri? ->
        imageUri = uri
    }

    Column (modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.align(Alignment.CenterHorizontally)){
            Card (modifier = Modifier
                .size(240.dp)
                .clip(shape = RoundedCornerShape(150.dp))) {
                AsyncImage(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .clickable { },
                    contentScale = ContentScale.FillBounds,
                    model = imageUri,
                    contentDescription = ""
                )
            }
            Button(
                onClick = { launcher.launch("image/*") },
                modifier = Modifier.align(Alignment.BottomEnd),
                shape = RoundedCornerShape(bottomStart = 48.dp, topEnd = 48.dp)
            ) {
                Text(text = "+")
            }
        }

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, top = 16.dp),
            value = name,
            onValueChange = { name = it },
            label = { Text("Enter your name") },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done,
                capitalization = KeyboardCapitalization.None
            ),
            maxLines = 1
        )

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp),
            value = email,
            onValueChange = { email = it },
            label = { Text("Enter your email") },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Done,
                capitalization = KeyboardCapitalization.None
            ),
            maxLines = 1
        )

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp),
            value = age,
            onValueChange = { age = it },
            label = { Text("Enter your age") },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done,
                capitalization = KeyboardCapitalization.None
            ),
            maxLines = 1
        )

        // START Button from save information about account
        Button(
            onClick = {
                if (email.isNotEmpty() &&
                    isValidEmail(email) &&
                    name.length in 3..12 &&
                    age.toInt() > 17){
                infoCheck = "information about user saved!!!"
            }else{
                age = ""
                name = ""
                email = ""
                infoCheck = "information about user is NOT saved!!!"
            }
                      },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, top = 16.dp),
            shape = RoundedCornerShape(bottomStart = 48.dp, topEnd = 48.dp)
        ) {
            Text(text = "Save information")
        }
        Text(text = infoCheck)
        // END Button from save information about account
    }
}

fun isValidEmail(email: String): Boolean {
    val emailRegex = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+".toRegex()
    return email.matches(emailRegex)
}
