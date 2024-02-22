package ac.id.utdi.allfinemaulinaro.rekomendasifilm

import ac.id.utdi.allfinemaulinaro.rekomendasifilm.data.DataSource
import ac.id.utdi.allfinemaulinaro.rekomendasifilm.model.Genres
import ac.id.utdi.allfinemaulinaro.rekomendasifilm.model.Movie
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ac.id.utdi.allfinemaulinaro.rekomendasifilm.ui.theme.RekomendasiFilmTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items as itemsLazy
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.MutableState
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RekomendasiFilmTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    // agar surface meingisi semua ruang
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column{
                        var status = remember { mutableStateOf("Action") }
                        MovieAllButton(status)
                        MovieApp(status)
                    }
                }
            }
        }
    }
}

@Composable
fun MovieApp(status: MutableState<String>){
    val movies = when (status.value) {
        "Action" -> DataSource.actions
        "Horror" -> DataSource.horrors
        else -> DataSource.comedies
    }
    // LazyVerticalGrid adalah komponen untuk menampilkan daftar item secara vertikal dengan jumlah kolom yang tetap
    LazyVerticalGrid(
        columns = GridCells.Fixed(2) // Menentukan jumlah kolom (dalam kasus ini, 2 kolom)
    ) {
        // items adalah komponen untuk menampilkan daftar item secara lazy (tidak semua item dimuat secara bersamaan)
        items(movies) {action ->
            // MovieCard adalah komponen untuk menampilkan detail film dalam bentuk kartu
            MovieCard(movie = action)
        }
    }
}

// komponen untuk tampilan Card untuk semua list movie
@Composable
fun MovieCard(movie: Movie,modifier: Modifier = Modifier){
    // Box adalah komponen untuk wadah dari konten
    Box(
        // styling komponen
        modifier = modifier
            .clip(RoundedCornerShape(5.dp)) // mengatur sudut bulatan
            .padding(5.dp) // menambahkan padding
            .fillMaxSize(), // Mengisi maksimum ukuran yang tersedia
        // Mengatur konten agar ketengah
        contentAlignment = Alignment.Center
    ) {
        // Card adalah komponen Material Design
        Card(
            // Membuat efek bayangan di card
            elevation = CardDefaults.cardElevation(20.dp)
        ){
            // Column digunakan agar konten disusun secara vertical
            Column(
                // Mengisi maksimum ruang yang tersedia
                modifier = Modifier.fillMaxSize()
            ){
                // Image adalah komponen untuk menampilkan gambar
                Image(
                    painter = painterResource(id = movie.imageRes), // Menampilkan gambar yang diinginkan
                    contentDescription = null, // Deskripsi gambar
                    modifier = Modifier
                        .fillMaxWidth(), // Mengisi lebar yang tersedia
                    contentScale = ContentScale.Crop // Mengatur gambar agar sesuai batas
                )
                // Column digunakan agar konten disusun secara vertical
                Column(
                    // Menambahkan padding pada teks
                    modifier = Modifier.padding(10.dp)
                ){
                    // Text adalah komponen untuk menampilkan teks
                    Text(
                        style= TextStyle(// Mendefinisikan gaya teks
                            fontSize = 20.sp // Mengatur ukuran teks
                        ),
                        text = stringResource(id = movie.nameMovie), // Teks yang akan ditampilkan
                        fontWeight = FontWeight.Bold, // Mengatur teks menjadi tebal (bold)
                        fontFamily = FontFamily.SansSerif // Memilih gaya font
                    )
                    // Text adalah komponen untuk menampilkan teks
                    Text(
                        text = stringResource(id = movie.releaseMovie), // Teks yang akan ditampilkan
                        fontWeight = FontWeight.Light, // Mengatur teks menjadi lebih tipis (light)
                        fontFamily = FontFamily.SansSerif // Memilih gaya font
                    )
                }
            }
        }
    }
}

// kompen untuk menggabungkan semua button
@Composable
fun MovieAllButton(status: MutableState<String>) {
    // Menggunakan lazy row
    LazyRow {
        itemsLazy(DataSource.genres) {genre ->
            // komponen compose
            MovieButton(genres = genre, status)
        }
    }
}

// komponen untuk button
@Composable
fun MovieButton(genres: Genres,status: MutableState<String>, modifier: Modifier = androidx.compose.ui.Modifier){
    // list nama genre di masukan ke alam variable
    val genreName = stringResource(id = genres.nameGenres)
    // fungtion button untuk tombol
    Button(onClick = { status.value = genreName }) {
        Text(text = stringResource(id = genres.nameGenres))
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RekomendasiFilmTheme {
//        val gendre = Genres(R.string.action)
//        ThreeButtons()
    }
}