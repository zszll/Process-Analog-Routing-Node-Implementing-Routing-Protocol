package homework4;
import java.util.*;
import java.io.*;
public class Dijkstra { 
	
	
	
	
	/*private static int N = 1000;
    private static int[][] Graph = {
            { 0, 2, 5, 1, N,N },
            { 2, 0, 3, 2, N, N },
            { 5, 3, 0, 3, 1, 5 },
            { 1, 2, 3, 0, 1, N },
            { N, N, 1, 1, 0, 2 },
            { N, N, 5, N, 2, 0 },
            };
    private static char [] node={'A','B','C','D','E','F'};
    public static void main(String[] args) throws Exception{
        dijkstra('A', Graph);
    }*/
	
	
	
	private static Object lock1= new byte[0];
	
	
	
	
    public  static synchronized void dijkstra(char z, int[][] Graph)throws Exception { 	
    	
    	int vs=0;
       char[] node=getArray.getArray(); 
        int NUM=node.length;
        vs=String.valueOf(node).indexOf(z);
        // 前驱节点数组
      
       LinkedList []prenode=new LinkedList[NUM];
        for(int i=0;i<NUM;i++){
        	prenode[i]=new LinkedList();
        }
        // 最短距离数组
        int[] mindist = new int[NUM];
        // 该节点是否已经找到最短路径
        boolean[] find = new boolean[NUM];
         
        int vnear = vs;
         /*遍历A与其他节点的直接关系*/
        for (int i = 0; i < NUM; i++) {
        	try{
            //prenode[i].add(i);
            mindist[i] = Graph[vs][i];
            find[i] = false;
        	}catch(Exception e){}
        }
 
        find[vs] = true;
         /*遍历A与其他节点的间接关系*/
        for (int v = 0; v < Graph.length; v++) {
        if(v==vs)
        	continue;
            // 每次循环求得距离vs最近的节点vnear和最短距离min
            int min = 9999;
            for (int j = 0; j < Graph.length; j++) {
                if (!find[j] && mindist[j] < min&&(mindist[j]!=-1)){
                    min = mindist[j];
                    vnear = j;
                }
            }
            find[vnear] = true;
 
            // 根据vnear修正vs到其他所有节点的前驱节点及距离
            for (int k = 0; k < Graph.length; k++) {
            	if(Graph[vnear][k]==-1)
            		continue;
                if (!find[k] && (min + Graph[vnear][k]) < mindist[k]) { 
                	prenode[k]=(LinkedList)prenode[vnear].clone();
                    prenode[k].add(vnear);
                    mindist[k] = min + Graph[vnear][k];
                }
            }
        }
        for (int i = 0; i < NUM; i++) {
        	prenode[i].add(i);
        }
       
        String []str=new String[NUM];
        for(int i=0;i<NUM;i++){      	
        	int j=0;
        	 char []ctr=new char[NUM];
        	while(!(prenode[i].isEmpty())){
        		ctr[j++]=node[(int)(prenode[i].remove())];
        	}
        	str[i]=String.valueOf(ctr).trim();
        	
        }
        	      	
       // synchronized(lock1){
        for (int i = 0; i < NUM; i++) {
        	
        	int flag=0;
        	for(int j=0;j<NUM;j++){
        		if(Graph[i][j]==-1){
        			continue;
        		}
        		else
        			flag=1;
        	}
        	if(flag==0){
        		if(vs==i){
        			System.out.println(node[i]+"宕机");
        			break;
        		}
        		System.out.println(node[i]+"宕机");
        		continue;
        	}
        	if((vs==i)||(mindist[i]==9999))
        		continue;
        		 
            System.out.println(z+" least-cost path to node " +node[i] +":"+node[vs]+str[i]+", and the cost is  " + mindist[i]);
        
    }
        System.out.println("..........................................................");
    
   // }
    }}




