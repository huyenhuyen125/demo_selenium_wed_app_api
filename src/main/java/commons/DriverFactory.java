package commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


public class DriverFactory {
    private WebDriver driver ;


    public WebDriver createDriver(){
        try {
            if(driver == null){
                String browser = System.getProperty("BROWSER", "chrome");
                System.out.println(">>> Browser param: " + browser);
                switch (browser.toLowerCase()){
                    case "chrome":
                        ChromeOptions chromeOptions = new ChromeOptions();
                        chromeOptions.addArguments("--start-maximized");
                        chromeOptions.addArguments("--incognito");
                        chromeOptions.addArguments("--headless");
                        driver = new ChromeDriver(chromeOptions);
                       break;
                    case "firefox":
                        FirefoxOptions firefoxOptions = new FirefoxOptions();
                        firefoxOptions.addArguments("--incognito");
                        driver =  new FirefoxDriver(firefoxOptions);
                        break;
                    case "edge":
                        EdgeOptions edgeOptions = new EdgeOptions();
                        edgeOptions.addArguments("--incognito");
                        driver  = new EdgeDriver(edgeOptions);
                        break;
                    default:
                        throw new RuntimeException("Browser not supported: " + browser);
                }
            }
            return driver;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        finally {
            Runtime.getRuntime().addShutdownHook(new Thread(new BrowserCleanup())) ;
        }

    }

public void closeDriver(){
        if(driver != null){
            System.out.println("close browser");
            //driver.get().quit();
        }
}


    class BrowserCleanup implements Runnable{
        @Override
        public void run() {
            closeDriver();
        }
    }


    protected String getUrlByServer(String serverName) {
      //  ServerList server = ServerList.valueOf(serverName.toUpperCase());

        switch (serverName.toLowerCase()) {
            case "dev": {
                serverName = GlobalConstants.URL_DEV;
                break;
            }
            case "stg": {
                serverName = "https://kenh14.vn/diem-chuan-nam-2024-du-bao-tang-nhe-215240726093715673.chn";
                break;
            }
            case "pro": {
                serverName = "https://kenh14.vn/chu-de-gay-xon-xao-mang-xa-hoi-han-yoona-khong-xung-lam-huyen-thoai-nhan-sac-215240725212942264.chn";
                break;
            }
            default:

        }
        return serverName;
    }




}
