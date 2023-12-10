package uitests.zakharchenkohw14;

import org.apache.commons.io.FileUtils;
import org.example.uitests.utils.ConfigProvider;
import org.example.uitests.utils.MyFilesUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import uitests.BaseTestClassUseProperties;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.example.uitests.TestConstant.PATH_DOWNLOADS_FOLDER;

public class ZakharchenkoHW14 extends BaseTestClassUseProperties {
    @Test
    public void downloadTest() throws IOException, InterruptedException {
        String originFilePath = "C:\\Users\\Sergery\\Desktop\\Hillel-git-projects\\Zakharchenko_Test_Project\\files\\rxMtkhpQuH.txt";
        driver.get(ConfigProvider.getInstance().getProperty("base.url"));
        WebElement inputField = driver.findElement(By.id("textbox"));
        inputField.click();
        inputField.sendKeys(FileUtils.readFileToString(new File(originFilePath)));
        driver.findElement(By.id("create")).click();
        driver.findElement(By.id("link-to-download")).click();
        File file1 = MyFilesUtils.waitTillFileIsLoaded(new File(PATH_DOWNLOADS_FOLDER, "easyinfo.txt"));
        Assert.assertEquals(-1, Files.mismatch(Path.of(originFilePath), Path.of(file1.getAbsolutePath())));
        file1.deleteOnExit();
    }
}
