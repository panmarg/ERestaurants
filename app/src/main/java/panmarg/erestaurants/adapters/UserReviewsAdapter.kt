package panmarg.erestaurants.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import panmarg.erestaurants.data.UserReviews
import panmarg.erestaurants.databinding.UserReviewBinding


class UserReviewsAdapter(private val userReviewsList: ArrayList<UserReviews>) : RecyclerView.Adapter<UserReviewsAdapter.UserReviewsViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserReviewsViewHolder {
        val userReviewView = UserReviewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return UserReviewsViewHolder(userReviewView)
    }

    override fun onBindViewHolder(holder: UserReviewsViewHolder, position: Int) {
        holder.bind(userReviewsList[position])
    }

    override fun getItemCount(): Int {
        return userReviewsList.size
    }


    inner class UserReviewsViewHolder(val binding: UserReviewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(userReviews: UserReviews) {
            binding.tvUserReview.text = userReviews.userRating.toString()
            binding.tvNumberOfReview.text = userReviews.reviewCounter.toString()
        }


    }


}