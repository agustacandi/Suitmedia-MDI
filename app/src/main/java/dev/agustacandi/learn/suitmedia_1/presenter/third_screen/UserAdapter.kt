package dev.agustacandi.learn.suitmedia_1.presenter.third_screen

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater.from
import android.view.ViewGroup
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import dev.agustacandi.learn.suitmedia_1.databinding.ItemUserBinding
import dev.agustacandi.learn.suitmedia_1.domain.user.model.User

class UserAdapter(private val navDirections: (String) -> NavDirections) : PagingDataAdapter<User, UserAdapter.MyViewHolder>(DIFF_CALLBACK) {

    class MyViewHolder(private val binding: ItemUserBinding, private val navDirections: (String) -> NavDirections) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User) {
            with(binding) {
                civAvatar.load(user.avatar) {
                    placeholder(ColorDrawable(Color.LTGRAY))
                }
                val fullName = "${user.firstName} ${user.lastName}"
                tvName.text = fullName
                tvEmail.text = user.email
                root.setOnClickListener { view ->
                    val navigateToSecondScreen = navDirections(fullName)
                    view.findNavController().navigate(navigateToSecondScreen)
                }
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val binding = ItemUserBinding.inflate(from(parent.context), parent, false)
        return MyViewHolder(binding, navDirections)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val user = getItem(position)
        if (user != null) {
            holder.bind(user)
        }
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<User>() {
            override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
                return oldItem == newItem
            }
        }
    }
}