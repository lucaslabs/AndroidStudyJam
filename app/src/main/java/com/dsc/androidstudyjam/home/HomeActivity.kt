package com.dsc.androidstudyjam.home

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.dsc.androidstudyjam.R
import com.dsc.androidstudyjam.databinding.ActivityHomeBinding
import com.dsc.androidstudyjam.home.HomeAdapter.Companion.CART
import com.dsc.androidstudyjam.home.HomeAdapter.Companion.CLOTHES
import com.dsc.androidstudyjam.home.HomeAdapter.Companion.MY_ITEMS
import com.dsc.androidstudyjam.home.HomeAdapter.Companion.PRIZE
import com.dsc.androidstudyjam.home.HomeAdapter.Companion.PROFILE
import com.dsc.androidstudyjam.home.HomeAdapter.Companion.TRACKING
import com.dsc.androidstudyjam.home.HomeAdapter.Companion.WALLET
import com.dsc.androidstudyjam.login.LoginActivity.Companion.USER_KEY

class HomeActivity : AppCompatActivity(), HomeAdapter.ItemClickListener {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = intent.getStringExtra(USER_KEY)

        setupUserName(username)

        setupItems()

        binding.tvEdit.setOnClickListener {
            val intent = Intent(this, PersonalDetailsActivity::class.java)
            startActivityForResult(intent, HOME_REQUEST_CODE)
        }
    }

    private fun setupUserName(username: String?) {
        binding.tvUser.text = username
    }

    private fun setupItems() {
        // Get items
        val items = createItems()

        // Create adapter
        val adapter = HomeAdapter(items, itemClickListener = this)

        // Set up RecyclerView adapter
        val dividerItemDecoration =
            DividerItemDecoration(binding.rvItems.context, LinearLayoutManager.VERTICAL)
        binding.rvItems.addItemDecoration(dividerItemDecoration)
        binding.rvItems.adapter = adapter
    }

    private fun createItems(): List<Pair<Int, String>> {
        return listOf(
            Pair(PROFILE, getString(R.string.profile)),
            Pair(MY_ITEMS, getString(R.string.my_items)),
            Pair(CART, getString(R.string.cart)),
            Pair(CLOTHES, getString(R.string.clothes)),
            Pair(PRIZE, getString(R.string.prize)),
            Pair(TRACKING, getString(R.string.tracking)),
            Pair(WALLET, getString(R.string.wallet))
        )
    }

    override fun onItemClick(item: Pair<Int, String>) {
        when (item.first) {
            PROFILE -> showScreen(item.second)
            MY_ITEMS -> showScreen(item.second)
            CART -> showScreen(item.second)
            CLOTHES -> showScreen(item.second)
            PRIZE -> showScreen(item.second)
            TRACKING -> showScreen(item.second)
            WALLET -> showScreen(item.second)
        }
    }

    private fun showScreen(screen: String) {
        Toast.makeText(this, "Go to $screen", Toast.LENGTH_SHORT).show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == HOME_REQUEST_CODE && resultCode == RESULT_OK) {
            setupUserName(data?.getStringExtra(USER_KEY))
        } else {
            // RESULT_CANCELED
        }
    }

    companion object {
        const val HOME_REQUEST_CODE = 100
    }
}