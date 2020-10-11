package com.benidict.master_details

import android.app.Application
import com.benidict.master_details.injection.gatewayModule
import com.benidict.master_details.injection.networkModule
import com.benidict.master_details.injection.usecaseModule
import com.benidict.master_details.injection.viewmodelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MasterDetailsApplication : Application(){
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MasterDetailsApplication)
            modules(
                networkModule,
                gatewayModule,
                usecaseModule,
                viewmodelModule
            )
        }
    }
}