import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Web_elements {
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
    public void Clear() throws InterruptedException {
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);

        //sendkey
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
    @Test
    public void cselector() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);

        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("input#email")).sendKeys("shwetashriram20@gmail.com");
    }


}

