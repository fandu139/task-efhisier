package com.fandu.home.view

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.fandu.home.MainViewModel
import com.fandu.home.R
import com.fandu.home.databinding.MainBinder
import com.fandu.home.view.fragment.AddFragment
import com.fandu.home.view.fragment.MainFragment

// target from MainFragment
// send to MainViewModel
// send to MainFragment
// send to AddFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding : MainBinder
    private lateinit var viewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            callMainFragment()

            viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        }
    }

    private fun callMainFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container,
                MainFragment.newInstance()
            )
            .commitNow()
    }

    fun callAddFragment() {
        supportFragmentManager.beginTransaction()
            .add(R.id.container,
                AddFragment.newInstance()
            )
            .addToBackStack("AddFragment").commit()
    }

    fun showSoftKeyboard(activity: Activity, showKeyboard : Boolean) {
        var view = activity.currentFocus
        when(showKeyboard){
            true -> {
                val imm = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
            }
            false ->{
                val imm = activity.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
                //Find the currently focused view, so we can grab the correct window token from it.

                //If no view currently has focus, create a new one, just so we can grab a window token from it
                if (view == null) {
                    view = View(activity)
                }
                imm.hideSoftInputFromWindow(view.windowToken, 0)
            }
        }
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount == 0) {
            super.onBackPressed()
        }
        else {
            supportFragmentManager.popBackStack()
        }
    }

}
