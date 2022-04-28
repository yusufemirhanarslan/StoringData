package com.yusufemirhanarslan.storingdata

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var sharedPreferences: SharedPreferences
    var ageFromPreferences: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //SharedPreferences Initialize
        sharedPreferences = this.getSharedPreferences("com.yusufemirhanarslan.storingdata",Context.MODE_PRIVATE)

         ageFromPreferences = sharedPreferences.getInt("age",0)

        if(ageFromPreferences == -1){
            textView2.text = "Your age:"
        }else{
            textView2.text = "Your Age: ${ageFromPreferences}"
        }

    }

    fun save(view: View){

        //SharedPreferences



        val myAge = editTextTextPersonName.text.toString().toIntOrNull()

        if(myAge != null){
            textView2.text = "Your Age: ${myAge}"
            sharedPreferences.edit().putInt("age",myAge).apply()
        }

    }

    fun delete(view: View){

        ageFromPreferences = sharedPreferences.getInt("age",-1)

        if(ageFromPreferences != -1) {

            sharedPreferences.edit().remove("age").apply()
            textView2.text = "Your Age:"

        }


    }




}