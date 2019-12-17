package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class HomePage extends ParentPage {
    @FindBy (xpath = ".//input[@name='search']")
    private WebElement inputSearch;
    @FindBy (xpath= ".//button[@class='btn-search']")
    private WebElement buttonSearch;
    @FindBy (xpath= ".//div[@class='row products-cards products__body']/div[1]//a[@class='title-product']")
    private WebElement firstElementInSearchResult;
    @FindBy (xpath = ".//button[@id='btn-menu-catalog']")
    private WebElement menuCatalog;

    public HomePage(WebDriver webDriver) {super(webDriver);}

    public void openPage(String linkURL){
        actionsWithOurElements.openPage(linkURL);
    }

    public void enterTextInToInputSearch(String text){
        actionsWithOurElements.enterTextInToInput(inputSearch,text);
    }

    public void clickOnButtonSearch() {
        actionsWithOurElements.clickOnElement(buttonSearch);
    }

    public boolean isSearchWordsInSearchResult(String text){
        return actionsWithOurElements.isTextInElement(firstElementInSearchResult, text);
    }


    public void clickOnMenuCatalog() {
        actionsWithOurElements.clickOnElement(menuCatalog);
    }

}
