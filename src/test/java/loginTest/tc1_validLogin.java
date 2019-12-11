package loginTest;

import abstractParentTest.AbstractParentTest;
import org.junit.Test;

public class tc1_validLogin extends AbstractParentTest {
    @Test
    public void validLogin(){
        loginPage.openPage("https://lavkababuin.com/login/");
        loginPage.enterLoginInToInputLogin("andrei_sush1@ukr.net");
        loginPage.enterPasswordInToInputPassword("123456QA");
        loginPage.clickOnButtonEnter();

        checkExpectedResult("user don't Authorization", accountPage.isUserBtnDisplayed());
    }

}
