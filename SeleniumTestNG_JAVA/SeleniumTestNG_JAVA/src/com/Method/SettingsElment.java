package com.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SettingsElment {
	
	public static String head="//li[@class='user-avatar-li nav-hover']";
	public static String setting="��������";
	public static String name="profile_truename";
	public static String sex="profile_gender_1";
	public static String idcard="profile_idcard";
	public static String mobile="profile_mobile";
	public static String company="profile_company";
	public static String job="profile_job";
	public static String title="profile_title";//ͷ��
	//����ǩ��
	public static String idiograph="//textarea[@id='profile_signature']";
  	//���ҽ���
	public static String homepage="//input[@id='profile_site']";
	public static String weibo="weibo";
	public static String weixin="profile_weixin";
	public static String QQ="profile_qq";
	public static String save="profile-save-btn";
	
	//�������ݣ�����ɹ�
	public static String getsave="//div[@class='alert alert-success']";
	
	
	//���ҽ���
     /*WebElement xf=driver.findElement(By.tagName("iframe"));
     driver.switchTo().frame(xf);
     driver.findElement(By.tagName("body")).sendKeys("����2����");;
     driver.switchTo().defaultContent();
    */ 


     
}
