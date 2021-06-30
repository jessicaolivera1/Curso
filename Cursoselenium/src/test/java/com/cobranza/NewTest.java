package com.cobranza;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class NewTest {
	  WebDriver driver ;
  
  @BeforeTest
  public void beforeTest() {
	  
	  
  }
  
  @Test
  public void f() {
	  
	  // agregamos la ruta donde se encuentra el driver de chrome
	  
	  System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chrome/v91chromedriver.exe");
	  //creamos el objeto de tipo driver
	  driver =new ChromeDriver();
	
	  
	 // driver.get("https://www.google.com/");
	  
	driver.get("https://www.abogados.telcel.com:4443/Abogados/login.xhtml");
	  driver.manage().window().maximize();
	  WebElement usuario= driver.findElement (By.name("j_username"));
	  
	  usuario.clear();
	  usuario.sendKeys("EX424236");
	  
	  WebElement password= driver.findElement(By.name("j_password"));
	  password.clear();
	  password.sendKeys("Jessi2qa");
	  password.submit();
	  
	  WebElement usuariosup=driver.findElement(By.id("cmbUsuarios"));
	  usuariosup.clear();
	  usuariosup.sendKeys("3839");
	  usuariosup.submit();
	  
	  WebElement menuAbogados=driver.findElement(By.id("j_id85"));
	  menuAbogados.click();
	  
	  
	  WebElement clicedo=driver.findElement(By.id("j_id90"));
	  clicedo.click();
	  WebDriverWait wait=new WebDriverWait (driver,7);
	  wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.name("form:cuenta")));
	  
	  //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  WebElement cuenta=driver.findElement(By.name("form:cuenta"));
	  cuenta.clear();
	  cuenta.sendKeys("1100900053");
	  
	  //WebDriverWait wait=new WebDriverWait (driver,7);
	  //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.name("form:j_id136")));
	
	  WebElement enviar=driver.findElement (By.name("form:j_id136"));
	  enviar.click();
  }
  
  

  @AfterTest
  public void afterTest() {
	  //driver.manage().timeouts().implicitlyWait(500000000, TimeUnit.SECONDS);
	  //driver.quit();
  }

}
