package panmarg.erestaurants.data

data class Restaurants(
    val name: String,
    val category: String,
    val rating: Double,
    val imageId: Int,
    val distance: String,
    val location: String,
    val price: String,
    val description: String
)