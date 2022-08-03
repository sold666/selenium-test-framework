package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchPage extends BasePage {

    @FindBy(name = "q")
    private WebElement searchField;

    @FindBy(xpath = "//body")
    private WebElement pageBody;

    @FindBy(css = "div.XDyW0e")
    private WebElement searchByVoiceButton;

    public SearchPage() {
        super();
    }

    public void pasteToSearchField(String text) {
        pasteTextToElementFromClipboard(searchField, text);
    }

    public void pressEnter() {
        searchField.sendKeys(Keys.RETURN);
    }

    public void moveToVoiceButton() {
        actions.moveToElement(searchByVoiceButton).build().perform();
    }

    public void clickToVoiceButton() {
        clickWithJavaScript(searchByVoiceButton);
    }

    public void assertVoiceButtonContainsCorrectToolTip(String text) {
        assertThat(pageBody.findElements(By.xpath("//*[contains(text(), '" + text + "')]")).size())
                .as("Expected tooltip [" + text + "] was not found").isNotZero();
    }
}
