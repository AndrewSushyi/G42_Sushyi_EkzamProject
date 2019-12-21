package cartTest;

import abstractParentTest.AbstractParentTest;
import org.junit.Test;

public class TC4_DeleteFromCartTest extends AbstractParentTest {
    @Test
    public void deleteFromCartTest() {
        homePage.openPage("https://lavkababuin.com/");
        homePage.clickOnCloseBanerButton();
        //1st proguct
        homePage.moveToProductFirst();
        homePage.pause(1000);
        homePage.clickOnBuyProductFirst();
        homePage.pause(1000);
        //2d proguct
        homePage.moveToProductSecond();
        homePage.pause(1000);
        homePage.clickOnBuyProductSecond();
        homePage.pause(2000);

        homePage.deleteAllProductInCart();

        homePage.pause(2000);


        homePage.closeCart();
        homePage.pause(2000);


       //homePage.closeCart();



        //homePage.checkValueCounterCartPictogram("0");
        System.out.println("finish good");
    }


}
