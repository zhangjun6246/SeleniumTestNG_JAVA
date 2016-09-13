package utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Readtxt {
	//
    public  Map<String,String> readTxtFile(String filePath){
    	
    	Map<String,String>   map=null;
		  try {
			 String encoding="GBK";
			 File file=new File(filePath); 
			 map=new HashMap<String,String> ();
		 if(file.isFile() && file.exists()){ //�ж��ļ��Ƿ���� 
			 InputStreamReader read = new InputStreamReader( new FileInputStream(file),encoding);//���ǵ������ʽ 
			 BufferedReader bufferedReader = new BufferedReader(read); 
			 String lineTxt = null;
			 while((lineTxt = bufferedReader.readLine()) != null){ 
	             String reds[]=lineTxt.split("\\s+");
	             if(null!=reds && reds.length==2 && !reds[0].isEmpty()&&!reds[1].isEmpty())
				 map.put(reds[0], reds[1]);
				// System.out.println(lineTxt); 
				 }
			 read.close();
				 }else{
					 System.out.println("�Ҳ���ָ�����ļ�");
				 } 
		 } catch (Exception e) { 
			 System.out.println("��ȡ�ļ����ݳ���"); e.printStackTrace(); 
		 }
		 
		return     map; 
		 }
    
    
    public static void main(String argv[]){
		String filePath = "E:\\senlenium\\Date.txt"; 
		  
//		Map<String,String> map=readTxtFile(filePath);
//		 for(Map.Entry<String,String>entry:map.entrySet()){
//			 System.out.println("key= " + entry.getKey() + " and value= "+ entry.getValue());
//		 }
	}   
    
}
	 
		 
	
		
	
		
		

