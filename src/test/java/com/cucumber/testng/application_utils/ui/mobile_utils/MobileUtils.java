package com.cucumber.testng.application_utils.ui.mobile_utils;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static com.cucumber.testng.application_utils.ui.UIObjects.sleep;
import static com.cucumber.testng.application_utils.ui.mobile_utils.ServerManager.getAndroidHome;

public class MobileUtils {

    private static AppiumDriverLocalService service;
    private static String sdkPath = getAndroidHome();
    private static String adbPath = sdkPath + File.separator + "platform-tools" + File.separator + "adb";
    private static String emulatorPath = sdkPath + File.separator + "emulator" + File.separator + "emulator";
    private static boolean areEmulatorsStarted = false;
    private static ArrayList<String> emulatorList;

    public static void startServer() {
        //Set Capabilities
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("noReset", "false");
        //Build the Appium service
        AppiumServiceBuilder builder = new AppiumServiceBuilder();
        builder.withCapabilities(cap);
        builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
        builder.withArgument(GeneralServerFlag.LOG_LEVEL, "error");
        //Start the server with the builder
        service = AppiumDriverLocalService.buildService(builder);
        service.start();
    }

    private static void stopServer() {
        try {
            sleep(5000);
            service.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void stopAppium() {
        closeAllEmulators();
        stopServer();
    }

    private static void closeAllEmulators() {
        command("Taskkill /IM qemu-system-x86_64.exe /F /T");
        System.out.println("All emulators closed");
    }

    public static void launchEmulator(String nameOfAVD) {
        System.out.println("Starting emulator for '" + nameOfAVD + "' ...");
        String[] aCommand = new String[]{emulatorPath, "-avd", nameOfAVD};
        try {
            Process process = new ProcessBuilder(aCommand).start();
            process.waitFor(25, TimeUnit.SECONDS);
            System.out.println("Emulator launched successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void launchAllEmulators() {
        if (!areEmulatorsStarted) {
            emulatorList = getConnectedDevices();
            for (String emulator : emulatorList) {
                launchEmulator(emulator);
            }
        }
        areEmulatorsStarted = true;
    }

    public static ArrayList getConnectedDevices() {
        ArrayList devices = new ArrayList();
        String output = command("emulator -list-avds");
        for (String line : output.split("\n")) {
            line = line.trim();
            devices.add(line.trim());
        }
        return devices;
    }

    public static String command(String command) {
        String output = ServerManager.runCommand(command);
        if (output == null) return "";
        else return output.trim();
    }
}
