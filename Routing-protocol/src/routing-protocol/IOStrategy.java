package homework4;

import java.net.DatagramPacket;

public interface IOStrategy { // IOStrategy.java
	public void service(java.net.DatagramPacket  p,char z,int [][] path,int [] Port,HeartPackageHandle  []HPH,Thread t1);  //对传入的socket对象进行处理
}
