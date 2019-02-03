package homework4;
import java.io.*;
import java.util.*;
public class getPeriod {

 
public static int getSendspan()throws Exception{
 Properties p = new Properties();
 p.load( new FileInputStream("src\\assignment.properties")) ;
 return Integer.parseInt(p.getProperty("TimeSpan"))*1000;
}


public static int getOutputspan()throws Exception{
	 Properties p = new Properties();
	 p.load( new FileInputStream("src\\assignment.properties")) ;
	 return Integer.parseInt(p.getProperty("Outputspan"))*1000;
	}


public static int getHeartspan()throws Exception{
	 Properties p = new Properties();
	 p.load( new FileInputStream("src\\assignment.properties")) ;
	 return (int)(Float.parseFloat(p.getProperty("Heartspan"))*1000);
	}




}