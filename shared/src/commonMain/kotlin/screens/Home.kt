package screens

import custom_views.ClinicItem
import custom_views.FilterButton
import custom_views.SearchBar
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import models.ClinicModel
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class, ExperimentalComposeUiApi::class)
@Composable
fun Home() {
    var isAll by remember { mutableStateOf(true) }
    val allBg by rememberUpdatedState(
        if (isAll) Color.Blue else Color.White
    )
    val allFg by rememberUpdatedState(
        if (isAll) Color.White else Color.Black
    )
    var isPopular by remember { mutableStateOf(false) }
    val popularBg by rememberUpdatedState(
        if (isPopular) Color.Blue else Color.White
    )
    val popularFg by rememberUpdatedState(
        if (isPopular) Color.White else Color.Black
    )
    var isFav by remember { mutableStateOf(false) }
    val favBg by rememberUpdatedState(
        if (isFav) Color.Blue else Color.White
    )
    val favFg by rememberUpdatedState(
        if (isFav) Color.White else Color.Black
    )

    val search = remember { mutableStateOf("") }

    val clinicList = listOf<ClinicModel>(
        ClinicModel("clinicdefaultimg.png", "MyVet 1", "175m", 1.0f),
        ClinicModel("clinicdefaultimg.png", "MyVet 2", "275m", 2.0f),
        ClinicModel("clinicdefaultimg.png", "MyVet 3", "375m", 3.0f),
        ClinicModel("clinicdefaultimg.png", "MyVet 4", "475m", 4.0f),
        ClinicModel("clinicdefaultimg.png", "MyVet 5", "575m", 5.0f),
        ClinicModel("clinicdefaultimg.png", "MyVet 6", "675m", 5.0f),
        ClinicModel("clinicdefaultimg.png", "MyVet 7", "775m", 4.0f),
        ClinicModel("clinicdefaultimg.png", "MyVet 8", "875m", 3.0f),
        ClinicModel("clinicdefaultimg.png", "MyVet 9", "975m", 2.0f),
        ClinicModel("clinicdefaultimg.png", "MyVet 10", "1075m", 1.0f)
    )

    var clinic by remember { mutableStateOf(false) }
    var clinicDetails by remember { mutableStateOf(ClinicModel("", "", "", 0f)) }

    if (clinic){
        Clinic(clinicDetails)
    }else{
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
            ) {
                Image(
                    painterResource("petsgohometopimg.png"),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp)
                        .padding(bottom = 20.dp)
                        .clip(MaterialTheme.shapes.medium)
                        .graphicsLayer {
                            clip = true
                            shape = RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp)
                        },
                    contentScale = ContentScale.Crop
                )

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(bottom = 40.dp),
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Text(
                        text = "Find the\n" +
                                "best clinic",
                        color = Color.White,
                        fontSize = 36.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(start = 20.dp, bottom = 20.dp)
                    )

                    SearchBar(value = search.value, onValueChanged = {
                        search.value = it
                    })
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                FilterButton(txt = "All", bg = allBg, fg = allFg, onClick = {
                    isAll = true
                    isPopular = false
                    isFav = false
                })
                FilterButton(txt = "Popular", bg = popularBg, fg = popularFg, onClick = {
                    isPopular = true
                    isAll = false
                    isFav = false
                })
                FilterButton(txt = "Favorites", bg = favBg, fg = favFg, onClick = {
                    isFav = true
                    isAll = false
                    isPopular = false
                })
            }

            LazyColumn(
                modifier = Modifier
                    .padding(start = 20.dp, end = 20.dp, top = 20.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                items(clinicList){
                    ClinicItem(it, click = {
                        clinic = true
                        clinicDetails = it
                    })
                }
            }
        }
    }
}
