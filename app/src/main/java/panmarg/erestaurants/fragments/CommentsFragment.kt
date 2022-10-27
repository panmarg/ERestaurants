package panmarg.erestaurants.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import panmarg.erestaurants.data.UserComments
import panmarg.erestaurants.adapters.UserCommentsAdapter
import panmarg.erestaurants.databinding.CommentsFragmentBinding

class CommentsFragment : Fragment() {


    private var binding: CommentsFragmentBinding? = null
    private lateinit var userCommentsRecyclerView: RecyclerView
    private lateinit var userCommentsArrayList: ArrayList<UserComments>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = CommentsFragmentBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var userCommentsData = arguments
        var commentsCounter = userCommentsData?.getString("commentsCounter")
        var username = userCommentsData?.getString("username")

        userCommentsRecyclerView = binding!!.rvUserComments
        userCommentsRecyclerView.layoutManager = LinearLayoutManager(context)
        userCommentsRecyclerView.setHasFixedSize(true)
        userCommentsArrayList = arrayListOf<UserComments>()

        if (commentsCounter != null && username != null) {
            getComments(commentsCounter.toInt(),username)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    private fun getComments(totalComments: Int, username: String){
        for (i in 1..totalComments) {
            userCommentsArrayList.add(UserComments(username, "This is a fantastic restaurant", "Mon at 12:45pm"))
        }
        userCommentsRecyclerView.adapter = UserCommentsAdapter(userCommentsArrayList)


    }

}