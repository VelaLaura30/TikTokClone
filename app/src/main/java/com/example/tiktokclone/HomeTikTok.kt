
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.tiktokclone.R


@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        bottomBar = { BottomNavigationBar() }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {

            TopHeader()

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(20) { index ->
                    VideoItem(index, navController)
                }
            }
        }
    }
}

@Composable
fun TopHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text("Siguiendo", color = Color.Black)
        Text("Amigos", color = Color.Black)
        Text("Para ti", color = Color.Black)
        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = "Buscar",
            tint = Color.Black,
            modifier = Modifier.clickable {}
        )
    }
}

@Composable
fun VideoItem(index: Int, navController: NavController) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)
    ) {

        Image(
            painter = painterResource(id = R.drawable.place),
            contentDescription = "Video",
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
        )

        Column(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(Icons.Default.Favorite, contentDescription = "Like", tint = Color.White)
            Text("6.1K", color = Color.White)
            Icon(
                painter = painterResource(id = R.drawable.comment),
                contentDescription = "Comment",
                tint = Color.White
            )
            Text("167", color = Color.White)
            Icon(Icons.Default.Share, contentDescription = "Share", tint = Color.White)
            Text("39", color = Color.White)
        }

        Column(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(16.dp)
        ) {
            Text(
                text = "Pipe García",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable {
                    navController.navigate("profile_screen")
                }
            )
            Text("Cuando subo a Monserrate...", color = Color.White)
            Text("♫ sonido original - Pipe García", color = Color.White)
        }
    }
}

@Composable
fun BottomNavigationBar() {

    NavigationBar(
        containerColor = Color.Black,
        contentColor = Color.White,
        modifier = Modifier.height(80.dp)
    ) {
        NavigationBarItem(
            icon = { Icon(Icons.Default.Home, contentDescription = "Inicio") },
            label = { Text("Inicio", fontSize = 10.sp) },
            selected = false,
            onClick = { }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Search, contentDescription = "Tendencias") },
            label = { Text("Tendencia", fontSize = 10.sp) },
            selected = false,
            onClick = { }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.AddCircle, contentDescription = "Publicar") },
            selected = true,
            onClick = { }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Email, contentDescription = "Bandeja de entrada") },
            label = { Text("Bandeja", fontSize = 10.sp) },
            selected = false,
            onClick = { }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Person, contentDescription = "Yo") },
            label = { Text("Yo", fontSize = 10.sp) },
            selected = false,
            onClick = { }
        )
    }
}

