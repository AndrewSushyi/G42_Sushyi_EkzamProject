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
    @FindBy (xpath = ".//ul[@class='menu-catalog']/li[1]/a")
    private WebElement submenuKnigi;
    //////////////////////////////////////////////////////////////////
    //product
    @FindBy (xpath = ".//*[@class='bg-grey mt-5 module-latest']//div[@data-slick-index='0']")
    private WebElement productFirst;
    @FindBy (xpath =".//*[@class='bg-grey mt-5 module-latest']//div[@data-slick-index='1']" )
    private WebElement productSecond;
    @FindBy (xpath = ".//*[@class='bg-grey mt-5 module-latest']//*[@class='product-card slick-slide slick-current slick-active']//button[@class='btn-add-to-cart']")
    private WebElement productFirstBuy;
    @FindBy (xpath = ".//*[@class='bg-grey mt-5 module-latest']//*[@class='product-card slick-slide slick-active' and @data-slick-index='1']//button[@class='btn-add-to-cart']")
    private WebElement productSecondBuy;
    //////////////////////////////////////////////////////////////////
    //PopUp Cart products and elements
    @FindBy (xpath = ".//*[@class='dropdown-menu show']//*[@class='cart-remove']")
    private  WebElement deleteProduct;
    @FindBy (xpath = "//*[@class='dropdown-menu show']//*[@class='cart-close']")
    private WebElement closeCart;
    //////////////////////////////////////////////////////////////////
    @FindBy (xpath = ".//div[@id='cart']//*[@class='count']")
    private  WebElement counterProductsOnPictogramCart;

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
//
    //
    public boolean isSearchWordsInSearchResult(String text){
        return actionsWithOurElements.isElementContainText(firstElementInSearchResult, text);
    }
    public boolean checkValueCounterCartPictogram(String text){
        return  actionsWithOurElements.isTextEqualElementText(counterProductsOnPictogramCart, text);
    }
    public void moveToProductFirst () {
        actionsWithOurElements.moveToElementAndHower(productFirst);
    }
    public void moveToProductSecond () {
        actionsWithOurElements.moveToElementAndHower(productSecond);
    }
    public void clickOnBuyProductFirst() {
        actionsWithOurElements.clickOnElement(productFirstBuy);
    }

    public void clickOnBuyProductSecond() {
        actionsWithOurElements.clickOnElement(productSecondBuy);
    }
    public void deleteAllProductInCart(){
        actionsWithOurElements.delete(deleteProduct);
    }
    public void closeCart(){
        actionsWithOurElements.clickOnElement(closeCart);
    }
    public void myWate (){}

}
