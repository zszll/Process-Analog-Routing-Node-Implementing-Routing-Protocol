package homework4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class getPort {
	public static String[] getPort() throws Exception{
	char []c =getArray.getArray();
	int NUM=c.length;
	String [] Port=new String[NUM];
  	 FileInputStream fin = new FileInputStream("src\\configTotal.txt");
  	 InputStreamReader isr=new InputStreamReader(fin,"GBK");
  	 BufferedReader bis = new BufferedReader(isr);
  	 String s=null;
  	 while((s=bis.readLine())!=null){
  		 String []sa=s.split(" ");
  		 Port[Integer.parseInt(sa[1])]=sa[2];
  	 }
  	bis.close();
  	return Port;
}
}