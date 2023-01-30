package fr.isen.choquell.androiderestaurant


import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.squareup.picasso.Picasso
import fr.isen.choquell.androiderestaurant.databinding.ActivityDetailsBinding
import fr.isen.choquell.androiderestaurant.model.Items
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.snackbar.Snackbar
import org.json.JSONObject
import java.io.File
import java.lang.StringBuilder


@Suppress("DEPRECATION")
class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding
    private lateinit var item: Items
    private lateinit var name: String

    //private var number by Delegates.notNull<Double>()
    private lateinit var viewPager: ViewPager
    private lateinit var pagerAdapter: CustomAdapter


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        item = intent.getSerializableExtra("detail") as Items
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        name = item.nameFr.toString()


        val actionBar = supportActionBar
        actionBar?.title = name


        val textView = findViewById<TextView>(R.id.detailsNamePlat)
        val text = name
        textView.text = text

        if (item.images.isNotEmpty()) {
            Picasso.get().load(item.images[0]).into(binding.DetailsImagePlat);
        }


        val ingredients = item.ingredients

        if (item.ingredients.isNotEmpty()) {
            val ingredientsString = StringBuilder()
            ingredients.forEach { ingredients ->
                ingredientsString.append(ingredients.nameFr)
                ingredientsString.append("\n")
            }
            binding.DetailsIngredientPlat.text = ingredientsString

        }


        val prix = item.prices
        val priceString = StringBuilder()
        val priceunique = item.prices[0].price?.toDouble()


        var addition = 0
        val number = addition * priceunique!!
        binding.floatingActionButtonPlus.setOnClickListener {
            addition++
            binding.incrementaionView.text =
                Editable.Factory.getInstance().newEditable(addition.toString())

            if (item.prices.isNotEmpty()) {
                prix.forEach { prix ->
                    priceString.append(prix.price)
                    priceString.append("$")
                }
                val number = addition * priceunique!!
                binding.textPriceTotal.text = number.toString()

                val data = JSONObject()
                data.put("nom", name)
                data.put("quantité", addition)
                data.put("prix total", number)


                val fileOutputStream = openFileOutput("pannier.json", Context.MODE_PRIVATE)
                fileOutputStream.write(data.toString().toByteArray())
                Snackbar.make(it, "Panier enregistré", Snackbar.LENGTH_SHORT).show()
                fileOutputStream.close()
            }


        }



        binding.floatingActionButtonMoins.setOnClickListener {
            addition--
            binding.incrementaionView.setText(
                Editable.Factory.getInstance().newEditable(addition.toString())
            )
            val number = addition * priceunique!!
            binding.textPriceTotal.text = number.toString()

            val data = JSONObject()
            data.put("prix", number)

            val fileOutputStream = openFileOutput("pannier.json", Context.MODE_PRIVATE)
            fileOutputStream.write(data.toString().toByteArray())
            Snackbar.make(it, "Panier enregistré", Snackbar.LENGTH_SHORT).show()
        }





        if (item.prices.isNotEmpty()) {
            prix.forEach { prix ->
                priceString.append(prix.price)
                priceString.append("$")
                priceString.append("\n")
            }
            binding.detailsPricePlat.text = priceString

        }


    }


}




