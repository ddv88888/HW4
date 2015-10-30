<%-- 
    Document   : add
    Created on : 2015-10-30, 2:19:20
    Author     : JIYUAN JIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>Add A New Player</title>
      <link rel="stylesheet" type="text/css" href="./main.css" />
   </head>
   <body>
      <h1>Add A New Player</h1>
      
      <form name="addForm" action="addPlayer" method="get">
         
         <label>Player Ingame ID:</label>
         <input tpye="text" name="playerInGameID" value="" />
         <br><br>
         <label>Player Name:</label>
         <input tpye="text" name="playerName" value="" />
         <br><br>
         <label>Total Income:</label>
         <input tpye="text" name="totalIncome" value="" />
         <br><br>
         <label>Playing Game:</label>
         <input tpye="text" name="playingGame" value="" />
         <br><br>
         <input type="reset" name="reset" value="Clear" />
         <input type="submit" name="submit" value="Submit" />
         
         
      </form>
   </body>
</html>
