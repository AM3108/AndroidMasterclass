package com.atul.androidmasterclass.learning.smartphone

import dagger.Module
import dagger.Provides

@Module
class MemoryCardModules {
//We should always annotate with provide otherwise dagger will not recognized it as provide function.
    //This annotation tells dagger these fn provide end object of the return data type
    @Provides
    fun provideMemoryCard() : MemoryCard{
        return MemoryCard()
    }

    /*Now we have created MemoryCardModuleClass.
    * We have to go to Component Interface eg:- SmartPhoneComponent Interface
    * And add module class to Component*/
}

/*Important Point
* Module is only needed when we cannot access that class for e.g. retrofit, room.
* It's not recommended for a module to have a state i.e A module should not have instance variable. Because it can lead to a unpredictable behaviour.
* We should create modules actually when we needed it. As we can Inject annotation then why to waste time.*/