package stepsDef;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.junit.Assert;

import java.util.List;

/**
 * Created by agustin on 09/06/2017.
 */

public class StepsDefinitions {

    public final static String SPORTBOOK_SPAIN = "http://sports.williamhill.es/bet_esp/es";
    private SharedSteps sharedSteps = new SharedSteps();

    @Given("^I navigate to Spanish Sportsbook homepage$")
    public void iNavigateToSpanishSportsbookHomepage() throws Throwable {
        Assert.assertTrue(sharedSteps.navigateToPage(SPORTBOOK_SPAIN));
        Assert.assertTrue(sharedSteps.validateSportsbookHomepageIsDisplayed());
    }

    @After
    public void closeWindows() {
        sharedSteps.closeWindow();
    }

    @And("^I add each event listed on the top page in a list$")
    public void iAddEachEventListedOnTheTopPageInAList() throws Throwable {
        Assert.assertTrue(sharedSteps.getEventList());
    }

    @And("^I validate that following events are present on the list$")
    public void iValidateThatFollowingEventsArePresentOnTheList(List<String> myEvents) throws Throwable {
        Assert.assertTrue(sharedSteps.compareEventslist(myEvents));

    }


    @And("^I Validate that each event contains \"([^\"]*)\" link$")
    public void iValidateThatEachEventContainsLink(String textLink) {
        Assert.assertTrue(sharedSteps.validateJuegoResponsableLinkonEachEvent(textLink));
    }


    @And("^Validate \"([^\"]*)\" is visible on each sport$")
    public void validateIsVisibleOnEachSport(String arg0) throws Throwable {
        sharedSteps.validateJuegoResponsableonEachTopSport();
    }
}
