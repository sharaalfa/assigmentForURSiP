<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Менеджер отчетов</title>
</head>
<body>
<div align="center">
    <h1>Выборка</h1>
    <table border="1">
        <th>Article_Name</th>
        <th>Count_Official_Text</th>
        <th>Count_English_Text</th>


        <c:forEach var="list" items="${listTypes}" varStatus="status">
            <tr>
                <td>${list.name}</td>
                <td>${list.officialText}</td>
                <td>${list.engText}</td>


            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
