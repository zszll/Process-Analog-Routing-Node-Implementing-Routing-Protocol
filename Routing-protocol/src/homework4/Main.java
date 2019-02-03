package homework4;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception{
		
		
		new Thread() {
			public void run() {
			
				try{
					String []str=new String[2];
					str[0]="A";
					str[1]="2000";
						Assignment.main(str);}catch(Exception e){};			
		}}.start();
		
	    new Thread() {
			public void run() {
			
				try{
					String []str=new String[2];
					str[0]="B";
					str[1]="2001";
						Assignment.main(str);}catch(Exception e){};			
		}}.start();
		
		new Thread() {
			public void run() {
			
				try{
					String []str=new String[2];
					str[0]="C";
					str[1]="2002";
						Assignment.main(str);}catch(Exception e){};			
		}}.start();
		
		new Thread() {
			public void run() {
			
				try{
					String []str=new String[2];
					str[0]="D";
					str[1]="2003";
						Assignment.main(str);}catch(Exception e){};			
		}}.start();
		
		 new Thread() {
			public void run() {
			
				try{
					String []str=new String[2];
					str[0]="E";
					str[1]="2004";
						Assignment.main(str);}catch(Exception e){};			
		}}.start();
		
		new Thread() {
			public void run() {
			
				try{
					String []str=new String[2];
					str[0]="F";
					str[1]="2005";
						Assignment.main(str);}catch(Exception e){};			
		}}.start(); 
		
		
		try{
			//等待控制台命令输出最短路径
			System.out.println("请输入想要查询的路由节点(以0结束)或者输入想要结束的节点（格式：AAA）：");
			while(true){
			Scanner Scan = new Scanner(System.in);
			String Read = Scan.nextLine();
			//Scan.close();
			if(Read.equals("0"))
				break;
			char []c=Read.toCharArray();
			//如果长度为1则为输出最短路径
			
			//获取端口号
			char [] C=getArray.getArray();
			String[] Port=getPort.getPort();
		   int index=String.valueOf(C).indexOf(c[0]);
			int port=Integer.parseInt(Port[index]);			   	
		 			 
		   	if(c.length==1){
		   		
		   		sendPackage.sendPackage(port, 1);
		   		
		   	}
			
			//如果长度为3则为终结某个节点
			if(c.length==3){
				sendPackage.sendPackage(port, 0.1);
			}
			
			
	}}catch(Exception e){};	
		
}
	


}


