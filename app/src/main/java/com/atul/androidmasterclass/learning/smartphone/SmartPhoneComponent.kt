package com.atul.androidmasterclass.learning.smartphone

import dagger.Component

@Component(modules = [MemoryCardModules::class])
interface SmartPhoneComponent {

    fun getSmartphone(): SmartPhone
}