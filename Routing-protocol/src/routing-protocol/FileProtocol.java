package homework4;

import java.io.*;
import java.net.*;
import java.util.*;

public class FileProtocol implements IOStrategy{	   
	public void service(DatagramPacket  recvPacket,char z,int [][] path,int [] Port,HeartPackageHandle  []HPH,Thread t1){ 		
		try { 
			byte[] buffer=recvPacket.getData();
			//长度为4时为输出命令
			if(recvPacket.getLength()==4)
			{	
			Dijkstra.dijkstra(z, path);	//调用迪杰斯特拉算法输出最短路径					
			}
			//长度为2时为心跳包
		else if(recvPacket.getLength()==2){			
			int i=0;
			while(true){				 								
				ByteArrayInputStream bais = new ByteArrayInputStream(buffer);
				DataInputStream dis=new DataInputStream(bais);
				char c=dis.readChar();
				char [] C=getArray.getArray();
				String[] P=getPort.getPort();
			   int index=String.valueOf(C).indexOf(c);
				int p=Integer.parseInt(P[index]);	
				if(Port[i]==p ){
					HPH[i].TimeReset();//将所收到心跳包节点的监听端口时间重置
					break;
				}
				i++;
			}						
		}
		//长度为8时为宕机命令	
		else if(recvPacket.getLength()==8){
			t1.interrupt();
			System.out.println("has been interrupt");
		}
		//收到路径数组
		else{
		byte[] recvData = new byte[recvPacket.getLength()];
		System.arraycopy(buffer, 0, recvData, 0, recvData.length);
		PackageHandle.PackageHandle(path, recvData);//调用路径更新函数更新路径
		}
		} catch (Exception e) {
			//e.printStackTrace();
		}
	}	
}
