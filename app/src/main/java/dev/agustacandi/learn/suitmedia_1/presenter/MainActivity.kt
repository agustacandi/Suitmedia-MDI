package dev.agustacandi.learn.suitmedia_1.presenter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.agustacandi.learn.suitmedia_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainActivityBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivityBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainActivityBinding.root)
    }
}