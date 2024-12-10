package gay.spiders.snorfify

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import gay.spiders.snorfify.ui.theme.SnorfifyTheme
import gay.spiders.snorfify.util.toPosition

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            var index by remember { mutableIntStateOf(0) }
            var playState by remember { mutableStateOf(false) }
            SnorfifyTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ) {
                        Text(
                            text = "Mambo No. $index",
                            style = MaterialTheme.typography.titleLarge
                        )
                        Text(
                            text = "Gideon the ${index.toPosition()}",
                            style = MaterialTheme.typography.bodyLarge
                        )
                        Image(
                            imageVector = Icons.Default.DateRange,
                            contentDescription = "Album Image",
                            modifier = Modifier
                                .padding(vertical = 24.dp)
                                .size(128.dp)
                        )
                        Row {
                            IconButton(
                                onClick = { index = (index - 1).coerceAtLeast(0) }
                            ) {
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                    contentDescription = "Go back a song"
                                )
                            }

                            IconButton(
                                onClick = { playState = !playState },
                                colors = IconButtonDefaults.iconButtonColors(
                                    containerColor = MaterialTheme.colorScheme.primaryContainer
                                )
                            ) {
                                Icon(
                                    imageVector = if (playState)Icons.Default.PlayArrow else Icons.Default.Menu, // TODO: Get actual pause icon
                                    contentDescription = if (playState) "Play" else "Pause"
                                )
                            }

                            IconButton(
                                onClick = { ++index }
                            ) {
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                                    contentDescription = "Go forward a song"
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}