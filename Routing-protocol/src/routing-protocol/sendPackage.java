package homework4;
import java.net.*;
import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class sendPackage {  
	
public static void sendPackage(int port,int [][]path) throws Exception{
	//��·������ת��Ϊbyte����
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	DataOutputStream dos=new DataOutputStream(baos);
	int num=path[0].length;
	for(int i=0;i<num;i++){
		for(int j=0;j<num;j++){
	        dos.writeInt(path[i][j]);
	        }
		}
	dos.flush();
	byte[] data =baos.toByteArray();	
	//UDPЭ�鷢�����ݰ�
	DatagramSocket socket = new DatagramSocket();
	DatagramPacket packet = new DatagramPacket(data,data.length);
	packet.setSocketAddress(new InetSocketAddress("localhost", port));
	socket.send(packet);	
    socket.close();
	
}

//���Dijkstra���·��
public static void sendPackage(int port,int Flag) throws Exception{
	
	
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	DataOutputStream dos=new DataOutputStream(baos);
	
	dos.writeInt(1);
	dos.flush();
	byte[] data =baos.toByteArray();
	DatagramSocket socket = new DatagramSocket();
	DatagramPacket packet = new DatagramPacket(data, data.length);

	packet.setSocketAddress(new InetSocketAddress("localhost", port));
	socket.send(packet);
	socket.close();
}

//��������
public static void sendPackage(int port,char c) throws Exception{
	//���ڵ��ʶת����byte����
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	DataOutputStream dos=new DataOutputStream(baos);	
	dos.writeChar(c);
	dos.flush();
	byte[] data =baos.toByteArray();
	//UDPЭ�鷢��������
	DatagramSocket socket = new DatagramSocket();
	DatagramPacket	packet = new DatagramPacket(data, data.length);
	packet.setSocketAddress(new InetSocketAddress("localhost", port));
	socket.send(packet);
    socket.close();
}


public static void sendPackage(int port,double d) throws Exception{
	
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	DataOutputStream dos=new DataOutputStream(baos);
	
	dos.writeDouble(d);
	dos.flush();
	byte[] data =baos.toByteArray();
	DatagramSocket socket = new DatagramSocket();
	DatagramPacket	packet = new DatagramPacket(data, data.length);

	packet.setSocketAddress(new InetSocketAddress("localhost", port));
	socket.send(packet);
    socket.close();
}

	
}
