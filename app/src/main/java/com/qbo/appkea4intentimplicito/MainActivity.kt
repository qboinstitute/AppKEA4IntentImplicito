package com.qbo.appkea4intentimplicito

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.qbo.appkea4intentimplicito.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btncompartir.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val enviarIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, "Hola mundo")
            type = "text/plain"
        }
        if(enviarIntent.resolveActivity(packageManager) != null){
            startActivity(enviarIntent)
        }
    }
}