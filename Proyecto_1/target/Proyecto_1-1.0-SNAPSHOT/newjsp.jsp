<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Pàgina JSP</title>
<script src="exemple.js" type="text/javascript"></script>
<link href="estils.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div>Hola, Món!</div>
<button onclick="hola();" value="salutació">salutació</button>
<p>Avui és <%= new java.util.Date() %> </p>
</body>
</html>
