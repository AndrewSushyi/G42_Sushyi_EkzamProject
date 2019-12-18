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
    //@FindBy (xpath = "//ul[@class=menu-catalog']//a[contains(text(),'Книги']")
    @FindBy (xpath = "//ul[@class='menu-catalog']/li[1]/a")
    private WebElement submenuKnigi;

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

    public void hoverOnButtonMenuCatalog(){actionsWithOurElements.hoverOnElement(menuCatalog);}
    public void clickOnSubmenuKnigi() {
        actionsWithOurElements.clickOnElement(submenuKnigi);
    }

    public boolean isSearchWordsInSearchResult(String text){
        return actionsWithOurElements.isTextInElement(firstElementInSearchResult, text);
    }

}
