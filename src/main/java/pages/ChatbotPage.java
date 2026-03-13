package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ChatbotPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private WebElement shadowHost;
    private SearchContext shadowRoot;


    private By inputField = By.id("chat-input");
    private By sendButton = By.id("send-btn");
    private By lastBotMessage = By.xpath("(//div[@class='message-bubble'])[last()]");

    public ChatbotPage(WebDriver driver, WebDriverWait wait, WebElement shadowHost, SearchContext shadowRoot) {
        this.driver = driver;
        this.wait = wait;
        this.shadowHost = shadowHost;
        this.shadowRoot = shadowRoot;

    }

    public void sendQuestion(String question) {

        WebElement chatInput = wait.until(d -> shadowRoot.findElement(By.cssSelector("#chat-input")));
        chatInput.clear();
        chatInput.sendKeys(question);
        WebElement sendBtn = shadowRoot.findElement(By.cssSelector("#send-btn"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", sendBtn);
    }

    public String getBotAnswer() throws InterruptedException {
        wait.until(d -> shadowRoot.findElement(By.cssSelector("#chat-input")).getAttribute("placeholder").equals("اكتب رسالتك هنا..."));
        List<WebElement> answers = wait.until(d -> shadowRoot.findElements(By.cssSelector("#message-bubble")));
        //get last message which is the answer
        WebElement answer = answers.getLast();
        return answer.getText();
    }
}
