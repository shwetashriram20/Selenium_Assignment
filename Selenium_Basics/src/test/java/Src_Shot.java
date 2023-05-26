import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class Src_Shot {
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
    public void Screenshot() throws InterruptedException, IOException {
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);

        driver.findElement(By.id("email")).sendKeys("shwetashriram20@gmail.com");
        driver.findElement(By.name("pass")).sendKeys("sshweta");
        driver.findElement(By.name("login")).click();

        TakesScreenshot ts = (TakesScreenshot) driver;
        File sfile = ts.getScreenshotAs(OutputType.FILE);
        File dfile = new File("C:\\Users\\ABC\\Downloads\\Selenium_Basics\\shot" + "Fb.png");
        FileHandler.copy(sfile, dfile);
    }
}
