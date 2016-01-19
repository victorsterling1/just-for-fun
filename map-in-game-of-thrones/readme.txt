This project is just for jun.

Base on the map of Westeros, which is the continent in the game of thrones TV shows, I build travel path recommendation system to find the shortest path between two main cities and calculate the distance.

This system will provide you information about your destination— owner, history and etc. In addition, it will also provide the shortest path and the distance. 

Thanks to wiki of games of thrones, and other guys’ help, I collected enough information to build the map.

First, in the DataBase.java, I constructed the database of relevant information of the map through JDBC in MySQL database.

Second, through Dijkstra's algorithm, I figure out the shortest path between cities and distance.