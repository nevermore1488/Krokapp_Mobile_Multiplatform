package by.ssrlab.krokapp.mobile.shared.data.entities

class PointApi(
    var city_id: Int,
    var id: Int,
    var id_point: Int,
    var is_excursion: Boolean,
    var lang: Int,
    var last_edit_time: Int,
    var lat: Double,
    var lng: Double,
    var logo: String,
    var name: String,
    var photo: String,
    var sound: String,
    var text: String,
    var visible: Boolean,
    var images: List<String>,
    var tags: List<Int>,
)