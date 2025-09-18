package step_definitions;

import context.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pageObjects.LoginObject;
import commons.PageGenneratorManager;

import java.util.List;
import java.util.Map;

public class LoginStep {
    private static final Logger log = LoggerFactory.getLogger(LoginStep.class);
    private WebDriver driver;
    LoginObject loginPage;

     public LoginStep(TestContext context){
         driver =  context.getDriverManager().getDriver();
         loginPage = PageGenneratorManager.getLoginPage(driver);
     }

    @Given("^Open login page$")
    public void openLoginPage() {
        loginPage.openDemoLink();
    }


    @When("Click button [Đăng Nhập] home page")
    public void clickButtonĐăngNhậpHomePage() {
        loginPage.clickToLinkLogin();
        loginPage.clickClosePopup();
    }

    @And("Click button [Đăng Nhập] login page")
    public void clickButtonĐăngNhậpLoginPage() {
        loginPage.clickBTNSubmit();
    }


    @Then("Verify message {string} in login page")
    public void verifyMessageInLoginPage(String errorMessage) {
        loginPage.verifyErrorMessage(errorMessage);
    }


    @Then("Verify title label")
    public void verifyTitleLabel(DataTable dataTable) {
        List<Map<String , String>> items = dataTable.asMaps();
        for(Map<String, String> item : items){
            String label_id = item.get("label_id");
            String label_expected = item.get("label_expected");
            loginPage.getLabelText(label_id, label_expected);
        }


    }

    @When("Input to textbox label")
    public void inputToTextboxLabel(DataTable dataTable) {
        List<Map<String,String>> items = dataTable.asMaps();
        for(Map<String,String> item : items){
            String idTextbox = item.get("idTextbox");
            String inputText = item.get("inputText");
            loginPage.inputToTextboxLabel(idTextbox, inputText);
            System.out.println("in ra done");
        }
    }


    @When("Click to button submit")
    public void clickToButtonSubmit() {
    }



}
