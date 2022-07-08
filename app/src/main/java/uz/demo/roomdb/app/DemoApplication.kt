package uz.demo.roomdb.app

import android.app.Application
import uz.demo.roomdb.di.AppComponent

class DemoApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        AppComponent.create(this)

    }
}