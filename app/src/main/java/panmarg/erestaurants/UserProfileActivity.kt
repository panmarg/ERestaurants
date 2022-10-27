package panmarg.erestaurants

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import panmarg.erestaurants.databinding.UserProfileBinding
import panmarg.erestaurants.fragments.CommentsFragment
import panmarg.erestaurants.fragments.ReviewsFragment

class UserProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = UserProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var username = intent.getStringExtra("username")
        var reviewsFragment = ReviewsFragment()
        var commentsFragment = CommentsFragment()
        var bundle = Bundle()

        binding.tvUsername.text = username
        binding.tvUserEmail.text = username?.replace(" ", "-")?.lowercase() + "@gmail.com"
        binding.tvUserInstagram.text = "@" + username?.replace(" ", "")?.lowercase()


        binding.ivBackCirceArrow.setOnClickListener {
            onBackPressed()
        }

        displayStats(reviewsFragment)
        passStats("reviewsCounter", binding.tvUserReviewsCounter.text.toString(), reviewsFragment, bundle)
        passStats("username", binding.tvUsername.text.toString(), commentsFragment, bundle)



        binding.clReviews.setOnClickListener {
            displayStats(reviewsFragment)
            passStats("reviewsCounter", binding.tvUserReviewsCounter.text.toString(), reviewsFragment, bundle)
            passStats("username", binding.tvUsername.text.toString(), reviewsFragment, bundle)
        }


        binding.clComments.setOnClickListener {
            displayStats(commentsFragment)
            passStats("commentsCounter", binding.tvUserCommentsCounter.text.toString(), commentsFragment, bundle)
            passStats("username", binding.tvUsername.text.toString(), commentsFragment, bundle)
        }


    }

    private fun passStats(key: String, value: String, fragment: Fragment, bundle: Bundle){
        bundle.putString(key, value)
        fragment.arguments = bundle
    }


    private fun displayStats(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fcvUserStats, fragment)
            commit()
        }
    }



}