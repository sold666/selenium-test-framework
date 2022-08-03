package steps;

import pages.SearchPage;

public class SearchSteps {

    private final SearchPage searchPage = new SearchPage();

    public SearchResultSteps executeByKeyWord(String key) {
        searchPage.pasteToSearchField(key);
        searchPage.pressEnter();
        return new SearchResultSteps();
    }

    public SearchSteps openTooltip() {
        searchPage.moveToVoiceButton();
        return this;
    }

    public SearchSteps clickToVoice() {
        searchPage.clickToVoiceButton();
        return this;
    }

    public SearchSteps verifyThatTooltipContainsCorrectText(String text) {
        searchPage.assertVoiceButtonContainsCorrectToolTip(text);
        return this;
    }
}
