package choiceElementForFilterTest;

import abstractParentTest.AbstractParentTest;
import org.junit.Test;

public class TC3_СhoiceElementForFilterTest extends AbstractParentTest {
    @Test
    public  void choiceElementForFilterTest(){
        homePage.openPage("https://lavkababuin.com/");
        homePage.hoverOnButtonMenuCatalog();
        homePage.clickOnSubmenuKnigi();
        knigiPage.clickOnLinkBusiness();
        //knigiPage.markCheckboxStock();
//      knigiPage.setSliderMinPrice(200);
//      knigiPage.setSliderMaxPrice(600);

        //checkExpectedResult("book with filterStock not found", knigiPage.isElementStockDisplayed());

    }
}
