package fr.isen.choquell.androiderestaurant

import android.R.id.button1
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
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
        action2.setOnClickListener {
            val intent = Intent(applicationContext, PlatActivity::class.java)
            startActivity(intent);
        }

     /*   val action3= findViewById<Button>(R.id.buttonPlat_affichage)
        action3.setOnClickListener() {
            Snackbar.make(it, "Creeper, OH MAN!!!", Snackbar.LENGTH_SHORT).show()
        }
*/
        val action4 = findViewById<Button>(R.id.buttonDessert_affichage)
        action4.setOnClickListener() {
            Snackbar.make(it, "Creeper, OH MAN!!!", Snackbar.LENGTH_SHORT).show()
        }
    }


}


