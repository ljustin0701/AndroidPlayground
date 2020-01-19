package justinli.com.meetkt.features.login

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class SessionManager(val context: Context?) {

    private var loggedIn: MutableLiveData<Boolean> = MutableLiveData(false)

    companion object {
        private var sessionManager: SessionManager? = null

        @Synchronized
        fun get(context: Context): SessionManager {
            sessionManager = sessionManager ?: SessionManager(context)
            return sessionManager!!
        }
    }

    fun loggedIn(): LiveData<Boolean> {
        return loggedIn
    }

    fun update(loggedIn: Boolean) {
        this.loggedIn.value = loggedIn
    }
}