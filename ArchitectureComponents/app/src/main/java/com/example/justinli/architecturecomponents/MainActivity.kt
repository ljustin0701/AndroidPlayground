package com.example.justinli.architecturecomponents

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.animation.AnimationUtils
import android.widget.EditText
import android.widget.TextSwitcher

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel : MainViewModel
    private lateinit var text : TextSwitcher
    private lateinit var editText : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        text = findViewById(R.id.text)
        editText = findViewById(R.id.edit_text)

        text.inAnimation = AnimationUtils.loadAnimation(this, android.R.anim.fade_in)
        text.outAnimation = AnimationUtils.loadAnimation(this, android.R.anim.fade_out)

        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        mainViewModel.text().observe(this, Observer<String> {
            string -> string?.let { text.setText(it) }
        })

        mainViewModel.editText().observe(this, Observer<String> {
            string -> string?.let { mainViewModel.text().value = it }
        })

        editText.setOnEditorActionListener { textView, _, _ ->
            textView?.let {
                mainViewModel.editText().value = it.text.toString()
                return@setOnEditorActionListener true
            }
            false
        }
    }
}
