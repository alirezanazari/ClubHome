package ir.alirezanazari.data.util

import android.content.Context
import java.util.*

// Written by Alireza Nazari, <@ali_rezaNazari> <a.alirezaNazari@gmail.com>.

// todo: save data to account manager
class SessionManager constructor(private val context: Context) {

    var deviceID: String? = null
    var userID: String? = null
    var userToken: String? = null
    var isWaitlisted: Boolean = false

    private val prefs by lazy {
        context.getSharedPreferences(PREF_SESSION, Context.MODE_PRIVATE)
    }

    fun load() {
        prefs.apply {
            deviceID = getString(PREF_DEVICE_ID, null)
            userID = getString(PREF_USER_ID, null)
            userToken = getString(PREF_USER_TOKEN, null)
            isWaitlisted = getBoolean(PREF_WAITLISTED, false)
        }

        if (deviceID == null) {
            deviceID = UUID.randomUUID().toString().toUpperCase()
            write()
        }
    }

    fun write() {
        prefs.edit()
            .putString(PREF_DEVICE_ID, deviceID)
            .putString(PREF_USER_ID, userID)
            .putString(PREF_USER_TOKEN, userToken)
            .putBoolean(PREF_WAITLISTED, isWaitlisted)
            .apply()
    }

    companion object {
        private const val PREF_SESSION = "session"
        private const val PREF_DEVICE_ID = "device_id"
        private const val PREF_USER_ID = "user_id"
        private const val PREF_USER_TOKEN = "user_token"
        private const val PREF_WAITLISTED = "waitlisted"
    }
}