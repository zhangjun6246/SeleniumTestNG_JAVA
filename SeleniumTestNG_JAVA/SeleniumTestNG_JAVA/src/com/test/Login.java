package com.test;

import junit.framework.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Method.BaseTest;
import com.Method.LoginBusiness;

/**
 * 
* @ClassName: Login
* @Description: TODO(������һ�仰��������������)
* @author jun
* @date 2016��8��30�� ����10:26:35
*
 */
public class Login extends BaseTest {
	WebDriver Driver;
	LoginBusiness  loginbusiness;
@BeforeClass
public void setUp(){
	loginbusiness=loginbusiness.getInstance();
}
@Test
@Parameters({"logname","password"})
public void testLogin(String logname,String password){
	loginbusiness.LoinTab();
	loginbusiness.inputUserName(logname);
	loginbusiness.inputPassword(password);
	loginbusiness.clickButton(Driver);
     /*
      *���ô��ڵĴ�С���������ܲ��ҵ��ҵ�ѧϰ�İ��������ڱ���������window���汨��
      *The method window() is undefined for the type WebDriver.Options
      */
	//driver.manage().window().maximize();
	Assert.assertEquals("�ҵ�ѧϰ",loginbusiness.getmethod());
	//Assert.assertEquals("�ҵ�ѧϰ", loginbusiness);
}
}
