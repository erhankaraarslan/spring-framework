<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title>KARAARSLAN Company Home Page</title>
</head>

<body>
	<h2>KARAARSLAN Company Home Page - Yoohoo - Silly Goose - NO
		SOUP!!!</h2>
	<hr>
	<p>Welcome to the KARAARSLAN company home page!</p>

	<!-- Add a logout button -->

	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">
		<input type="submit" value="Logout" />

	</form:form>


</body>
</html>