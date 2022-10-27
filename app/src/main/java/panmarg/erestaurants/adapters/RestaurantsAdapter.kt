package panmarg.erestaurants.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import panmarg.erestaurants.data.Restaurants
import panmarg.erestaurants.databinding.RestaurantCardBinding


class RestaurantsAdapter(
    private var restaurantsList: ArrayList<Restaurants>,
    private var onRestaurantClick: (restaurant: Restaurants) -> Unit
) :
    RecyclerView.Adapter<RestaurantsAdapter.RestaurantsViewHolder>() {

    fun updateRestaurants(newRestaurants: List<Restaurants>) {
        restaurantsList.clear()
        restaurantsList.addAll(newRestaurants)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantsViewHolder {
        val restaurantView =
            RestaurantCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RestaurantsViewHolder(restaurantView)
    }

    override fun onBindViewHolder(holder: RestaurantsViewHolder, position: Int) {
        holder.bind(restaurantsList[position])
    }

    override fun getItemCount(): Int {
        return restaurantsList.size
    }

    inner class RestaurantsViewHolder(val binding: RestaurantCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(restaurant: Restaurants) {
            binding.tvRestaurantName.text = restaurant.name
            binding.ivRestaurantImage.setImageResource(restaurant.imageId)
            binding.tvRestaurantCategory.text = restaurant.category
            binding.tvRestaurantRating.text = restaurant.rating.toString()
            binding.tvRestaurantDistance.text = restaurant.distance
            binding.tvRestaurantLocation.text = restaurant.location
            binding.clRestaurant.setOnClickListener {
                onRestaurantClick(restaurant)
            }
        }


    }

}