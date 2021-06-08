package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.ResultsPage;
import pages.SearchPage;
import utilities.Driver;

public class SearchSteps {
    WebDriver driver = Driver.getDriver();
    SearchPage searchPage = new SearchPage();
    ResultsPage resultsPage = new ResultsPage();

    @Given("^the user navigated to Google search page$")
    public void the_user_navigated_to_Google_search_page()  {
        driver.navigate().to("https://www.google.com/");
    }

    @When("^the user inputs \"([^\"]*)\" in the search box$")
    public void the_user_inputs_in_the_search_box(String searchCriteria)  {
        searchPage.inputTextInSearchBox(searchCriteria);
    }

    @When("^the user clicks on Google Search button$")
    public void the_user_clicks_on_Google_Search_button()  {
        searchPage.clickOnSearchButton();
    }

    @Then("^the user should see \"([^\"]*)\" on the title page$")
    public void the_user_should_see_on_the_title_page(String searchCriteria)  {
        Assert.assertTrue(driver.getTitle().toLowerCase().contains(searchCriteria));
    }

    @Then("^every search result should be relevant and should contain the word \"([^\"]*)\"$")
    public void every_search_result_should_be_relevant_and_should_contain_the_work(String searchCriteria)  {
        for(WebElement searchResult: resultsPage.searchResultsInBold){
            Assert.assertTrue("Search result is irrelevant",
                    searchResult.getText().toLowerCase().contains(searchCriteria));
        }
    }


    @When("^the user inputs \"([^\"]*)\" in the search box and the user presses ENTER on the keyboard$")
    public void the_user_inputs_in_the_search_box_and_the_user_presses_ENTER_on_the_keyboard(String searchCriteria)  {
        searchPage.pressENTER(searchCriteria);

    }

    @When("^the user picks \"([^\"]*)\" from the suggested search results$")
    public void the_user_picks_from_the_suggested_search_results(String searchCriteria) throws InterruptedException {
        searchPage.clickOnAutomatedResult(searchCriteria, searchPage.automatedSuggestions);
    }


    @And("^the search input box should display the searched word \"([^\"]*)\"$")
    public void theSearchInputBoxShouldDisplayTheSearchedWord(String searchCriteria)  {
        Assert.assertEquals("Search box doesn't contains " + searchCriteria,
                resultsPage.searchBox.getAttribute("value").trim(),searchCriteria);
    }

    @Then("^verify \"([^\"]*)\" \"([^\"]*)\" is displayed$")
    public void verifyIsDisplayed(String showingResults, String searchCriteria)  {
        Assert.assertTrue(showingResults +" for " + searchCriteria + " is not displayed",
                resultsPage.showingResultsFor.isDisplayed());
        Assert.assertTrue("Did you mean "+ searchCriteria + " is not guessing "+ searchCriteria,
                resultsPage.didYouMean.getText().equals(searchCriteria));
    }
}
