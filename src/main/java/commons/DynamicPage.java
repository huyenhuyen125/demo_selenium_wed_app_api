package commons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class DynamicPage extends BasePage {
    private WebDriverWait explicitWait;

    // locator Dynamic
    public String getDynamicLocator(String Locator, String... dynamic) {
        Locator = String.format(Locator, (Object[]) dynamic);
        return Locator;
    }

    public By getByLocator(String locator, String... dynamic) {
        return By.xpath(getDynamicLocator(locator, dynamic));
    }


    public WebElement getWebElement(WebDriver driver, String locator , String ...dynamic) {
        return driver.findElement(getByLocator(locator, dynamic));
    }


    public void  clickToElement(WebDriver driver, String locator, String... dynamic) {
        waitForElementClick(driver, locator, dynamic);
        getWebElement(driver, locator, dynamic).click();
    }

    public void verifyButtonEnable(WebDriver driver, String locator, String... dynamic) {
        WebElement button = getWebElement(driver, locator, dynamic);
        Assert.assertTrue(button.isEnabled(),"button disable");
    }

    public void verifyButtonDisable(WebDriver driver, String locator, String ...dynamic) {
        WebElement button = getWebElement(driver, locator, dynamic);
        Assert.assertFalse(button.isEnabled(),"button enable");
    }

    public void verifyCheckboxSelect(WebDriver driver, String locator, String ... dynamic) {
        WebElement checkbox = getWebElement(driver, locator, dynamic);
        Assert.assertTrue(checkbox.isSelected(),"button chưa được chọn");
    }


    public void verifyCheckboxNotSelect(WebDriver driver, String locator, String ...dynamic) {
        WebElement checkbox = getWebElement(driver, locator, dynamic);
        Assert.assertFalse(checkbox.isSelected(),"button đã được chọn");
    }

    public void verifyIsDisplayed(WebDriver driver, String locator, String ...dynamic) {
        WebElement text = getWebElement(driver, locator, dynamic);
        Assert.assertTrue(text.isDisplayed(),"text/item chưa hiển thị");
    }

    public void inputToElement(WebDriver driver, String locator, String textValue, String ...dynamic) {
        getWebElement(driver, locator, dynamic).sendKeys(textValue);

    }

    public void clearToElement(WebDriver driver, String locator, String ...dynamic) {
        getWebElement(driver, locator, dynamic).clear();
    }

    public String getText(WebDriver driver, String locator, String ...dynamic) {
        return getWebElement(driver, locator, dynamic).getText();
    }

    public void verifyText(WebDriver driver, String locator, String text,String ...dynamic) {
        waitForElementClick(driver, locator, dynamic);
     Assert.assertEquals(getText(driver,locator, dynamic),text);

    }

    public String getAttribute(WebDriver driver, String locator, String attribute, String ...dynamic) {
        return getWebElement(driver, locator, dynamic).getAttribute(attribute);
    }



    public void waitForElementClick(WebDriver driver, String locator, String ...dynamic) {
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10L));
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locator, dynamic)));
    }


    public boolean waitInvisible(WebDriver driver, String locator, String ...dynamic) {
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30L));
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locator, dynamic)));
        return false;
    }

    public boolean waitStaleness(WebDriver driver, String locator, String ...dynamic) {
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30L));
        explicitWait.until(ExpectedConditions.stalenessOf(getWebElement(driver, locator, dynamic)));
        return false;
    }

    public boolean waitDynamicPresence(WebDriver driver, String locator, String ...dynamic) {
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30L));
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(getByLocator(locator, dynamic)));
        return false;
    }


}
