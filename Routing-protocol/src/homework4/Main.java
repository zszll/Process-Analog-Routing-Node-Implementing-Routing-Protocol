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
			//�ȴ�����̨����������·��
			System.out.println("��������Ҫ��ѯ��·�ɽڵ�(��0����)����������Ҫ�����Ľڵ㣨��ʽ��AAA����");
			while(true){
			Scanner Scan = new Scanner(System.in);
			String Read = Scan.nextLine();
			//Scan.close();
			if(Read.equals("0"))
				break;
			char []c=Read.toCharArray();
			//�������Ϊ1��Ϊ������·��
			
			//��ȡ�˿ں�
			char [] C=getArray.getArray();
			String[] Port=getPort.getPort();
		   int index=String.valueOf(C).indexOf(c[0]);
			int port=Integer.parseInt(Port[index]);			   	
		 			 
		   	if(c.length==1){
		   		
		   		sendPackage.sendPackage(port, 1);
		   		
		   	}
			
			//�������Ϊ3��Ϊ�ս�ĳ���ڵ�
			if(c.length==3){
				sendPackage.sendPackage(port, 0.1);
			}
			
			
	}}catch(Exception e){};	
		
}
	


}


