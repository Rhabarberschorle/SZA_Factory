package org.example.uitests.pages.download;

import org.example.uitests.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DownloadDemoPage extends BasePage {

    @FindBy(id = "textbox")
    private WebElement inputField;

    @FindBy(id = "create")
    private WebElement generateFileButton;

    @FindBy(id  = "link-to-download")
    private WebElement downloadButton;

    public DownloadDemoPage() {
        super();
    }

    public DownloadDemoPage enterValueToDownloadPage(String value) {
        inputField.click();
        inputField.sendKeys(value);
        return this;
    }

    public DownloadDemoPage clickOnGenerateFileButton() {
        generateFileButton.click();
        return this;
    }

    public void clickOnDownloadButton() {
        downloadButton.click();
    }
}
