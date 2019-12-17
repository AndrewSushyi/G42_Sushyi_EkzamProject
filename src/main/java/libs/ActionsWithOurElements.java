package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActionsWithOurElements {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());

    public ActionsWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

// вынес из LoginPage
    public void openPage(String  linkURL) {
        //т.к. действие то Обработаем сразу Экспшин
        try {
            webDriver.get(linkURL);

        }catch (Exception e){
            // именно в методе Open исп ассертФейл = безоговоречная остановка теста  т.к. не Открылась страница и дал.дейстивя не имеют смысла
            // это сообщение попадет в Отчет
            Assert.fail("can not work with browser");
        }

    }

    public void enterTextInToInput(WebElement webElement, String text){
        try {
            webElement.clear();
            webElement.sendKeys(text);
            logger.info(text + " was inputted in to input");

        } catch (Exception e){
            stopTestAndPrintMessage();
        }

    }

    public void clickOnElement (WebElement webElement){
        try {
            webElement.click();
            logger.info("Element was clicked");

        } catch (Exception e){
            stopTestAndPrintMessage();
        }
    }

    public boolean isElementDisplayed (WebElement webElement){
        try {
            boolean state = webElement.isDisplayed();
            logger.info("Is element displayed -> " + state);
            return state;
        }catch (Exception e){
            logger.info("Is element displayed -> false");
            return false;
        }
    }

    public boolean isTextInElement (WebElement webElement, String expectedText){
        try{
            boolean state = webElement.getText().contains(expectedText);
            logger.info("Is text in element -> " + state);
            return state;

        }catch (Exception e){
            logger.info("Is text in element -> false");
            return false;
        }
    }

    private void stopTestAndPrintMessage() {
        logger.error("Can not work with element ");
        Assert.fail("Can not work with element ");
    }


}
