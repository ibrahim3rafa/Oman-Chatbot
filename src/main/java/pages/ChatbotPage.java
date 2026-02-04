package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ChatbotPage {

    private WebDriver driver;
    private WebDriverWait wait;


    private By inputField = By.id("chat-input");
    private By sendButton = By.id("send-btn");
    private By lastBotMessage = By.xpath("(//div[@class='message-bubble'])[last()]");

    public ChatbotPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void sendQuestion(String question) {

        WebElement input = wait.until(
                ExpectedConditions.visibilityOfElementLocated(inputField));
        input.clear();
        input.sendKeys(question);

        driver.findElement(sendButton).click();
    }

    public String getBotAnswer() {

        WebElement answer = wait.until(
                ExpectedConditions.visibilityOfElementLocated(lastBotMessage));

        return answer.getText();
    }
}
