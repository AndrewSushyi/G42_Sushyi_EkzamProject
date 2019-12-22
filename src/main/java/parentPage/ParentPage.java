package parentPage;

import libs.ActionsWithOurElements;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ParentPage {
   protected WebDriver webDriver;
   protected Logger logger = Logger.getLogger(getClass());
   protected ActionsWithOurElements actionsWithOurElements;

    //в конструктор передаем Ведрайвер сгенерированный в Тесте
    public ParentPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        //чтоб каждый раз при Обращении к Странице Инициализи-ь ее переменные @FindBy
        // this - это параметр = названию страницы
        PageFactory.initElements(webDriver, this);
        actionsWithOurElements = new ActionsWithOurElements(webDriver);
    }
}
