package custom_views

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FilterButton(
    txt: String,
    bg: Color,
    fg: Color,
    onClick: () -> Unit
) {
    Button(onClick = onClick,
        modifier = Modifier
            .height(30.dp)
            .clip(MaterialTheme.shapes.medium)
            .graphicsLayer {
                clip = true
                shape = RoundedCornerShape(30.dp)
            }
            .padding(start = 20.dp, end = 20.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = bg)
    ) {
        Text(
            text = txt,
            color = fg,
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal
        )
    }
}
