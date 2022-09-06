package com.example.retrofit_with_coroutines.data


data class Posts(
    val id: Int,
    val title: String,
    val Thumbnail: String,
    val imageUrl: String
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