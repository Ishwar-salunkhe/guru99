package SelPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Guru99 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver= new ChromeDriver();
        driver.get("https://demo.guru99.com/telecom/index.html");
        driver.manage().window().maximize();

        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement pageText=driver.findElement(By.xpath("//a[text()='Guru99 telecom']"));
        WebElement addCustomerLink=driver.findElement(By.xpath("//section[@id='one']//descendant::h3//a[text()='Add Customer']"));
        WebElement doneRadioBtn=driver.findElement(By.xpath("//label[@for='done']"));
        WebElement firstName=driver.findElement(By.xpath("//input[@id='fname']"));
        WebElement lastName=driver.findElement(By.xpath("//input[@id='lname']"));
        WebElement emailInputBox=driver.findElement(By.xpath("//input[@id='email']"));
        WebElement addressTextBox=driver.findElement(By.xpath("//textarea[@placeholder='Enter your address']"));
        WebElement mobileNumber=driver.findElement(By.xpath("//input[@id='telephoneno']"));
        WebElement submitBtn=driver.findElement(By.xpath("//input[@name='submit']"));
        WebElement customerIDmessage=driver.findElement(By.xpath("//b[text()='Please Note Down Your CustomerID']"));


        //Validating Home page Title
        String pageTextTitle=pageText.getText();
        if(pageTextTitle.contains("Guru99"))
        {
            System.out.println("User is on the correct page "+pageTextTitle);
        }

        addCustomerLink.click();
        wait.until(ExpectedConditions.visibilityOf(firstName));
        doneRadioBtn.click();
        firstName.sendKeys("John");
        lastName.sendKeys("Cena");
        emailInputBox.sendKeys("johncena@gmail.com");
        addressTextBox.sendKeys("Pune, India");
        mobileNumber.sendKeys("1112223333");
        submitBtn.click();

        //validating Add customer succesfull message
        if(customerIDmessage.isDisplayed())
        {
            System.out.println("Customer added successfully with message "+customerIDmessage);
        }

    }
}

