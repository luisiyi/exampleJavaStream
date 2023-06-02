/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Tutorial;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/**
 *
 * @author lgutierrez
 */
public class Calendar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        
        
        System.setProperty("webdriver.chrome.driver", "C:/bin/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.path2usa.com/travel-companions");
        //August 23
        WebElement myelement = driver.findElement(By.xpath("//*[@id='form-field-travel_comp_date']"));
        JavascriptExecutor jse2 = (JavascriptExecutor)driver;
        jse2.executeScript("arguments[0].scrollIntoView()", myelement);
        Thread.sleep(1000);
//        Actions actions = new Actions(driver);
//        actions.moveToElement(myelement).click().build().perform();
        driver.findElement(By.xpath("//input[@id='form-field-travel_comp_date']")).click(); 
        
        //span[@class='flatpickr-next-month']
        
        while (!driver.findElement(By.xpath("//span[@class='flatpickr-next-month']")).getText().equalsIgnoreCase("April ")) { 
            System.out.println(driver.findElement(By.xpath("//span[@class='flatpickr-next-month']")).getText());
            driver.findElement(By.xpath("//span[@class='flatpickr-next-month']")).click();
        }
        
        List<WebElement> dates = driver.findElements(By.className("flatpickr-day"));
        
        int count = driver.findElements(By.className("flatpickr-day")).size();
        
        for (int i = 0; i < count; i++) {
            String text = driver.findElements(By.className("flatpickr-day")).get(i).getText();
            if(text.equalsIgnoreCase("23")){
                driver.findElements(By.className("flatpickr-day")).get(i).click();
                break;
            }
        }
        
        
    }
}
