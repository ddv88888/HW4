
package dbHelpers;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ESportPlayers;

public class ReadRecord {
   
   private Connection conn;
   private ResultSet results;
   private ESportPlayers player = new ESportPlayers();
   private int playerID;
   
   public ReadRecord(int playerID){
   
      Properties props = new Properties();
      InputStream instr = getClass().getResourceAsStream("dbConn.properties"); 
      try {
         props.load(instr);
      } catch (IOException ex) {
         Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
      }
      try {
         instr.close();
      } catch (IOException ex) {
         Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
      }
      
      String driver = props.getProperty("driver.name");
      String url = props.getProperty("server.name");
      String username = props.getProperty("user.name");
      String passwd = props.getProperty("user.password");
      
      this.playerID = playerID; 
      
      try {
         Class.forName(driver);
      } catch (ClassNotFoundException ex) {
         Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
      }
      try {
         conn = DriverManager.getConnection(url, username, passwd);
      } catch (SQLException ex) {
         Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
      }
   }
   
   public void doRead(){
     try {
         String query = "SELECT * FROM ESportPlayers WHERE playerID = ?";
         
         PreparedStatement ps = conn.prepareStatement(query);
         
         ps.setInt(1, playerID);
         
         this.results = ps.executeQuery();
         this.results.next();
         player.setPlayerID(this.results.getInt("playerID"));
         player.setPlayerInGameID(this.results.getString("playerInGameID"));
         player.setPlayerName(this.results.getString("playerName"));
         player.setTotalIncome(this.results.getInt("totalIncome"));
         player.setPlayingGame(this.results.getString("playingGame"));
      } catch (SQLException ex) {
         Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
      }
  }

   public ESportPlayers getPlayer(){
      return this.player;
   }




}
      
      
      
   
   
      
   
   
   
   

   
  