package techtest.stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import techtest.pageObjects.HospitalsPage;
import techtest.pageObjects.ResultPage;
import techtest.pageView.HospitalsPageView;
import techtest.pageView.ResultPageView;

import static org.junit.Assert.*;

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

    @When("I click on it")
    public void whenIClickOnIt() {
        HospitalsPageView.getHospitalsPages().forEach(HospitalsPage::clickSearchButton);
        HospitalsPageView.getHospitalsPages().forEach(hospitalsPage -> assertTrue(hospitalsPage.isSearchBoxTextEntryVisible()));

    }

    @Then("I can enter text")
    public void iCanEnterText() {
        HospitalsPageView.getHospitalsPages().forEach(hospitalsPage -> hospitalsPage.enterSearchText("Test Text"));
        HospitalsPageView.getHospitalsPages().forEach(hospitalsPage -> assertEquals("Test Text", hospitalsPage.getSearchText()));

    }

    @Given("I enter invalid characters in the search")
    public void iEnterInvalidCharactersInTheSearch() {
        HospitalsPageView.getHospitalsPages().forEach(HospitalsPage::clickSearchButton);
        HospitalsPageView.getHospitalsPages().forEach(hospitalsPage -> assertTrue(hospitalsPage.isSearchBoxTextEntryVisible()));
        HospitalsPageView.getHospitalsPages().forEach(hospitalsPage -> hospitalsPage.enterSearchText("!!@@£"));

    }

    @When("I perform the search")
    public void iPerformTheSearch() {
        //Incase there is a change in how the search is carried out. Right now this does nothing. So it is harmless
    }

    @Then("No Results are shown")
    public void noResultsAreShown() {
        HospitalsPageView.getHospitalsPages().forEach(hospitalsPage -> assertFalse(hospitalsPage.isListVisible()));
    }

    @And("I can clear the text")
    public void iCanClearTheText() {
        HospitalsPageView.getHospitalsPages().forEach(hospitalsPage -> assertTrue(hospitalsPage.isSearchClearVisible()));
//        HospitalsPageView.getHospitalsPages().forEach(HospitalsPage::clickClearSearch);
    }

    @Given("I enter University Hospital Coventry in the search")
    public void iEnterUniversityHospitalCoventryInTheSearch() {
        HospitalsPageView.getHospitalsPages().forEach(HospitalsPage::clickSearchButton);
        HospitalsPageView.getHospitalsPages().forEach(hospitalsPage -> assertTrue(hospitalsPage.isSearchBoxTextEntryVisible()));
        HospitalsPageView.getHospitalsPages().forEach(hospitalsPage -> hospitalsPage.enterSearchText("University Hospital (Coventry)"));

    }

    @Then("One Result is shown")
    public void oneResultIsShown() {
        HospitalsPageView.getHospitalsPages().forEach(hospitalsPage -> assertTrue(hospitalsPage.getListSize() == 1));
    }

    @And("The Result is for University Hospital Coventry")
    public void theResultIsForUniversityHospitalCoventry() {
        HospitalsPageView.getHospitalsPages().forEach(hospitalsPage -> assertEquals("University Hospital (Coventry)", hospitalsPage.getFirstResultHospitalName()));
//        HospitalsPageView.getHospitalsPages().forEach(HospitalsPage::clickClearSearch);
    }

    @Given("I enter University Hospital Co in the search")
    public void iEnterUniversityHospitalCoInTheSearch() {
        HospitalsPageView.getHospitalsPages().forEach(HospitalsPage::clickSearchButton);
        HospitalsPageView.getHospitalsPages().forEach(hospitalsPage -> assertTrue(hospitalsPage.isSearchBoxTextEntryVisible()));
        HospitalsPageView.getHospitalsPages().forEach(hospitalsPage -> hospitalsPage.enterSearchText("University Hospital (Co"));

    }

    @Given("I enter Coventry in the search")
    public void iEnterCoventryInTheSearch() {
        HospitalsPageView.getHospitalsPages().forEach(HospitalsPage::clickSearchButton);
        HospitalsPageView.getHospitalsPages().forEach(hospitalsPage -> assertTrue(hospitalsPage.isSearchBoxTextEntryVisible()));
        HospitalsPageView.getHospitalsPages().forEach(hospitalsPage -> hospitalsPage.enterSearchText("Coventry"));

    }

    @And("I see the hospitals type")
    public void iSeeTheHospitalsType() {
        HospitalsPageView.getHospitalsPages().forEach(hospitalsPage -> assertTrue(hospitalsPage.isTypeVisible()));
    }

    @Given("I enter University in the search")
    public void iEnterUniversityInTheSearch() {
        HospitalsPageView.getHospitalsPages().forEach(HospitalsPage::clickSearchButton);
        HospitalsPageView.getHospitalsPages().forEach(hospitalsPage -> assertTrue(hospitalsPage.isSearchBoxTextEntryVisible()));
        HospitalsPageView.getHospitalsPages().forEach(hospitalsPage -> hospitalsPage.enterSearchText("University"));

    }

    @Then("Multiple Results are shown")
    public void multipleResultsAreShown() {
        HospitalsPageView.getHospitalsPages().forEach(hospitalsPage -> assertTrue(hospitalsPage.getListSize() > 1));
    }

    @And("The Results are for Hospitals that match the search term")
    public void theResultsAreForHospitalsThatMatchTheSearchTerm() {
        HospitalsPageView.getHospitalsPages().forEach(hospitalsPage -> assertTrue(hospitalsPage.checkAllNamesForString("University")));

    }

    @After
    public void clearUpSearch(){
        HospitalsPageView.getHospitalsPages().forEach(HospitalsPage::clickClearSearch);
    }

    @When("I click on the first result")
    public void iClickOnTheFirstResult() {
        HospitalsPageView.getHospitalsPages().forEach(HospitalsPage::clickFirstItemInList);
    }

    @Then("I am taken to the results page")
    public void iAmTakenToTheResultsPage() {
        ResultPageView.getResultPages().forEach(resultPage -> assertTrue(resultPage.getListSize() == 9));
        ResultPageView.getResultPages().forEach(resultPage -> assertEquals("Hospitals", resultPage.getLineOfText(0)));
        ResultPageView.getResultPages().forEach(resultPage -> assertEquals("Name: University Hospital (Coventry)", resultPage.getLineOfText(1)));
        ResultPageView.getResultPages().forEach(resultPage -> assertEquals("Subtype: Hospital", resultPage.getLineOfText(2)));
        ResultPageView.getResultPages().forEach(resultPage -> assertEquals("Sector: NHS Sector", resultPage.getLineOfText(3)));
        ResultPageView.getResultPages().forEach(resultPage -> assertEquals("Address:", resultPage.getLineOfText(4)));
        ResultPageView.getResultPages().forEach(resultPage -> assertEquals("Clifford Bridge Road", resultPage.getLineOfText(5)));
        ResultPageView.getResultPages().forEach(resultPage -> assertEquals("CV2 2DX Coventry, Warwickshire", resultPage.getLineOfText(6)));
        ResultPageView.getResultPages().forEach(resultPage -> assertEquals("Website: http://www.uhcw.nhs.uk", resultPage.getLineOfText(7)));
        ResultPageView.getResultPages().forEach(resultPage -> assertEquals("Phone: 024 76964000", resultPage.getLineOfText(8)));

    }

    @And("I can return to the search page")
    public void iCanReturnToTheSearchPage() {
        ResultPageView.getResultPages().forEach(ResultPage::goBack);
    }
}
