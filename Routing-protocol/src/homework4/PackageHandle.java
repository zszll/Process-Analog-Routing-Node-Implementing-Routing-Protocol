package homework4;
import java.io.*;
import java.util.*;
public class PackageHandle {
	//对节点的path数组进行更新重写操作，所以需要加锁
public static synchronized void PackageHandle(int path[][],byte []RecvData) throws Exception{
	ByteArrayInputStream bais = new ByteArrayInputStream(RecvData);
	DataInputStream dis=new DataInputStream(bais);
	int num=path[0].length;
	int [][]recvData=new int [num][num];
	for(int i=0;i<num;i++){
		for(int j=0;j<num;j++){
			recvData[i][j]=dis.readInt();
			 if(path[i][j]>recvData[i][j]){
				path[i][j]=recvData[i][j];
				
			}
		}
	}
		dis.close();
		bais.close();
	
}
}
