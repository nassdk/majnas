package com.nassdk.supchat.presentation.resetpassword.mvp

import android.content.Context
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.google.firebase.auth.FirebaseAuth
import com.nassdk.supchat.domain.extensions.isNetworkAvailable

@InjectViewState
class ResetPassPresenter : MvpPresenter<ResetPassView>() {

    fun resetPassword(eMail: String) {

        val auth: FirebaseAuth = FirebaseAuth.getInstance()

        if (eMail.isEmpty()) {
            viewState.showEmptyError()
        } else run {
            auth.sendPasswordResetEmail(eMail).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    viewState.openLogin()
                    viewState.showSuccess()
                } else {
                    val error = task.exception!!.message
                    viewState.showError(error)
                }
            }
        }
    }

    fun checkInternetConnection(context: Context) : Boolean {
        if(!isNetworkAvailable(context)) {
            viewState.showNoInternetDialog()
            return true
        }
        return false
    }
}