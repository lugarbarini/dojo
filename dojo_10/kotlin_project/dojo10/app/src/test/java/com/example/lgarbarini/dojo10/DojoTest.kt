package com.example.lgarbarini.dojo10

import com.example.lgarbarini.dojo10.model.congrats.Congrats
import com.example.lgarbarini.dojo10.model.devices.Android
import com.example.lgarbarini.dojo10.model.devices.IOS
import com.example.lgarbarini.dojo10.model.devices.androidversions.Version_103_0_0
import com.example.lgarbarini.dojo10.model.devices.androidversions.Version_7_12_0
import com.example.lgarbarini.dojo10.model.devices.iosversions.Version_8_10_0
import com.example.lgarbarini.dojo10.model.devices.iosversions.Version_8_11_0
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
        val originalJson = loadFile("congrats_order_paid_off_for_ios_8_10_0.json")
        val expectedResponse = loadFile("congrats_order_paid_off_for_ios_8_10_0.json")
        val iOSDevice = IOS(Version_8_10_0())
        val iOSResponse = Congrats(originalJson).adaptFor(iOSDevice).toJson()

        assertEquals(expectedResponse, iOSResponse)
    }

    @Test
    fun congrats_order_paid_off_for_android_7_12_0_returns_offline_payment() {
        val originalJson = loadFile("congrats_order_paid_off_for_ios_8_10_0.json")
        val expectedResponse = loadFile("congrats_order_paid_off_for_android_7_12_0.json")
        val androidDevice = Android(Version_7_12_0())
        val androidResponse = Congrats(originalJson).adaptFor(androidDevice).toJson()

        assertEquals(expectedResponse, androidResponse)
    }

    @Test
    fun congrats_order_paid_off_for_android_103_0_0_returns_offline_payment() {
        val originalJson = loadFile("congrats_order_paid_off_for_ios_8_10_0.json")
        val expectedResponse = loadFile("congrats_order_paid_off_for_android_103_0_0.json")
        val androidDevice = Android(Version_103_0_0())
        val androidResponse = Congrats(originalJson).adaptFor(androidDevice).toJson()

        assertEquals(expectedResponse, androidResponse)
    }

    @Test
    fun congrats_order_paid_off_for_ios_8_11_0_returns_offline_payment() {
        val originalJson = loadFile("congrats_order_paid_off_for_ios_8_10_0.json")
        val expectedResponse = loadFile("congrats_order_paid_off_for_ios_8_11_0.json")
        val iosDevice = IOS(Version_8_11_0())
        val iosResponse = Congrats(originalJson).adaptFor(iosDevice).toJson()

        assertEquals(expectedResponse, iosResponse)
    }



    // -----


    private fun loadFile(file:String): String {
        return String (Files.readAllBytes(File(this.javaClass.classLoader.getResource(file).file)
                .toPath()))
    }
}