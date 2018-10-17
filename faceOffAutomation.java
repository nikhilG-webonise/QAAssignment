import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class faceOffAutomation {
	public static String randomNameSelection()
	{
		Random nameRandom=new Random();
		String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
        String Small_chars = "abcdefghijklmnopqrstuvwxyz"; 
        String values = Capital_chars + Small_chars;
        char[] namesArray = new char[10]; 
        for (int i = 0; i < 10; i++) { 
            namesArray[i] = 
              values.charAt(nameRandom.nextInt(values.length())); 
        } 
        String names="";
        for(int j=0;j<namesArray.length;j++){
        	names=names+namesArray[j];
        }
        return names;
	}
	public static String randomPassSelection()
	{
		Random passwordRandom=new Random();
		String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
        String Small_chars = "abcdefghijklmnopqrstuvwxyz"; 
        String numb="0123456789";
        String values = Capital_chars + Small_chars+numb;
        char[] namesArray = new char[6]; 
        for (int i = 0; i < 6; i++) { 
            namesArray[i] = 
              values.charAt(passwordRandom.nextInt(values.length())); 
        } 
        String passwordName="";
        for(int j=0;j<namesArray.length;j++) {
        	passwordName=passwordName+namesArray[j];
        }
        return passwordName;
	}
	public static void main(String args[])
	{
		String email=randomNameSelection()+"@gmail.com";
		String names=randomNameSelection();
		String password=randomPassSelection();
		try{
		System.setProperty("webdriver.chrome.driver","/home/webonise/workspaces/Auto/Resource/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
        driver.get("https://web-stg.gofaceoff.com/");
        driver.findElement(By.xpath("//a[@href='/signup']")).click();
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
        driver.findElement(By.xpath("//*[@name='username']")).sendKeys(names);
        driver.findElement(By.xpath("//*[@name='password']")).sendKeys(password);
        driver.findElement(By.xpath("//*[@name='first_name']")).sendKeys(names);
        driver.findElement(By.xpath("//*[@name='last_name']")).sendKeys(names);
        driver.findElement(By.xpath("  //*[@name='dateOfBirth']")).sendKeys("12/15/1996");
        WebElement element = driver.findElement(By.xpath("//*[@name='state']"));
        Select state = new Select(element); 
        state.selectByVisibleText("TX");
        driver.findElement(By.xpath("//input[@name='referralCode']")).sendKeys("ian");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(10000);
        driver.findElement(By.xpath("//a[text()='Skip']")).click();
        driver.findElement(By.xpath("//span[@class='dropDownIcon']")).click();
        driver.findElement(By.xpath("//div/a[text()='Log Out']")).click();
		driver.quit();
		}catch(Exception e){System.out.println(e);}
	}
}