package panmarg.erestaurants.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import panmarg.erestaurants.data.UserComments
import panmarg.erestaurants.databinding.UserCommentBinding

class UserCommentsAdapter(private val userCommentsList: ArrayList<UserComments>) : RecyclerView.Adapter<UserCommentsAdapter.UserCommentsViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserCommentsViewHolder {
        val userCommentView = UserCommentBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return UserCommentsViewHolder(userCommentView)
    }

    override fun onBindViewHolder(holder: UserCommentsViewHolder, position: Int) {
        holder.bind(userCommentsList[position])

    }

    override fun getItemCount(): Int {
        return userCommentsList.size
    }

    inner class UserCommentsViewHolder(val binding: UserCommentBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(userComments: UserComments){
            binding.tvUsername.text = userComments.username
            binding.tvUserComment.text = userComments.comment
            binding.tvUserCommentDate.text = userComments.commentDate
        }
    }
}