package pageObjects;

import commons.BasePage;
import commons.DynamicPage;
import org.openqa.selenium.WebDriver;
import pageUIs.LoginUI;
import pageUIs.RegisterUI;

public class RegisterObject extends DynamicPage {
    WebDriver driver;

    public RegisterObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToRadioButtonShowPass() {
        String attributeValue = getAttribute(driver, RegisterUI.ACTRIBUTE_TEXTBOX_PASS, "type");
        switch (attributeValue) {
            case "text":
                System.out.println("pass show");
                break;
            case "password":
                System.out.println(" pass not show");
                clickToElement(driver, RegisterUI.CHECKBOX_SHOWPASS);
                break;
            default:
                System.out.println("ko phai ca 2 ");
        }
    }

    public void clickToCheckboxConfirm() {
        String attributeValue = getAttribute(driver, RegisterUI.CHECKBOX_DIEUKHOAN, "alt");
        switch (attributeValue) {
            case "true":
                System.out.println("đã check box");
                break;
            case "false":
                System.out.println("chưa check box");
                clickToElement(driver, RegisterUI.CHECKBOX_DIEUKHOAN);
                break;
            default:
                System.out.println("ko phai ca 2 ");
        }
    }

}
