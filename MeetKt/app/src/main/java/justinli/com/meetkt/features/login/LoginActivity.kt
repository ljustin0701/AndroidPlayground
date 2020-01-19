package justinli.com.meetkt.features.login

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import justinli.com.meetkt.MainActivity
import justinli.com.meetkt.R

class LoginActivity : AppCompatActivity() {

    private lateinit var sessionManager: SessionManager
    private var loginButton: ImageButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        sessionManager = SessionManager.get(applicationContext)
        loginButton = requireViewById(R.id.login_button)
        loginButton?.setOnClickListener {
            sessionManager.update(true)
            startActivity(Intent(applicationContext, MainActivity::class.java))
        }
    }
}