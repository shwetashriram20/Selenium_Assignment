import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class Robot_Class {
    public static WebDriver driver;

    @BeforeMethod
    public void setDriver() {
        //System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
        //driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
    }
    @Test

    public void Using_RobotClass() throws InterruptedException, IOException, AWTException {
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        Robot robot= new Robot();
        //robot.mouseMove(100, 300);
        //robot.mouseWheel(2);
        robot.keyPress (KeyEvent.VK_S);
        robot.keyRelease (KeyEvent.VK_S);
        robot.keyPress (KeyEvent.VK_T);
        robot.keyRelease (KeyEvent.VK_T);
        Thread.sleep(5000);


//select

        robot.keyPress (KeyEvent.VK_CONTROL);
        robot.keyPress (KeyEvent.VK_A);
        robot.keyRelease (KeyEvent.VK_CONTROL);
        robot.keyRelease (KeyEvent.VK_A);
        Thread.sleep(5000);

//copy

        robot.keyPress (KeyEvent.VK_CONTROL);
        robot.keyPress (KeyEvent.VK_C);
        robot.keyRelease (KeyEvent.VK_CONTROL);
        robot.keyRelease (KeyEvent.VK_C);
        Thread.sleep(5000);

        robot.keyPress (KeyEvent.VK_TAB);
        robot.keyRelease (KeyEvent.VK_TAB);
        Thread.sleep(5000);
        robot.keyPress (KeyEvent.VK_CONTROL);
        robot.keyPress (KeyEvent.VK_V);
        robot.keyRelease (KeyEvent.VK_CONTROL);
        robot.keyRelease (KeyEvent.VK_V);
        Thread.sleep(5000);

        robot.keyPress (KeyEvent.VK_ENTER);
        robot.keyRelease (KeyEvent.VK_ENTER);

    }

}
