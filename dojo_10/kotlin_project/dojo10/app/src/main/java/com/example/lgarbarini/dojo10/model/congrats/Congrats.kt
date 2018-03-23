package com.example.lgarbarini.dojo10.model.congrats

import com.example.lgarbarini.dojo10.model.devices.Device

/**
 * Created by lgarbarini on 23/02/2018.
 */
class Congrats(var json: String) {

    fun adaptFor(device: Device) : Congrats {
        device.adaptCongrats(this)
        return this
    }

    fun toJson() : String {
        return json
    }

    fun removeSection(sectionName: String) {
        json = json.replace(", {\n" +
                "    \"type\": \"exit\",\n" +
                "    \"model\": {\n" +
                "      \"actions\": [{\n" +
                "        \"id\": \"go_to_home\",\n" +
                "        \"text\": \"Seguir comprando\"\n" +
                "      }]\n" +
                "    }\n" +
                "  }", "")
    }

    fun replaceSectionType(oldSectionName: String, newSectionName: String) {
        json = json.replace(oldSectionName, newSectionName)
    }
}