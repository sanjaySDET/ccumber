package stepDefinitions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LofinToAppTest {
	public WebDriver driver;
    public String organisationName;
	
//	@Given("launch the browser")
//	public void launch_the_browser() {
//		 driver=new ChromeDriver(); 
//		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//	}
//	@When("enter the url")
//	public void enter_the_url() {
//		 driver.get("http://localhost:8888/");
//	}
//	@Then("Login page should be displayed")
//	public void login_page_should_be_displayed() {
//	    System.out.println("Login page is displaying");
//	}
	
	//@Before
	//@After
	//BeforeStep
	//AfterStep
	
	//Hooks:- Whenever the preconditions and postconditions are different for each scenarios u r going use hooks concepts
//	@Before("@smokeTest")
//	public void launchBrowser()
//	{
//		driver=new ChromeDriver(); 
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//	}
//	@After("@smokeTest")
//	public void closeBrowser()
//	{
//		driver.quit();
//	}
//	
//	@Before("@regTest")
//	public void launchFireFoxBrowser()
//	{
//		driver=new FirefoxDriver(); 
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//	}
//	@After("@regTest")
//	public void quitBrowser()
//	{
//		driver.quit();
//	}
	
	
	
	
	@Given("I will launch the browser")
	public void i_will_launch_the_browser() {
	   driver=new ChromeDriver(); 
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Given("I will enter the url")
	public void i_will_enter_the_url() {
	    driver.get("http://localhost:8888/");
	}
	
	@When("Login page is displayed I will enter invalid {string} and valid password {string}")
	public void login_page_is_displayed_i_will_enter_invalid_and_valid_password(String username, String password) {
		System.out.println(username);
		System.out.println(password);
		driver.findElement(By.name("user_name")).sendKeys(username);
	    driver.findElement(By.name("user_password")).sendKeys(password);
	}
	@When("I will click on login button")
	public void i_will_click_on_login_button() {
	    driver.findElement(By.id("submitButton")).click();
	}
	@Then("I will validate the error message")
	public void i_will_validate_the_error_message() {
	    String toastMsg = driver.findElement(By.xpath("//div[@class='errorMessage']")).getText();
	    System.out.println(toastMsg);
	    Assert.assertEquals(toastMsg, "You must specify a valid username and password.");
		}
	
	@When("Login page is displayed I will enter valid {string} and valid password {string}")
	public void login_page_is_displayed_i_will_enter_valid_and_valid_password(String username, String password) {
		System.out.println(username);
		System.out.println(password);
		driver.findElement(By.name("user_name")).sendKeys(username);
	    driver.findElement(By.name("user_password")).sendKeys(password);
	}
	
	@Then("check whether home page is displaying or not")
	public void check_whether_home_page_is_displaying_or_not() {
	   String url = driver.getCurrentUrl();
	   if(url.contains("Home"))
	   {
		   System.out.println("HomePage is displaying");
	   }else {
		   System.out.println("HomePage is not diaplaying");
	   }
	}
	
	@When("^enter the username (.+) and enter the password (.+)$")
	public void enter_the_username_manager_and_enter_the_password_admin(String username,String password) 
	{
		System.out.println(username);
		System.out.println(password);
		driver.findElement(By.name("user_name")).sendKeys(username);
	    driver.findElement(By.name("user_password")).sendKeys(password);
	}
	
	@When("Login page is displaying enter username, enter password,click on orgs link, click on create org lookup img,enter the orgName,click on saveBtn")
	public void login_page_is_displaying_enter_username_enter_password_click_on_orgs_link_click_on_create_org_lookup_img_enter_the_org_name_click_on_save_btn(io.cucumber.datatable.DataTable dataTable) {
	  List<List<String>> data = dataTable.asLists();
	  String username = data.get(0).get(0);
	  String password = data.get(0).get(1);
	  String organisationName = data.get(0).get(2);
	  
	  driver.findElement(By.name("user_name")).sendKeys(username);
	  driver.findElement(By.name("user_password")).sendKeys(password);
	  driver.findElement(By.id("submitButton")).click();
	  driver.findElement(By.xpath("//a[.='Organizations']")).click();
	  driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
	  driver.findElement(By.name("accountname")).sendKeys(organisationName);
	  driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	}
	
	
	@Then("Verify org is created or not")
	public void verify_org_is_created_or_not() {
//		String orgname = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
//		  if(orgname.contains(organisationName))
//		{
//			System.out.println("Organisation is created");  
//		}else {
//			System.out.println("Organisation is not created");
//		}
	}
}
