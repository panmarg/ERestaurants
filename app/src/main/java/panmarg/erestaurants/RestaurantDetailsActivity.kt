package panmarg.erestaurants


import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import panmarg.erestaurants.adapters.RestaurantCommentsAdapter
import panmarg.erestaurants.data.RestaurantComments
import panmarg.erestaurants.databinding.RestaurantDetailsBinding

class RestaurantDetailsActivity : AppCompatActivity() {

    private lateinit var restaurantPrices: ArrayList<ImageView>
    private lateinit var restaurantCommentsRecyclerView: RecyclerView
    private lateinit var restaurantCommentsArrayList: ArrayList<RestaurantComments>
    private lateinit var restaurantCommentsData: Array<RestaurantComments>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = RestaurantDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        var restaurantName = intent.getStringExtra("restaurantName")
        var restaurantImage = intent.getIntExtra("restaurantImage", 0)
        var restaurantLocation = intent.getStringExtra("restaurantLocation")
        var restaurantPrice = intent.getStringExtra("restaurantPrice")
        var restaurantDescr = intent.getStringExtra("restaurantDescr")

        binding.tvRestaurantName.text = restaurantName
        binding.ivRestaurantImage.setImageResource(restaurantImage)
        binding.tvRestaurantLocation.text = restaurantLocation
        binding.tvRestaurantDescription.text = restaurantDescr


        binding.ivBackCirceArrow.setOnClickListener {
            onBackPressed()
        }

        restaurantPrices = arrayListOf(
            binding.ivFirstDollar,
            binding.ivSecondDollar,
            binding.ivThirdDollar,
            binding.ivFourthDollar,
            binding.ivFifthDollar
        )

        restaurantCommentsData = arrayOf(
            RestaurantComments(
                "Samson Christensen",
                "You should visit this place",
                "Mon at 12:45pm"
            ),
            RestaurantComments(
                "Aleisha Shannon",
                "Fine place to eat",
                "Fri at 01:06am"
            ),
            RestaurantComments(
                "Jai Dylan",
                "Unbelievable experience",
                "Sat at 08:43am"
            ),
            RestaurantComments(
                "Angel Rhodes",
                "Wonderful Plates",
                "Wed at 11:36pm"
            )
        )

        restaurantCommentsRecyclerView = binding.rvRestaurantComments
        restaurantCommentsRecyclerView.layoutManager = LinearLayoutManager(this)
        restaurantCommentsRecyclerView.setHasFixedSize(true)

        restaurantCommentsArrayList = arrayListOf<RestaurantComments>()
        getRestaurantCommentsData()
        setDollars(restaurantPrice)


    }

    private fun getRestaurantCommentsData() {
        for (i in restaurantCommentsData.indices) {
            restaurantCommentsArrayList.add(restaurantCommentsData[i])
        }

        restaurantCommentsRecyclerView.adapter =
            RestaurantCommentsAdapter(restaurantCommentsArrayList) {
                val intent = Intent(this, UserProfileActivity::class.java)
                intent.putExtra("username", it.username)
                this.startActivity(intent)
            }

    }


    private fun setDollars(restaurantPrice: String?) {
        if (restaurantPrice != null) {
            for (i in 0 until restaurantPrice.toInt()) {
                restaurantPrices[i].setBackgroundResource(R.drawable.ic_active_dollar)
            }
        }
    }


}