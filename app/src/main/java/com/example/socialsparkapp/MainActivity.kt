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

            }else{

                //if anything not alphabetic is input, user motivated to calibrate field correctly - error handling
                if(time.all{it.isLetter()}){

                    tvSparkDisplay.text = "Please use a-z format"

                }else{
                    //statement for morning spark
                    val morning = "Send a good Morning text to a family member"
                    if(time == morning){

                        tvSparkDisplay.text = morning

                    }else{
                        //statement for midmorning spark
                        val midmorning = "Reach out to a colleague with a quick Thank you"
                        if(time == midmorning){

                            tvSparkDisplay.text = midmorning

                        }else{

                            val afternoon = "Share a funny meme or interesting link with a friend"
                            if(time == afternoon){

                                tvSparkDisplay.text = afternoon

                            }else{
                                //statement for evening spark
                                val evening = "Send a quick thinking of you message"
                                if(time == evening){

                                    tvSparkDisplay.text = evening

                                }else{
                                    //statement for dinner spark
                                    val dinner = "Call a relative or friend for a 5-minute catch-up"
                                    if(time == dinner){

                                        tvSparkDisplay.text = dinner

                                    }else{

                                        val night = "Leave a thoughtful message ona friends post"
                                        if(time == night){

                                            tvSparkDisplay.text = night

                                        }else{

                                            tvSparkDisplay.text = "Please enter a valid time of day"

                                        }

                                    }

                                }

                            }
                        }

                    }

                }

            }


        }


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