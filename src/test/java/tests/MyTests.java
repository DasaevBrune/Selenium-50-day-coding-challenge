package tests;

import org.openqa.selenium.By;
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
        String urlWithCredentials = "http://" + Constants.user + ":" + Constants.password + "@" + Constants.urlAuthPopup;
        driver.get(urlWithCredentials);

        driver.get(urlWithCredentials);

        WebElement successMsgElement = driver.findElement(By.xpath(pageElements.authSuccessMsg));

        String actualSuccessMsg = successMsgElement.getText();

        String expectedSuccessMsg = "Congratulations! You must have the proper credentials.";

        Assert.assertTrue(actualSuccessMsg.contains(expectedSuccessMsg), "El mensaje de éxito no coincide.");



    }

    @Test
    public void disableFieldTest(){

        driver.get(disableFieldsWeb);


    }

}
