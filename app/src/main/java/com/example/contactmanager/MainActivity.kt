package com.example.contactmanager
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contactmanager.databinding.ActivityMainBinding
import com.example.contactmanager.room.myviewModel.UserViewModel
import com.example.contactmanager.room.myviewModel.UserViewModelFactory
import com.example.contactmanager.room.User
import com.example.contactmanager.room.UserDatabase
import com.example.contactmanager.room.UserRepro
import com.example.contactmanager.viewsUi.MyRecyclerViewAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var userViewModel: UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val dao = UserDatabase.getInstance(application).userDAO
        val repository = UserRepro(dao)
        val factory = UserViewModelFactory(repository)
        userViewModel = ViewModelProvider(this, factory).get(UserViewModel::class.java)
        binding.userViewModel = this.userViewModel
        binding.lifecycleOwner = this
        initRecyclerView()
    }


    private fun initRecyclerView() {
        binding.recyclerview.layoutManager = LinearLayoutManager(this)
        DisplayUserList()

    }

    private fun DisplayUserList() {
       userViewModel.user.observe(this, Observer {
           binding.recyclerview.adapter =MyRecyclerViewAdapter(it,
               {selectedItem: User ->listItemClicked(selectedItem)})
       })
    }

    private fun listItemClicked(selectedItem: User) {
        Toast.makeText(this,"Selected name is ${selectedItem.name}",Toast.LENGTH_LONG).show()
        userViewModel.initUpdateAndDelete(selectedItem)

    }
}