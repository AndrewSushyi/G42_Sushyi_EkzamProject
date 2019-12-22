package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import parentPage.ParentPage;

public class KnigiPage extends ParentPage {
    @FindBy(xpath = ".//*[@class='banner__wrap']//i[@class='fas fa-times']")
    private WebElement closeBanerButton;

    @FindBy (xpath = ".//div[@class='category__wall-block']//*[contains(text(), 'Бизнес')]")
    private WebElement linkBusiness;
//FilterSidebar:
    //checkbox "Акция"
    @FindBy (xpath = ".//*[@class='ocf-option-values']//*[@class='form-check'][1]")
    private WebElement checkboxStock;
    @FindBy (xpath = ".//*[@class='noUi-handle noUi-handle-lower']")
    private WebElement sliderMinPrice;
    @FindBy (xpath = ".//*[@class='noUi-handle noUi-handle-upper']")
    private WebElement sliderMaxPrice;

    @FindBy (xpath = ".//*[@class='row products-cards products__body']/div[1]//*[@class='stock']")
    private WebElement parameterStockInResult;
    @FindBy (xpath = ".//*[@class='row products-cards products__body']/div[1]//*[@class='price']")
    private WebElement parameterPriceInResult;

    public KnigiPage(WebDriver webDriver) {super(webDriver);}

    public void clickOnCloseBanerButton() {
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(closeBanerButton));
        actionsWithOurElements.clickOnElement(closeBanerButton);
    }

    public void clickOnLinkBusiness(){
        actionsWithOurElements.clickOnElement(linkBusiness);
    }
    public void markCheckboxStock() {
        actionsWithOurElements.clickOnElement(checkboxStock);
    }
    public boolean isLabelStockInproduct (String label){
        boolean isTextInLabel = actionsWithOurElements.isElementContainText(parameterStockInResult, label);
        if (isTextInLabel){
            logger.info("  in books result they have label:" + parameterStockInResult.getText());
            return true;
        }else {
            logger.info("  in books result they DON`T have label:" + parameterStockInResult.getText());
            return false;}
    }
}
