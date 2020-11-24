package com.dsc.androidstudyjam.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dsc.androidstudyjam.databinding.ActivityPersonalDetailsBinding
import com.dsc.androidstudyjam.login.LoginActivity.Companion.USER_KEY

class PersonalDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPersonalDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPersonalDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSave.setOnClickListener {
            // TODO Do validations
            val name = binding.etName.text.toString()
            val data = intent.putExtra(USER_KEY, name)
            setResult(RESULT_OK, data)
            finish()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        setResult(RESULT_CANCELED, null)
        finish()
    }
}