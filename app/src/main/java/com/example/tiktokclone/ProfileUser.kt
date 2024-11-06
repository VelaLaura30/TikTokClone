import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tiktokclone.R



@Composable
fun ProfileUser() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        ProfileHeader()
        UserPostsGrid()
    }
}

@Composable
fun ProfileHeader() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "Pipe García", fontWeight = FontWeight.Bold, fontSize = 20.sp)

        Image(
            painter = painterResource(id = R.drawable.profile_picture),
            contentDescription = "Profile Picture",
            modifier = Modifier
                .size(100.dp)
                .padding(top = 8.dp)
        )

        Text(text = "@soypipegarcia", color = Color.Gray)

        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.padding(vertical = 8.dp)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("496", fontWeight = FontWeight.Bold)
                Text("Siguiendo", fontSize = 12.sp)
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("13.7K", fontWeight = FontWeight.Bold)
                Text("Seguidores", fontSize = 12.sp)
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("55.3K", fontWeight = FontWeight.Bold)
                Text("Me gusta", fontSize = 12.sp)
            }
        }

        // Botón de Seguir
        Button(
            onClick = {},
            modifier = Modifier.padding(vertical = 8.dp)) {
            Text("Seguir", color = Color.Black)
        }

        Text(
            "🎤 Stand Up Comedy\nEn YouTube encuentras mi especial completo",
            textAlign = TextAlign.Center,
            color = Color.Black
        )
    }
}

@Composable
fun UserPostsGrid() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        contentPadding = PaddingValues(4.dp)
    ) {
        items(20) { index ->
            Box(
                modifier = Modifier
                    .padding(4.dp)
                    .aspectRatio(1f)
                    .background(Color.LightGray)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.sample_image),
                    contentDescription = "Post Image ${index + 1}",
                    modifier = Modifier
                        .fillMaxSize()
                        .align(Alignment.Center)
                )
            }
        }
    }
}
