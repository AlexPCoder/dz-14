import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverActions {

    private WebDriver driver;

    // Constructor to initialize the WebDriver
    public WebDriverActions() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        this.driver = new ChromeDriver();
    }

    // Method to open a webpage
    public void openWebPage(String url) {
        driver.get(url);
    }

    // Method to find a button using XPath and click on it
    public void clickButtonByXPath(String buttonXPath) {
        WebElement button = driver.findElement(By.xpath(buttonXPath));
        button.click();
    }

    // Method to read the text of an element using XPath
    public String readMessageByXPath(String messageXPath) {
        WebElement messageElement = driver.findElement(By.xpath(messageXPath));
        return messageElement.getText();
    }

    public void enterTextByXPath(String textFieldXPath, String text) {
        WebElement textField = driver.findElement(By.xpath(textFieldXPath));
        textField.clear(); // Clears any existing text in the field
        textField.sendKeys(text); // Enters the new text
    }

    // Method to check if the email value in the element matches the expected value
    public boolean checkEmailValue(String xpathNewElement, String expectedEmail) {
        WebElement emailElement = driver.findElement(By.xpath(xpath));
        String actualEmail = emailElement.getText();
        return actualEmail.equals(expectedEmail);
    }

    // Method to close the browser
    public void closeBrowser() {
        driver.quit();
    }

    // Main method to demonstrate the use of the methods
    public static void main(String[] args) {
        WebDriverActions actions = new WebDriverActions();

        // Example usage
        String url = "http://example.com";
        String buttonXPath = "//*[@id='button-id']"; // Replace with the actual XPath
        String messageXPath = "//*[@id='message-id']"; // Replace with the actual XPath

        actions.openWebPage(url);
        actions.clickButtonByXPath(buttonXPath);
        String message = actions.readMessageByXPath(messageXPath);
        System.out.println("Message: " + message);
        actions.closeBrowser();
    }
}
