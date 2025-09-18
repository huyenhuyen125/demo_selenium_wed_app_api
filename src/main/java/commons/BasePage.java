package commons;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BasePage {
    private WebDriverWait explicitWait;


    public void openPageUrl(WebDriver driver, String url) {
        driver.get(url);
    }
//     driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Hello world");

    public By getByLocator(String locator) {
        return By.xpath(locator);
    }


    public WebElement getWebElement(WebDriver driver, String locator) {
        return driver.findElement(getByLocator(locator));
    }

    public void clickToElement(WebDriver driver, String locator) {
        waitForElementClick(driver, locator);
        getWebElement(driver, locator).click();
    }
//    public void clickToButtonEnable(WebDriver driver, String locator) {
//        WebElement button = getWebElement(driver, locator);
//        if (button.isEnabled()) {
//            button.click();
//        } else {
//            System.out.println("Login button is disabled");
//        }
//    }

    public void verifyButtonEnable(WebDriver driver, String locator) {
        WebElement button = getWebElement(driver, locator);
        Assert.assertTrue(button.isEnabled(),"button disable");
    }

    public void verifyButtonDisable(WebDriver driver, String locator) {
        WebElement button = getWebElement(driver, locator);
        Assert.assertFalse(button.isEnabled(),"button enable");
    }

    public void verifyCheckboxSelect(WebDriver driver, String locator) {
        WebElement checkbox = getWebElement(driver, locator);
        Assert.assertTrue(checkbox.isSelected(),"button chưa được chọn");
    }


    public void verifyCheckboxNotSelect(WebDriver driver, String locator) {
        WebElement checkbox = getWebElement(driver, locator);
        Assert.assertFalse(checkbox.isSelected(),"button đã được chọn");
    }

    public void verifyIsDisplayed(WebDriver driver, String locator) {
        WebElement text = getWebElement(driver, locator);
        Assert.assertTrue(text.isDisplayed(),"text/item chưa hiển thị");
    }

    public void inputToElement(WebDriver driver, String locator, String textValue) {
        getWebElement(driver, locator).sendKeys(textValue);

    }

    public void clearToElement(WebDriver driver, String locator) {
        getWebElement(driver, locator).clear();
    }

    public String getText(WebDriver driver, String locator) {
        return getWebElement(driver, locator).getText();
    }

    public void verifyText(WebDriver driver, String locator, String text) {
        waitForElementClick(driver, locator);
     Assert.assertEquals(getText(driver,locator),text);

    }

    public String getAttribute(WebDriver driver, String locator, String attribute) {
        return getWebElement(driver, locator).getAttribute(attribute);
    }

    public List<WebElement> getListWebElement(WebDriver driver, String locator) {
        return driver.findElements(getByLocator(locator));
    }

    public int getElementSize(WebDriver driver, String locator) {
        return this.getListWebElement(driver, locator).size();
    }


    public void selectDefaultByName(WebDriver driver, String locator, String name) {
        Select select = new Select(getWebElement(driver, locator));
        select.selectByVisibleText(name);
        try {
            Assert.assertEquals(select.getFirstSelectedOption().getText(), name);
        } catch (NullPointerException var6) {
            System.out.println("text ko đúng");
        }

    }

    public int selectDefaultGetOptionNumber(WebDriver driver, String locator) {
        Select select = new Select(getWebElement(driver, locator));
        System.out.println(select.getOptions().size());
        return select.getOptions().size();
    }

    public void selectDefaultGetOption(WebDriver driver, String locator) {
        Select select = new Select(getWebElement(driver, locator));
        select.getOptions().get(0).getText();
    }

    public void selectDefaultByValue(WebDriver driver, String locator, String value) {
        Select select = new Select(this.getWebElement(driver, locator));
        select.selectByValue(value);
    }


    public List<String> getAllValueDropdownToList(WebDriver driver, String locator) {
        List<String> listValue = new ArrayList();
        Select select = new Select(this.getWebElement(driver, locator));
        List<WebElement> values = select.getOptions();
        Iterator var6 = values.iterator();

        while (var6.hasNext()) {
            WebElement value = (WebElement) var6.next();
            listValue.add(value.getText());
        }

        return listValue;
    }

    public void selectCustom(WebDriver driver, String locator, String name) {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30L));
        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(locator)));
        List<WebElement> allItems = getListWebElement(driver, locator);
        Iterator var6 = allItems.iterator();

        while (var6.hasNext()) {
            WebElement item = (WebElement) var6.next();
            String textItem = item.getText();
            if (textItem.equals(name)) {
                item.click();
                System.out.println("đúng");
                break;
            }

            System.out.println(" ko đúng");
        }

    }

    public void acceptAlert(WebDriver driver) {
        waitAlert(driver);
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void dismissAlert(WebDriver driver) {
        waitAlert(driver);
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    public String getTextAlert(WebDriver driver) {
        waitAlert(driver);
        Alert alert = driver.switchTo().alert();
      return  alert.getText();
    }


    public void sendKeysAlert(WebDriver driver, String name) {
        waitAlert(driver);
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(name);
    }

    public void sleepInSecond(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException var4) {
            InterruptedException e = var4;
            e.printStackTrace();
        }

    }


    public void waitForElementClick(WebDriver driver, String locator) {
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10L));
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locator)));
    }


    public boolean waitInvisible(WebDriver driver, String locator) {
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30L));
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locator)));
        return false;
    }

    public boolean waitStaleness(WebDriver driver, String locator) {
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30L));
        explicitWait.until(ExpectedConditions.stalenessOf(getWebElement(driver, locator)));
        return false;
    }

    public boolean waitPresence(WebDriver driver, String locator) {
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30L));
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(getByLocator(locator)));
        return false;
    }
    public void waitAlert(WebDriver driver) {
        Alert alert = explicitWait.until(ExpectedConditions.alertIsPresent());
    }

    public void getAuthenticationAlert(WebDriver driver, String username, String password, String domain ) {
        driver.get("https://" + username + ":" + password + "@" + domain);
    }



}
