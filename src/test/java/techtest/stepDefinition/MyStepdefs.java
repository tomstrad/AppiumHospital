package techtest.stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import techtest.pageObjects.HospitalsPage;
import techtest.pageView.HospitalsPageView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MyStepdefs {
    @Given("I have launched the app")
    public void iHaveLaunchedTheApp() {
    }

    @When("I am on the hospitals page")
    public void iAmOnTheHospitalsPage() {
        HospitalsPageView.getHospitalsPages().forEach(hospitalsPage -> assertTrue(hospitalsPage.isTitleVisible()));
    }

    @Then("I see a list of hospitals")
    public void iSeeAListOfHospitals() {
        HospitalsPageView.getHospitalsPages().forEach(hospitalsPage -> assertTrue(hospitalsPage.isListVisible()));
        HospitalsPageView.getHospitalsPages().forEach(hospitalsPage -> assertTrue(hospitalsPage.getListSize() > 0));

    }

    @And("I see a search bar")
    public void iSeeASearchBar() {
        HospitalsPageView.getHospitalsPages().forEach(hospitalsPage -> assertTrue(hospitalsPage.isSearchBarVisible()));
        HospitalsPageView.getHospitalsPages().forEach(hospitalsPage -> assertTrue(hospitalsPage.isSearchBarUsable()));
    }

    @When("When I click on it")
    public void whenIClickOnIt() {
        HospitalsPageView.getHospitalsPages().forEach(HospitalsPage::clickSearchButton);
        HospitalsPageView.getHospitalsPages().forEach(hospitalsPage -> assertTrue(hospitalsPage.isSearchBoxTextEntryVisible()));

    }

    @Then("I can enter text")
    public void iCanEnterText() {
        HospitalsPageView.getHospitalsPages().forEach(hospitalsPage -> hospitalsPage.enterSearchText("Test Text"));
        HospitalsPageView.getHospitalsPages().forEach(hospitalsPage -> assertEquals("Test Text", hospitalsPage.getSearchText()));

    }
}
