package homework4;
import java.net.*;

public class NwServer { // NwServer.java，负责接受连接请求，并将创建的DatagramSocket对象
	// 通过IOStrategy接口传递给ThreadSupport对象
	public NwServer(int port, IOStrategy ios,char z,int [][] path,int [] Port,HeartPackageHandle  []HPH,Thread t1) { // 这个方法将在主线程中执行
		try {
			DatagramSocket ss = new DatagramSocket(port);
			while (true) {
				byte [] b=new byte[144];
				DatagramPacket p=new DatagramPacket (b,b.length);
				 ss.receive(p); // 负责接受连接请求，				
				ios.service(p,z,path,Port,HPH,t1); // 将DatagramPacket传递给ThreadSupport对象
			} 
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
}
