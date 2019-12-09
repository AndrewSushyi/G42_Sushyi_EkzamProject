package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class HomePage extends ParentPage {
    @FindBy (xpath = ".//*[@class='btn-blue dropdown-toggle']")
    private WebElement userBtn;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }
// учим Страницу проверять наличия Элемента
    public boolean isUserBtnDisplayed(){
      return actionsWithOurElements.isElementDisplayed(userBtn);
    }

}

