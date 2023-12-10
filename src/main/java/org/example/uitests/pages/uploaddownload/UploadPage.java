package org.example.uitests.pages.uploaddownload;

import org.example.uitests.driver.WebDriverFactory;
import org.example.uitests.driver.WebDriverHolder;
import org.example.uitests.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class UploadPage extends BasePage {

    @FindBy(id = "file-upload")
    private WebElement browseButton;
    @FindBy(id = "file-submit")
    private WebElement uploadButton;
    @FindBy(id = "uploaded-files")
    private WebElement fileUploadedMessage;

    public UploadPage() {
        super();
    }

    private void clickUploadButton() {
        uploadButton.click();
    }

    public void uploadFile(String filePath) {
        browseButton.sendKeys(filePath);
    }

    public void clickSubmitButton() {
        uploadButton.click();
    }

    public String getUploadedMessageText() {
        return fileUploadedMessage.getText().trim();
    }
}
