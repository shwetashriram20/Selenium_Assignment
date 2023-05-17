import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
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
    public void FBook() throws InterruptedException {
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
//        driver.findElement(By.id("email")).sendKeys("shwetashriram20@gmail.com");
//        driver.findElement(By.name("pass")).sendKeys("sshweta");
//        driver.findElement(By.name("login")).click();

        driver.findElement(By.cssSelector("input#email")).sendKeys("shwetashriram20@gmail.com");

        //      driver.findElement(By.xpath("//input[name='pass']")).sendKeys("sshweta");
        //      driver.findElement(By.xpath("//button[contains(text(),'Log')]")).click();

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

    @Test
    public void Clear() throws InterruptedException {
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);

        WebElement ele = driver.findElement(By.id("email"));
        ele.sendKeys("shwetashriram20@gmail.com");
        ele.clear();
        ele.sendKeys("shweta@gmail.com");
    }

    @Test
    public void Attribute() throws InterruptedException {
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);

        //sendkey
        WebElement ele = driver.findElement(By.id("pass"));
        ele.sendKeys("sshweta");

        String attribute = ele.getAttribute("placeholder");
        System.out.println(attribute);
    }

    @Test
    public void Location_Method() throws InterruptedException {
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        WebElement ema = driver.findElement(By.xpath("//input[@id='email']"));// get location any also pass
        int emax = ema.getLocation().getX();
        int emay = ema.getLocation().getY();
        System.out.println("Email getx :" + emax);
        System.out.println("Email gety :" + emay);
    }

    @Test
    public void GetText() throws InterruptedException {
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        WebElement ele = driver.findElement(By.xpath("//button[@name='login']"));
        //getText
        String text = ele.getText();
        System.out.println("Text Name :" + text);
        //TagName
        String tagName = ele.getTagName();
        System.out.println("Tag Name :" + tagName);
        //submit
        ele.submit();

    }

    @Test
    public void isDisplayed() throws InterruptedException {

        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        WebElement Dis = driver.findElement(By.xpath("//input[@id='email']"));

        Boolean display = Dis.isDisplayed();
        System.out.println("Email field is displayed :" + display);
    }

    @Test
    public void isEnable() throws InterruptedException {

        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        WebElement Dis = driver.findElement(By.xpath("//input[@id='email']"));

        Boolean Enable = Dis.isEnabled();
        System.out.println("Email field is Enable :" + Enable);

    }

    @Test
    public void isSelected() throws InterruptedException {

        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        WebElement Dis = driver.findElement(By.xpath("//input[@id='email']"));

        boolean status = Dis.isSelected();
        System.out.println("isSelected status :" + status);
    }
    @Test
    public void GetSize() throws InterruptedException {
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        WebElement di = driver.findElement(By.xpath("//input[@id='email']"));
        int dix = di.getSize().getHeight();
        int diy = di.getSize().getWidth();

        System.out.println("Email Height :" + dix);
        System.out.println("Email Width :" + diy);
    }


}