/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Tutorial;

import java.time.Duration;
import java.util.function.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

/**
 *
 * @author lgutierrez
 */
public class fluentWaitTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        System.setProperty("webdriver.chrome.driver", "C:/bin/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        
        driver.findElement(By.cssSelector("[@id='start'] button")).click();
        
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
        
        
        WebElement foo = wait.until(new Function<WebDriver, WebElement>(){
            
           public WebElement apply(WebDriver driver){
               if(driver.findElement(By.cssSelector("[id='fnish'] h4")).isDisplayed())
               {
                   return driver.findElement(By.cssSelector("[id='fnish'] h4"));
               }
               else
                   return null;
           } 
        });
        System.out.println(driver.findElement(By.cssSelector("[id='fnish'] h4")).getText());       
    }
    
}
