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
		// 定义本节点的节点可达数组。
		// 从配置文件中读取全部节点个数	
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
		// 获取自身相连节点参数（节点名称与端口号）
		// 将自身直接相连节点路径信息更新到路径数组中	
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
			//更改初始的可达路径数组
			path[num1][num2] = Integer.parseInt(sa[1]);
			path[num2][num1] = Integer.parseInt(sa[1]);
			//读取直接相连的端口号存在Port数组中
			Port[k++]=Integer.parseInt(sa[2]);			
		}
		bis.close();
		isr.close();
		fin.close();
   				
		//开启心跳包监听线程
		HeartPackageHandle []HPH=new HeartPackageHandle [k];
		for(int i=0;i<k;i++){			
			HPH[i]=new HeartPackageHandle();
			(HPH[i]).HeartPackageHandle(Port[i],path);
		}
		
		//发心跳包
		Thread t1=	new Thread() {
			Timer timer=null;
				public void run() {		
					try {	// 遍历Port数组，给每一个直接相连的端口号发包经过特定的时间间隔发包						 
						  timer = new Timer();
						timer.schedule(new TimerTask(){
							public void run(){
								try{
									if(!Thread.currentThread().isInterrupted()) {//线程没有被终止时才有资格发包
										for(int i=0;i<NUM;i++){
										if(Port[i]!=0){											
											sendPackage.sendPackage(Port[i], z);//调用心跳包发送函数											
										}
									}
									}									
								}catch (Exception e){}
								}
							
						},0,getPeriod.getHeartspan());	//通过配置文件得到心跳包发送时间间隔				
				}catch(Exception e){}
					}
				public void interrupt() {
					timer.cancel();
				}
			};			
			t1.start();
			
			
		//收包
		new Thread() {			
			public void run() {
			new NwServer(port, new ThreadPoolSupport(new FileProtocol()),z,path,Port,HPH,t1);
			}
		}.start();
		
		
		//发数据包
		new Thread() {
			public void run() {				
				try {
					// 遍历Port数组，给每一个直接相连的端口号发包经过特定的时间间隔发包
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
					},0,getPeriod.getSendspan());//读取配置文件得到发送数据包的时间间隔								
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}.start();
		
		//定时输出最短路径信息	
		new Thread() {
			public void run() {
				try {										
					//经过特定的时间间隔发包
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
