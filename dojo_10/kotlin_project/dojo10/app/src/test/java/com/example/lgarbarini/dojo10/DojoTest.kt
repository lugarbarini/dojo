package com.example.lgarbarini.dojo10

import com.example.lgarbarini.dojo10.model.congrats.Congrats
import com.example.lgarbarini.dojo10.model.devices.Android
import com.example.lgarbarini.dojo10.model.devices.IOS
import java.io.File
import java.nio.file.Files
import kotlin.test.Test
import kotlin.test.assertEquals


/**
 * Created by lgarbarini on 23/02/2018.
 */
class DojoTest {

    @Test
    fun congrats_order_paid_off_for_ios_8_10_0_returns_mlu_offline_payment() {
        /*
        Map congrats = JSONMapper.toObject(
                ResourceLoader.getFileAsString("congrats/congrats/congrats_order_paid_off_for_ios_8_10_0.json"),
                Map.class
        );

        assertEquals(
                ((List<Map>)congrats.get("sections")).get(0).get("type"),
                "mlu_offline_payment"
        );
         */
        val originalJson = loadFile("congrats_order_paid_off_for_ios_8_10_0.json")
        val expectedResponse = loadFile("congrats_order_paid_off_for_ios_8_10_0.json")
        val iOSDevice = IOS("8.10.0")
        val iOSResponse = Congrats(originalJson).adaptFor(iOSDevice).toJson()

        assertEquals(expectedResponse, iOSResponse)
    }

    @Test
    fun congrats_order_paid_off_for_android_7_12_0_returns_offline_payment() {
        /*
          Map congrats = JSONMapper.toObject(
                ResourceLoader.getFileAsString("congrats/congrats/congrats_order_paid_off_for_android_7_12_0.json"),
                Map.class
        );

        assertEquals(
                ((List<Map>)congrats.get("sections")).get(0).get("type"),
                "offline_payment"
        );
         */

        val originalJson = loadFile("congrats_order_paid_off_for_ios_8_10_0.json")
        val expectedResponse = loadFile("congrats_order_paid_off_for_android_7_12_0.json")
        val androidDevice = Android("7.12.0")
        val androidResponse = Congrats(originalJson).adaptFor(androidDevice).toJson()

        assertEquals(expectedResponse, androidResponse)
    }

    fun loadFile(file:String): String {
        return String (Files.readAllBytes(File(this.javaClass.classLoader.getResource(file).file)
                .toPath()))
    }
}