<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<form action="../action/login" method="get">
    Starbuck's ${roast} Roast Coffees:
    <table>
        <c:forEach var="advice" items="${advices}" varStatus="count">
            <c:if test="${count.count%2 == 0}">
                <tr style="background-color: cyan">
            </c:if>
            <c:if test="${count.count%2 != 0}">
                <tr style="background-color: yellow">
            </c:if>
            <td>
                ${advice}
            </td>
                </tr>
        </c:forEach>
    </table>
    <input type="submit" value="Back">
</form>
</body>
</html>
