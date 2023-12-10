package uitests.zakharchenkohw15;

import org.apache.commons.io.FileUtils;
import org.example.uitests.driver.WebDriverHolder;
import org.example.uitests.pages.download.DownloadDemoPage;
import org.example.uitests.pages.uploaddownload.UploadPage;
import org.example.uitests.utils.MyFilesUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import uitests.BaseTests;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.example.uitests.TestConstant.PATH_DOWNLOADS_FOLDER;

public class ZakharchenkoHW15 extends BaseTests {
    @Test
    public void uploadTestPO() throws IOException {
        File file = MyFilesUtils.generateLoremFile();
        goToPart("upload");
        UploadPage uploadPage = new UploadPage();
        uploadPage.uploadFile(file.getAbsolutePath());
        uploadPage.clickSubmitButton();
        Assert.assertEquals(uploadPage.getUploadedMessageText(), file.getName());
        goToPart("download");
        By uploadedFileLocator = By.linkText(file.getName());
        Assert.assertTrue(WebDriverHolder.getInstance().getDriver().findElement(uploadedFileLocator).isDisplayed());
    }

    @Test
    public void downloadTestPO() throws IOException, InterruptedException {
        String downloadDemoUrl = "https://demo.seleniumeasy.com/generate-file-to-download-demo.html";
        String originFilePath = "C:\\Users\\Sergery\\Desktop\\Hillel-git-projects\\SZA_Factory\\files\\rxMtkhpQuH.txt";
        goToUrl(downloadDemoUrl);
        DownloadDemoPage downloadDemoPage = new DownloadDemoPage();
        downloadDemoPage.enterValueToDownloadPage(FileUtils.readFileToString(new File(originFilePath)))
                .clickOnGenerateFileButton()
                .clickOnDownloadButton();
        File file1 = MyFilesUtils.waitTillFileIsLoaded(new File(PATH_DOWNLOADS_FOLDER, "easyinfo.txt"));
        Assert.assertEquals(-1, Files.mismatch(Path.of(originFilePath), Path.of(file1.getAbsolutePath())));
        file1.deleteOnExit();
    }
}
