package by.ssrlab.krokapp.mobile.shared.data.entities

import kotlinx.serialization.Serializable

@Serializable
data class CityApi(
    // Unique
    val id_locale: Int,
    val id: Int,
    val lang: Int,
    val last_edit_time: Int,
    val logo: String,
    val name: String,
    val visible: Boolean
)