package com.example.gatheringfront

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.gatheringfront.databinding.ActivityMainBinding
import com.example.gatheringfront.ui.ContentAddActivity
import com.example.gatheringfront.ui.home.HomeFragment
import com.example.gatheringfront.ui.ProfileFragment
import com.example.gatheringfront.ui.SearchFragment
import com.example.gatheringfront.util.replace


class MainActivity : AppCompatActivity() {
    private val homeFragment: HomeFragment by lazy { HomeFragment() }
    private val profileFragment: ProfileFragment by lazy { ProfileFragment()}
    private val searchFragment : SearchFragment by lazy { SearchFragment()}
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
    }

    override fun onResume(){
        super.onResume()
        Log.d("itm", "resume")
        replaceHomeFragment()
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
                val intent = Intent(this, ContentAddActivity::class.java)
                startActivity(intent)
                return true
            }
        }
        return false
    }

    private fun replaceHomeFragment() {
        Log.d("itm", "replace home fragment")
        replace(R.id.container_main, homeFragment)
    }
}