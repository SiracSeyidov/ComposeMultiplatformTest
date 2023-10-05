package custom_views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color

@Composable
fun RatingBar(
    rating: Float,
    onRatingChange: (Float) -> Unit,
) {
    var currentRating by remember { mutableStateOf(rating) }

    Row(
        modifier = Modifier
    ) {
        for (i in 1..5) {
            val iconModifier = Modifier
                .size(16.dp)
                .clickable {
                    currentRating = i.toFloat()
                    onRatingChange(currentRating)
                }

            val icon = if (i <= currentRating) {
                Icons.Default.Star
            } else {
                Icons.Default.Star
            }

            Icon(
                imageVector = icon,
                contentDescription = null,
                modifier = iconModifier,
                tint = if (i <= currentRating) Color.Yellow else Color.Gray
            )
        }
    }
}
