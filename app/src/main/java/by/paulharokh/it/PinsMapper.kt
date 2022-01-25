package by.paulharokh.it

import android.content.Context
import java.io.IOException

data class PinsMapper(
    val services: List<String>,
    val pins: List<Pins>
)

data class Pins(
    val id: Long,
    val service: String,
    val coordinates: Coordinates
)

data class Coordinates(
    val lat: Double,
    val lng: Double
)

fun getJsonDataFromAsset(context: Context, fileName: String): String? {
    val jsonString: String
    try {
        jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
    } catch (ioException: IOException) {
        ioException.printStackTrace()
        return null
    }
    return jsonString
}
