package homework4;
import java.net.*;

public class NwServer { // NwServer.java����������������󣬲���������DatagramSocket����
	// ͨ��IOStrategy�ӿڴ��ݸ�ThreadSupport����
	public NwServer(int port, IOStrategy ios,char z,int [][] path,int [] Port,HeartPackageHandle  []HPH,Thread t1) { // ��������������߳���ִ��
		try {
			DatagramSocket ss = new DatagramSocket(port);
			while (true) {
				byte [] b=new byte[144];
				DatagramPacket p=new DatagramPacket (b,b.length);
				 ss.receive(p); // ���������������				
				ios.service(p,z,path,Port,HPH,t1); // ��DatagramPacket���ݸ�ThreadSupport����
			} 
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
}
