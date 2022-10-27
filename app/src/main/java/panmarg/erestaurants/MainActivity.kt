package panmarg.erestaurants

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import panmarg.erestaurants.adapters.RestaurantsAdapter
import panmarg.erestaurants.data.Restaurants
import panmarg.erestaurants.databinding.ActivityMainBinding
import panmarg.erestaurants.viewmodels.RestaurantsViewModel

class MainActivity : AppCompatActivity() {
    
    private lateinit var restaurantsViewModel: RestaurantsViewModel
    private lateinit var restaurantsAdapter: RestaurantsAdapter
    private lateinit var restaurantsRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initializeValues(binding)
        initializeRecyclerView()
        restaurantsViewModelObserve()


    }

    private fun initializeValues(binding: ActivityMainBinding) {
        restaurantsViewModel = ViewModelProvider(this)[RestaurantsViewModel::class.java]
        restaurantsAdapter = RestaurantsAdapter(arrayListOf()) {
            onRestaurantClick(it)
        }
        restaurantsRecyclerView = binding.rvRestaurants
    }

    private fun initializeRecyclerView() {
        restaurantsRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = restaurantsAdapter
            setHasFixedSize(true)
        }
    }

    private fun restaurantsViewModelObserve() {
        restaurantsViewModel.refresh()
        restaurantsViewModel.restaurants.observe(this) {
            restaurantsAdapter.updateRestaurants(it)
        }
    }

    private fun onRestaurantClick(restaurant: Restaurants) {
        val intent = Intent(this, RestaurantDetailsActivity::class.java)
        intent.putExtra("restaurantName", restaurant.name)
        intent.putExtra("restaurantImage", restaurant.imageId)
        intent.putExtra("restaurantLocation", restaurant.location)
        intent.putExtra("restaurantPrice", restaurant.price)
        intent.putExtra("restaurantDescr", restaurant.description)
        this.startActivity(intent)
    }


}