package homework4;

import java.net.DatagramPacket;

public interface IOStrategy { // IOStrategy.java
	public void service(java.net.DatagramPacket  p,char z,int [][] path,int [] Port,HeartPackageHandle  []HPH,Thread t1);  //�Դ����socket������д���
}
