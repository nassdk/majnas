package com.nassdk.supchat.global

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.Toolbar
import com.arellomobile.mvp.MvpAppCompatFragment
import com.nassdk.supchat.R
import com.nassdk.supchat.global.extensions.makeGone
import com.nassdk.supchat.global.extensions.makeVisible
import com.nassdk.supchat.presentation.mainflow.ui.MainFlowFragment
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.loading_view.*

abstract class BaseFragment : MvpAppCompatFragment(), BaseView {

    abstract val resourceLayout: Int
    protected val subscriptions = CompositeDisposable()

    final override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            layoutInflater.inflate(resourceLayout, container, false)

    override fun onDestroy() {
        subscriptions.clear()
        super.onDestroy()
    }

    override fun showLoading() = spinner.makeVisible()
    override fun hideLoading() = spinner.makeGone()

    fun showNoInternetDialog() {
        val builder = AlertDialog.Builder(context!!)
        builder.setTitle(getString(R.string.warning_message_title))
                .setMessage(getString(R.string.warning_no_internet_message))
                .setIcon(R.drawable.ic_warning)
                .setCancelable(false)
                .setNegativeButton(getString(R.string.warning_alert_exit_button_title)
                ) { _, _ -> activity?.finish() }
        val alert = builder.create()
        alert.show()
    }

    protected fun setupToolbar(
            title: String,
            showNavIcon: Boolean = false,
            @DrawableRes iconDrawable: Int = R.drawable.ic_action_navigation_arrow_back_inverted
    ) {
        val toolbar: Toolbar? = view?.findViewById(R.id.toolBar)
        toolbar?.run {
            if (showNavIcon) {
                setNavigationIcon(iconDrawable)
                setNavigationOnClickListener { onBackPressed() }
            }
            this.title = title
        }
    }

    protected fun getBaseFragment() = (parentFragment as MainFlowFragment)

    abstract fun onBackPressed()

    open fun resetStack() {}
    open fun toSwitchTab(pos: Int) {}
    open fun previousTab() {}
    open fun showBottomNavigation(show: Boolean) {}
}