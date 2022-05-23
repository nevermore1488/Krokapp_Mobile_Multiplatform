package by.ssrlab.krokapp.mobile.shared.domain.repos

import by.ssrlab.krokapp.mobile.shared.domain.entities.City
import kotlinx.coroutines.flow.Flow

/**
 * @author Alexander Nevertovich
 */
interface CitiesRepository {

    fun getCities(): Flow<List<City>>
}