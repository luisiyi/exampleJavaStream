/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Tutorial;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author lgutierrez
 */
public class Scope {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        
        // 1. Give me the count of the links on the page
        // 2. Count of footer section.
        
        System.setProperty("webdriver.chrome.driver", "C:/bin/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        
        
        driver.get("http://qaclickacademy.com/practice.php");
        
        System.out.println(driver.findElements(By.tagName("a")).size());
        
        WebElement footerdriver = driver.findElement(By.id("gf-BIG")); //limiting webdriver scope
        
        System.out.println(footerdriver.findElements(By.tagName("a")).size());
        
        // 3. 
        WebElement columndriver = footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        
        System.out.println(columndriver.findElements(By.tagName("a")).size());
        
        // 4. Click on each link in the column and check if the pages are opening
        for(int i=1; i<columndriver.findElements(By.tagName("a")).size(); i++){
            
            String clickonlinkTab=Keys.chord(Keys.CONTROL, Keys.ENTER);
            
            columndriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlinkTab);
            Thread.sleep(5000);
        }  
        // open all the tabs 
        Set<String> abc = driver.getWindowHandles();
        Iterator<String> it =abc.iterator();
        
        while(it.hasNext()){
            
            driver.switchTo().window(it.next());
            System.out.println(driver.getTitle());
            
        }
        
        
        
        
        
        
        
        
        
        
    }
    
}
