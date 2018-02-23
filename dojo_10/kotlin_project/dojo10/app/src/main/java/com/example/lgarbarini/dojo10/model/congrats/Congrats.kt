package com.example.lgarbarini.dojo10.model.congrats

import com.example.lgarbarini.dojo10.model.devices.Device

/**
 * Created by lgarbarini on 23/02/2018.
 */
class Congrats(val json: String) {

    fun adaptFor(device: Device) : Congrats {
        return this
    }

    fun toJson() : String {
        return json
    }
}