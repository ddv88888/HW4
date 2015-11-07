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
      <div class="wrap">
      <%@ include file="includes/header.jsp" %>
      <%@ include file="includes/menu.jsp" %>
      <h1>E-sports Players 2015 Income</h1>
      <%= table %>
      <%@ include file="includes/footer.jsp" %>
      </div>
   </body>
</html>
