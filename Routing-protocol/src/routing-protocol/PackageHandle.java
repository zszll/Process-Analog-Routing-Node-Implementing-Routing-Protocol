package homework4;
import java.io.*;
import java.util.*;
public class PackageHandle {
	//�Խڵ��path������и�����д������������Ҫ����
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
