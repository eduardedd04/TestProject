import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SDAWebPageTests {
    private WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "D:\\Programe Curs IT\\WebDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testPrintSDAAcademyPageTitle() throws InterruptedException {

        driver.get(" https://stackoverflow.com/");
        String pageTitle = driver.getTitle();
        System.out.println("Titlul paginii este: " + driver.getTitle());
        // assertEquals(pageTitle,"Stack Overflow - Where Developers Learn, Share, & Build Careers","Titlul paginii nu este corect");
        Thread.sleep(2000);
        assertTrue("Titlul paginii nu este corect", pageTitle.equals("Stack Overflow - Where Developers Learn, Share, & Build Careers"));

    }

    @Test
    public void testUserIsLogIn() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        WebElement username = driver.findElement(By.xpath("//input[@name = 'username']"));
        WebElement password = driver.findElement(By.xpath("//input[@name = 'password']"));
        WebElement loginButton = driver.findElement(By.tagName("button"));
        username.sendKeys("Admin");
        password.sendKeys("admin123");
        loginButton.click();
        assertTrue("User-ul nu este logat", driver.getCurrentUrl().contains("dashboard"));
    }

    @Test
    public void testInvalidCredentials() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        WebElement username = driver.findElement(By.xpath("//input[@name = 'username']"));
        WebElement password = driver.findElement(By.xpath("//input[@name = 'password']"));
        WebElement loginButton = driver.findElement(By.tagName("button"));
        username.sendKeys("bla bla");
        password.sendKeys("noi321");
        Thread.sleep(3000);
        loginButton.click();
        WebElement invalidCredentialsText = driver.findElement(By.xpath("//div[@class='orangehrm-login-error']//p[@class='oxd-text oxd-text--p oxd-alert-content-text']"));
        String errorMessage = invalidCredentialsText.getText();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        assertTrue("Invalid Credentials not displayed", errorMessage.contains("Invalid credentials"));
    }
    @Test
    public void testlistOfLinks() {
        driver.get("https://www.bbc.com/");
        System.out.println("Numarul de link-uri este: " + driver.findElements(By.xpath("//a[@class='media__link']")).size());
        System.out.println("Numarul de imagini este: " + driver.findElements(By.tagName("img")).size());
    }
    @Test
    public void testSDA() throws InterruptedException {
        driver.get("https://google.com/");
        Thread.sleep(3000);
        WebElement search = driver.findElement(By.xpath("//*[@id='APjFqb']"));
        WebElement searchBt = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[4]/center/input[1]"));
        search.sendKeys("Software Development Academy");
        Thread.sleep(3000);
        searchBt.click();
        WebElement testSDA = driver.findElement(By.xpath("//textarea[@class='gLFyf']"));



    }
    @Test
    public void testBox() throws InterruptedException {
        driver.get("https://google.com/");
        Thread.sleep(3000);
        WebElement search = driver.findElement(By.xpath("//*[@id='APjFqb']"));
        WebElement searchBt = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[4]/center/input[1]"));
        search.sendKeys("Java");
        Thread.sleep(2000);
        }



            driver.close();
        }
    }



