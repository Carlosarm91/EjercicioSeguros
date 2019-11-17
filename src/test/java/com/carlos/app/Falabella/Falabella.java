package com.carlos.app.Falabella;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;


public class Falabella {
	String nombrepagina2="";
	String url = "https://cotizador.123seguro.com.co/step1/google-search?gclid=EAIaIQobChMIs93-9f_v5QIVR4VaBR1WOgQzEAMYASAAEgIEAvD_BwE";
	WebDriver driver;
	int opcion_1ToInteger = 0,opcion_2ToInteger = 0,opcion_3ToInteger = 0,opcion_4ToInteger = 0,opcion_5ToInteger = 0,opcion_6ToInteger = 0,opcion_7ToInteger = 0;
	int menor=0,a=0;
	int array []= new int [7];
	private static String hoja;
	private static XSSFWorkbook worbook;
	String Excel[];
		@Before
		public void main () {
			int a=0;
			Excel = new String[18];
			String nombreArchivo = "Data.xlsx";
			String rutaArchivo = "C:\\Users\\sarmi\\Documents\\Carlos Sarmiento\\TATA\\Falabella\\" + nombreArchivo;
			hoja = "Sheet1";
	 		try (FileInputStream file = new FileInputStream(new File(rutaArchivo))) {
	 			worbook = new XSSFWorkbook(file);
				XSSFSheet sheet = worbook.getSheetAt(0);
				Iterator<Row> rowIterator = sheet.iterator();
	 			Row fila;
				fila = rowIterator.next();
				Iterator<Cell> cellIterator = fila.cellIterator();
					Cell celda;
					while (cellIterator.hasNext()) {
						celda = cellIterator.next();
						Excel[a]=celda.toString();
						a++;
					}
			} catch (Exception e) {	}
		}

	@Test
	public void Automatizar () throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		driver = new ChromeDriver( options );
		driver.get(url);
		WebElement Tipo_Carro = driver.findElement(By.xpath("//ul[@class='col d-flex flex-row tiposCarro']//li[1]"));
		Tipo_Carro.click();
		WebElement Marca_Auto = driver.findElement(By.xpath("//input[@placeholder='escribela aquí...']"));
		Marca_Auto.sendKeys(Excel[0]);
		Thread.sleep(100);
		Marca_Auto.sendKeys(Excel[1]);
		Thread.sleep(100);
		Marca_Auto.sendKeys(Excel[2]);
		Thread.sleep(100);
		Marca_Auto.sendKeys(Excel[3]);
		Thread.sleep(1000);
		WebElement Click_1 = driver.findElement(By.xpath("//a[contains(text(),'CHEVROLET')]"));
		Click_1.click();
		Thread.sleep(1000);
		WebElement year = driver.findElement(By.xpath("//a[contains(text(),'2017')]"));
		year.click();
		WebElement ref = driver.findElement(By.xpath("//input[@placeholder='escribela aquí...']"));
		ref.sendKeys(Excel[4]);	
		Thread.sleep(100);
		ref.sendKeys(Excel[5]);
		Thread.sleep(100);
		ref.sendKeys(Excel[6]);
		Thread.sleep(1000);
		WebElement ref_2 = driver.findElement(By.xpath("//a[@data-id='236']"));
		ref_2.click();
		Thread.sleep(1000);
		WebElement placa = driver.findElement(By.xpath("//input[@data-rel='placa']"));
		placa.sendKeys(Excel[7]);	
		Thread.sleep(1000);
		WebElement depart = driver.findElement(By.xpath("//input[@data-rel='departamento']"));
		depart.sendKeys(Excel[8]);	
		Thread.sleep(100);
		depart.sendKeys(Excel[9]);
		Thread.sleep(100);
		depart.sendKeys(Excel[10]);
		Thread.sleep(1000);
		WebElement Click_2 = driver.findElement(By.xpath("//a[@data-id='32']"));
		Click_2.click();
		Thread.sleep(1000);
		WebElement City = driver.findElement(By.xpath("//input[@placeholder='escribelo aquí...']"));
		City.sendKeys(Excel[8]);	
		Thread.sleep(100);
		City.sendKeys(Excel[9]);
		Thread.sleep(100);
		City.sendKeys(Excel[10]);
		Thread.sleep(1000);
		WebElement Click_3 = driver.findElement(By.xpath("//a[@data-id='586']"));
		Click_3.click();
		Thread.sleep(1000);
		WebElement Name = driver.findElement(By.xpath("//input[@id='nombre-form']"));
		Name.sendKeys(Excel[11]);
		WebElement Lastname = driver.findElement(By.xpath("//input[@id='apellido1-form']"));
		Lastname.sendKeys(Excel[12]);
		WebElement Lastname2 = driver.findElement(By.xpath("//input[@id='apellido2-form']"));
		Lastname2.sendKeys(Excel[13]);
		WebElement document = driver.findElement(By.xpath("//input[@id='doc-form']"));
		document.sendKeys(Excel[14]);
		WebElement age = driver.findElement(By.xpath("//input[@id='edad-form']"));
		age.sendKeys(Excel[15]);
		WebElement email = driver.findElement(By.xpath("//input[@id='email-form']"));
		email.sendKeys(Excel[16]);
		WebElement phone = driver.findElement(By.xpath("//input[@id='telefono']"));
		phone.sendKeys(Excel[17]);
		Thread.sleep(1000);
		WebElement quote = driver.findElement(By.xpath("//a[@id='verCotizaciones']"));
		quote.click();
		Thread.sleep(1500);
		WebDriverWait wait = new WebDriverWait(driver,100);
		
