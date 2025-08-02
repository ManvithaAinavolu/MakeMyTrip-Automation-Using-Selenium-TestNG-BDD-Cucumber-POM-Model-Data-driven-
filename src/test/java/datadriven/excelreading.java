package datadriven;
import java.io.*;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
public class excelreading {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		FileInputStream file=new FileInputStream("C:\\Users\\LENOVO\\Downloads\\Book1.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheetname=workbook.getSheet("Sheet1");
		
		int count=sheetname.getLastRowNum();
		
		for(int i=1;i<=count;i++) {
			XSSFRow row=sheetname.getRow(i);
			
			XSSFCell cell=row.getCell(0);
			
			String uname=cell.getStringCellValue();
			XSSFCell cell1=row.getCell(1);
			
			String pwd = cell1.getStringCellValue(); 

			WebDriverManager.chromedriver().setup();
			
			WebDriver driver = new ChromeDriver();
			Thread.sleep(3000);	
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			Thread.sleep(3000);	
			driver.findElement(By.name("username")).sendKeys(uname);
			driver.findElement(By.name("password")).sendKeys(pwd);
			Thread.sleep(3000);	
			//driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
			//attribute type
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			//text type
			driver.close();
		}
		
		System.out.println("completed reading file");

	}

}
