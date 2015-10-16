
package model;


public class ESportPlayers {
   private int playerID;
   private String playerInGameID;
   private String playerName;
   private int totalIncome;
   private String playingGame;
   
   public ESportPlayers() {
      this.playerID = 0;
      this.playerInGameID = "";
      this.playerName = "";
      this.totalIncome = 0;
      this.playingGame = "";
   }
   
   
   
   public ESportPlayers(int playerID, String playerInGameID, String playerName, int totalIncome, String playingGame) {
      this.playerID = playerID;
      this.playerInGameID = playerInGameID;
      this.playerName = playerName;
      this.totalIncome = totalIncome;
      this.playingGame = playingGame;
   }

   public int getPlayerID() {
      return playerID;
   }

   public void setPlayerID(int playerID) {
      this.playerID = playerID;
   }

   public String getPlayerInGameID() {
      return playerInGameID;
   }

   public void setPlayerInGameID(String playerInGameID) {
      this.playerInGameID = playerInGameID;
   }

   public String getPlayerName() {
      return playerName;
   }

   public void setPlayerName(String playerName) {
      this.playerName = playerName;
   }

   public int getTotalIncome() {
      return totalIncome;
   }

   public void setTotalIncome(int totalIncome) {
      this.totalIncome = totalIncome;
   }

   public String getPlayingGame() {
      return playingGame;
   }

   public void setPlayingGame(String playingGame) {
      this.playingGame = playingGame;
   }

   @Override
   public String toString() {
      return "ESportPlayers{" + "playerID=" + playerID + ", playerInGameID=" + playerInGameID + ", playerName=" + playerName + ", totalIncome=" + totalIncome + ", playingGame=" + playingGame + '}';
   }
   
   
}
