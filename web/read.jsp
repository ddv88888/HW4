<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>JSP Page</title>
      <link rel="stylesheet" type="text/css" href="./main.css" />
   </head>
   
   <% String table = (String) request.getAttribute("table"); %>
   
   <body>
      <h1>E-sports Players 2015 Income</h1>
      <%= table %>
      <br><br>
      <div>
         <a href ="add">Add A New Friend</a>
      </div>
      
   </body>
</html>
