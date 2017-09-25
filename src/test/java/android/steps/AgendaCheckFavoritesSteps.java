package android.steps;

import android.pageobjects.AgendaView;
import android.utils.AndroidDriverFactory;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class AgendaCheckFavoritesSteps {

	private AndroidDriver andDrv;
	private AgendaView agenda;

	public AgendaCheckFavoritesSteps() {
		andDrv = AndroidDriverFactory.get();
		agenda = new AgendaView(andDrv);
		PageFactory.initElements(new AppiumFieldDecorator(andDrv), agenda);
	}

	@Given("^I am on agenda start view$")
	public void iAmOnAgendaStartView() {
		agenda.checkIfAgendaViewIsVisible();
	}

	@When("^I add first event to favorites$")
	public void iAddFirstEventToFavorites() {
		agenda.addFirstEventToFavorites();
	}

	@And("^I select MY SCHEDULE$")
	public void iSelectSchedulesList() {
		agenda.selectSchedulesList();
	}

	@Then("^I see an event I added in MY SCHEDULE$")
	public void iSeeAnEventIChosenInTheScheduleSList() {
		agenda.checkIfEventExistInSchedule();
	}


}
