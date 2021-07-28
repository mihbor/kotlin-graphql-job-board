package auth

import API
import kotlinx.browser.localStorage
import model.Credentials

const val accessTokenKey = "accessToken";

val accessToken get() = localStorage.getItem(accessTokenKey)

fun isLoggedIn() = !localStorage.getItem(accessTokenKey).isNullOrEmpty()

suspend fun logIn(email: String, password: String) =
  API.login(Credentials(email, password))
    ?.also{ localStorage.setItem(accessTokenKey, it.token) }

fun logOut() = localStorage.removeItem(accessTokenKey)
