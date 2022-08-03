package tests;

import org.testng.annotations.Test;

public class SeleniumTest extends BaseSelenium {

    @Test(dataProvider = "dataProvider")
    public void openGoogleInChromeTest(String text) {
        searchSteps.executeByKeyWord(text)
                .verifyThatTopResultIsDisplayed()
                .verifyThatTopResultContainsCorrectText("ИКНТ");
    }

    @Test
    public void verifySearchButtonVoiceTooltipOnGoogle() {
        searchSteps.openTooltip()
                .verifyThatTooltipContainsCorrectText("Голосовой поиск")
                .clickToVoice();
    }
}
