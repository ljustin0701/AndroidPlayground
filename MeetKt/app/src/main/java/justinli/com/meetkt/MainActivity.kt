package justinli.com.meetkt

import android.content.Intent
import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import justinli.com.meetkt.features.login.LoginActivity
import justinli.com.meetkt.features.login.SessionManager

class MainActivity : AppCompatActivity() {

    private lateinit var sessionManager: SessionManager
    private lateinit var mainViewModel: MainViewModel
    private lateinit var fragmentRoot: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fragmentRoot = requireViewById(R.id.fragment)

        mainViewModel = ViewModelProviders.of(this)[MainViewModel::class.java]
        sessionManager = SessionManager.get(applicationContext)
    }

    override fun onStart() {
        super.onStart()

        sessionManager.loggedIn().observe(this, Observer {
            if (!it) {
                val loginIntent = Intent(applicationContext, LoginActivity::class.java)
                startActivity(loginIntent)
                finish()
            }
        })
    }
}
