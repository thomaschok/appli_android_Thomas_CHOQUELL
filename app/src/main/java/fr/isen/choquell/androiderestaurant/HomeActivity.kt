package fr.isen.choquell.androiderestaurant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val action = findViewById<Button>(R.id.buttonEntrée_affichage)
        action.setOnClickListener() {
            Toast.makeText(applicationContext, "Creeper, OH MAN!!!", Toast.LENGTH_SHORT).show();
        }


        val action2= findViewById<Button>(R.id.buttonPlat_affichage)
        action2.setOnClickListener() {
            Snackbar.make(it, "Creeper, OH MAN!!!", Snackbar.LENGTH_SHORT).show()
        }

        val action3 = findViewById<Button>(R.id.buttonDessert_affichage)
        action3.setOnClickListener() {
            Snackbar.make(it, "Creeper, OH MAN!!!", Snackbar.LENGTH_SHORT).show()
        }
    }


}


