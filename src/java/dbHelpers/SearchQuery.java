package dbHelpers;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ESportPlayers;


public class SearchQuery {
   
   private Connection conn;
   private ResultSet results;
   
   public SearchQuery(){
      
      Properties props = new Properties();
      InputStream instr = getClass().getResourceAsStream("dbConn.properties");
         try {
            props.load(instr);
         } catch (IOException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
         }
         try {
            instr.close();
         } catch (IOException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
         }
      
      String driver = props.getProperty("driver.name");
      String url = props.getProperty("server.name");
      String username = props.getProperty("user.name");
      String passwd = props.getProperty("user.password");
      try {
         Class.forName(driver);
      } catch (ClassNotFoundException ex) {
         Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
      }
      try {
         conn = DriverManager.getConnection(url, username, passwd);
      } catch (SQLException ex) {
         Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
      }
      
   }
   
   public void doSearch(String playerInGameID){
      
      try {
         String query = "SELECT * FROM ESPORTPLAYERS WHERE UPPER(playerInGameID) LIKE ? ORDER BY playerID ASC";
         
         PreparedStatement ps = conn.prepareStatement(query);
         ps.setString(1, "%" + playerInGameID.toUpperCase() + "%");
         this.results = ps.executeQuery();
      } catch (SQLException ex) {
         Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
      }
      
   }
   
   public String getHTMLtable(){
      
      String table = "";
      table += "<table>";
      
      try {
         table += "<tr>";
         
            table += "<th>";
            table += "ID";
            table += "</th>";
            
            table += "<th>";
            table += "In Game ID";
            table += "</th>";
            
            table += "<th>";
            table += "Player Name";
            table += "</th>";
            
            table += "<th>";
            table += "TotalIncome($)";
            table += "</th>";
            
            table += "<th>";
            table += "PlayingGame";
            table += "</th>";
            
            table += "<th>";
            table += "";
            table += "</th>";
            
            table += "</tr>";
         while(this.results.next()){
            
            ESportPlayers eSportPlayers = new ESportPlayers();
            eSportPlayers.setPlayerID(this.results.getInt("playerID"));
            eSportPlayers.setPlayerInGameID(this.results.getString("playerInGameID"));
            eSportPlayers.setPlayerName(this.results.getString("playerName"));
            eSportPlayers.setTotalIncome(this.results.getInt("totalIncome"));
            eSportPlayers.setPlayingGame(this.results.getString("playingGame"));
            
            table += "<tr>";
            
            table += "<td>";
            table += eSportPlayers.getPlayerID();
            table += "</td>";
            
            table += "<td>";
            table += eSportPlayers.getPlayerInGameID();
            table += "</td>";
            
            table += "<td>";
            table += eSportPlayers.getPlayerName();
            table += "</td>";
            
            table += "<td>";
            table += eSportPlayers.getTotalIncome();
            table += "</td>";
            
            table += "<td>";
            table += eSportPlayers.getPlayingGame();
            table += "</td>";
            
            table += "<td>";
            table += "<a href=update?playerID=" + eSportPlayers.getPlayerID() + "> Update </a>" + "<a href=delete?playerID=" + eSportPlayers.getPlayerID() + "> Delete </a>";
            table += "</td>";
            
            table += "</tr>";
         }
      } catch (SQLException ex) {
         Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
      }
      
      
      table += "</table>";
         return table;
   }
   
   
   
}
