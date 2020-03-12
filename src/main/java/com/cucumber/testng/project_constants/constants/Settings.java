package com.cucumber.testng.project_constants.constants;

import java.io.File;

import static java.lang.System.getProperty;

public class Settings {
    //Log Path for framework
    public static String LogPath = System.getProperty("user.dir") + "\\target\\logs";
    //Chrome driver path
    public static String CHROME_DRIVER_PATH = System.getProperty("user.dir") + "\\src\\main\\java\\com\\cucumber\\testng\\drivers\\web\\chromedriver.exe";
    public static String CHROME_DRIVER_74_PATH = System.getProperty("user.dir") + "\\src\\main\\java\\com\\cucumber\\testng\\drivers\\web\\chromedriver_74.exe";
    //Driver Type for SQL Server connectivity
    private static final String ZALENIUM_KEY = "zalenium";
    public static boolean toBeRunOnZalenium = Boolean.parseBoolean(getProperty(ZALENIUM_KEY));
    public static String DriverType;
    public static String ExcelSheetPath;
    public static com.cucumber.testng.project_constants.enams.BrowserType BrowserType;
    public static String SeleniumGridHub;
    public static String HistoricalReport;
    public static String GS_APP;
    public static String IMX_URL;
    public static String ZB_URL;
    public static String TwitterBaseURI;
    public static String TwitterBasePath;
    public static String ConsumerKey;
    public static String ConsumerSecret;
    public static String Token;
    public static String TokenSecrete;
    public static String Project_directory = System.getProperty("user.dir");
    public static final String sep = File.separator;
}
