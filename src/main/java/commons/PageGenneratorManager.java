package commons;

import org.openqa.selenium.WebDriver;
import pageObjects.AddCartObject;
import pageObjects.LoginObject;
import pageObjects.RegisterObject;

public class PageGenneratorManager {

    public static LoginObject getLoginPage(WebDriver driver) {
        return new LoginObject(driver);
    }
    public static RegisterObject registerObject(WebDriver driver) {
        return new RegisterObject(driver);
    }
    public static AddCartObject addCartObject(WebDriver driver) {
        return new AddCartObject(driver);
    }


}
