package uz.demo.roomdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import uz.demo.roomdb.ui.home.MoviesFragment


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(savedInstanceState == null){
            val homeFragment = MoviesFragment()
            supportFragmentManager.commit {
                replace(R.id.fragment_container_view_tag, homeFragment)
                setReorderingAllowed(true)
            }

        }

    }

}