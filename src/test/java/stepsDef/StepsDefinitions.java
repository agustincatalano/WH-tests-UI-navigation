package stepsDef;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
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
    public void validateIsVisibleOnEachSport(String text) throws Throwable {
        sharedSteps.validateJuegoResponsableonEachTopSport(text);
    }

    @And("^I mouse over on the link \"([^\"]*)\"$")
    public void iMouseOverOnTheLink(String linkText) throws Throwable {
        sharedSteps.mouseOverOnLinkText(linkText);
    }

    @And("^I click on the link \"([^\"]*)\"$")
    public void iClickOnTheLink(String linkText) throws Throwable {
        sharedSteps.clickOnLinkWithText(linkText);
    }

    @And("^I switch to next windows$")
    public void iSwitchToNextWindows() throws Throwable {
        sharedSteps.swichToNextWindow();
    }

    @And("^I validate that the following URL is \"([^\"]*)\"$")
    public void iValidateThatTheFollowingURLIs(String url) throws Throwable {
        sharedSteps.validateURL(url);
    }

    @And("^I add each link from the rn_navigation bar in a list$")
    public void iAddEachLinkFromTheRn_navigationBarInAList() throws Throwable {
        sharedSteps.getLinksfromRnNavigatorToAList();
    }

    @Then("^I validate that following links are present on the list$")
    public void iValidateThatFollowingLinksArePresentOnTheList(List<String> myRNLinks) throws Throwable {
        Assert.assertTrue("Links from RN container are not equals to the links from .feature file", sharedSteps.compreListlinks(myRNLinks));
    }
}
