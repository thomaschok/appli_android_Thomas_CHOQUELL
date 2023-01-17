package fr.isen.choquell.androiderestaurant


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import fr.isen.choquell.androiderestaurant.databinding.ActivityPlatBinding


class PlatActivity : AppCompatActivity() {
    private val listPlat = ArrayList<String>()
    private lateinit var customAdapter: CustomAdapter
    private lateinit var binding: ActivityPlatBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val salut = intent.getStringExtra("samplename")

        val actionBar = supportActionBar
        actionBar?.title = salut

        val recyclerView: RecyclerView = findViewById(R.id.mealList)
        customAdapter = CustomAdapter(prepareItems())
        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = customAdapter



    }

    private fun prepareItems() : List<String> {
        val itemsList = arrayListOf<String>()
        itemsList.add("Item 1")
        itemsList.add("Item 2")
        itemsList.add("Item 3")
        itemsList.add("Item 4")
        itemsList.add("Item 5")
        itemsList.add("Item 6")
        itemsList.add("Item 7")
        itemsList.add("Item 8")
        itemsList.add("Item 9")
        itemsList.add("Item 10")
        itemsList.add("Item 11")
        itemsList.add("Item 12")
        itemsList.add("Item 13")
        return itemsList
    }
}



