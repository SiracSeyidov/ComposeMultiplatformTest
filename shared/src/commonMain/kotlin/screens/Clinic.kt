package screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import models.ClinicModel

@Composable
fun Clinic(
    model: ClinicModel
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(model.name)
        Text(model.distance)
    }
}
