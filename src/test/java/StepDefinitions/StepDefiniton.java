package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;ff
public class StepDefiniton {
	
	@Given("Open chrome with given URL")
	public void open_chrome_with_given_url() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		try {
		
        WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.name("username")).sendKeys("Admin");
		 ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("reports.html");
		    
	        // create ExtentReports and attach reporter(s)
	        ExtentReports extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);

	        // creates a toggle for the given test, adds all log events under it    
	        ExtentTest test = extent.createTest("MyFirstTest", "Sample description");

	        // log(Status, details)
	        test.log(Status.INFO, "This step shows usage of log(status, details)");
			Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		test.log(Status.INFO, "This step shows usage of log(status, details)");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class=\"oxd-main-menu-item active\"]")).click();
		Thread.sleep(2000);
		
		test.log(Status.INFO, "This step shows usage of log(status, details)");
//		driver.findElement(By.xpath("//button[normalize-space()='Add']")).click();
		Thread.sleep(2000);
		
		
		
		extent.flush();
		driver.quit();
		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}

	@Given("Enter Credentials and perform login")
	public void enter_credentials_and_perform_login() {
	    // Write code here that turns the phrase above into concrete actions
		
		System.out.println("in Given");
		
		
	}

	@When("Validating login by screenshot")
	public void validating_login_by_screenshot() {
	    // Write code here that turns the phrase above into concrete actions
	}



}
