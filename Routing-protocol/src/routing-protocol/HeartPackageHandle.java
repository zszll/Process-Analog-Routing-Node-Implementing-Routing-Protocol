package homework4;

import java.util.Timer;
import java.util.TimerTask;
// A 2000 B 2001 C 2002 D 2003 E 2004 F 2005
public class  HeartPackageHandle {
      int num;  
      Object lock1= new byte[0];
	  Object lock2= new byte[0];
	public   void HeartPackageHandle(int port,int [][]path) throws Exception {	
	    num =30;
		Timer timer = new Timer();
		timer.schedule(new TimerTask(){
			public void run(){
				synchronized(lock1){  //同步锁
					num--;   
					}
			    //连续N次接收不到心跳包，则认为宕机
				if(num<=0){
					//获取已经宕机的端口号
					synchronized(lock2){					
					try{
					String[] Port=getPort.getPort();
					String p=String.valueOf(port);
					int key=-1;
					for(int i=0;i<Port.length;i++){
						if(Port[i].equals(p))
							{key=i;
						     break;}
					}
					//将路径不可达的代价设为-1
				  for(int i=0;i<path[0].length;i++){
					  for(int j=0;j<path[0].length;j++){
						  if(i==key||j==key)
							  path[i][j]=-1;
					  }
				  }				 
				}
					catch(Exception e){}
					timer.cancel();					
				}}
				
			}
		},250,250);
		

	
	}

	public  void TimeReset(){		
				synchronized(lock1){
		num=30;		
		}

		}
	}
	
