package by.ssrlab.krokapp.mobile.shared.data.api.entities

import kotlinx.serialization.*

@Serializable
data class CityApi(
    val id_locale: Int,
    val id: Int,
    val lang: Int,
    val last_edit_time: Int,
    val logo: String,
    val name: String,
    val visible: Boolean,
    var lat: Double = 0.0,
    var lng: Double = 0.0
)