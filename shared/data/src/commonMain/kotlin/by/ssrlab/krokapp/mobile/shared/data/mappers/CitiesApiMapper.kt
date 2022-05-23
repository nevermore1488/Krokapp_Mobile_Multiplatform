package by.ssrlab.krokapp.mobile.shared.data.mappers

import by.ssrlab.krokapp.mobile.shared.data.api.entities.CityApi
import by.ssrlab.krokapp.mobile.shared.domain.entities.City

/**
 * @author Alexander Nevertovich
 */
class CitiesApiMapper {

    operator fun invoke(cityApi: CityApi): City {
        return City(
            id = cityApi.id,
            logo = cityApi.logo,
            name = cityApi.name,
            lang = cityApi.lang,
            lastEditTime = cityApi.last_edit_time,
            lat = cityApi.lat,
            lng = cityApi.lng
        )
    }
}