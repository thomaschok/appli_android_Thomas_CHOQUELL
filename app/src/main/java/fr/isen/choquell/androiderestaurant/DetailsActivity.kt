package fr.isen.choquell.androiderestaurant

import android.content.ClipData.Item
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import fr.isen.choquell.androiderestaurant.databinding.ActivityDetailsBinding
import fr.isen.choquell.androiderestaurant.model.DataResult
import fr.isen.choquell.androiderestaurant.model.Items
import org.json.JSONObject

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
        name= item.nameFr.toString()



        val actionBar = supportActionBar
        actionBar?.title= name

    }


}

