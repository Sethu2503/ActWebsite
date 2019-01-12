package com.actwebsite.qa.pageobjects;

import com.actwebsite.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.xml.xpath.XPath;

public class HomePage extends TestBase {


    @FindBy(xpath="//a[@title='ACT TV']")
    WebElement ActTV;

    @FindBy(xpath = "//a[@id='aui_3_4_0_1_126']")
    WebElement AboutAct;

    public HomePage()
    {

        PageFactory.initElements(driver, this);

    }


    public String ValidatePageTitle()
    {
        return driver.getTitle();

    }

    public boolean ValidatePageImage()
    {

        return ActTV.isDisplayed();
    }


    public AboutAct ClickonAboutAct()
    {

        AboutAct.click();
        return new AboutAct();
    }

}
