<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<title>TestURSiP webapp</title>
</head>

<body>
<h2>Выборка по типам</h2>

<form:form method="POST" commandName="types">
	<table>
		<tr>
			<td>Типы</td>
			<td><form:select path="typeName" multiple="true" size="1">
				<form:options items="${typesList}"/>
			</form:select>
			</td>
			<td><form:errors path="typeName" cssStyle="color: #ff0000;" /></td>
		</tr>
		<tr>
			<td><input type="submit" name="submit" value="Поиск"></td>
		</tr>
		<tr>
	</table>
</form:form>

</body>
</html>