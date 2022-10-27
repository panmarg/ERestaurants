package panmarg.erestaurants.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import panmarg.erestaurants.data.UserReviews
import panmarg.erestaurants.adapters.UserReviewsAdapter

import panmarg.erestaurants.databinding.ReviewsFragmentBinding

class ReviewsFragment : Fragment() {

    private var binding: ReviewsFragmentBinding? = null
    private lateinit var userReviewsRecyclerView: RecyclerView
    private lateinit var userReviewsArrayList: ArrayList<UserReviews>




    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ReviewsFragmentBinding.inflate(inflater,container,false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var userCommentsData = arguments
        var reviewsCounter = userCommentsData?.getString("reviewsCounter")


        userReviewsRecyclerView = binding!!.rvUserReviews
        userReviewsRecyclerView.layoutManager = LinearLayoutManager(context)
        userReviewsRecyclerView.setHasFixedSize(true)
        userReviewsArrayList = arrayListOf<UserReviews>()

        if (reviewsCounter != null) {
            getReviews(reviewsCounter.toInt())
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }


    private fun getReviews(totalReviews: Int){
        for (i in 1..totalReviews) {
            val randomNumber = (0..10).random()
            userReviewsArrayList.add(UserReviews(i,randomNumber.toDouble()))
        }
        userReviewsRecyclerView.adapter = UserReviewsAdapter(userReviewsArrayList)


    }
}