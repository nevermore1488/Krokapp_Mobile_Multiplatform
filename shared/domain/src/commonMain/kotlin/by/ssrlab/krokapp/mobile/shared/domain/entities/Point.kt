package by.ssrlab.krokapp.mobile.shared.domain.entities

class Point(
    var id: Int,
    var cityId: Int,
    var logo: String,
    var name: String,
    var sound: String?,
    var text: String,
    var images: List<String>,
    var tags: List<Int>,
    var lang: Int,
    var lastEditTime: Int,
    var lat: Double,
    var lng: Double
)
