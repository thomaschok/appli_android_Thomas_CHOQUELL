package fr.isen.choquell.androiderestaurant

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import fr.isen.choquell.androiderestaurant.databinding.ActivityHomeBinding


class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)




        val actionBar = supportActionBar
        actionBar!!.title = "World"


        /*
        val action = findViewById<Button>(R.id.buttonEntrée_affichage)
        action.setOnClickListener() {
            Toast.makeText(applicationContext, "Creeper, OH MAN!!!", Toast.LENGTH_SHORT).show();
        }
        */

        //val action1= findViewById<Button>(R.id.buttonEntrée_affichage)
        binding.buttonStarteraffichage.setOnClickListener {

            Log.d("TAG", "Home est delete")

            val intent = Intent(this@HomeActivity, PlatActivity::class.java)
            intent.putExtra("samplename", "Nether")
            startActivity(intent)
        }


        binding.buttonPlataffichage.setOnClickListener {
            val intent= Intent(this@HomeActivity, PlatActivity::class.java)
            intent.putExtra("samplename", "Mineshaft")
            startActivity(intent)
        }


        binding.buttonDessertaffichage.setOnClickListener {
            val intent= Intent(this@HomeActivity, PlatActivity::class.java)
            intent.putExtra("samplename", "Ender")
            startActivity(intent)
        }



        /*val action3= findViewById<Button>(R.id.buttonPlat_affichage)
        action3.setOnClickListener() {
            Snackbar.make(it, "Creeper, OH MAN!!!", Snackbar.LENGTH_SHORT).show()
        }
            */

        /* val action4 = findViewById<Button>(R.id.buttonDessert_affichage)
        action4.setOnClickListener() {
            Snackbar.make(it, "Creeper, OH MAN!!!", Snackbar.LENGTH_SHORT).show()
        }

         */




    }


}


