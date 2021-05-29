package com.national.testhilt.utils

import android.app.Service
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import com.google.android.material.snackbar.Snackbar

fun View.showKeyBoard(){
    (this.context.getSystemService(Service.INPUT_METHOD_SERVICE) as? InputMethodManager)
        ?.showSoftInput(this, 0)
}

fun View.hideKeyboard() {
    (this.context.getSystemService(Service.INPUT_METHOD_SERVICE) as? InputMethodManager)
        ?.hideSoftInputFromWindow(this.windowToken, 0)
}

fun View.toVisible(){
    this.visibility = View.VISIBLE
}

fun View.toGone(){
    this.visibility = View.GONE
}

fun View.toInvisible(){
    this.visibility = View.GONE
}

fun View.showSnackBar(snackBarTexr : String , timeLength : Int){
    Snackbar.make(this,snackBarTexr,timeLength).run {
        addCallback(object : Snackbar.Callback() {
            override fun onShown(sb: Snackbar?) {

            }

            override fun onDismissed(transientBottomBar: Snackbar?, event: Int) {
            }

    })
        show()
    }
}

fun View.setupSnackbar(lifecycleOwner: LifecycleOwner,
                       snackbarEvent : LiveData<SingleEvent<Any>>,
                       timeLength : Int){
    snackbarEvent.observe(lifecycleOwner,{event ->
        event.getContentIfNotHandled()?.let {
            when(it) {
             is String -> {
                 hideKeyboard()
                 showSnackBar(it,timeLength)
             }
                is Int -> {
                    hideKeyboard()
                    showSnackBar(this.context.getString(it) , timeLength)
                }
                else ->{

                }
            }
        }
    })
}