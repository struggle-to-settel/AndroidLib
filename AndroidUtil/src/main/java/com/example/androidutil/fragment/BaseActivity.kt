package com.example.androidutil.fragment

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<viewBinding : ViewBinding> : AppCompatActivity() {

    private var _binding: viewBinding? = null
    val binding get() = _binding!!

    abstract fun getViewBinding(): viewBinding

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        _binding = getViewBinding()
        setContentView(binding.root)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = getViewBinding()
        setContentView(binding.root)
    }


}