package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import parentPage.ParentPage;

public class LoginPage extends ParentPage {

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openPage() {
        //т.к. действие то Обработаем сразу Экспшин
        try {
            webDriver.get("https://lavkababuin.com/login/");

        }catch (Exception e){
            // именно в методе Open исп ассертФейл = безоговоречная остановка теста  т.к. не Открылась страница и дал.дейстивя не имеют смысла
            // это сообщение попадет в Отчет
            Assert.fail("can not work with browser");
        }

    }
}
