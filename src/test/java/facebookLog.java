import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;


public class facebookLog {
    public WebDriver driver;


    @BeforeMethod
    public void setup() {
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ABC\\Downloads\\chromedriver_win32 \\chromedriver.exe");
//        driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
    }

    @Test
    public void Web_driver() throws InterruptedException {
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        String url = driver.getCurrentUrl();
        System.out.println(url);
        String title = driver.getTitle();
        System.out.println(title);
        String source = driver.getPageSource();
        System.out.println(source);
        Thread.sleep(5000);
        // driver.close();
        // driver.quit();
        // driver.navigate().to("https://www.flipkart.com/");
        driver.navigate().back();
        driver.navigate().refresh();
        //web drives here
    }

    @Test
    public void Login_User() throws InterruptedException {
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.findElement(By.id("email")).sendKeys("shwetashriram20@gmail.com");
        driver.findElement(By.name("pass")).sendKeys("sshweta");
        driver.findElement(By.name("login")).click();


    }
    @Test
    public void New_Reg() throws InterruptedException {
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        Thread.sleep(5000);
        driver.findElement(By.partialLinkText("Create new ")).click();
        Thread.sleep(5000);
        WebElement firstname= driver.findElement(By.name("firstname"));
        Thread.sleep(2000);
        firstname.sendKeys( "shweta");
        Thread.sleep(2000);
        WebElement Lastname= driver.findElement(By.name("lastname"));
        Lastname.sendKeys("sshwetaaa");
        Thread.sleep(2000);
        WebElement em = driver.findElement(By.name("reg_email__"));
        em.sendKeys("shwetashriram93@gmail.com");
        Thread.sleep(5000);
        WebElement pass= driver.findElement(By.name("reg_passwd__"));
        pass.sendKeys("shhwetaaaa");
        Thread.sleep(5000);
        WebElement element1 = driver.findElement(By.name("birthday_day"));
        Select day = new Select(element1);
        day.selectByIndex(20);
        WebElement element2 = driver.findElement(By.name("birthday_month"));
        Select Month = new Select(element2);
        Month.selectByValue("2");
        WebElement element3 = driver.findElement(By.name("birthday_year"));
        Select year = new Select(element3);
        year.selectByVisibleText("1995");
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.className("_58mt"));
        element.click();
        driver.findElement(By.name("websubmit")).click();
        Thread.sleep(2000);
        driver.close();

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
        File dfile = new File("C:\\Users\\ABC\\Downloads\\Facebook_Auto\\shot" + "Fb.png");
        FileHandler.copy(sfile, dfile);
    }
}







