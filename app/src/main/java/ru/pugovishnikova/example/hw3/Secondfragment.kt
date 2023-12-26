package ru.pugovishnikova.example.hw3

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment

class Secondfragment : Fragment(R.layout.second_fragment) {
    var ind = 0
    var titleCur = ""
    var bodyCur = ""
    var imgCur = 0
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var title = view.findViewById<TextView>(R.id.title)
        var body = view.findViewById<TextView>(R.id.body)
        var btnNext = view.findViewById<View>(R.id.btn2)
        var progress = view.findViewById<View>(R.id.progress_bar)
        val img: ImageView = view.findViewById(R.id.avatar)
        var btnMore = view.findViewById<View>(R.id.btn1)
        var btnRepeat = view.findViewById<View>(R.id.btn3)
        progress.isVisible = false
        btnRepeat.isVisible = false
        val myLambda = { result: Map<String, Any>?, error: Throwable? ->
            when {
                result != null -> {
                    title.isVisible = true
                    body.isVisible = true
                    btnNext.isVisible = true
                    btnMore.isVisible = true
                    img.isVisible = true
                    progress.isVisible = false
                    btnRepeat.isVisible = false
                    titleCur = result["title"]!!.toString()
                    title.text = titleCur
                    bodyCur = result["body"]!!.toString()
                    body.text = bodyCur
                    imgCur = result["img"]!! as Int
                    img.setImageResource(imgCur)
                }

                result == null -> {
                    if (error != null) {
                        title.isVisible = false
                        body.isVisible = false
                        btnNext.isVisible = false
                        btnMore.isVisible = false
                        img.isVisible = false
                        Toast.makeText(
                            context,
                            TOAST_EXCEPTION,
                            Toast.LENGTH_LONG
                        ).show()
                        btnRepeat?.isVisible = true
                    } else {
                        title.isVisible = true
                        body.isVisible = true
                        btnNext.isVisible = true
                        btnMore.isVisible = true
                        img.isVisible = true
                        progress.isVisible = false
                        Toast.makeText(
                            context,
                            TOAST_STR,
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            }

        }

        if (savedInstanceState != null) {
            ind = savedInstanceState.getInt("ind")!!
            titleCur = savedInstanceState.getString("tit")!!
            title.text = titleCur
            bodyCur = savedInstanceState.getString("bod")!!
            body.text = bodyCur
            imgCur = savedInstanceState.getInt("img")!!
            img.setImageResource(imgCur)
        } else {
            title.isVisible = false
            body.isVisible = false
            btnNext.isVisible = false
            btnMore.isVisible = false
            img.isVisible = false
            progress.isVisible = true
            Controller.getData(ind, myLambda)
        }

        btnNext.setOnClickListener {
            ind += 1
            title.isVisible = false
            body.isVisible = false
            btnNext.isVisible = false
            btnMore.isVisible = false
            img.isVisible = false
            progress.isVisible = true
            Controller.getData(ind, myLambda)
        }
        btnRepeat.setOnClickListener {
            Controller.getData(ind, myLambda)
            btnRepeat.isVisible = false
        }
    }

    companion object {
        var TOAST_STR = "Нет доступных статей. Повторите попытку позже."
        var TOAST_EXCEPTION = "Ошибка сети. Повторите попытку."
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("tit", titleCur)
        outState.putString("bod", bodyCur)
        outState.putInt("img", imgCur)
        outState.putInt("ind", ind)
    }
}
