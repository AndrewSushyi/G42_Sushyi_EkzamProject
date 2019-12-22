package cartTest;

import abstractParentTest.AbstractParentTest;
import org.junit.Test;

public class TC4_DeleteFromCartTest extends AbstractParentTest {
    @Test
    public void deleteFromCartTest() {
        homePage.openPage("https://lavkababuin.com/");
//1st proguct
        homePage.moveToProductFirst();
        homePage.clickOnBuyProductFirst();

        homePage.moveToProductFirst();
        homePage.clickOnBuyProductFirst();
//2d product
        homePage.moveToProductSecond();
        homePage.clickOnBuyProductSecond();

        homePage.closeCart();




       //homePage.closeCart();



        //homePage.checkValueCounterCartPictogram("0");
        System.out.println("finish good");
    }


}
