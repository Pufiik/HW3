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

    fun getData(ind: Int, callback: (result: Map<String, String>?) -> Unit) {
        scope.launch {
            delay(2000L)
            var data = Provider.getInfo(ind)
            var result = data
            withContext(Dispatchers.Main) {
                callback(result)
            }
        }
    }
}
