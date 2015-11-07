<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.ESportPlayers"%>
<% ESportPlayers player = (ESportPlayers) request.getAttribute("player"); %>

<!DOCTYPE html>
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>Update A Player</title>
      <link rel="stylesheet" type="text/css" href="./main.css" />
   </head>
   <body>
      <div class="wrap">
      <%@ include file="includes/header.jsp" %>
      <%@ include file="includes/menu.jsp" %>
      <h1>Update A Player Record</h1>
      
      <form name="updateForm" action="updatePlayer" method="get">
         
         <label>Player ID:</label>
         <input tpye="text" name="playerID" value="<%= player.getPlayerID() %>" readonly/>
         <br><br>
         <label>Player Ingame ID:</label>
         <input tpye="text" name="playerInGameID" value="<%= player.getPlayerInGameID() %>" />
         <br><br>
         <label>Player Name:</label>
         <input tpye="text" name="playerName" value="<%= player.getPlayerName() %>" />
         <br><br>
         <label>Total Income:</label>
         <input tpye="text" name="totalIncome" value="<%= player.getTotalIncome() %>" />
         <br><br>
         <label>Playing Game:</label>
         <input tpye="text" name="playingGame" value="<%= player.getPlayingGame() %>" />
         <br><br>
         <input type="reset" name="reset" value="Clear" />
         <input type="submit" name="submit" value="Update" />
         
         
      </form>
      <%@ include file="includes/footer.jsp" %>
      </div>  
   </body>
</html>
