/*
 * @Author: Qiao ZHao
 * @Date: 1/1/2016
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class shortestPath {
	// JDBC driver name and database URL
		static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
		static final String DB_URL = "jdbc:mysql://localhost:3306/map";
		//url = jdbc:mysql://localhost:3306/dbname
	    //Database credentials
		static final String USER = "root";
		static final String PASS = "123";
		
		static int[] dis = new int[22];
	    static String[] start = new String[22];
	    static String[] end = new String[22];
		
	    private static class Node {  
	        private String name;  
	        private Map<Node,Integer> child=new HashMap<Node,Integer>();  
	        public Node(String name){  
	            this.name=name;  
	        }  
	        public String getName() {  
	            return name;  
	        }  
	        public void setName(String name) {  
	            this.name = name;  
	        }  
	        public Map<Node, Integer> getChild() {  
	            return child;  
	        }  
	        public void setChild(Map<Node, Integer> child) {  
	            this.child = child;  
	        }  
	    }
	    private static Node CB =new Node("Castle Black");  
	    private static Node WF =new Node("Winterfell"); 
	    private static Node TT =new Node("The Twins"); 
	    private static Node E =new Node("Eyrie"); 
	    private static Node P =new Node("Pyke"); 
	    private static Node R =new Node("RiverRun"); 
	    private static Node K =new Node("Kings Landing"); 
	    private static Node CR =new Node("Casterly Rock"); 
		private static Node H =new Node("Highgarden"); 
		private static Node startNode, endNode;
		private static Set<Node> open=new HashSet<Node>();  
	    private static HashMap<Node,Integer> base = new HashMap<Node, Integer>();
	    private static HashMap<Integer, String> res = new HashMap<Integer, String>();
		
	public static void main(String[] args){
		
		Scanner s = new Scanner(System.in);
		System.out.println("Welcome to the world of game of thrones.");
		System.out.println("Where is your destination in westeros?");
		System.out.println("you can choose from the following cities:");
		System.out.println("Castle Black; Winterfell; The Twins; Eyrie; Pyke; RiverRun; Kings Landing; Casterly Rock; Highgarden");
		String end = s.next();
		System.out.println("Where do you want to begin your journey in westeros?");
		String start = s.next();
		s.close();
		System.out.println("Description of "+ end +": "+getDescription(end));
		
		loadData();
	    buildMap(start,end,open);
		//shortest(startNode,endNode);
	    getPath(startNode,endNode,startNode.getName(),0);
		int distance = Integer.MAX_VALUE;
	    for(Integer i : res.keySet()){
			distance = Math.min(distance, i);
		}
	    System.out.println("The shortest distance is "+ distance+" miles.");
	    System.out.println("The best path is "+ res.get(distance));
		
		
		
		
		
		//String path = shortestPath(end,start,type);
		//System.out.println("Your best travel path is "+ path);
		//System.out.println("The total distance is " );
	}
	
	
	public static void loadData(){
		Connection conn = null;
		Statement stmt = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");//Register JDBC driver
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL,USER,PASS);//Open a connection
			System.out.println("Creating statement...");
		    stmt = conn.createStatement();//Execute a query
		    String sql = "SELECT start, end, distance FROM travel";
		    ResultSet rs = stmt.executeQuery(sql);
		    int i=0;
		    while(rs.next()){
		    	start[i] = rs.getString("start");
		        end[i] = rs.getString("end");
		        dis[i++] = rs.getInt("distance");//Extract data from result set
		    }
		    stmt.close();
		    conn.close();	
		    }catch(SQLException se){
		        se.printStackTrace();//Handle errors for JDBC
		     }catch(Exception e){
		        e.printStackTrace();//Handle errors for Class.forName
		     }finally{
		        //finally block used to close resources
		        try{
		           if(stmt!=null)
		              stmt.close();
		        }catch(SQLException se2){
		        }// nothing we can do
		        try{
		           if(conn!=null)
		              conn.close();
		        }catch(SQLException se){
		           se.printStackTrace();
		        }//end finally try
		     }//end try
		
	}
	
	public static String shortestPath(String end,String start, String type){
		String path=null;
		
		return path;
	}
	
	public static String getDescription(String name){
		String res=null;
		Connection conn = null;
		Statement stmt = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");//Register JDBC driver
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL,USER,PASS);//Open a connection
			System.out.println("Creating statement...");
		    stmt = conn.createStatement();//Execute a query
		    String sql = "SELECT description FROM city WHERE name= '" + name + "'";
		    ResultSet rs = stmt.executeQuery(sql);
		    if(rs.next()){
		    	res = rs.getString("description");//Extract data from result set
		    }
		    stmt.close();
		    conn.close();	
		    }catch(SQLException se){
		        se.printStackTrace();//Handle errors for JDBC
		     }catch(Exception e){
		        e.printStackTrace();//Handle errors for Class.forName
		     }finally{
		        //finally block used to close resources
		        try{
		           if(stmt!=null)
		              stmt.close();
		        }catch(SQLException se2){
		        }// nothing we can do
		        try{
		           if(conn!=null)
		              conn.close();
		        }catch(SQLException se){
		           se.printStackTrace();
		        }//end finally try
		     }//end try
		     return res;
	}
	
	public static void buildMap(String start1, String end1,Set<Node> open){
		 //construct the node list of start and end
		 Node[] listN = new Node[]{CB,WF,TT,E,P,R,K,CR,H};
		 Node[] startN = new Node[22];
		 Node[] endN = new Node[22];
		 for(Node e: listN){
			 if(e.getName().equals(start1)) startNode=e;
			 if(e.getName().equals(end1)) endNode=e;
		 }
		 for(int i=0;i<startN.length;i++){
			 for(Node e: listN){
				 if(e.getName().equals(start1)) startNode=e;
				 if(e.getName().equals(end1)) endNode=e;
				 if(e.getName().equals(start[i])) startN[i]=e;
				 if(e.getName().equals(end[i])) endN[i] =e;
			 }
		 }
		
		 for(int i=0;i<startN.length;i++){
			 startN[i].getChild().put(endN[i], dis[i]);
		 }
		 for(Node e: listN){
			 if(e!=startNode) open.add(e);
		 }
	}

	
	public static void getPath(Node A, Node B, String path, int distance){  
		Map<Node,Integer> childs=A.getChild();
		//initialization
		for(Node child:childs.keySet()){
			if(open.contains(child)){
				if(child!=A){
					if(!base.containsKey(child)){
						base.put(child, childs.get(child));
					}else{
						if(base.get(child)>distance+childs.get(child)){
							base.put(child,distance+childs.get(child));
						}
					}
					if(child == B){
						res.put(base.get(child), path + "->"+B.getName());
						return;
					}else{
						if(open.contains(A)){
							open.remove(A);
						}
						getPath(child,B,path+"->"+child.getName(),base.get(child));
					}
				}
			}
			
		}
		return;
		
		 
    }  
	
	

}
