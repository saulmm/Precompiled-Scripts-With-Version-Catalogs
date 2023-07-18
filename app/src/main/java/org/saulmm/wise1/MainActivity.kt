package org.saulmm.wise1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.saulmm.wise1.feature.featureb.FeatureBScreen
import org.saulmm.wise1.feature1.FeatureAScreen
import org.saulmm.wise1.ui.theme.PrecompiledAndTomlTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = "home"
                ) {
                    composable(route = "home") {
                        HomeScreen(
                            onButtonClick = {
                                navController.navigate("a")
                            }
                        )
                    }
                    composable(route = "a") {
                        FeatureAScreen(
                            onButtonClick = {
                                navController.navigate("b")
                            }
                        )
                    }
                    composable(route = "b") {
                        FeatureBScreen(
                            onButtonClick = {
                                navController.popBackStack("home", inclusive = false)
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun HomeScreen(onButtonClick: () -> Unit) {
    MaterialTheme {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Hi from :home",
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = onButtonClick) {
                Text("Click me")
            }
        }
    }
}