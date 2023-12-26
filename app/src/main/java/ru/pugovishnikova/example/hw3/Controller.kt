package ru.pugovishnikova.example.hw3

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


object Controller {

    val scope = CoroutineScope(Dispatchers.IO)
    fun checkEmail(emailEditText: String, callback: (result: Boolean) -> Unit) {
        scope.launch {
            delay(4000L)
            val result = emailEditText == Provider.getEmail()
            withContext(Dispatchers.Main) {
                callback(result)
            }

        }
    }

    fun getData(ind: Int, callback: (result: Map<String, Any>?, error: Throwable?) -> Unit) {
        scope.launch {
            delay(2000L)
            try {
                var data = Provider.getInfo(ind)
                var result = data
                var rand = (0..10).random()
                if (rand % 2 == 0)
                    throw Exception("exeption")
                withContext(Dispatchers.Main) {
                    callback(result, null)
                }
            } catch (e: Throwable) {
                withContext(Dispatchers.Main) {
                    callback(null, e)
                }
            }
        }
    }
}
