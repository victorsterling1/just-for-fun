/*
 * @Author: Qiao ZHao
 * @Date: 1/1/2016
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;



public class DataBase {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost:3306/map";
	//url = jdbc:mysql://localhost:3306/dbname
    //Database credentials
	static final String USER = "root";
	static final String PASS = "123";
	
	public static void main(String[] args){
		buildTable();
		InsertData();
		
	}
	
	public static void InsertData(){
		Connection conn = null;
		Statement stmt = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");//Register JDBC driver
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL,USER,PASS);//Open a connection
			System.out.println("Creating statement...");
		    stmt = conn.createStatement();//Execute a query
		    String ddl1,ddl2;
		    ddl1 = "INSERT INTO city VALUES ('Castle Black', 'Night Wacth',"
		    		+ "'Castle Black is the primary headquarters and redoubt of the Night Watch. It is located roughly halfway along the length of the Wall on its southern side, at the northern end of the Kingsroad. It is a dark and chilling home to its garrison.');";
		    stmt.executeUpdate(ddl1);
		    ddl1 = "INSERT INTO city VALUES ('Winterfell', 'Stark',"
		    		+ "'Winterfell is the seat of House Stark. It is a very large castle located at the center of the North, from where the head of House Stark rules over his people. A small Godswood is enclosed within the walls. It is the capital of the North under King Robb Stark. The castle is located alongside the Kingsroad as it makes its way from the Wall to the capital at Kings Landing, more than a thousand miles to the south. It is situated atop hot springs which keep the castle warm even in the worst winters.[1] Winding tombs below the castle contain the remains of Stark kings and lords and record the history of the ancient family.');";
		    stmt.executeUpdate(ddl1);
		    ddl1 = "INSERT INTO city VALUES ('The Twins', 'Frey',"
		    		+ "'The Twins consist of two identical stone castles standing on a margin of the Green Fork of the Trident. They have high curtain walls, deep moats and a barbican and portcullis in each. A stone bridge arches between them, with the bridge footings rising from within the inner keeps. This bridge is wide enough for two wagons to cross abreast, and is guarded by a tower in the middle known as the Water Tower. It is the only crossing point over the Green Fork for hundreds of miles in either direction, from the North to the western riverlands. It lies directly athwart the main route from Winterfell to Riverrun.');";
		    stmt.executeUpdate(ddl1);
		    ddl1 = "INSERT INTO city VALUES ('Eyrie', 'Arryn',"
		    		+ "'The Eyrie is the principal stronghold of House Arryn. It is located in the Vale of Arryn near the east coast of Westeros. The Eyrie straddles the top of a peak in the Mountains of the Moon several thousand feet above the valley floor below. It is approached by a narrow causeway and road. Those who would approach the Eyrie must pass through three way-castles guarding the ascent - and then, must proceed in single file, making them very vulnerable to archers. For these reasons, the Eyrie is considered impregnable to any attack that does not involve dragons.');";
		    stmt.executeUpdate(ddl1);
		    ddl1 = "INSERT INTO city VALUES ('Pyke', 'Greyjoy',"
		    		+ "'Pyke is the stronghold and seat of House Greyjoy, located on the island of the same name, which is one of the seven major Iron Islands. The castle is the regional capital of the Iron Islands as a whole. Pyke is an ancient stronghold and the cliff it was built on has been eroded by the sea leaving the towers standing on stone stacks. The towers are connected by swaying rope bridges. The rocky moss covered stone at its base is not suitable for ships landing so traffic to the island flows through the nearby harbor town Lordsport.');";
		    stmt.executeUpdate(ddl1);
		    ddl1 = "INSERT INTO city VALUES ('RiverRun', 'Tully',"
		    		+ "'Riverrun is the former seat of House Tully, who continue to hold it in defiance of the Iron Throne and its new lawful rulers, House Frey. It is a large castle located in the central-western part of the Riverlands. It sits at the point where the Red Fork of the Trident River is joined by its major tributary, the Tumblestone River flowing out of the west. In times of danger, sluice gates can be opened to flood a channel cut to the west of the castle, turning Riverrun into an island. Its walls rise sheer from the waters and its towers command the opposite shores, making assaulting it almost impossible without huge casualties.');";
		    stmt.executeUpdate(ddl1);
		    ddl1 = "INSERT INTO city VALUES ('Kings Landing', 'King',"
		    		+ "'Kings Landing is the capital of the Seven Kingdoms. It is located on the east coast of Westeros in the Crownlands, overlooking Blackwater Bay. It is the site of the Iron Throne and the Red Keep, the seat of the King of the Andals and the First Men. The walled city is located on uplands just north of where the Blackwater Rush flows into Blackwater Bay. It enjoys a warm climate and life there is luxurious for those that can afford it, although it is not without its slums such as Flea Bottom. The city is overpopulated and dangerous at the best of times, despite being policed by a City Watch.');";
		    stmt.executeUpdate(ddl1);
		    ddl1 =  "INSERT INTO city VALUES ('Casterly Rock', 'Lannister',"
		    		+ "'Casterly Rock is the ancestral stronghold of House Lannister. It is located on the Western coast of Westeros on a rocky promontory overlooking the Sunset Sea. It overlooks the major city of Lannisport. A major goldmine is located under Casterly Rock. It is one of the most productive in the realm and provides House Lannister with their wealth.');";
		    stmt.executeUpdate(ddl1);
		    ddl1 = "INSERT INTO city VALUES ('Highgarden', 'Tyrell',"
		    		+ "'Highgarden is the seat of House Tyrell and the regional capital of the Reach. Located on the banks of the river Mander, Highgarden sits astride the Roseroad, a major thoroughfare linking Oldtown and Kings Landing. Highgarden also forms the southern terminus of the the Searoad, which leads to Lannisport. As Kings Landing, Oldtown, and Lannisport are the first, second, and third largest cities in the realm, heavy trade and traffic across a large swath of southern Westeros ultimately passes through Highgarden.');";
		    stmt.executeUpdate(ddl1);
		    ddl2 = "INSERT INTO travel VALUES ('Castle Black', 'Winterfell','road', 680);";
		    stmt.executeUpdate(ddl2);
		    ddl2 = "INSERT INTO travel VALUES ('Winterfell', 'Castle Black','road', 680);";
		    stmt.executeUpdate(ddl2);
		    ddl2 = "INSERT INTO travel VALUES ('The Twins', 'Winterfell','road', 1120);";
		    stmt.executeUpdate(ddl2);
		    ddl2 = "INSERT INTO travel VALUES ('Winterfell', 'The Twins', 'road', 1120);";
		    stmt.executeUpdate(ddl2);
		    ddl2 = "INSERT INTO travel VALUES ('Eyrie', 'The Twins', 'road', 930);";
		    stmt.executeUpdate(ddl2);
		    ddl2 = "INSERT INTO travel VALUES ('The Twins', 'Eyrie', 'road', 930);";
		    stmt.executeUpdate(ddl2);
		    ddl2 = "INSERT INTO travel VALUES ('The Twins', 'RiverRun', 'road', 495);";
		    stmt.executeUpdate(ddl2);
		    ddl2 = "INSERT INTO travel VALUES ('RiverRun', 'The Twins', 'road', 495);";
		    stmt.executeUpdate(ddl2);
		    ddl2 = "INSERT INTO travel VALUES ('Casterly Rock', 'RiverRun', 'road', 590);";
		    stmt.executeUpdate(ddl2);
		    ddl2 = "INSERT INTO travel VALUES ('RiverRun', 'Casterly Rock', 'road', 590);";
		    stmt.executeUpdate(ddl2);
		    ddl2 = "INSERT INTO travel VALUES ('Casterly Rock', 'Kings Landing', 'road', 470);";
		    stmt.executeUpdate(ddl2);
		    ddl2 = "INSERT INTO travel VALUES ('Kings Landing', 'Casterly Rock', 'road', 470);";
		    stmt.executeUpdate(ddl2);
		    ddl2 = "INSERT INTO travel VALUES ('Highgarden', 'Kings Landing', 'road', 915);";
		    stmt.executeUpdate(ddl2);
		    ddl2 = "INSERT INTO travel VALUES ('Kings Landing', 'Highgarden', 'road', 915);";
		    stmt.executeUpdate(ddl2);
		    ddl2 = "INSERT INTO travel VALUES ('Highgarden', 'Casterly Rock', 'road', 730);";
		    stmt.executeUpdate(ddl2);
		    ddl2 = "INSERT INTO travel VALUES ('Casterly Rock', 'Highgarden', 'road', 730);";
		    stmt.executeUpdate(ddl2);
		    ddl2 = "INSERT INTO travel VALUES ('Pyke', 'Casterly Rock', 'sea', 700);";
		    stmt.executeUpdate(ddl2);
		    ddl2 = "INSERT INTO travel VALUES ('Casterly Rock', 'Pyke', 'sea', 700);";
		    stmt.executeUpdate(ddl2);
		    ddl2 = "INSERT INTO travel VALUES ('The Twins', 'Pyke', 'sea', 720);";
		    stmt.executeUpdate(ddl2);
		    ddl2 = "INSERT INTO travel VALUES ('Pyke', 'The Twins', 'sea', 720);";
		    stmt.executeUpdate(ddl2);
		    ddl2 = "INSERT INTO travel VALUES ('The Twins', 'Kings Landing', 'road', 1070);";
		    stmt.executeUpdate(ddl2);
		    ddl2 = "INSERT INTO travel VALUES ('Kings Landing', 'The Twins', 'road', 1070);";
		    stmt.executeUpdate(ddl2);
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
		     System.out.println("Data have been inserted.");
	}
	
	public static void buildTable(){
		Connection conn = null;
		Statement stmt = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");//Register JDBC driver
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL,USER,PASS);//Open a connection
			System.out.println("Creating statement...");
		    stmt = conn.createStatement();//Execute a query
		    String ddl1,ddl2;
		    ddl1 = "create table city "
		    		+ "(name		   varchar(30) not null,"
		    		+ " owner		   varchar(30) not null,"
		    		+ " description    LONGTEXT not null,"
		    		+ " primary key (name));";
		    ddl2 = "create table travel"
		    		+ "(start		  varchar(30) not null,"
		    		+ "end			  varchar(30) not null,"
		    		+ "type           varchar(30) not null,"
		    		+ "distance       Integer check (distance > 0),"
		    		+ "primary key (start,end));";
		    stmt.executeUpdate(ddl1);
		    stmt.executeUpdate(ddl2);
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
		     System.out.println("Tables have been built.");
	}

}
