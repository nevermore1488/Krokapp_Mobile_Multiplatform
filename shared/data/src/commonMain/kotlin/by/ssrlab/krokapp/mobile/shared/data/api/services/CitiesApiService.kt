package by.ssrlab.krokapp.mobile.shared.data.api.services

import by.ssrlab.krokapp.mobile.shared.data.entities.CityApi
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

/**
 * @author Alexander Nevertovich
 */
class CitiesApiService(
    private val apiClient: HttpClient,
    private val baseUrl: String
) {

    suspend fun getCities(): List<CityApi> {
        return apiClient.get("$baseUrl/get_cities/111111").body()
    }
}