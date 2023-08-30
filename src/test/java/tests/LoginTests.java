package tests;

import utils.TestHelpers;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;
//Erro webdrivermanager
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LoginTests {

    private static WebDriver driver;

    private TestHelpers testHelpers;

    public LoginTests() {
    }

    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }

    @BeforeEach
    public void beforeEachTest(){
        testHelpers = new TestHelpers();
        testHelpers.setarURLeWindow(driver);
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }

    @Test
    @Order(1)
    @DisplayName("Teste de login com informações válidas")
    public void testLoginCaminhoFeliz() throws InterruptedException {
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).sendKeys("qualityforce@trademaster.com.br");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys("anTRADE@1234#");
        // driver.findElement(By.cssSelector("button")).click();
        // driver.findElement(By.xpath("//button[span[contains(text(),'Entrar')]]")).click();
        driver.findElement(By.xpath("//button[span[contains(.,'Entrar')]]")).click();
    }

    @Test
    @Order(2)
    @DisplayName("Teste de login sem informar um nome de login")
    public void testLoginSemInformarUmEmail() {
        driver.findElement(By.id("email")).click();
        driver.findElement(By.cssSelector("button")).click();
        assertEquals(driver.findElement(By.cssSelector("#root > main > div.sc-cQdYHF.crNFeT > div > div.sc-fMSvki.ghyuns > div > form > div:nth-child(1) > small.sc-bBXxYQ.eCqMwL")).getText(), "Campo obrigatório");
    }

    @Test
    @Order(3)
    @DisplayName("Teste de login sem informar uma senha mas informando um login")
    public void testLoginComEmailMasSemSenha() {
        driver.findElement(By.id("password")).click();
        driver.findElement(By.cssSelector("button")).click();
        assertEquals(driver.findElement(By.cssSelector("#root > main > div.sc-cQdYHF.crNFeT > div > div.sc-fMSvki.ghyuns > div > form > div:nth-child(2) > small.sc-bBXxYQ.eCqMwL")).getText(), "Campo obrigatório");
    }

    @Test
    @Order(4)
    @DisplayName("Teste de login com credenciais inválidas")
    public void testLoginCredenciaisInvalidas() throws InterruptedException {
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).sendKeys("erroqualityforce@trademaster.com.br");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys("erroanTRADE@1234#");
        driver.findElement(By.cssSelector(".bwragY")).click();
        Thread.sleep(2000);
        assertEquals(driver.findElement(By.cssSelector(".sc-hKMtZM > span")).getText(), "Credenciais Inválidas");
    }

    @Test
    @Order(5)
    @DisplayName("Teste de login sem informar um nome de login2")
    public void testLoginSemInformarUmEmail2() {
        driver.findElement(By.id("email")).click();
        driver.findElement(By.cssSelector("button")).click();
        assertEquals(driver.findElement(By.cssSelector("#root > main > div.sc-cQdYHF.crNFeT > div > div.sc-fMSvki.ghyuns > div > form > div:nth-child(1) > small.sc-bBXxYQ.eCqMwL")).getText(), "Campo obrigatório");
    }
}