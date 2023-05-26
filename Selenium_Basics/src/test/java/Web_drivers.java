import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Web_drivers {
    public WebDriver driver;

    @BeforeMethod
    public void setuup() {
//       System.setProperty("webdriver.chrome.driver", "C:\\Users\\ABC\\Downloads\\chromedriver_win32 \\chromedriver.exe");
//       driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
    }

    @Test
    public void Web_driver() throws InterruptedException {
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        String title = driver.getTitle();
        System.out.println("Title: " +title);
        Thread.sleep(4000);
        String sourceCode = driver.getPageSource();
        System.out.println("source code: "+sourceCode);
        Thread.sleep(4000);
        String currentUrl = driver.getCurrentUrl();
        System.out.println("current url: "+currentUrl);
        String windowHandle = driver.getWindowHandle();
        System.out.println("current url: "+ windowHandle);
        driver.manage().window().maximize();
        driver.navigate().to( "https://www.flipkart.com/");
        driver.navigate().forward();
        driver.navigate().back();
       // driver.navigate().refresh();
        //driver.switchTo().window("https://www.instagram.com/");
        //driver.quit();
        //driver.close();
    }

}
