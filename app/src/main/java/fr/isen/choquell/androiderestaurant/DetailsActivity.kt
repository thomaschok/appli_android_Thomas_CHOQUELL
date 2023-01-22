package fr.isen.choquell.androiderestaurant


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import fr.isen.choquell.androiderestaurant.databinding.ActivityDetailsBinding
import fr.isen.choquell.androiderestaurant.model.Items


@Suppress("DEPRECATION")
class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding
    private lateinit var item: Items
    private lateinit var name: String



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        item = intent.getSerializableExtra("detail") as Items
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        name = item.nameFr.toString()


        val actionBar = supportActionBar
        actionBar?.title = name


        val textView = findViewById<TextView>(R.id.DetailsNamePlat)
        val text = name
        textView.text = text

        if (item.images.isNotEmpty()) {
            Picasso.get().load(item.images[0]).into(binding.detailsImagePlat);}

        val ingredients= item.ingredients
        val ingredientsString = java.lang.StringBuilder()
        ingredients.forEach{ ingredients -> ingredientsString.append(ingredients.nameFr)
        ingredientsString.append("\n")
        }
    binding.detailsPricePlat.text = ingredientsString
    }


}

