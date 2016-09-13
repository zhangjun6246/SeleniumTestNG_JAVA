package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Method.BaseTest;
import com.Method.LoginBusiness;
import com.Method.SettingBusiness;

/**
 * 
* @ClassName: Setting
* @Description: TODO(������һ�仰��������������)
* @author jun
* @date 2016��8��30�� ����10:26:56
*
 */
public class Setting extends BaseTest {
	/*
	 * ������ø��ı�����
	 */
	
@Parameters({"logname","password"})	
@Test
public void TestSeeting(String logname,String password) {
	//��¼
	LoginBusiness.getInstance().login(logname,password);
	//����ҵ�����
	
	SettingBusiness settingPage=new SettingBusiness();
		//�����������ͷ��
		settingPage.getSetting();
		// ��д�û���Ϣ
		settingPage.getName();
		settingPage.getSex();
		settingPage.getIdcard();
		settingPage.getMobile();
		settingPage.getCompany();
		settingPage.getJob();
		settingPage.gettitle();
		settingPage.getidiograph();
	//���ҽ���
	//	settingPage.getSelfIntroduction();Ŀǰһ������ʧ��
		 settingPage.getHomePage();
		settingPage.getWeibo();
		settingPage.getWeixin();;
		settingPage.getQQ();;
		settingPage.getsave();
		//�������ݣ��������ݲ�Ҫ̫��
	    Assert.assertTrue(settingPage.getTrueDisaplayed());
}

}
