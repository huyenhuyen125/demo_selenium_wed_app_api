//package pageObjects;
//
//import commons.DynamicPage;
//import commons.ExcelUtils;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//import pageUIs.DynamicUI;
//import pageUIs.LoginUI;
//
//import java.io.IOException;
//
//public class DataDriven extends DynamicPage {
//    WebDriver driver;
//
//    // Bước 1: Khởi tạo browser
//    @BeforeClass
//    public void setUp() {
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//    }
//
////@DataProvider(name ="'ffff'")
////public Object[][]abc(){
////        return new Object[][]{
////                {"admin","admin123"},
////                {"user1","password1"},
////                {"user2","password2"}
////        };
////}
//
//    // DataProvider đọc data từ ExcelUtils
//    @DataProvider(name = "excelData")
//    public Object[][] getExcelData() throws IOException {
//        return ExcelUtils.readExcel("src/test/resources/testdata.xlsx", "Sheet1");
//    }
//
//    // Bước 3: Test dùng data từ DataProvider
//    @Test(dataProvider = "ffff")
//    public void loginTest(String username, String password) {
//        driver.get("https://demoqa.com/automation-practice-form");
//        driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys(username);
//        driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(password);
//    }
//
//    // Bước 5: Đóng browser
//    @AfterClass
//    public void tearDown() {
//        if (driver != null) {
//            // driver.quit();
//        }
//    }
//
//
//}
