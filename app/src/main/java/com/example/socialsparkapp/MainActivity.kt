package com.example.socialsparkapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {


    lateinit var txtTimeInput: EditText
    lateinit var btnSpark: Button
    lateinit var btnReset: Button
    lateinit var tvSparkDisplay: TextView

    val morning = "Send a \"Good morning\" text to a family member"
    val midmorning = "Reach out to a colleague with a quick \"Thank you\""
    val afternoon = "Share a funny meme or interesting link with a friend"
    val evening = "Send a quick \"Thinking of you\" message"
    val dinner = "Call a relative or friend for a 5-minute catch-up"
    val night = "Leave a thoughtful message on a friends post"




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        //Mapping all xml data with findViewById function
        txtTimeInput = findViewById(R.id.txtTimeInput)

        btnSpark = findViewById(R.id.btnSpark)
        btnReset = findViewById(R.id.btnReset)

        tvSparkDisplay = findViewById(R.id.tvSparkDisplay)



        //button to output suggestion being created with necessary if statements and Spark logic
        btnSpark.setOnClickListener {
            val time = txtTimeInput.text.toString()
            //if the field is left empty, user motivated to enter data - error handling
            if(time.isEmpty()){
                tvSparkDisplay.text = "Please fill field"
            //if anything not alphabetic is input, user motivated to calibrate field correctly - error handling
            }else if(!time.all{it.isLetter()}){
                    tvSparkDisplay.text = "Please use a-z format"
                }else if(time.trim().lowercase() == "morning"){
                        tvSparkDisplay.text = morning
                    }else if(time.trim().lowercase() == "midmorning"){
                            tvSparkDisplay.text = midmorning
                        }else if(time.trim().lowercase() == "afternoon"){
                                tvSparkDisplay.text = afternoon
                            }else if(time.trim().lowercase() == "evening"){
                                    tvSparkDisplay.text = evening
                                }else if(time.trim().lowercase() == "dinner"){
                                        tvSparkDisplay.text = dinner
                                    }else if(time.trim().lowercase() == "night"){
                                            tvSparkDisplay.text = night
                //if anything alphabetic but not within designated spark suggestion logic fields, user motivated to enter a valid time of day - error handling
                                        }else{
                                            tvSparkDisplay.text = "Please enter a valid time of day"
                                        }
            }





        //button to reset all input and output fields
        btnReset.setOnClickListener {
            txtTimeInput.text.clear()
            tvSparkDisplay.text = " "
        }




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}