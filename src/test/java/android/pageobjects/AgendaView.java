package android.pageobjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class AgendaView extends AbstractView {

    public AgendaView(AndroidDriver driver) {
        super(driver);
    }

    String partialtext = "MY SCHEDULE";

    @AndroidFindBy(className = "com.pgssoft.testwarez:id/llEventListItem")
    public List<AndroidElement> agendaList;

    @AndroidFindBy(id = "com.pgssoft.testwarez:id/favorite")
    public List<AndroidElement> favoritesCalendarButton;

    public void checkIfAgendaViewIsVisible() {
        wait.until(ExpectedConditions.visibilityOf(agendaList.get(0)));
    }

    public void addFirstEventToFavorites() {
        favoritesCalendarButton.get(0).click();
        wait.until(ExpectedConditions.visibilityOf(agendaList.get(0)));
    }

    public void selectSchedulesList() {
        wait.until(ExpectedConditions.visibilityOf(agendaList.get(0)));
    }

    public void checkIfEventExistInSchedule() {
        driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\""+partialtext+"\")").click();
        Assert.assertTrue(favoritesCalendarButton.get(0).isEnabled());
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

