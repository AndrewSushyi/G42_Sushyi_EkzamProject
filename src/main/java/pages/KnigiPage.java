package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class KnigiPage extends ParentPage {
    @FindBy (xpath = ".//div[@class='category__wall-block']//*[contains(text(), 'Бизнес')]")
    private WebElement linkBusiness;
//FilterSidebar:
    //checkbox "Акция"
    @FindBy (xpath = ".//input[@type='checkbox' and @id='iv-r16'")
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

    public void clickOnLinkBusiness(){
        actionsWithOurElements.clickOnElement(linkBusiness);
    }


    public void markCheckboxStock() {
        actionsWithOurElements.clickOnElement(checkboxStock);
    }

    public boolean isElementStockDisplayed() {
        return actionsWithOurElements.isElementDisplayed(parameterStockInResult);
    }
    public boolean isElementPriceDisplayed() {
        return actionsWithOurElements.isElementDisplayed(parameterPriceInResult);
    }
}
