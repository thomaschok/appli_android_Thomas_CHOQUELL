package fr.isen.choquell.androiderestaurant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.isen.choquell.androiderestaurant.databinding.ActivityPlatBinding
import fr.isen.choquell.androiderestaurant.databinding.ActivitySoupeBinding

class SoupeActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySoupeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_soupe)
        binding = ActivitySoupeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        }
}

