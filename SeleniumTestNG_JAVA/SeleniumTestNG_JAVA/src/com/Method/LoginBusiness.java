package com.Method;

import org.openqa.selenium.WebDriver;

public class LoginBusiness {
/*
 * ��Ҫʵ�ֿؼ��ķ���
 * ����ҵ��ؼ�
 */
/*
 *  ����ģʽ
 */
	private static LoginBusiness loginbusiness=null;
	public static LoginBusiness getInstance(){
		if(loginbusiness==null){
			loginbusiness=new LoginBusiness();
		}
		return loginbusiness;
	}
	public void LoinTab(){
		SeekMethod.getLink("��¼", BaseTest.driver).click();
	}
	public void   inputUserName(String name){
		
		SeekMethod.getId((LoginElment.name),BaseTest.driver).sendKeys(name);
	}
     public void   inputPassword(String word){
		
    	 SeekMethod.getName((LoginElment.passWord), BaseTest.driver).sendKeys(word);
	}
      public void clickButton(WebDriver driver){
    	  SeekMethod.getcssSelector(LoginElment.LoginBtn, BaseTest.driver).click();
}
      //������ʹ��
      public String getmethod(){
    	  String loginassert=SeekMethod.getXpath(("//li[@class='visible-lg']"),BaseTest.driver).getText();
    	  
    	 return loginassert;
      }
     
      public void login(String userName,String pw){
    	  SeekMethod.getLink("��¼", BaseTest.driver).click();
    	  //driver.findElement(By.linkText("��¼")).click();
    	  inputUserName(userName);
    	  inputPassword(pw);
    	  clickButton(BaseTest.driver);
    	  
      }
}
