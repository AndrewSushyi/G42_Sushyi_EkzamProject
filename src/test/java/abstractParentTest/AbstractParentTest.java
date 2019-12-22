package abstractParentTest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AccountPage;
import pages.HomePage;
import pages.KnigiPage;
import pages.LoginPage;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class AbstractParentTest {
    WebDriver webDriver;
    // Объект страницы Login в тесте выполн. наши команды на ней)
    protected LoginPage loginPage;
    protected AccountPage accountPage;
    protected HomePage homePage;
    protected KnigiPage knigiPage;

    @Before
    public void setUP(){
        File file = new File("./src/drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        webDriver = new ChromeDriver();

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // Инициализируем переменную loginPage передавая выше созданный webdriver
        // !! т.е. loginPage будет работать с единым webdriver созданным в Тесте
       // т.о. этот конструктор попал в Page и потом в ParrentPage
        loginPage = new LoginPage(webDriver);
        accountPage = new AccountPage(webDriver);
        homePage = new HomePage(webDriver);
        knigiPage = new KnigiPage(webDriver);
    }

    @After
    public void tearDown(){
        webDriver.quit();
    }

    protected void checkExpectedResult(String message, boolean actualResult) {
        Assert.assertEquals(message, true, actualResult);

    }
}
