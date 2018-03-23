package com.example.lgarbarini.dojo10.model.devices.iosversions

import com.example.lgarbarini.dojo10.model.congrats.Congrats
import com.example.lgarbarini.dojo10.model.devices.Version

/**
 * Created by lgarbarini on 23/03/2018.
 */
class Version_8_11_0 : Version() {


    override fun adaptCongrats(congrats: Congrats) {
        congrats.removeSection("exit")
    }

}