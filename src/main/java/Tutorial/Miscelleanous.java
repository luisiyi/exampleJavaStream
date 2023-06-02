/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Tutorial;

import java.io.File;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.apache.commons.io.FileUtils;

/**
 *
 * @author lgutierrez
 */
public class Miscelleanous {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        System.setProperty("webdriver.chrome.driver", "C:/bin/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        //driver.manage().deleteCookieNamed("sessionKey");
        
        driver.get("https://www.google.com");
        
        
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        
        //FileUtils.copyFile(src, new File("C://screenshot.png"));
        
        
        
        
        
        
    }
    
}
