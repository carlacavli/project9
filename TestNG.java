import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestNG {
    private WebDriver driver;
    private WebDriverWait wait;

    @Parameters({"username", "password"})
    @BeforeClass
    public void setup(String username, String password) {
        System.setProperty("webdriver.chrome.driver", "/Users/muberracavli/Desktop/TechnoStudy/chrome driver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 5);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.get("https://test-basqar.mersys.io");
        driver.findElement(By.cssSelector("[formcontrolname=\"username\"]")).sendKeys(username);
        driver.findElement(By.cssSelector("[formcontrolname=\"password\"]")).sendKeys(password);
        driver.findElement(By.cssSelector("button[aria-label=\"LOGIN\"]")).click();
    }
    @Test
    public void main() {

        driver.findElement(By.cssSelector(".group-items > :nth-child(6)")).click();
        driver.findElement(By.cssSelector(".group-items > :nth-child(6) > .children > :nth-child(1)")).click();
        driver.findElement(By.cssSelector(".group-items > :nth-child(6) > .children > :nth-child(1) > .children > :nth-child(1)")).click();
        driver.findElement( By.cssSelector( "[data-icon='plus']" ) ).click();


        String descriptionname="campus44";
        driver.findElement(By.xpath("//*[@id=\"mat-input-5\"]")).sendKeys(descriptionname);

        driver.findElement(By.cssSelector("#mat-select-2")).click();
        driver.findElement(By.xpath("//*[@id=\"mat-option-11\"]/span")).click();

        String datenm= "01/01/2020";
        driver.findElement(By.xpath("//*[@id=\"mat-input-7\"]")).sendKeys(datenm);

        String enddate ="03/28/2020";
        driver.findElement(By.xpath("//*[@id=\"mat-input-8\"]")).sendKeys(enddate);

        driver.findElement(By.xpath("//*[@id=\"mat-input-6\"]")).sendKeys("command");
        driver.findElement(By.xpath("//div[@class='mat-tab-label mat-ripple ng-star-inserted']")).click();
        driver.findElement(By.xpath("//input[@class='mat-input-element mat-form-field-autofill-control cdk-text-field-autofill-monitored ng-untouched ng-pristine ng-invalid']")).sendKeys("1");
        driver.findElement(By.xpath("//ms-decimal-field//input")).sendKeys("22112");
        driver.findElement(By.xpath("//button[@class='mat-raised-button mat-button-base mat-basic ng-star-inserted']")).click();
        WebElement saveIcon = driver.findElement( By.cssSelector( "mat-dialog-container [data-icon=\"save\"]" ) );
        saveIcon.click();
        try {
            wait.until( ExpectedConditions.visibilityOfElementLocated( By.cssSelector( "[aria-label='Budget Group successfully created']" ) ) );

        } catch( Exception e) {
            Assert.fail( "Delete failure", e );
        }

        String  text = driver.findElement(By.xpath("//td[text()='campus44']")).getText();
        Assert.assertEquals(descriptionname,text);

        String date = driver.findElement(By.xpath("//td[text()='01/01/2020']")).getText();
        Assert.assertEquals(datenm,date);

        String enddt = driver.findElement(By.xpath("//td[text()='03/28/2020']")).getText();
        Assert.assertEquals(enddate,enddt);

    }
    @AfterClass
    public void quit(){
        driver.quit();
    }
}


