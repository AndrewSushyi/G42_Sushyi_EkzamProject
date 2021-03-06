package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class ActionsWithOurElements {
    WebDriver webDriver;
    Actions action;
    WebDriverWait webDriverWait_10, webDriverWait_15;
    Logger logger = Logger.getLogger(getClass());

    public ActionsWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        action = new Actions(webDriver);
        webDriverWait_10 = new WebDriverWait(webDriver, 10);
        webDriverWait_15 = new WebDriverWait(webDriver, 15);
    }

    public void pause(Integer milliseconds){
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

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

    public void waitUntilAllJQueryWillBeFinished(){
        new WebDriverWait(webDriver, 3000)
                .until(new ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        JavascriptExecutor js = (JavascriptExecutor) driver;
                        return (Boolean) js.executeScript("return jQuery.active == 0");
                    }
                });
    }

    public void clickOnElement (WebElement webElement){
        try {
            waitUntilAllJQueryWillBeFinished();
            webDriverWait_10.until(ExpectedConditions.elementToBeClickable(webElement));
            webElement.click();
            waitUntilAllJQueryWillBeFinished();
            logger.info("Element" + webElement + " was clicked");
        } catch (Exception e){
            logger.error(e);
            stopTestAndPrintMessage();
        }
    }

    public void moveToElementAndHower(WebElement webElement) {
        try {
            action.moveToElement(webElement).perform();
            webDriverWait_10.until(ExpectedConditions.visibilityOf(webElement));
            logger.info("moved and hovered on element");
        } catch (Exception e){
            logger.info(e);
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

    public boolean isElementContainText(WebElement webElement, String expectedText){
        try{
            boolean state = webElement.getText().contains(expectedText);
            logger.info("Is text in element -> " + state);
            return state;
        }catch (Exception e){
            logger.info("Is text in element -> false");
            return false;
        }
    }

    public boolean isTextEqualElementText (WebElement webElement, String expectedText){
        try{
            boolean state = webElement.getText().equals(expectedText);
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

//метод требует доработки: для проверки Отсутсвия элемента хотел исп. метод isDisplayed но он не подходит т.к. гененрирует эксешин когда элемент удален (что для меня true)
    public boolean deleteAll(WebElement webElement) {
        try{
            boolean state = webElement.isDisplayed();
            do {
                webElement.click();
                pause(1000);
            }while (isElementDisplayed(webElement));

            logger.info("vse Element was remove from Korzina - true");
            return true;
        }catch (Exception e){
            logger.info("such Elements not found - False");
            return false;
        }

    }


}
