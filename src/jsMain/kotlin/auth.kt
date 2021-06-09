package auth

import Credentials
import kotlinx.browser.localStorage

const val accessTokenKey = "accessToken";

fun isLoggedIn() = !localStorage.getItem(accessTokenKey).isNullOrEmpty()

suspend fun logIn(email: String, password: String) =
  API.login(Credentials(email, password))
    ?.also{ localStorage.setItem(accessTokenKey, it) }

fun logOut() = localStorage.removeItem(accessTokenKey)
