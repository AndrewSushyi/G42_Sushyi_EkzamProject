package searchFieldTest;

import abstractParentTest.AbstractParentTest;
import org.junit.Test;

public class TC2_validSearchInSearchField extends AbstractParentTest {
    @Test
    public void validSearchInSearchField(){
       homePage.openPage("https://lavkababuin.com/");
       homePage.enterTextInToInputSearch("Думай и богатей");
       homePage.clickOnButtonSearch();

       checkExpectedResult("book not found", homePage.isSearchWordsInSearchResult("Думай и богатей"));
    }
}
