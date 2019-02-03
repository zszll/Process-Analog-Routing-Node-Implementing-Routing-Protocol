package homework4;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.*;
//A 2000 B 2001 C 2002 D 2003 E 2004 F 2005
public class Assignment {
	public static void main(String[] args) throws Exception {
		// ���屾�ڵ�Ľڵ�ɴ����顣
		// �������ļ��ж�ȡȫ���ڵ����	
		 char[] node = getArray.getArray();
	  int NUM = node.length;
		 int[][] path = new int[NUM][NUM];
		for (int i = 0; i < NUM; i++) {
			for (int j = 0; j < NUM; j++) {
				path[i][j] = 9999;
			}
		}		
		char z;
		int port;
		z=args[0].charAt(0);
		port=Integer.parseInt(args[1]);		
		// ��ȡ���������ڵ�������ڵ�������˿ںţ�
		// ������ֱ�������ڵ�·����Ϣ���µ�·��������	
		int []Port=new int [NUM];
		int num1 = String.valueOf(node).indexOf(z);
		FileInputStream fin = new FileInputStream("src\\config" + z + ".txt");
		InputStreamReader isr = new InputStreamReader(fin, "GBK");
		BufferedReader bis = new BufferedReader(isr);
		String S = bis.readLine();
		 int k=0;
		while ((S = bis.readLine()) != null) {
			String[] sa = S.split(" ");
			char[] c1 = sa[0].toCharArray();
			int num2 = String.valueOf(node).indexOf(c1[0]);
			//���ĳ�ʼ�Ŀɴ�·������
			path[num1][num2] = Integer.parseInt(sa[1]);
			path[num2][num1] = Integer.parseInt(sa[1]);
			//��ȡֱ�������Ķ˿ںŴ���Port������
			Port[k++]=Integer.parseInt(sa[2]);			
		}
		bis.close();
		isr.close();
		fin.close();
   				
		//���������������߳�
		HeartPackageHandle []HPH=new HeartPackageHandle [k];
		for(int i=0;i<k;i++){			
			HPH[i]=new HeartPackageHandle();
			(HPH[i]).HeartPackageHandle(Port[i],path);
		}
		
		//��������
		Thread t1=	new Thread() {
			Timer timer=null;
				public void run() {		
					try {	// ����Port���飬��ÿһ��ֱ�������Ķ˿ںŷ��������ض���ʱ��������						 
						  timer = new Timer();
						timer.schedule(new TimerTask(){
							public void run(){
								try{
									if(!Thread.currentThread().isInterrupted()) {//�߳�û�б���ֹʱ�����ʸ񷢰�
										for(int i=0;i<NUM;i++){
										if(Port[i]!=0){											
											sendPackage.sendPackage(Port[i], z);//�������������ͺ���											
										}
									}
									}									
								}catch (Exception e){}
								}
							
						},0,getPeriod.getHeartspan());	//ͨ�������ļ��õ�����������ʱ����				
				}catch(Exception e){}
					}
				public void interrupt() {
					timer.cancel();
				}
			};			
			t1.start();
			
			
		//�հ�
		new Thread() {			
			public void run() {
			new NwServer(port, new ThreadPoolSupport(new FileProtocol()),z,path,Port,HPH,t1);
			}
		}.start();
		
		
		//�����ݰ�
		new Thread() {
			public void run() {				
				try {
					// ����Port���飬��ÿһ��ֱ�������Ķ˿ںŷ��������ض���ʱ��������
					Timer timer = new Timer();
					timer.schedule(new TimerTask(){
						public void run(){
							try{
							for(int i=0;i<NUM;i++){
								if(Port[i]!=0){									
									sendPackage.sendPackage(Port[i], path);									
								}
							}}catch (Exception e){}
							}						
					},0,getPeriod.getSendspan());//��ȡ�����ļ��õ��������ݰ���ʱ����								
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}.start();
		
		//��ʱ������·����Ϣ	
		new Thread() {
			public void run() {
				try {										
					//�����ض���ʱ��������
					Timer timer = new Timer();
					timer.schedule(new TimerTask(){
						public void run(){
							try{
								Dijkstra.dijkstra(z,path);
							}catch (Exception e){}
							}
						
					},0,getPeriod.getOutputspan());
	
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}.start();
	
	}

}
