package parentPage;

import org.openqa.selenium.WebDriver;

public class ParentPage {
   protected WebDriver webDriver;
    //в конструктор передаем Бедрайвер сгенерированный в Тесте
    public ParentPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }


}
