package ru.pugovishnikova.example.hw3

object Provider {
    private val Data = mutableListOf(
    mapOf<String, Any>(
        "title" to "Феномен манги JoJo’s Bizarre Adventure",
        "body" to "Очень много людей знает и любит «Невероятные приключения ДжоДжо» за авторством вечно молодого Хирохико Араки — так в чём же секрет такой известности?\n" +
                "35-летняя эпопея о качках как феномен стиля и пафоса.",
        "caption" to "fhgvureiohvle",
        "img" to R.drawable.main
    ),
    mapOf(
        "title" to "Jujutsu Kaisen - современная классика",
        "body" to "“Магическая битва” - манга “новой школы”, рассказывающая о студентах Токийского магического техникума. Чем же история так привлекает читателей?\n" +
                "Инцидент в Сибуя, магия и отсылки к буддизму.",
        "caption" to "aaaaaa",
        "img" to R.drawable.profile
    ),
)
    private val email = "daria.pugovka@yahoo.com"

    fun getEmail(): String {
        return email
    }
    fun getInfo(ind : Int): Map<String, Any>?{
        return if (ind < Data.size) Data[ind] else null
    }
}