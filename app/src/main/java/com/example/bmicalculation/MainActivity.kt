package com.example.bmicalculation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnCalculate.setOnClickListener {

            if(txtHeight.text.toString()!=null && txtWeight.text.toString()!=null)
            {
                val weight:Double = txtWeight.text.toString().toDouble()
                val height:Double = txtHeight.text.toString().toDouble()

                val bmi:Double = calculateBMI(weight,height)
                val status:String
                lblBMI.text = "%.2f".format(calculateBMI(weight,height))


                if(   bmi <= 18.5)
                {
                    status= "Under"
                    txtStatus.text = "Under"
                    image.setImageResource(R.drawable.under)
                }

                else if(bmi >= 18.5 && bmi <= 24.9){

                    status= "Normal"
                    txtStatus.text = "Normal"

                    image.setImageResource(R.drawable.normal)
                }

                else
                {
                    status= "Over"
                    txtStatus.text = "Over"
                    image.setImageResource(R.drawable.over)
                }

            }
            else
            {
                val str:String ="Empty"
                txtHeight.setText(str)

                txtWeight.setText (str)
            }
        }

        btnReset.setOnClickListener {
            /* txtHeight.text = null
             txtWeight.text = null*/
            val str:String ="Empty"
            txtHeight.setText(str)

            txtWeight.setText (str)
            lblBMI.text = null
            image.setImageResource(R.drawable.empty)
            txtWeight.requestFocus()
        }

    }

    private fun  calculateBMI(a:Double ,b:Double):Double
    {

        val result:Double =(b / ((a/100)*(a/100)))

        return result
    }

}

