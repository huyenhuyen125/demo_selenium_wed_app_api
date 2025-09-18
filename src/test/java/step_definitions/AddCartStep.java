package step_definitions;

import commons.PageGenneratorManager;
import context.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObjects.AddCartObject;
import pageObjects.LoginObject;
import pageObjects.RegisterObject;

public class AddCartStep {
    private WebDriver driver;
    RegisterObject registerObject;
    LoginObject loginObject;
    AddCartObject addCartObject;

    public AddCartStep(TestContext context) {
        driver = context.getDriverManager().getDriver();
        loginObject = PageGenneratorManager.getLoginPage(driver);
        registerObject = PageGenneratorManager.registerObject(driver);
        addCartObject = PageGenneratorManager.addCartObject(driver);

    }


    @Given("Open add page alert")
    public void openAddPageAlert() {
        addCartObject.goToCartPage();
    }

    @When("Click button [add to cart]")
    public void clickButtonAddToCart() {
        addCartObject.clickToButtonAddCart();
    }

    @Then("Verify alert {string}")
    public void verifyAlert(String alertText) {
        addCartObject.verifyTextAlert(alertText);
    }

    @When("Accept alert")
    public void acceptAlert() {
        addCartObject.acceptAlert();
    }

    @Given("Open dropown options page")
    public void openDropownOptionsPage() {
        addCartObject.openDropownOptionsPage();
    }

    @When("Select option in dropdowns page")
    public void selectOptionInDropdownsPage() {
        addCartObject.verifyDataDropdown();
        addCartObject.selectOptionInDropdownsPage();
    }

    @Given("Open dropown custom page")
    public void openDropownCustomPage() {
        addCartObject.openDropdownCustomPage();
    }
    @When("Input to textbox")
    public void inputToTextbox() {
        addCartObject.inputToTextbox();
    }
}
