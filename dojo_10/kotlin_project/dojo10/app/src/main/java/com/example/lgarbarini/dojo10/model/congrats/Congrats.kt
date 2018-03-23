package com.example.lgarbarini.dojo10.model.congrats

import com.example.lgarbarini.dojo10.model.devices.Device

/**
 * TODO crear sections
 * Created by lgarbarini on 23/02/2018.
 */
class Congrats(private val jsonFromApi: String) {
    var adaptedJson : String = ""

    fun toJson() : String {
        return jsonFromApi
    }


    fun toJson(device: Device) : String {
        adaptedJson = jsonFromApi
        device.adaptCongrats(this)
        return adaptedJson
    }

    fun removeSection(sectionName: String) {
        // TODO hacer que de verdad remueva cualquier seccion y no este hardcodeo
        adaptedJson = adaptedJson.replace(", {\n" +
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
        // TODO decirle a la section que cambie su nombre
        adaptedJson = adaptedJson.replace(oldSectionName, newSectionName)
    }
}