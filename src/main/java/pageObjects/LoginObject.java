package pageObjects;

import commons.BasePage;
import commons.DynamicPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageUIs.DynamicUI;
import pageUIs.LoginUI;

public class LoginObject extends DynamicPage {
    WebDriver driver;

    public LoginObject(WebDriver driver) {
        this.driver = driver;
    }

    public void openDemoLink() {
        openPageUrl(driver, "https://www.tienganh123.com/");
    }

    public void clickToLinkLogin() {
        waitForElementClick(driver, LoginUI.LINK_TEXT_LOGIN);
        clickToElement(driver, LoginUI.LINK_TEXT_LOGIN);
    }

    public void clickClosePopup() {
        waitForElementClick(driver, LoginUI.ICON_X_PC_CLOSE);
        clickToElement(driver, LoginUI.ICON_X_PC_CLOSE);
    }

    public void clickBTNSubmit() {
        waitForElementClick(driver, LoginUI.BTN_SUBMIT);
        clickToElement(driver, LoginUI.BTN_SUBMIT);
    }

    public void verifyErrorMessage(String errorMessage) {
        verifyText(driver, LoginUI.TEXT_ERROR_MESSAGE, errorMessage);
    }

    public void getLabelText(String label_id, String label_expected) {
        switch (label_id) {
            case "userName-label":
                System.out.println("label_id: " + label_id);
                System.out.println("label_expected: " + label_expected);
                verifyText(driver, DynamicUI.DYNAMIC_LABEL_ID, label_expected, label_id);
                break;
            case "userEmail-label":
                System.out.println("label_id: " + label_id);
                System.out.println("label_expected: " + label_expected);
                verifyText(driver, DynamicUI.DYNAMIC_LABEL_ID, label_expected, label_id);
                break;
            case "genterWrapper":
                System.out.println("label_id: " + label_id);
                System.out.println("label_expected: " + label_expected);
                verifyText(driver,LoginUI.LABEL_GENDER,label_expected);
                break;
            case "subjects-label":
                System.out.println("label_id: " + label_id);
                System.out.println("label_expected: " + label_expected);
                verifyText(driver, DynamicUI.DYNAMIC_LABEL_ID, label_expected, label_id);
                break;
            default:
                Assert.fail("Label not found");
                break;
        }

    }

    public void inputToTextboxLabel(String idTextbox, String inputText) {
    switch (idTextbox){
        case "firstName":
            clearToElement(driver, DynamicUI.DYNAMIC_INPUT_ID, idTextbox);
            inputToElement(driver, DynamicUI.DYNAMIC_INPUT_ID ,inputText , idTextbox );
            break;
        case "lastName":
            clearToElement(driver, DynamicUI.DYNAMIC_INPUT_ID, idTextbox);
            inputToElement(driver, DynamicUI.DYNAMIC_INPUT_ID ,inputText , idTextbox );
            break;
        case "userEmail":
            clearToElement(driver, DynamicUI.DYNAMIC_INPUT_ID, idTextbox);
            inputToElement(driver, DynamicUI.DYNAMIC_INPUT_ID ,inputText , idTextbox );
            break;
//        case "userNumber":
//            clearToElement(driver, DynamicUI.DYNAMIC_INPUT_ID, idTextbox);
//            inputToElement(driver, DynamicUI.DYNAMIC_INPUT_ID ,inputText , idTextbox );
//            break;
//        case "hobbies-checkbox-2":
//            System.out.println("moi den  den");
//            verifyCheckboxNotSelect(driver, DynamicUI.DYNAMIC_INPUT_ID, "hobbies-checkbox-2");
////            System.out.println("da den");
////            clickToElement(driver, "//label[text()='Reading']" );
////            System.out.println("da clcik");
////            break;
        default:
            Assert.fail("TextBox not found");
            break;
    }
    }
}
