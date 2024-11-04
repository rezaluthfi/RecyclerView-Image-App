package com.example.recyclerimageapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.recyclerimageapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { view, insets ->
            val statusBarInsets = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(0, statusBarInsets.top, 0, 0)
            insets
        }

        val heroes = listOf(
            Movie("Spider-Man: Far From Home", "https://www.themoviedb.org/t/p/w1280/4q2NNj4S5dG2RLF9CpXsej7yXl.jpg"),
            Movie("Coco", "https://www.themoviedb.org/t/p/w1280/gGEsBPAijhVUFoiNpgZXqRVWJt2.jpg"),
            Movie("Despicable Me 4", "https://www.themoviedb.org/t/p/w1280/wWba3TaojhK7NdycRhoQpsG0FaH.jpg"),
            Movie("The Lion King", "https://www.themoviedb.org/t/p/w1280/2bXbqYdUdNVa8VIWXVfclP2ICtT.jpg"),
            Movie("The Avengers", "https://www.themoviedb.org/t/p/w1280/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg"),
            Movie("The Incredibles", "https://www.themoviedb.org/t/p/w1280/2LqaLgk4Z226KkgPJuiOQ58wvrm.jpg"),
            Movie("The Incredibles 2", "https://www.themoviedb.org/t/p/w1280/9lFKBtaVIhP7E2Pk0IY1CwTKTMZ.jpg"),
            Movie("Toy Story 4", "https://www.themoviedb.org/t/p/w1280/w9kR8qbmQ01HwnvK4alvnQ2ca0L.jpg"),
            Movie("Up", "https://www.themoviedb.org/t/p/w1280/mFvoEwSfLqbcWwFsDjQebn9bzFe.jpg"),
            Movie("The Dark Knight", "https://www.themoviedb.org/t/p/w1280/qJ2tW6WMUDux911r6m7haRef0WH.jpg"),
            Movie("Mad Max: Fury Road", "https://www.themoviedb.org/t/p/w1280/hA2ple9q4qnwxp3hKVNhroipsir.jpg"),
            Movie("The Shawshank Redemption", "https://www.themoviedb.org/t/p/w1280/9cqNxx0GxF0bflZmeSMuL5tnGzr.jpg"),
            Movie("The Godfather", "https://www.themoviedb.org/t/p/w1280/3bhkrj58Vtu7enYsRolD1fZdja1.jpg"),
            Movie("The Dark Knight Rises", "https://www.themoviedb.org/t/p/w1280/hr0L2aueqlP2BYUblTTjmtn0hw4.jpg"),
            Movie("Venom: The Last Dance", "https://www.themoviedb.org/t/p/w1280/k42Owka8v91trK1qMYwCQCNwJKr.jpg")
            )

        binding.rvMovies.adapter = MovieAdapter(heroes)
        binding.rvMovies.layoutManager = GridLayoutManager(this, 3)

    }
}