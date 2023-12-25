package ru.pugovishnikova.example.hw3

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment

class MainFragment : Fragment(R.layout.main_fragment) {
    var email = ""
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (savedInstanceState != null) {
            email = savedInstanceState.getString("mail")!!
        }
        val editText = view.findViewById<EditText>(R.id.textEmailAddress)
        val button = view?.findViewById<View>(R.id.btn1)
        val myLambda = { result: Boolean ->
            when {
                result == true -> {
                    val intent = Intent(context, SecondActivity::class.java)
                    startActivity(intent)
                }

                result == false -> {
                    Toast.makeText(
                        context,
                        TOAST_STR,
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }

        button?.setOnClickListener {
            email = editText.text.toString()
            Controller.checkEmail(email, myLambda)
        }
    }

    companion object {
        var TOAST_STR = "Вы ввели неверный логин"
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("mail", email)
    }
}
