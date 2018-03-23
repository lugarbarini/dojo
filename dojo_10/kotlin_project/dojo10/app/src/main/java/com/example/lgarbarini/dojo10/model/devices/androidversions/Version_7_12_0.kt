package com.example.lgarbarini.dojo10.model.devices.androidversions

import com.example.lgarbarini.dojo10.model.congrats.Congrats
import com.example.lgarbarini.dojo10.model.devices.Version

/**
 * Created by lgarbarini on 23/03/2018.
 */
class Version_7_12_0 : Version() {

    override fun adaptCongrats(congrats: Congrats) {
        congrats.replaceSectionType("mlu_offline_payment", "offline_payment")
    }
}