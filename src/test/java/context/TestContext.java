package context;

import commons.DriverManager;
import org.openqa.selenium.WebDriver;

public class TestContext {
    DriverManager driverManager;

public TestContext(){
    driverManager =  new DriverManager();
}

    public DriverManager getDriverManager() {
        return driverManager;
    }

}
