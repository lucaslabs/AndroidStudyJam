package com.dsc.androidstudyjam.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dsc.androidstudyjam.databinding.ActivityHomeBinding
import com.dsc.androidstudyjam.login.LoginActivity.Companion.USER_KEY

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = intent.getStringExtra(USER_KEY)
        setupUserName(username)

        binding.tvEdit.setOnClickListener {
            val intent = Intent(this, PersonalDetailsActivity::class.java)
            startActivityForResult(intent, HOME_REQUEST_CODE)
        }
    }

    private fun setupUserName(username: String?) {
        binding.tvUser.text = username
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