package by.ssrlab.krokapp.mobile.shared.domain.entities

class City(
    val id: Int,
    val logo: String,
    val name: String,
    val lang: Int,
    val lastEditTime: Int,
    var lat: Double,
    var lng: Double
)