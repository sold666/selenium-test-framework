package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "//div[@class=\"yuRUbf\"]//h3")
    private WebElement resultRow;
    @FindBy(xpath = "//div[@class=\"yuRUbf\"]//h3")
    private List<WebElement> resultRows;

    public SearchResultsPage() {
        super();
    }

    public void assertThatTopResultContainsCorrectText(String expected) {
        assertThat(resultRows.stream().map(WebElement::getText).collect(Collectors.toList()).toString()).as("Wrong text has been displayed!").contains(expected);
    }

    public void assertThatTopResultIsDisplayed() {
        assertThat(resultRow.isDisplayed()).as("Element has not been displayed!").isTrue();
    }
}
