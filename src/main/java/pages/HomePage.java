package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import parentPage.ParentPage;

public class HomePage extends ParentPage {

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }
// учим Страницу проверять наличия Элемента
    public boolean isUserBtnDisplayed(){
        try{
            WebElement UserBtn = webDriver.findElement(By.xpath(".//*[@class='btn-blue dropdown-toggle']"));
            return UserBtn.isDisplayed();
        }catch (Exception e){
            return false;
        }

    }

}

