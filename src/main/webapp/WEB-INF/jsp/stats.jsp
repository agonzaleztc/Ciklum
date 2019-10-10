<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <title>Rock Paper Scissors</title>
</head>

<body>

<h1>Rock Paper Scissors</h1>
<h2><a href="/">Index</a> <a href="/stats">Stats</a></h2>
<h3 style="text-align: center">Global stats</h3>

<c:if test="${stats != null}">
    <table class="table table-bordered" style="width: 30%;margin: 0 auto">
        <tr>
            <td>Total played rounds</td>
            <td>${stats.totalPlayedRounds}</td>
        </tr>
        <tr>
            <td>Total Player 1 wins</td>
            <td>${stats.totalPlayer1Wins}</td>
        </tr>
        <tr>
            <td>Total Player 2 wins</td>
            <td>${stats.totalPlayer2Wins}</td>
        </tr>
        <tr>
            <td>Total draws</td>
            <td>${stats.totalDraws}</td>
        </tr>
    </table>
</c:if>

</body>
</html>
