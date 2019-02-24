package nikita.com.plainkeeper

import android.app.Application
import nikita.com.plainkeeper.di.authModule
import nikita.com.plainkeeper.di.plainKeeperModule
import nikita.com.plainkeeper.di.sessionModule
import org.koin.android.ext.android.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(
            this, listOf(plainKeeperModule, authModule, sessionModule)
        )
    }

}