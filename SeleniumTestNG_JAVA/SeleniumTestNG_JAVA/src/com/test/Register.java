package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.FixMethodOrder;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import utility.Readtxt;

import com.Method.*;

@FixMethodOrder(MethodSorters.DEFAULT)

public class Register {
	static WebDriver driver=null;
	

	SeekMethod  getmethod=new SeekMethod();
	public String filePath = "E:\\senlenium\\Date.txt";

	//Basetest   testdriver=new Basetest();
	@Before
	public  void StartDriver() {
		
		System.out.println("srart selenium");
	 	 driver=new ChromeDriver();
	 	 driver.get("http://www.91testing.net");
	     
	}
	
	public void Login(String name,String password) throws InterruptedException{
		driver.findElement(By.linkText("��¼")).click();
		System.out.printf("url of current page is %s\n", driver.getCurrentUrl());
		  getmethod.getId("login_username",driver).clear();
		 ((JavascriptExecutor)driver).executeScript("document.getElementById('login_username').value='"+name+"';");
		driver.findElement(By.name("_password")).clear();
		 ((JavascriptExecutor)driver).executeScript("document.getElementById('login_password').value='"+password+"';");
		Thread.sleep(300);
		driver.findElement(By.cssSelector("button[type='submit']")).click();

	}

@Test
	public void TestLogin(){
		try {
			Login("xiaozhang","xiaozhang");
			String loginassert=getmethod.getXpath(("//li[@class='visible-lg']"),driver).getText();
			System.out.print(loginassert);
			Assert.assertEquals("�ҵ�ѧϰ",loginassert);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	
	 @Test
		public void TestSpacecp() {
	
		try {
			Login("xiaozhang","xiaozhang");
			Readtxt readtxt=new Readtxt();
			Map<String, String> map=readtxt.readTxtFile(filePath);
			// ���������У��ڵ�������˳�
			Actions action = new Actions(driver);
			action.clickAndHold(driver.findElement(By.xpath("//li[@class='user-avatar-li nav-hover']"))).perform();
			driver.findElement(By.linkText("��������")).click();
			//������������
			Thread.sleep(3000);
			getmethod.getId("profile_truename", driver).sendKeys(map.get("name"));
			getmethod.getId("profile_gender_1",driver).click(); 
			getmethod.getId("profile_idcard",driver).clear();
			getmethod.getId("profile_idcard",driver).sendKeys(map.get("cd"));
			getmethod.getId("profile_mobile",driver).clear();
			getmethod.getId("profile_mobile", driver).sendKeys(map.get("mobile"));
			getmethod.getId("profile_company",driver).sendKeys(map.get("company"));
			getmethod.getId("profile_job", driver).sendKeys(map.get("job"));
		
			getmethod.getId("profile_title",driver).sendKeys(map.get("title"));
		    getmethod.getXpath("//textarea[@id='profile_signature']",driver).sendKeys(map.get("qianming"));
			
		      WebElement xf=driver.findElement(By.tagName("iframe"));
		     driver.switchTo().frame(xf);
		     driver.findElement(By.tagName("body")).sendKeys("����2����");;
		     driver.switchTo().defaultContent();
		     
		      Thread.sleep(3000);
		    getmethod.getXpath("//input[@id='profile_site']", driver).sendKeys(map.get("zhuye"));
		    getmethod.getId("weibo", driver).sendKeys(map.get("weibo"));
		    getmethod.getId("profile_weixin", driver).sendKeys(map.get("weixin"));
		    getmethod.getId("profile_qq", driver).sendKeys(map.get("qq"));
		    getmethod.getId("profile-save-btn",driver).click();
		     
		  //�������ɹ�����true����ʾ��Ϣ����ɹ�
		    boolean  save= getmethod.getXpath(("//div[@class='alert alert-success']"),driver).isDisplayed();
		    Assert.assertTrue(save);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		}
  

   @Test
	public void TestChangePhoto(){
	   try {
		Login("xiaozhang","xiaozhang");
		// ���뵽�ҵ�ѧϰҳ��
	       getmethod.getXpath(("//li[@class='visible-lg']"),driver).click();
				// ����ҵ�ѧϰҳ�浱ǰ���
				String Setting_handles = driver.getWindowHandle();
				System.out.print(Setting_handles);
				// �������---����һ����ʱʱ��
				 getmethod.getLink("�������", driver).click();
				// �����ô���
				Thread.sleep(3000);
				// ������о��
				Set<String> handles = driver.getWindowHandles();
				System.out.println(handles);
				// �ж��Ƿ�Ϊ���ô��ڣ����������ô����ϵ�Ԫ��
				for (String handle : handles) {
					if (handle.equals(Setting_handles) == false) {
						// �л����ϴ�ͷ��ҳ��
						driver.switchTo().window(handle);
						Thread.sleep(3000);
						getmethod.getXpath("//input[@name='file']", driver).sendKeys("F://123.jpg");
						Thread.sleep(5000);
						getmethod.getXpath("//a[@class='btn btn-fat btn-primary']",driver).click();	
						
						//�����ϴ�ͷ���Ƿ�ɹ�
					    String image=getmethod.getXpath("//a[@id='upload-picture-btn']", driver).getText();
						Assert.assertEquals("�ϴ���ͷ��", image);
						// ���������У��ڵ�������˳�
						Actions action = new Actions(driver);
						action.clickAndHold(driver.findElement(By.xpath("//li[@class='user-avatar-li nav-hover']"))).perform();
						getmethod.getLink("��������", driver).click();
					}
				}
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
		
				
	}
	
   @Ignore	
@After
	public void tearDown(){
		driver.quit();
		driver.close();
	}

}
