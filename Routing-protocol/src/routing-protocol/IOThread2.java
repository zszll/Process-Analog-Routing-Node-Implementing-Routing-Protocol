package homework4;//�������޸ĺ���߳��࣬�ó����ͬ�����ƣ�wait��notify�����ĵ���Ҫ��ϸ�
import java.net.*;

public class IOThread2 extends Thread {
	private DatagramPacket   socket = null;
	private IOStrategy ios = null;
	char z;int [][] path;int [] Port;HeartPackageHandle  []HPH;Thread t1;
	public IOThread2(IOStrategy ios) { // ��Ƚ���һ���е�IOThread��Ĺ��췽��
		this.ios = ios; // �кβ�ͬ��
	}

	public boolean isIdle() { // ���socket����Ϊ�գ���ô����̵߳�Ȼ�ǿ��е�
		return socket == null;
	}

	public synchronized void setSocket(DatagramPacket  socket,char z,int [][] path,int [] Port,HeartPackageHandle  []HPH,Thread t1) {
		this.socket = socket; // ���ݸ�����������߳�һ�������񡱣�����������
		this.z=z;
		this.path=path;
		this.Port=Port;
		this.HPH=HPH;
		this.t1=t1;
		notify();
	}

	public synchronized void  run() { // ���ͬ�����������Ǳ���ʲô�������ݣ�
		while (true) { // ������Ϊwait�������ñ���ӵ�ж�����
			try {
				wait(); // �����߳�������̽����������ȴ�״̬
				ios.service(socket,z,path,Port,HPH,t1); // �����Ѻ����̿�ʼִ�з���Э��
				//System.out.println("the thread is working!");
				socket = null; // ������������̷��ص�����״̬
			} catch (Exception e) {
				//e.printStackTrace();
			}
		}
	}
}
