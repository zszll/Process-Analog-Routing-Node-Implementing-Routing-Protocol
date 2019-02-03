package homework4;
import java.util.*; //����ĳ�������滻ThreadSupport.java
import java.net.DatagramPacket;
import java.net.Socket;
public class ThreadPoolSupport implements IOStrategy { // ThreadPoolSupport.java
	private ArrayList threads = new ArrayList();
	private final int INIT_THREADS = 50;
	private final int MAX_THREADS = 100;
	private IOStrategy ios = null;
	public ThreadPoolSupport(IOStrategy ios) { // �����̳߳�
		this.ios = ios;
		for (int i = 0; i < INIT_THREADS; i++) {		
			IOThread2 t = new IOThread2(ios); // ����Э����󣬵��ǻ�û��socket
			t.start(); // �����̣߳������߳������wait
			threads.add(t);
		}
		try {
			Thread.sleep(300);
		} catch (Exception e) {
		} // �ȴ��̳߳ص��̶߳������С�
	}
	public void service( DatagramPacket  socket,char z,int [][] path,int [] Port,HeartPackageHandle  []HPH,Thread t1) { 
		// �����̳߳أ��ҵ�һ�����е��̣߳�
		IOThread2 t = null; // �ѿͻ��˽�������������
		boolean found = false;
		
		for (int i = 0; i < threads.size(); i++) {
			t = (IOThread2) threads.get(i);
			if (t.isIdle()) {
				//System.out.println(i+"�̵߳õ�����");
				found = true;
				break;
			}
		}
		if (!found) // �̳߳��е��̶߳�æ��û�а취�ˣ�ֻ�д���
		{ // һ���߳��ˣ�ͬʱ��ӵ��̳߳��С�
			t = new IOThread2(ios);
			t.start();
			try {
				Thread.sleep(300);
			} catch (Exception e) {
			}
			threads.add(t);
		}
		t.setSocket(socket,z,path,Port,HPH,t1); // �����󴫵ݸ�������е��߳�
	} // ���俪ʼִ��Э�飬�ṩ����
}
