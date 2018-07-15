<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Flights</title>
</head>

<body>
    <h2>Flights:</h2>
    <table>
        <tr>
        <th>Airlines</th>
        <th>Departure City</th>
        <th>Arribal City</th>
        <th>Departure Time</th>
        <th>Airlines</th>
        </tr>
        <c:forEach items="${flights}" var="flight">
        <tr>
            <td>${flight.operatingAirlines}</td>
            <td>${flight.departureCity}</td>
            <td>${flight.arrivalCity}</td>
            <td>${flight.dateOfDeparture}</td>
            <td><a href="reservationComplete?flightId=${flight.id}">Select</a> </td>
        </tr>
        </c:forEach>
    </table>


</body>

</html>