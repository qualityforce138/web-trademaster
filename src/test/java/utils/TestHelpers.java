package utils;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

public class TestHelpers {
    private static WebDriver driver;

    public void setarURLeWindow(WebDriver driver){
        driver.get("https://portal.hml.trademaster.com.br/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

    }
}