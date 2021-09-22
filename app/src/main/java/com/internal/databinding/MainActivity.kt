package com.internal.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.internal.databinding.adapter.RepoListAdapter
import com.internal.databinding.databinding.ActivityMainBinding
import com.internal.databinding.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }

    private val binding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }

    private val adapter = RepoListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        binding.rvAcronym.adapter = adapter
        viewModel.acronymData.observe(this, { repos ->
            repos?.let { adapter.repos = it }
            adapter.notifyDataSetChanged()
        })

        viewModel.showError.observe(this, {
            Toast.makeText(this,it, Toast.LENGTH_SHORT).show()
        })
    }
}