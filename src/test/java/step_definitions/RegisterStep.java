package step_definitions;

import commons.PageGenneratorManager;
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
import pageObjects.RegisterObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RegisterStep {
    private WebDriver driver;
    RegisterObject registerObject;
    LoginObject loginObject;

    public RegisterStep(TestContext context) {
        driver = context.getDriverManager().getDriver();
        loginObject = PageGenneratorManager.getLoginPage(driver);
        registerObject = PageGenneratorManager.registerObject(driver);
    }

    @Given("Open register page")
    public void openRegisterPage() {
        registerObject.openPageUrl(driver, "https://www.tienganh123.com/register");
        loginObject.clickClosePopup();
    }

    @When("Check to checkbox [Xác nhận điều khoản ] register page")
    public void checkToCheckboxXácNhậnĐiềuKhoảnRegisterPage() {
        registerObject.clickToRadioButtonShowPass();

    }

    @And("Check to radio button open [Hiện mật khẩu ] register page")
    public void checkToRadioButtonOpenHiệnMậtKhẩuRegisterPage() {
        registerObject.clickToCheckboxConfirm();
    }


}
