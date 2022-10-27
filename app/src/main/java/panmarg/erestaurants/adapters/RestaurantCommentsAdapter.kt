package panmarg.erestaurants.adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import panmarg.erestaurants.data.RestaurantComments
import panmarg.erestaurants.databinding.RestaurantCommentBinding

class RestaurantCommentsAdapter(
    private val restaurantCommentsList: ArrayList<RestaurantComments>,
    val onRestaurantCommentClick: (restaurantsComment: RestaurantComments) -> Unit
) : RecyclerView.Adapter<RestaurantCommentsAdapter.RestaurantCommentsViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RestaurantCommentsViewHolder {
        val restaurantCommentsView =
            RestaurantCommentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RestaurantCommentsViewHolder(restaurantCommentsView)

    }

    override fun onBindViewHolder(holder: RestaurantCommentsViewHolder, position: Int) {
        holder.bind(restaurantCommentsList[position])


    }

    override fun getItemCount(): Int {
        return restaurantCommentsList.size
    }

    inner class RestaurantCommentsViewHolder(val binding: RestaurantCommentBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(restaurantComment: RestaurantComments) {
            binding.tvUsername.text = restaurantComment.username
            binding.tvUserComment.text = restaurantComment.comment
            binding.tvUserCommentDate.text = restaurantComment.commentDate
            binding.clComment.setOnClickListener {
              onRestaurantCommentClick(restaurantComment)
            }
        }



    }
}