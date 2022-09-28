package com.atul.androidmasterclass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.atul.androidmasterclass.learning.smartphone.*

class MainActivity : AppCompatActivity() {
    private lateinit var smartPhone: SmartPhone
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
// without dagger
//        val smartPhone = SmartPhone(
//            Battery(),
//            MemoryCard(),
//            SimCard(ServiceProvider())
//        ).makeACallWithRecording()

        //with Dagger
        DaggerSmartPhoneComponent.create()
            .getSmartphone()
            .makeACallWithRecording()
        /*We do not constructed any dependency in Main Activity.
        * Instead we constructed them outside of Activity and Injected them in Activity if required*
        * We have to use Inject for all the constructor we use
        * We have to also use component Interface annoted with component annotation to tell dagger to construc these dpendencies*/
    }
}