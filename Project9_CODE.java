import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Project9_CODE {
        public static void main(String[] args) {


//            @Test
//            public void myTest(){


        System.setProperty("webdriver.chrome.driver", "/Users/muberracavli/Desktop/TechnoStudy/chrome driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://test-basqar.mersys.io");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.get("https://test-basqar.mersys.io");
        driver.findElement(By.cssSelector("[formcontrolname=\"username\"]")).sendKeys("admin");
        driver.findElement(By.cssSelector("[formcontrolname=\"password\"]")).sendKeys("admin");
        driver.findElement(By.cssSelector("button[aria-label=\"LOGIN\"]")).click();
        driver.findElement(By.cssSelector(".group-items > :nth-child(6)")).click();
        driver.findElement(By.cssSelector(".group-items > :nth-child(6) > .children > :nth-child(1)")).click();
        driver.findElement(By.cssSelector(".group-items > :nth-child(6) > .children > :nth-child(1) .children > :nth-child(1)")).click();
        driver.findElement(By.cssSelector("[data-icon='plus']")).click();

        String descriptionname="CarlaCavli";
        driver.findElement(By.xpath("//*[@id=\"mat-input-5\"]")).sendKeys(descriptionname);

        driver.findElement(By.cssSelector("#mat-select-2")).click();
        driver.findElement(By.xpath("//*[@id=\"mat-option-11\"]/span")).click();

        String datenm= "01/01/2020";
        driver.findElement(By.xpath("//*[@id=\"mat-input-7\"]")).sendKeys(datenm);
       // driver.findElement(By.xpath("//*[@id=\"mat-input-7\"]")).sendKeys("01/01/2020");
        String enddate ="03/28/2020";
        driver.findElement(By.xpath("//*[@id=\"mat-input-8\"]")).sendKeys(enddate);
       // driver.findElement(By.xpath("//*[@id=\"mat-input-8\"]")).sendKeys("03/28/2020");
        String command = "SUCCESS!";
        driver.findElement(By.xpath("//*[@id=\"mat-input-6\"]")).sendKeys(command);
        //driver.findElement(By.xpath("//*[@id=\"mat-input-6\"]")).sendKeys("SUCCESS!");
        driver.findElement(By.xpath("//div[@class='mat-tab-label mat-ripple ng-star-inserted']")).click();
        driver.findElement(By.xpath("//input[@class='mat-input-element mat-form-field-autofill-control cdk-text-field-autofill-monitored ng-untouched ng-pristine ng-invalid']")).sendKeys("1");
        driver.findElement(By.xpath("//ms-decimal-field//input")).sendKeys("22112");
        driver.findElement(By.xpath("//button[@class='mat-raised-button mat-button-base mat-basic ng-star-inserted']")).click();
        WebElement saveIcon = driver.findElement( By.cssSelector( "mat-dialog-container [data-icon=\"save\"]" ) );
        saveIcon.click();
        try {
            wait.until( ExpectedConditions.visibilityOfElementLocated( By.cssSelector( "[aria-label='Budget Group successfully created']" ) ) );
            System.out.println("Creation success!");
        } catch( Exception e) {
            System.out.println("Creation failure!");
        }

        String  text = driver.findElement(By.xpath("//td[text()='CarlaCavli']")).getText();
        if(descriptionname.equals(text)) {
                System.out.println("success");
        }
        else{
                System.out.println("faile");
        }

        String date = driver.findElement(By.xpath("//td[text()='01/01/2020']")).getText();
        if(datenm.equals(date)){
                System.out.println("success");

        }else{
                System.out.println("faile");
        }
        String enddt = driver.findElement(By.xpath("//td[text()='03/28/2020']")).getText();
        if(enddate.equals(enddt)){
                System.out.println("success");
        }else{
                System.out.println("faile");
        }


                  //  System.out.println(text);
    }
}