package homework4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class getArray {
public static char [] getArray() throws Exception{
	
	 FileInputStream fis = new FileInputStream("src\\configTotal.txt");
   	 InputStreamReader Isr=new InputStreamReader(fis,"GBK");
   	 BufferedReader Bis = new BufferedReader(Isr);
	int NUM=0;
	while((Bis.readLine())!=null){
		NUM++;
	}
	Bis.close();
	 char [] node=new char[NUM];
   	 FileInputStream fin = new FileInputStream("src\\configTotal.txt");
   	 InputStreamReader isr=new InputStreamReader(fin,"GBK");
   	 BufferedReader bis = new BufferedReader(isr);
   	 String s=null;
   	 while((s=bis.readLine())!=null){
   		 String []sa=s.split(" ");
   		 char [] c1=sa[0].toCharArray();
   		 node[Integer.parseInt(sa[1])]=c1[0];
   	 }
   	bis.close();
   	return node;
}
}
