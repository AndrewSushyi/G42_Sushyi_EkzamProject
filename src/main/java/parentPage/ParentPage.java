package parentPage;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ParentPage {
   protected WebDriver webDriver;
   //обр к статич методу Логгера где передаем getClass ИмяКласса в котором он будет вызван
   // это для информативности и в сообщении будет писаться Имя этого Класса в котором был вы
    protected Logger logger = Logger.getLogger(getClass());

    //в конструктор передаем Ведрайвер сгенерированный в Тесте
    public ParentPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        //чтоб каждый раз при Обращении к Странице Инициализи-ь ее переменные @FindBy
        // this - это параметр =названию страницы
        PageFactory.initElements(webDriver, this);
    }




}
