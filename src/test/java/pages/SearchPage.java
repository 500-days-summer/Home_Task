package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class SearchPage {
    public SearchPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(name = "q")
    public WebElement searchInputBox;

    @FindBy(name = "btnK")
    public WebElement searchButton;


    @FindBy(xpath = "//ul[@role='listbox']//li/descendant::div[@class='wM6W7d']//span")
    public List<WebElement> automatedSuggestions;



    public void inputTextInSearchBox(String input){
        searchInputBox.sendKeys(input);
    }
    public void pressENTER(String input){
        searchInputBox.sendKeys(input+  Keys.ENTER);
    }

    public void clickOnSearchButton(){
        searchButton.click();
    }

    public void clickOnAutomatedResult(String searchCriteria, List<WebElement> automatedSuggestions) throws InterruptedException {
        for(int i =0; i< automatedSuggestions.size(); i++){
            if(automatedSuggestions.get(i).getText().equals(searchCriteria)){
                automatedSuggestions.get(i).click();
                break;
            }
        }
    }

}
