package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Method.BaseTest;
import com.Method.HeadportaitBusiness;
import com.Method.LoginBusiness;
import com.Method.SettingBusiness;

/**
 * 
* @ClassName: UploadAvatar
* @Description: TODO(������һ�仰��������������)
* @author jun
* @date 2016��8��30�� ����10:27:05
*
 */
public class UploadAvatar extends BaseTest{
	
	/*
	 * ��¼���뵽����������
	 * �ڸ���������ѡ��ͷ������
	 * ��ѡ�����ͷ��
	 * 
	 */
	
@Test
@Parameters({"logname","password"})
public void TestUpload(String logname,String password){
	LoginBusiness.getInstance().login(logname, password);
	SettingBusiness settingbus=new SettingBusiness();
	settingbus.getSetting();
	//ʹ�õ���ģʽ���÷���ʧ��SettingBusiness.getInstance().getSetting();
	HeadportaitBusiness headport=new HeadportaitBusiness();
	headport.getImagesetting();
	headport.getclickuploap();
/*
 * �ϴ�ͷ��������ʲô�����ԱȽϺ�
 */


}
}
