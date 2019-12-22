package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class LoginPage extends ParentPage {
    @FindBy (id = "input-email")
    private WebElement inputLogin;
    @FindBy (id = "input-password")
    private WebElement inputPassword;
    @FindBy (xpath = ".//*[@class='btn btn-main btn-xl ml-auto mr-minus']")
    private WebElement buttonEnter;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openPage(String linkURL){
        actionsWithOurElements.openPage(linkURL);
    }
    public void enterLoginInToInputLogin(String login) {
        actionsWithOurElements.enterTextInToInput(inputLogin, login);
    }
    public void enterPasswordInToInputPassword(String password) {
        actionsWithOurElements.enterTextInToInput(inputPassword, password);
    }
    public void clickOnButtonEnter() {
        actionsWithOurElements.clickOnElement(buttonEnter);
    }
}
