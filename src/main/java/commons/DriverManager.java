package commons;

import org.openqa.selenium.WebDriver;

public class DriverManager {
    private WebDriver driver;
 private DriverFactory driverFactory = new  DriverFactory();


    public WebDriver getDriver(){
        if(driver == null ){
            driver = driverFactory.createDriver();
            driverFactory.getUrlByServer("dev");
            System.out.println( driverFactory.getUrlByServer("dev"));
        }else {
                System.out.println("driver not open");
        } return driver;

    }

    public void openURL(String url){
        System.out.println( driverFactory.getUrlByServer(url));
        driver.get(driverFactory.getUrlByServer(url));
    }

    public void closeDriver(){
        driverFactory.closeDriver();
    }




}

