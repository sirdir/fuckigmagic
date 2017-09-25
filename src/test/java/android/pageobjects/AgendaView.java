package android.pageobjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class AgendaView extends AbstractView {

    public AgendaView(AndroidDriver driver) {
        super(driver);
    }

    String partialtext = "MY SCHEDULE";

//    @AndroidFindBy(className = "com.pgssoft.testwarez:id/llEventListItem")
//    public List<AndroidElement> agendaList;

    public By agendaList = By.className("com.pgssoft.testwarez:id/llEventListItem");

//    public String agendaList = "com.pgssoft.testwarez:id/llEventListItem";


//    @AndroidFindBy(id = "com.pgssoft.testwarez:id/favorite")
//    public List<AndroidElement> favoritesCalendarButton;

    public By favoritesCalendarButton = By.id("com.pgssoft.testwarez:id/favorite");

//    public String favoritesCalendarButton = "com.pgssoft.testwarez:id/favorite";

    public void checkIfAgendaViewIsVisible() {
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(agendaList, 0));
    }

    public void addFirstEventToFavorites() {
        List<AndroidElement> list1 = driver.findElements(favoritesCalendarButton);
        list1.get(0).click();
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(agendaList, 0));
    }

    public void selectSchedulesList() {
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(agendaList, 0));

    }

    public void checkIfEventExistInSchedule() {
        driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\""+partialtext+"\")").click();
        List<AndroidElement> list1 = driver.findElements(favoritesCalendarButton);
        Assert.assertTrue(list1.get(0).isEnabled());
    }

//    public boolean (AndroidElement agendaList, int timeout){
//        try{
//            WebDriverWait wait = new WebDriverWait(driver, 30);
//            wait.until(ExpectedConditions.visibilityOf(agendaList));
//            return true;
//        }catch(Exception e){
//            return false;
//        }
//    }
}

