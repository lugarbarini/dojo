package com.example.lgarbarini.dojo10.model.devices

import com.example.lgarbarini.dojo10.model.congrats.Congrats

/**
 * Created by lgarbarini on 23/02/2018.
 */
class Android(val version: Version) : Device {

    override fun adaptCongrats(congrats:Congrats) {
        return version.adaptCongrats(congrats)
    }
}