		Boolean explicit;
		explicit= wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='table']/tbody/tr[1]/td[1]/span/i")));
		if (explicit==true) {
			System.out.print("Primera Opcion: $");
			WebDriverWait wait_2 = new WebDriverWait(driver,5);
			boolean basic_1 = driver.findElement(By.xpath("//div[@id='cotizaciones']//tr[1]//td[1]//span[1]")).isDisplayed();
			if (basic_1==false) {
				String opcion_1 = driver.findElement(By.xpath("//body[@id='app']/div[@id='cotizaciones']/div[@class='page']/div[@class='container']/div[@class='sixteen columns']/table[@id='table']/tbody/tr[1]/td[1]/div[1]")).getAttribute("prima");
				opcion_1=opcion_1.replace(".", "");
				opcion_1ToInteger = Integer.parseInt(opcion_1);
				array[0]=opcion_1ToInteger;
				System.out.println(opcion_1ToInteger);
			}
			else {
				System.out.println("No valor");
				array[0]=0;
			}
		}
		else {
			System.out.println("Esperando");
		}
		
		Boolean explicit_2;
		explicit_2= wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='table']/tbody/tr[2]/td[1]/span/i")));
		if (explicit_2==true) {
			System.out.print("Segunda Opcion: $");
			WebDriverWait wait_2 = new WebDriverWait(driver,5);
			boolean basic_2 = driver.findElement(By.xpath("//div[@id='cotizaciones']//tr[2]//td[1]//span[1]")).isDisplayed();
			if (basic_2==false) {
				String opcion_2 = driver.findElement(By.xpath("//body[@id='app']/div[@id='cotizaciones']/div[@class='page']/div[@class='container']/div[@class='sixteen columns']/table[@id='table']/tbody/tr[2]/td[1]/div[1]")).getAttribute("prima");
				opcion_2=opcion_2.replace(".", "");
				opcion_2ToInteger = Integer.parseInt(opcion_2);
				array[1]=opcion_2ToInteger;
				System.out.println(opcion_2ToInteger);
			}
			else {
				System.out.println("No valor");
				array[1]=0;
			}
		}
		else {
			System.out.println("Esperando");
		}
		
		Boolean explicit_3;
		explicit_3= wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='table']/tbody/tr[3]/td[1]/span/i")));
		if (explicit_3=true) {
			System.out.print("Tercera Opcion: $");
			WebDriverWait wait_2 = new WebDriverWait(driver,5);
			boolean basic_3 = driver.findElement(By.xpath("//div[@id='cotizaciones']//tr[3]//td[1]//span[1]")).isDisplayed();
			if (basic_3==false) {
				String opcion_3 = driver.findElement(By.xpath("//body[@id='app']/div[@id='cotizaciones']/div[@class='page']/div[@class='container']/div[@class='sixteen columns']/table[@id='table']/tbody/tr[3]/td[1]/div[1]")).getAttribute("prima");
				opcion_3=opcion_3.replace(".", "");
				opcion_3ToInteger = Integer.parseInt(opcion_3);
				array[2]=opcion_3ToInteger;
				System.out.println(opcion_3ToInteger);
			}
			else {
				System.out.println("No valor");
				array[2]=0;
			}
		}
		else {
			System.out.println("Esperando");
		}
		
		Boolean explicit_4;
		explicit_4= wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='table']/tbody/tr[4]/td[1]/span/i")));
		if (explicit_4==true) {
			System.out.print("Cuarta Opcion: $");
			WebDriverWait wait_2 = new WebDriverWait(driver,5);
			boolean basic_4 = driver.findElement(By.xpath("//div[@id='cotizaciones']//tr[4]//td[1]//span[1]")).isDisplayed();
			if (basic_4==false) {
				String opcion_4 = driver.findElement(By.xpath("//body[@id='app']/div[@id='cotizaciones']/div[@class='page']/div[@class='container']/div[@class='sixteen columns']/table[@id='table']/tbody/tr[4]/td[1]/div[1]")).getAttribute("prima");
				opcion_4=opcion_4.replace(".", "");
				opcion_4ToInteger = Integer.parseInt(opcion_4);
				array[3]=opcion_4ToInteger;
				System.out.println(opcion_4ToInteger);
			}
			else {
				System.out.println("No valor");
				array[3]=0;
			}
		}
		else {
			System.out.println("Esperando");
		}
	
	Boolean explicit_5;
	explicit_5= wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='table']/tbody/tr[5]/td[1]/span/i")));
	if (explicit_5==true) {
		System.out.print("Quinta Opcion: $");
		WebDriverWait wait_2 = new WebDriverWait(driver,5);
		boolean basic_5 = driver.findElement(By.xpath("//div[@id='cotizaciones']//tr[5]//td[1]//span[1]")).isDisplayed();
		if (basic_5==false) {
			String opcion_5 = driver.findElement(By.xpath("//body[@id='app']/div[@id='cotizaciones']/div[@class='page']/div[@class='container']/div[@class='sixteen columns']/table[@id='table']/tbody/tr[5]/td[1]/div[1]")).getAttribute("prima");
			opcion_5=opcion_5.replace(".", "");
			opcion_5ToInteger = Integer.parseInt(opcion_5);
			array[4]=opcion_5ToInteger;
			System.out.println(opcion_5ToInteger);
		}
		else {
			System.out.println("No valor");
			array[4]=0;
		}
	}
	else {
		System.out.println("Esperando");
	}
	
	Boolean explicit_6;
	explicit_6= wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='table']/tbody/tr[6]/td[1]/span/i")));
	if (explicit_6==true) {
		System.out.print("Sexta Opcion: $");
		WebDriverWait wait_2 = new WebDriverWait(driver,5);
		boolean basic_6 = driver.findElement(By.xpath("//div[@id='cotizaciones']//tr[6]//td[1]//span[1]")).isDisplayed();
		if (basic_6==false) {
			String opcion_6 = driver.findElement(By.xpath("//body[@id='app']/div[@id='cotizaciones']/div[@class='page']/div[@class='container']/div[@class='sixteen columns']/table[@id='table']/tbody/tr[6]/td[1]/div[1]")).getAttribute("prima");
			opcion_6=opcion_6.replace(".", "");
			opcion_6ToInteger = Integer.parseInt(opcion_6);
			array[5]=opcion_6ToInteger;
			System.out.println(opcion_6ToInteger);
		}
		else {
			System.out.println("No valor");
			array[5]=0;
		}
	}
	else {
		System.out.println("Esperando");
	}
	
	Boolean explicit_7;
	explicit_7= wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='table']/tbody/tr[6]/td[1]/span/i")));
	if (explicit_7==true) {
		System.out.print("Septima Opcion: $");
		WebDriverWait wait_2 = new WebDriverWait(driver,5);
		boolean basic_7 = driver.findElement(By.xpath("//div[@id='cotizaciones']//tr[6]//td[1]//span[1]")).isDisplayed();
		if (basic_7==false) {
			String opcion_7 = driver.findElement(By.xpath("//body[@id='app']/div[@id='cotizaciones']/div[@class='page']/div[@class='container']/div[@class='sixteen columns']/table[@id='table']/tbody/tr[6]/td[1]/div[1]")).getAttribute("prima");
			opcion_7=opcion_7.replace(".", "");
			opcion_7ToInteger = Integer.parseInt(opcion_7);
			array[6]=opcion_7ToInteger;
			System.out.println(opcion_7ToInteger);
		}
		else {
			System.out.println("No valor");
			array[6]=0;
		}
	}
	else {
		System.out.println("Esperando");
	}
	
	for(int i=0;i<array.length;i++) {
		if (array[i]!=0) {
			if (array[i]<array[i+1]);
			menor=array[i];
			a++;
		}
	}
	System.out.println("Se ha seleccionado el seguro con menor precio dentro del plan basico: $"+menor);
	switch (a) {
	case 1:
		WebElement verDetalles1 = driver.findElement(By.xpath("//tr[1]//td[1]//div[1]//div[2]//a[1]//span[1]"));
		verDetalles1.click();
		break;
	case 2:
		WebElement verDetalles2 = driver.findElement(By.xpath("//tr[2]//td[1]//div[1]//div[2]//a[1]//span[1]"));
		verDetalles2.click();
		break;
	case 3:
		WebElement verDetalles3 = driver.findElement(By.xpath("//tr[3]//td[1]//div[1]//div[2]//a[1]//span[1]"));
		verDetalles3.click();
		break;
	case 4:
		WebElement verDetalles4 = driver.findElement(By.xpath("//tr[4]//td[1]//div[1]//div[2]//a[1]//span[1]"));
		verDetalles4.click();
		break;
	case 5:
		WebElement verDetalles5 = driver.findElement(By.xpath("//tr[5]//td[1]//div[1]//div[2]//a[1]//span[1]"));
		verDetalles5.click();
		break;
	case 6:
		WebElement verDetalles6 = driver.findElement(By.xpath("//tr[6]//td[1]//div[1]//div[2]//a[1]//span[1]"));
		verDetalles6.click();
		break;
	case 7:
		WebElement verDetalles7 = driver.findElement(By.xpath("//tr[7]//td[1]//div[1]//div[2]//a[1]//span[1]"));
		verDetalles7.click();
		break;
		}
	}
} 