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
    var imgCur = ""
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var title = view.findViewById<TextView>(R.id.title)
        var body = view.findViewById<TextView>(R.id.body)
        var btnNext = view.findViewById<View>(R.id.btn2)
        var progress = view.findViewById<View>(R.id.progress_bar)
        val img: ImageView = view.findViewById(R.id.avatar)
        var btnMore = view.findViewById<View>(R.id.btn1)
        progress.isVisible = false
        if (savedInstanceState != null) {
            ind = savedInstanceState.getInt("ind")!!
            titleCur = savedInstanceState.getString("tit")!!
            bodyCur = savedInstanceState.getString("bod")!!
        } else {
            title.isVisible = false
            body.isVisible = false
            btnNext.isVisible = false
            btnMore.isVisible = false
            img.isVisible = false
            progress.isVisible = true
            Controller.getData(ind) {
                when {
                    it != null -> {
                        title.isVisible = true
                        body.isVisible = true
                        btnNext.isVisible = true
                        btnMore.isVisible = true
                        img.isVisible = true
                        progress.isVisible = false
                        titleCur = it["title"]!!
                        title.text = titleCur
                        bodyCur = it["body"]!!
                        body.text = bodyCur

                    }

                    it == null -> {
                        Toast.makeText(
                            context,
                            TOAST_STR,
                            Toast.LENGTH_LONG
                        ).show()
                    }

                }
            }
        }
//        val myLambda = { result: Map<String, String>? ->
//            when {
//                result != null -> {
//                    title.isVisible = true
//                    body.isVisible = true
//                    btnNext.isVisible = true
//                    btnMore.isVisible = true
//                    img.isVisible = true
//                    progress.isVisible = false
//                    titleCur = result["title"]!!
//                    title.text = titleCur
//                    bodyCur = result["body"]!!
//                    body.text = bodyCur
//                }
//
//                result == null -> {
//                    title.isVisible = true
//                    body.isVisible = true
//                    btnNext.isVisible = true
//                    btnMore.isVisible = true
//                    img.isVisible = true
//                    progress.isVisible = false
//                    Toast.makeText(
//                        context,
//                        TOAST_STR,
//                        Toast.LENGTH_LONG
//                    ).show()
//                }
//
//            }
//        }

        btnNext.setOnClickListener {
            ind += 1
            title.isVisible = false
            body.isVisible = false
            btnNext.isVisible = false
            btnMore.isVisible = false
            img.isVisible = false
            progress.isVisible = true
            Controller.getData(ind) {
                when {
                    it != null -> {
                        title.isVisible = true
                        body.isVisible = true
                        btnNext.isVisible = true
                        btnMore.isVisible = true
                        img.isVisible = true
                        progress.isVisible = false
                        titleCur = it["title"]!!
                        title.text = titleCur
                        bodyCur = it["body"]!!
                        body.text = bodyCur
//                        val uri: Uri = Uri.parse("/Users/darapugovisnikova/AndroidStudioProjects/HW3/app/src/main/res/drawable/${result["img"]}")
//                        Log.i("qqq", uri.toString())
//                        img.setImageURI(null)
//                        img.setImageURI(uri)
//                    titleCur = result["title"]!!
//                    Log.i("dataaaa", titleCur)
//                    bodyCur = result["body"]!!

                    }

                    it == null -> {
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
    }

    companion object {
        var TOAST_STR = "Нет доступных статей. Повторите попытку позже."
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("tit", titleCur)
        outState.putString("bod", bodyCur)
        outState.putInt("ind", ind)
        Log.i("index", outState.getInt("ind").toString())
    }
}
