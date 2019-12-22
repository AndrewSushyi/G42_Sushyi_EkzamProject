package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class AccountPage extends ParentPage {
    @FindBy (xpath = ".//*[@class='btn-blue dropdown-toggle']")
    private WebElement userBtn;

    public AccountPage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isUserBtnDisplayed(){
        return actionsWithOurElements.isElementDisplayed(userBtn);
    }

}

