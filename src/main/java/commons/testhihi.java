package commons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class testhihi extends BasePage{
    public static WebDriver driver;

    @DataProvider(name = "loginData")
    public Object[][] provideData() {
        return new Object[][] {
                {"admin", "admin123"},
                {"user1", "password1"},
                {"user2", "password2"}
        };
    }


    public static void selectDropdownInDropdownsPage() {
   //     String urlImage ="Downloads/anh1.jpg";
       String urlImage1 ="D:\\Học Test\\anh1.jpg";
        String urlImage2 ="D:\\Học Test\\anh2.jpg";
        WebElement element = getElement("//input[@id='uploadPicture']");
        element.sendKeys(urlImage1 + "\n" + urlImage2);
        element.getAttribute("value");
        System.out.println(element.getAttribute("value"));

    }

    public static WebElement getElement(String locator) {
        return driver.findElement(getLocator(locator));
    }

    public static By getLocator(String locator) {
        return By.xpath(locator);
    }


}

