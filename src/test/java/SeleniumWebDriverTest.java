import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebDriverActionsTest {

    private WebDriverActions actions;

    @BeforeMethod
    public void setUp() {
        actions = new WebDriverActions();
    }

    @Test
    public void testButtonClickAndReadMessage() {
        // URL to open
        String url = "https://demoqa.com/buttons";
        // XPath for the button
        String buttonXPath1 = "//*[@id=\"item-4\"]"; // Replace with the actual XPath
        String buttonXPath2 = "//*[@id=\"DdfqK\"]";
        // XPath for the message element
        String messageXPath = "//*[@id=\"dynamicClickMessage\"]"; // Replace with the actual XPath

        // Perform actions
        actions.openWebPage(url);
        actions.clickButtonByXPath(buttonXPath1);
        actions.clickButtonByXPath(buttonXPath2);
        String message = actions.readMessageByXPath(messageXPath);

        // Assert or print the message (use assertions in real tests)
        System.out.println("Message: " + message);
    }

    @Test
    public void testFillAndEditForm() {
        // URL to open
        String url = "https://demoqa.com/webtables";
        // XPath for the button
        String buttonAddXPath = "//*[@id=\"addNewRecordButton\"]";
        String buttonSubmitXPath = "//*[@id=\"submit\"]";
        String buttonEditXPath = "//*[@id=\"edit-record-4\"]";
        // XPath
        String textFieldFNameXPath = "//*[@id=\"firstName\"]";
        String textFieldSNameXPath = "//*[@id=\"lastName\"]";
        String textEmailXPath = "//*[@id=\"userEmail\"]";
        String textFieldAgeXPath = "//*[@id=\"age\"]";
        String textFieldSalaryXPath = "//*[@id=\"salary\"]";
        String textFieldDepartmentXPath = "//*[@id=\"department\"]";
        String xpathNewElement = "//div[@class='rt-td' and @role='gridcell' and text()='p@email.com']\n";
        String xpathUpdatedElement = "//div[@class='rt-td' and @role='gridcell' and text()='new@email.com']\n";
        // Text to enter into the text field
        String textToEnterFName = "Alex";
        String textToEnterSName = "Pod";
        String textToEnterEmail = "Alex@email.com";
        String textToEnterAge = "1";
        String textToEnterSalary = "2";
        String textToEnterDepartment = "IT";
        String expectedEmail = "p@email.com";

        // Perform actions
        actions.openWebPage(url);
        // Create new record
        actions.clickButtonByXPath(buttonAddXPath);
        actions.enterTextByXPath(textFieldFNameXPath, textToEnterFName);
        actions.enterTextByXPath(textFieldSNameXPath, textToEnterSName);
        actions.enterTextByXPath(textEmailXPath, textToEnterEmail);
        actions.enterTextByXPath(textFieldAgeXPath, textToEnterAge);
        actions.enterTextByXPath(textFieldSalaryXPath, textToEnterSalary);
        actions.enterTextByXPath(textFieldDepartmentXPath, textToEnterDepartment);
        actions.clickButtonByXPath(buttonSubmitXPath);
        // Check that new record exist
        actions.checkEmailValue(xpathNewElement, expectedEmail);
        // Check edit new record
        actions.clickButtonByXPath(buttonEditXPath);
        actions.enterTextByXPath(textEmailXPath, "new@email.com");
        actions.clickButtonByXPath(buttonSubmitXPath);
        // Check that new record exist
        actions.checkEmailValue(xpathUpdatedElement, "new@email.com");
    }

    @AfterMethod
    public void tearDown() {
        // Close the browser after the test
        actions.closeBrowser();
    }
}
