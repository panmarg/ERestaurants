package panmarg.erestaurants.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import panmarg.erestaurants.R
import panmarg.erestaurants.data.Restaurants

class RestaurantsViewModel : ViewModel() {
    private val _restaurants = MutableLiveData<List<Restaurants>>()

    val restaurants : LiveData<List<Restaurants>>
        get() = _restaurants


    fun refresh(){
        fetchRestaurants()
    }

    private fun fetchRestaurants(){
        val mockRestaurantsData = listOf(
            Restaurants(
                "Burger King",
                "BURGERS",
                8.6,
                R.drawable.restaurant_1,
                "600 m",
                "Cleveland",
                "4",
                "Savor a flavor at Burger King, a brand-new restaurant in Cleveland. Whether you’re in the mood for something spicy or sweet, we’ve got a huge range of authentic cuisine available on our menu all deep fried to perfection. We’re excited to bring something new to our community and can’t wait to share our unique recipes."
            ),
            Restaurants(
                "Hakka Bistro",
                "STEAKS",
                7.9,
                R.drawable.restaurant_2,
                "450 m",
                "Boston",
                "1",
                "Savor a flavor at Hakka Bistro, a brand-new restaurant in Boston. Whether you’re in the mood for something spicy or sweet, we’ve got a huge range of authentic cuisine available on our menu all deep fried to perfection. We’re excited to bring something new to our community and can’t wait to share our unique recipes."

            ),
            Restaurants(
                "Ace of Salads",
                "SALADS",
                7.6,
                R.drawable.restaurant_3,
                "790 m",
                "Houston",
                "2",
                "Savor a flavor at Ace of Salads, a brand-new restaurant in Houston. Whether you’re in the mood for something spicy or sweet, we’ve got a huge range of authentic cuisine available on our menu all deep fried to perfection. We’re excited to bring something new to our community and can’t wait to share our unique recipes."

            ),
            Restaurants(
                "Insta Italy",
                "PASTA",
                7.5,
                R.drawable.restaurant_4,
                "120 m",
                "San Antonio",
                "5",
                "Savor a flavor at Insta Italy, a brand-new restaurant in San Antonio. Whether you’re in the mood for something spicy or sweet, we’ve got a huge range of authentic cuisine available on our menu all deep fried to perfection. We’re excited to bring something new to our community and can’t wait to share our unique recipes."

            )
        )

        _restaurants.postValue(mockRestaurantsData)
    }

}