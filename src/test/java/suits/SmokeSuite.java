package suits;

import cartTest.TC4_DeleteFromCartTest;
import choiceElementForFilterTest.TC3_СhoiceElementForFilterTest;
import loginTest.TC1_validLoginTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import searchFieldTest.TC2_validSearchInSearchField;

//запуск Коллекции тестов
@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                TC1_validLoginTest.class,
                TC2_validSearchInSearchField.class,
                TC3_СhoiceElementForFilterTest.class,
                TC4_DeleteFromCartTest.class
        }
)
public class SmokeSuite {
}
