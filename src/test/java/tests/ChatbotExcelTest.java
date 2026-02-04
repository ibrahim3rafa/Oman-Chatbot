package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.ChatbotPage;
import utils.ExcelUtil;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class ChatbotExcelTest {

    private WebDriver driver;
    private WebDriverWait wait;
    private ChatbotPage chatbot;
    private ExcelUtil excel;
    private By chatButton = By.id("chatbot-button");
    private By disclaimerAcceptButton = By.id("disclaimer-accept");

    @BeforeClass
    public void setup() throws Exception {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://conf-tions-suzuki-reactions.trycloudflare.com/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(chatButton));
        driver.findElement(chatButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(disclaimerAcceptButton));
        driver.findElement(disclaimerAcceptButton).click();

        chatbot = new ChatbotPage(driver);
        excel = new ExcelUtil("chatbot_data.xlsx");
    }

    @Test
    public void chatbotExcelDataDrivenTest() throws Exception {

        for (int i = 1; i <= excel.getRowCount(); i++) {

            String question = excel.getQuestion(i);
            chatbot.sendQuestion(question);
            Thread.sleep(10000); // Wait for the bot to respond
            String answer = chatbot.getBotAnswer();
            excel.writeAnswer(i, answer);
        }
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
//        Thread.sleep(5000); // Just to visually confirm the last answer is written before closing
        driver.quit();
    }
}
