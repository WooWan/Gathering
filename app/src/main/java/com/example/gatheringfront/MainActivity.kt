package com.example.gatheringfront

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.gatheringfront.databinding.ActivityMainBinding
import com.example.gatheringfront.ui.HomeFragment
import com.example.gatheringfront.ui.ProfileFragment
import com.example.gatheringfront.ui.ContentAddFragment
import com.example.gatheringfront.ui.SearchFragment
import com.example.gatheringfront.util.replace


class MainActivity : AppCompatActivity() {
    private val homeFragment: HomeFragment by lazy { HomeFragment() }
    private val profileFragment: ProfileFragment by lazy { ProfileFragment()}
    private val searchFragment : SearchFragment by lazy { SearchFragment()}
    private val contentAddFragment : ContentAddFragment by lazy { ContentAddFragment()}
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        replaceHomeFragment()
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        binding.toolbar.inflateMenu(R.menu.menu_itmes)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.toolbar_search ->{
                replace(R.id.container_main, profileFragment)
                return true
            }
            R.id.toolbar_profile ->{
                replace(R.id.container_main, profileFragment)
                return true
            }
            R.id.toolbar_writing ->{
                replace(R.id.container_main, contentAddFragment)
                return true
            }
        }
        return false
    }

    private fun replaceHomeFragment() {
        replace(R.id.container_main, homeFragment)
    }
}