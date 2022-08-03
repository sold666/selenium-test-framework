package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import static tests.BaseSelenium.getDriver;

public abstract class BasePage {
    WebDriver driver;
    Actions actions;

    JavascriptExecutor executor;

    public BasePage() {
        this.driver = getDriver();
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
        executor = (JavascriptExecutor) driver;
    }

    void pasteTextToElementFromClipboard(WebElement webElement, String text) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Clipboard clipboard = toolkit.getSystemClipboard();
        StringSelection stringSelection = new StringSelection(text);
        clipboard.setContents(stringSelection, null);
        webElement.sendKeys(Keys.CONTROL, "v");
    }

    void clickWithJavaScript(WebElement webElement) {
        executor.executeScript("arguments[0].click()", webElement);
    }
}
