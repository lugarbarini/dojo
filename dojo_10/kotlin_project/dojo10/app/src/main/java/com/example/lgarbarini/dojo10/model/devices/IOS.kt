package com.example.lgarbarini.dojo10.model.devices

/**
 * Created by lgarbarini on 23/02/2018.
 */
class IOS(val version: Version) : Device {

    override fun adaptCongrats(json: String) : String {
        return version.adaptCongrats(json)
    }
}