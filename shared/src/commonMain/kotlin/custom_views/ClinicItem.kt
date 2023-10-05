package custom_views

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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

@OptIn(ExperimentalResourceApi::class, ExperimentalMaterialApi::class)
@Composable
fun ClinicItem(
    model : ClinicModel,
    click : () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .graphicsLayer {
                clip = false
                shape = RoundedCornerShape(16.dp)
            },
        elevation = 1.dp,
        onClick = click
    ) {
        Row(modifier = Modifier
            .padding(10.dp)) {
            Image(
                painterResource(model.img),
                contentDescription = null,
                modifier = Modifier
                    .size(width = 80.dp, height = 80.dp)
                    .clip(MaterialTheme.shapes.medium)
                    .graphicsLayer {
                        clip = true
                        shape = RoundedCornerShape(8.dp)
                    },
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(20.dp))
            
            Column {
                Text(
                    text = model.name,
                    color = Color.Black,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = model.distance,
                    color = Color.Gray,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium
                )
                Spacer(modifier = Modifier.height(10.dp))
                RatingBar(rating = model.rating, onRatingChange = {

                })
            }
        }
    }
}
