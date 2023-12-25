package ru.pugovishnikova.example.hw3

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

class Secondfragment : Fragment(R.layout.second_fragment) {
        lateinit var email: String
    //    lateinit var urls = mutableListOf<String>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var id = 0
        super.onViewCreated(view, savedInstanceState)
        var tv = view.findViewById<TextView>(R.id.title_tv__fragment_2)
        tv.text = "AAAAAAA"
    }
}
//        if (savedInstanceState != null) {
//            rectangles.addAll(savedInstanceState.getIntegerArrayList("1")!!)
//            num = savedInstanceState.getInt("2")
//        }

//
//        button?.setOnClickListener {
//
//            Controller.loadData(myLambda)
//        }
//        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT)
//            recycler?.layoutManager =
//                StaggeredGridLayoutManager(COUNT_VERTICAL, StaggeredGridLayoutManager.VERTICAL)
//        else recycler?.layoutManager =
//            StaggeredGridLayoutManager(COUNT_HORIZONTAL, StaggeredGridLayoutManager.HORIZONTAL)
//        Controller.loadData(myLambda)
//        Log.d("MyTag", "After func")
//
//    }
//
//    override fun onSaveInstanceState(outState: Bundle) {
//        super.onSaveInstanceState(outState)
//        outState.putIntegerArrayList(KEY, urls as ArrayList<String>)
//    }
//
//    companion object {
//        const val COUNT_VERTICAL = 2
//        const val COUNT_HORIZONTAL = 3
//        var TOAST_STR = "Во время выполнения запроса возникла ошибка подключения к сети"
//        const val KEY = "key"
//    }
//

//}
