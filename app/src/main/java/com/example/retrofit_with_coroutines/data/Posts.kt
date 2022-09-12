package com.example.retrofit_with_coroutines.data

import com.squareup.moshi.Json

data class Posts(
    @Json(name = "id") val id: Int,
    @Json(name = "title") val title: String,
    @Json(name = "url") val url: String? = "",
    @Json(name = "thumbnailUrl") val thumbnailUrl: String? = ""
)

object sampleData {
    val list = listOf<Posts>(
        Posts(
            1,
            "Title 1",
            "https://via.placeholder.com/150/92c952",
            "https://via.placeholder.com/600/92c952"
        ),
        Posts(

            2,
            "Title 2",
            "https://via.placeholder.com/150/92c952",
            "https://via.placeholder.com/600/92c952"
        ),
        Posts(
            3,
            "Title 3",
            "https://via.placeholder.com/150/92c952",
            "https://via.placeholder.com/600/92c952"
        ),
        Posts(
            4,
            "Title 4",
            "https://via.placeholder.com/150/92c952",
            "https://via.placeholder.com/600/92c952"
        ),
        Posts(
            5,
            "Title 5",
            "https://via.placeholder.com/150/92c952",
            "https://via.placeholder.com/600/92c952"
        )
    )
}