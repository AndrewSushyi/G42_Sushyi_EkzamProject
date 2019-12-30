package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import parentPage.ParentPage;

public class HomePage extends ParentPage {
    @FindBy(xpath = ".//*[@class='banner__wrap']//i[@class='fas fa-times']")
    private WebElement closeBanerButton;
    //
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
    //@FindBy (xpath = ".//*[@class='bg-grey mt-5 module-latest']//div[@data-slick-index='0']")
    @FindBy (xpath = ".//*[@class='bg-grey mt-5 module-latest']//*[@class='product-card slick-slide slick-current slick-active']//button[@class='btn-add-to-cart']")
    private WebElement productFirst;
   // @FindBy (xpath =".//*[@class='bg-grey mt-5 module-latest']//div[@data-slick-index='1']" )
   @FindBy (xpath = ".//*[@class='bg-grey mt-5 module-latest']//*[@class='product-card slick-slide slick-active' and @data-slick-index='1']//button[@class='btn-add-to-cart']")
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

    String nameObject="";

    @FindBy(xpath = "//div[@class='dropdown-menu show']//h3[text()='Корзина']")
    private WebElement titleOfCart;

    @FindBy(xpath = "//div[@class='dropdown-menu show']//h3//..//button//i[@class='fa fa-times-circle']")
    private WebElement buttonCloseCart;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void pause (Integer milliseconds){actionsWithOurElements.pause(milliseconds);}

    public void openPage(String linkURL){
        actionsWithOurElements.openPage(linkURL);
    }

    public void clickOnCloseBanerButton() {
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(closeBanerButton));
        actionsWithOurElements.clickOnElement(closeBanerButton);
    }

    public void enterTextInToInputSearch(String text){
        actionsWithOurElements.enterTextInToInput(inputSearch,text);
    }
    public void clickOnButtonSearch() {
        actionsWithOurElements.clickOnElement(buttonSearch);
    }
    public void hoverOnButtonMenuCatalog(){
        actionsWithOurElements.moveToElementAndHower(menuCatalog);
    }
    public void clickOnSubmenuKnigi() {
        actionsWithOurElements.clickOnElement(submenuKnigi);
    }
///////
    public boolean isSearchWordsInSearchResult(String text){
        return actionsWithOurElements.isElementContainText(firstElementInSearchResult, text);
    }
    public boolean checkValueCounterCartPictogram(String text){
        if (actionsWithOurElements.isTextEqualElementText(counterProductsOnPictogramCart, text)==true){
            logger.info("  All books was deleted! Counter books in Korzina = " + counterProductsOnPictogramCart.getText());
        }
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

        actionsWithOurElements.isElementDisplayed(titleOfCart);
        actionsWithOurElements.isElementDisplayed(buttonCloseCart);
        actionsWithOurElements.moveToElementAndHower(buttonCloseCart);
        actionsWithOurElements.clickOnElement(buttonCloseCart);

    }

    public void clickOnBuyProductSecond() {
        actionsWithOurElements.clickOnElement(productSecondBuy);
        actionsWithOurElements.isElementDisplayed(titleOfCart);
        actionsWithOurElements.isElementDisplayed(buttonCloseCart);
        actionsWithOurElements.moveToElementAndHower(buttonCloseCart);
    }
    public void deleteAllProductInCart(){
        actionsWithOurElements.deleteAll(deleteProduct);
    }
    public void closeCart(){
        actionsWithOurElements.clickOnElement(closeCart);
    }
}
