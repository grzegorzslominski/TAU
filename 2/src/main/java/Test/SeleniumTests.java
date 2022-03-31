package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.edge.EdgeDriver;


public class SeleniumTests {


    private static final Logger logger = LogManager.getLogger(SeleniumTests.class);

    public static void main(String[] args) throws InterruptedException {



        System.setProperty("webdriver.chrome.driver", "F:\\Studia\\sem6\\TAU\\2\\chromedriver.exe");
        System.setProperty("webdriver.edge.driver", "F:\\Studia\\sem6\\TAU\\2\\msedgedriver.exe");


        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        //Scenariusz zalando (Chrome)
        logger.info("Strona główna zalando");
        driver.get("https://www.zalando.pl/");

        String title = driver.getTitle();
        logger.info(title);

        WebElement elementName2 = driver.findElement(By.name("headerbanner.help.contact"));
        logger.info(elementName2.getText());
        elementName2.click();
        logger.info("Zakładka Pomoc i kontakt");

        WebElement logisticPartners = driver.findElement(By.xpath("//*[text()='Nasi partnerzy logistyczni']"));
        logger.info(logisticPartners.getText());
        logisticPartners.click();
        logger.info("Zakładka partnerzy logistyczni");

        WebElement DPDPartner = driver.findElement(By.xpath("//*[text()='DPD']"));
        DPDPartner.click();

        logger.info("Strona partnera DPD");
        driver.quit();


        //Scenariusz wolframalpha (Edge)


        WebDriver driverEdge = new EdgeDriver();
        driverEdge.manage().window().maximize();
        driverEdge.get("https://www.wolframalpha.com/");
        logger.info("Strona główna WolframAlpha");

        WebElement loginButton = driverEdge.findElement(By.xpath("//span[contains(text(),'Sign in')]"));
        loginButton.click();
        logger.info("Przejście do strony logowania");

        WebElement emailInput = driverEdge.findElement(By.cssSelector("#email"));
        emailInput.sendKeys("test@wp.pl");
        logger.info("Wprowadzenie wartości dla pola email");

        WebElement continueButton = driverEdge.findElement(By.xpath("//button[@id='sign-in-btn']"));
        continueButton.click();

        WebElement passwordInput = driverEdge.findElement(By.xpath("//input[@id='password']"));
        passwordInput.sendKeys("haslotest");
        logger.info("Wprowadzenie wartości dla pola hasło");

        WebElement signInButton = driverEdge.findElement(By.xpath("//button[@id='sign-in-btn']"));
        signInButton.click();

        WebElement elementaryMath = driverEdge.findElement(By.xpath("//body/div[@id='__next']/div[1]/div[1]/div[1]/section[1]/section[1]/ul[1]/li[2]/a[1]"));
        elementaryMath.click();
        logger.info("Przejście do zakładki Elementary Math");

        WebElement exponentiation = driverEdge.findElement(By.xpath("//body/div[@id='__next']/div[1]/div[1]/div[1]/section[1]/div[1]/div[1]/section[1]/section[1]/div[3]/a[1]"));
        exponentiation.click();

        WebElement valueInput = driverEdge.findElement(By.xpath("//body/div[@id='__next']/div[1]/div[1]/main[1]/div[1]/div[1]/section[1]/form[1]/div[1]/div[1]/input[1]"));
        valueInput.clear();
        valueInput.sendKeys("4^10");
        logger.info("Obliczenie wyniku dla działania 4^10");
        valueInput.sendKeys(Keys.ENTER);

        WebElement result = driverEdge.findElement(By.xpath("//body/div[@id='__next']/div[1]/div[1]/main[1]/div[2]/div[1]/div[2]/section[1]/section[2]/div[1]"));

        logger.info("Wynik: " + result);

        driverEdge.quit();

    }
}
