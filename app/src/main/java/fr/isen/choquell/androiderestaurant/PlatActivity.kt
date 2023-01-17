package fr.isen.choquell.androiderestaurant

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import fr.isen.choquell.androiderestaurant.databinding.ActivityPlatBinding

class PlatActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPlatBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var category = intent.getStringExtra("ActivityName")
        val actionBar = supportActionBar
        actionBar?.title = category

        val dishes = resources.getStringArray(R.array.plats).toList() as ArrayList<String>
        binding.mealList.layoutManager = LinearLayoutManager(this)
        binding.mealList.adapter = CustomAdapter(dishes){
            val intent = Intent(this,SoupeActivity::class.java)
            startActivity(intent)
        }



    }

}



