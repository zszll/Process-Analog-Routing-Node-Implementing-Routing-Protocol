package homework4;

import java.io.*;
import java.net.*;
import java.util.*;

public class FileProtocol implements IOStrategy{	   
	public void service(DatagramPacket  recvPacket,char z,int [][] path,int [] Port,HeartPackageHandle  []HPH,Thread t1){ 		
		try { 
			byte[] buffer=recvPacket.getData();
			//����Ϊ4ʱΪ�������
			if(recvPacket.getLength()==4)
			{	
			Dijkstra.dijkstra(z, path);	//���õϽ�˹�����㷨������·��					
			}
			//����Ϊ2ʱΪ������
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
					HPH[i].TimeReset();//�����յ��������ڵ�ļ����˿�ʱ������
					break;
				}
				i++;
			}						
		}
		//����Ϊ8ʱΪ崻�����	
		else if(recvPacket.getLength()==8){
			t1.interrupt();
			System.out.println("has been interrupt");
		}
		//�յ�·������
		else{
		byte[] recvData = new byte[recvPacket.getLength()];
		System.arraycopy(buffer, 0, recvData, 0, recvData.length);
		PackageHandle.PackageHandle(path, recvData);//����·�����º�������·��
		}
		} catch (Exception e) {
			//e.printStackTrace();
		}
	}	
}
