package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;



    public class GoogleSearchfeature {

        WebDriver driver = null;
        @Given("browser is opened")
        public void browser_is_opened() {
            // Write code here that turns the phrase above into concrete actions
            String projectPath= System.getProperty("user.dir");
            System.out.println("Project path is:" +projectPath);
            System.out.println("Inside Step - browser is open");
            System.setProperty("webdriver.chrome.driver",projectPath+"/src/test/resources/drivers/chromedriver.exe");
            driver = new ChromeDriver();

            driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        }
        @And("user is on google search page")
        public void user_is_on_google_search_page() {
            // Write code here that turns the phrase above into concrete actions
            System.out.println("Inside Step - user is on google search page");
            driver.manage().window().maximize();
            driver.navigate().to("https://google.com");
        }

        @When("user enters word computer in search box")
        public void user_enters_word_computer_in_search_box() throws InterruptedException {
            // Write code here that turns the phrase above into concrete actions
            System.out.println("Inside Step - user enter a text in search box");
            driver.findElement(By.name("q")).sendKeys("computer");

            Thread.sleep(2000);
        }

        @When("user press enter")
        public void hits_enter() throws InterruptedException {
            // Write code here that turns the phrase above into concrete actions
            System.out.println("Inside Step - user hits enter");
            driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
            Thread.sleep(4000);
        }

        @Then("user should see the header of the search")
        public void user_should_see_the_header_of_the_search() {
            // Write code here that turns the phrase above into concrete actions
            System.out.println("Inside Step - user is navigated to search results");

            driver.getPageSource().contains("computer");
            driver.close();
            driver.quit();
        }
    }


