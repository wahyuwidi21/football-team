package com.made.footballteam.favorite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.made.footballteam.favorite.databinding.ActivityFavoriteBinding

class FavoriteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFavoriteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityFavoriteBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}