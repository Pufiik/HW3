package ru.pugovishnikova.example.hw3

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment


class SecondActivity: AppCompatActivity() {
    var id = 0
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)

        var fragment = findViewById<View>(R.id.secondfragment)

    }
}