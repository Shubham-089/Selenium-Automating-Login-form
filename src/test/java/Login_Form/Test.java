package Login_Form;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Test {
	
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		// 1. go to the orangeHRM Website 
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		Thread.sleep(4000);
		
		//2. Enter Username
		//finding the element 
		
		driver.findElement(By.cssSelector("[name=\"username\"]")).sendKeys("Admin");
		
		//3. Enter Password
		
	    driver.findElement(By.xpath("//input[@placeholder=\'Password\']")).sendKeys("admin123");
	    
		// 4. Click on login button 
	    
		driver.findElement(By.xpath("//button[@type = 'submit']")).click();
		
		//5. Validate successful login
		
		Thread.sleep(2000);
		
	    boolean logoisDisplayed =	driver.findElement(By.xpath("//img[@alt='client brand banner']")).isDisplayed();
	    
	    
	    
	    if(!logoisDisplayed) {
	    	System.out.println("Login Unsuccessful");
	    }else {
	    	System.out.println("Login Successful");
	    }
	    
		// 6.logout orangeHrm Website
	    
	    driver.findElement(By.cssSelector("[class=\"oxd-userdropdown-name\"]")).click();
	    
	    Thread.sleep(2000);
	    
	    driver.findElement(By.xpath("(//a[@role=\"menuitem\"])[4]")).click();
	    
	    
	    // 7. validate login
	    
	    String url = driver.getCurrentUrl();
	    
	    if(url.contains("login")) {
	    	
	    	System.out.println("Logout successful");
	    }else {
	    	System.out.println("Logout Unsuccessful");
	    }
	    
	    // Closing the Browser
	    
	    driver.close();
	    
	}
}
