package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.Constants;
import utils.pageElements;
import static utils.Constants.disableFieldsWeb;

public class MyTests extends BaseTest {


    @Test
    public void authPopupTest(){
        String urlWithCredentials = "https://" + Constants.user + ":" + Constants.password + "@" + Constants.urlAuthPopup;
        driver.get(urlWithCredentials);
        WebElement successMsgElement = driver.findElement(By.xpath(pageElements.authSuccessMsg));

        String actualSuccessMsg = successMsgElement.getText();

        String expectedSuccessMsg = "Congratulations! You must have the proper credentials.";

        Assert.assertTrue(actualSuccessMsg.contains(expectedSuccessMsg), "The successful message does not match.");



    }

    @Test
    public void disableFieldTest(){

        driver.get(disableFieldsWeb);
        WebElement disabledField = driver.findElement(By.xpath(pageElements.disableFieldPassword));


        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('disabled')", disabledField);
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', arguments[1])", disabledField, Constants.password);

        String content = disabledField.getAttribute("value");

        Assert.assertTrue(disabledField.isEnabled(),"Field is enable");
        Assert.assertEquals(Constants.password,content);


    }

}
