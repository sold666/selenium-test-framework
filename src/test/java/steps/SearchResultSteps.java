package steps;

import pages.SearchResultsPage;

public class SearchResultSteps {
    private final SearchResultsPage searchResultsPage = new SearchResultsPage();

    public SearchResultSteps verifyThatTopResultIsDisplayed() {
        searchResultsPage.assertThatTopResultIsDisplayed();
        return this;
    }

    public SearchResultSteps verifyThatTopResultContainsCorrectText(String text) {
        searchResultsPage.assertThatTopResultContainsCorrectText(text);
        return this;
    }
}
