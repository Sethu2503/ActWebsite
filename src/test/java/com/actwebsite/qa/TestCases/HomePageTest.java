package com.actwebsite.qa.TestCases;

import com.actwebsite.qa.base.TestBase;
import com.actwebsite.qa.pageobjects.HomePage;
import org.testng.Assert;
import org.testng.annotations.*;

public class HomePageTest extends TestBase {

    HomePage homepage;

    public HomePageTest()
    {
        super();
    }

    @BeforeMethod
    public void Setup()
    {
        Initialization();

        homepage = new HomePage();

    }

    @Test(priority = 1)
    public void HomePageTitleTest()
    {

        String HomeTitle = homepage.ValidatePageTitle();
        Assert.assertEquals(HomeTitle, "Home", "This is not the Home title expected");
    }


    @Test(priority = 2)
    public void HomePageImageTest()
    {
        boolean validImage = homepage.ValidatePageImage();
        Assert.assertTrue(validImage);
    }


    @Test(priority = 3)
    public void NavigateToAboutAct()
    {

        homepage.ClickonAboutAct();
    }



    @AfterMethod
    public void Teardown()
    {
        driver.quit();
    }


}
