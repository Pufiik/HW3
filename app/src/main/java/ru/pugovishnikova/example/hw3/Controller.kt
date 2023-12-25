package ru.pugovishnikova.example.hw3

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


object Controller {

    val scope = CoroutineScope(Dispatchers.IO)
    private val mapData = mapOf (
        "title" to "bcvuerbior",
        "body" to "bfviurehwifge;ifirh4w",
        "caption" to "fhgvureiohvle",
    )
    private val email = "daria.pugovka@yahoo.com"
    fun checkEmail(emailEditText: String, callback: (result: Boolean) -> Unit) {
        scope.launch {
            delay(4000L)
            val result = emailEditText == email
            Log.i("AAA", emailEditText)
            withContext(Dispatchers.Main) {
                callback(result)
            }

        }
    }

    fun getData(id: String, callback: (result: Map<String, String>, res: Boolean) -> Unit) {
        scope.launch {
            delay(2000L)
            var result = mapData["id"] == id
            Log.i("AAAA", result.toString())
//            withContext(Dispatchers.Main) {
//                callback(mapData["id"], result)
//            }

        }
    }
}
//    fun loadData(callback: (result: Map<String, String>, error: Throwable?) -> Unit) {
//        scope.launch {
//            try {
//                val result = requireService().getTrendingGifs()
//                withContext(Dispatchers.Main) {
//                    callback(result, null)
//                }
//
//            } catch (e: Throwable) {
//                withContext(Dispatchers.Main) {
//                    callback(null, e)
//                }
//            }
//        }
//    }

