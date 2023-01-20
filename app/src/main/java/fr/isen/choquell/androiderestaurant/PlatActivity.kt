package fr.isen.choquell.androiderestaurant

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import fr.isen.choquell.androiderestaurant.databinding.ActivityPlatBinding
import fr.isen.choquell.androiderestaurant.model.DataResult
import org.json.JSONObject



class PlatActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPlatBinding
    private lateinit var category: String


    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        binding = ActivityPlatBinding.inflate(layoutInflater)
        setContentView(binding.root)
        category = intent.getStringExtra("samplename") ?:""

        var namecategory = intent.getStringExtra("samplename")
        val actionBar = supportActionBar
        actionBar?.title = namecategory

        val dishes = resources.getStringArray(R.array.plats).toList() as ArrayList<String>
        binding.mealList.layoutManager = LinearLayoutManager(this)
        binding.mealList.adapter = CustomAdapter(arrayListOf()) {
            val intent = Intent(this, DetailsActivity::class.java)
            startActivity(intent)
        }

        loadDishesFromAPI()

        //GsON()

    }

    private fun loadDishesFromAPI(){
        Volley.newRequestQueue(this)
        val url = "http://test.api.catering.bluecodegames.com/menu"
        val jsonObject = JSONObject()
        jsonObject.put("id_shop", "1")
        val jsonRequest = JsonObjectRequest(
            Request.Method.POST, url, jsonObject, {
                Log.w("PlatActivity", "response : $it")
                handleAPIData(it.toString())
            }, {
                Log.w("PlatActivity", "erreur : $it")
            }
        )
        Volley.newRequestQueue(this).add(jsonRequest)
    }


private fun handleAPIData(data: String) {
    val mealResult = Gson().fromJson(data, DataResult::class.java)
    val mealcategoryfilter = mealResult.data.firstOrNull { it.nameFr == category }
    val adapter = binding.mealList.adapter as CustomAdapter
    adapter.refreshList(mealcategoryfilter?.items?.map {it.nameFr} as ArrayList<String>)

}


/*
    private fun GsON() {
        val builder = GsonBuilder()
        val gson = builder.create()
        val values = "http://test.api.catering.bluecodegames.com/menu"
        println(gson.toJson(values))
        println("Salut")
    }

    */
}








