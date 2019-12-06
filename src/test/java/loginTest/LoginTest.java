package loginTest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class LoginTest {
    WebDriver webDriver;

    @Test
    public void  validLogin(){

        File file = new File("./src/drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        webDriver = new ChromeDriver();

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//
        webDriver.get("https://lavkababuin.com/login/");

        webDriver.findElement(By.id("input-email")).clear();
        webDriver.findElement(By.id("input-email")).sendKeys("andrei_sush1@ukr.net");

        webDriver.findElement(By.id("input-password")).clear();
        webDriver.findElement(By.id("input-password")).sendKeys("123456QA");
        //btn Войти
        webDriver.findElement(By.xpath(".//*[@class='btn btn-main btn-xl ml-auto mr-minus']")).click();

//
        Assert.assertTrue("User is not authorization via LoginPage",
                isUserBtnPresentAfterLogin());



    }

    private boolean isUserBtnPresentAfterLogin() {
        try {
            return webDriver.findElement(By.xpath(".//*[@class='btn-blue dropdown-toggle']")).isDisplayed();
        }catch (Exception e){
            return false;
        }
    }
}
