package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class ResultsPage {

    public ResultsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//div[@class='IsZvec']//div//span//em")
    public List<WebElement> searchResultsInBold;

    @FindBy(name = "q")
    public WebElement searchBox;

    @FindBy(xpath = "//span[@class='gL9Hy']")
    public WebElement showingResultsFor;

    @FindBy(id =  "fprsl")
    public WebElement didYouMean;


}
