package com.actwebsite.qa.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import com.actwebsite.qa.util.*;

public class TestBase {

    public static WebDriver driver;
    public static Properties prop;


    public  TestBase()  {

        try
        {

            prop = new Properties();
            FileInputStream ip = new FileInputStream("C:/Users/Sethu/workspace/ACTWebsite" +
                    "/src/main/java/com/actwebsite/qa/config/config.properties");
            prop.load(ip);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public void Initialization()
    {
        String browserName = prop.getProperty("browser");
        if(browserName.equals("Chrome"))
        {
            System.setProperty("webdriver.chrome.driver", "C:/Users/Sethu/Desktop/Chromedriver/chromedriver.exe");

            driver = new ChromeDriver();
        }
        else if(browserName=="Firefox")
        {
            System.setProperty("webdriver.gecko.driver","C:/Users/Sethu/Desktop/Geckodriver");
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIME, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

        driver.get(prop.getProperty("url"));



    }



}
