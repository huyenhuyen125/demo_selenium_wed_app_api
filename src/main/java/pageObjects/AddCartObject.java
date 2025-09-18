package pageObjects;

import commons.BasePage;
import commons.DynamicPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pageUIs.AddCartUI;
import pageUIs.DynamicUI;
import pageUIs.RegisterUI;

import javax.swing.text.Element;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.cucumber.core.internal.com.fasterxml.jackson.databind.cfg.CoercionInputShape.Array;

public class AddCartObject extends DynamicPage {
    WebDriver driver;

    public AddCartObject(WebDriver driver) {
        this.driver = driver;
    }

    public void goToCartPage() {
        openPageUrl(driver, "https://demoblaze.com/prod.html?idp_=1#");
    }

    public void clickToButtonAddCart() {
        verifyButtonEnable(driver, AddCartUI.BUTTON_ADD_CART);
        clickToElement(driver, AddCartUI.BUTTON_ADD_CART);
    }

    public void verifyTextAlert(String alertText) {
        System.out.println(getTextAlert(driver));
        Assert.assertEquals(getTextAlert(driver), alertText);
    }

    public void acceptAlert() {
        acceptAlert(driver);
    }

    public void openDropownOptionsPage() {
        openPageUrl(driver, "https://demoqa.com/automation-practice-form");
    }

    public void verifyDataDropdown() {
        selectDefaultGetOptionNumber(driver, "//select[@id='fruits']");
        Assert.assertEquals(selectDefaultGetOptionNumber(driver, "//select[@id='fruits']"), 6);
    }

    public void selectOptionInDropdownsPage() {
        selectDefaultByName(driver, "//select[@id='fruits']", "Mango");
    }

    public void openDropdownCustomPage() {
        openPageUrl(driver, "https://demoqa.com/webtables");
    }

    public void inputToTextbox() {
        // check giá trị tableName
        List<String> tableName = Arrays.asList("First Name", "Last Name", "Age", "Email", "Salary", "Department", "Action");
        List<String> row1 = Arrays.asList("Cierra", "Vega", "39", "cierra@example.com", "10000", "Insurance");
        List<List<String>> expectedTable = new ArrayList<>();
        expectedTable.add(row1);

        List<String> listTableName = new ArrayList<>();
        List<WebElement> tableNameExpects = getListWebElement(driver, "//div[@class='rt-tr']/div");
        for (WebElement tableNameExpect : tableNameExpects) {
            tableNameExpect.getText();
            listTableName.add(tableNameExpect.getText());
        }
        Assert.assertEquals(listTableName, tableName);

        List<List<String>> listAllDatatable = new ArrayList<>();
        List<WebElement> allDataTablerows = getListWebElement(driver, "//div[@class='rt-tr-group']/div");
        //System.out.println("allDataTablerows 1 " + " /n  " +  allDataTablerows.get(0).getText());
       for(int i = 0 ; i < allDataTablerows.size() ; i++ ){
           List<String> rowData = new ArrayList<>();
           List<WebElement> eachrows = allDataTablerows.get(i).findElements(By.xpath(".//div[@class='rt-td']"));
           for(WebElement row : eachrows){

               String getRow = row.getText();
               if (!getRow.isEmpty()){
                   rowData.add(getRow);
               }
           }
           System.out.println(" moi row" + listAllDatatable);
           listAllDatatable.add(rowData);
       }

        System.out.println("expectedTable cuoi cung " + expectedTable);
        System.out.println("listAllDatatable cuoi sđ" + listAllDatatable);
        Assert.assertTrue(listAllDatatable.containsAll(expectedTable));
    }

}

