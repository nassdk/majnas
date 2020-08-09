package com.nassdk.supchat.global.navigation

import com.nassdk.supchat.presentation.SplashFragment
import com.nassdk.supchat.presentation.conversation.ui.ConversationFragment
import com.nassdk.supchat.presentation.login.ui.LoginFragment
import com.nassdk.supchat.presentation.mainflow.ui.MainFlowFragment
import com.nassdk.supchat.presentation.mychats.ui.MyChatsFragment
import com.nassdk.supchat.presentation.news.ui.NewsFragment
import com.nassdk.supchat.presentation.profilescreen.ui.ProfileFragment
import com.nassdk.supchat.presentation.registerscreen.ui.RegistrationFragment
import com.nassdk.supchat.presentation.resetpassword.ui.ResetPassFragment
import com.nassdk.supchat.presentation.searchusers.ui.SearchFragment
import com.nassdk.supchat.presentation.startscreen.StartFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

object Screens {

    object SplashScreen : SupportAppScreen() {
        override fun getFragment()
                = SplashFragment()
    }

    object StartScreen : SupportAppScreen() {
        override fun getFragment()
                = StartFragment()
    }

    object LoginScreen : SupportAppScreen() {
        override fun getFragment()
                = LoginFragment()
    }

    object RegistrationScreen : SupportAppScreen() {
        override fun getFragment()
                = RegistrationFragment()
    }

    object MainScreen : SupportAppScreen() {
        override fun getFragment()
                = MainFlowFragment()
    }

    object NewsScreen : SupportAppScreen() {
        override fun getFragment()
                = NewsFragment()
    }

    object ChatsScreen : SupportAppScreen() {
        override fun getFragment()
                = MyChatsFragment()
    }

    object ProfileScreen : SupportAppScreen() {
        override fun getFragment()
                = ProfileFragment()
    }

    object ResetPassScreen : SupportAppScreen() {
        override fun getFragment()
                = ResetPassFragment()
    }

    object SearchScreen : SupportAppScreen() {
        override fun getFragment()
                = SearchFragment()
    }

    data class ConversationScreen(val userId: String): SupportAppScreen() {
        override fun getFragment()
                = ConversationFragment.newInstance(userId = userId)
    }

    data class DiffProfileScreen(val userId: String): SupportAppScreen() {
        override fun getFragment()
                = ProfileFragment.newInstance(userId = userId)
    }
}