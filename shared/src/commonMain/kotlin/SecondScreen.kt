import CustomViews.MyTextField
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SecondScreen() {
    var third by remember { mutableStateOf(false) }
    val name = remember { mutableStateOf("") }
    val phone = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    if (!third){
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "Sign up",
                color = Color.Black,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(start = 20.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Start here to your journey of petcare",
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .padding(start = 20.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))
            MyTextField(
                value =  name.value,
                placeholder = "Name",
                error = "",
                onValueChanged = {
                    name.value = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))
            MyTextField(
                value =  phone.value,
                placeholder = "Phone",
                error = "",
                onValueChanged = {
                    phone.value = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))
            MyTextField(
                value =  password.value,
                placeholder = "Password",
                error = "",
                onValueChanged = {
                    password.value = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = {},
                modifier = Modifier
                    .size(width = 250.dp, height = 50.dp)
                    .clip(MaterialTheme.shapes.medium)
                    .graphicsLayer {
                        clip = true
                        shape = RoundedCornerShape(25.dp)
                    }
                    .align(Alignment.CenterHorizontally),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue)
            ) {
                Text(
                    text = "SIGN UP",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            TextButton(onClick = {
                third = true
            }, colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                modifier = Modifier
                    .padding(bottom = 40.dp)
                    .align(Alignment.CenterHorizontally)
            ){
                Row {
                    Text(
                        text = "Have already an account?",
                        color = Color.Black,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.padding(end = 10.dp)
                    )

                    Text(
                        text = "Log in",
                        color = Color.Blue,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                    )
                }
            }
        }
    }else{
        ThirdScreen()
    }
}
