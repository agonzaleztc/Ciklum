<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <script src="js/rps.js"></script>
    <title>Rock Paper Scissors</title>
</head>

<body>

<h1>Rock Paper Scissors</h1>
<h2><a href="/">Index</a> <a href="/stats">Stats</a></h2>

<div class="row">
    <div class="col-lg-8">
        <div id="round">
            <table class="table table-bordered">
                <thead>
                <td>Player 1</td>
                <td>Player 2</td>
                <td>Result</td>
                </thead>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
            </table>
        </div>
        <form action="javascript:play()">
            <button type="submit" class="btn">Play Round</button>
        </form>
    </div>
    <div class="col-lg-4">
        <div>
            <table id="rounds-table" class="table table-striped">
                <tr>
                    <td>Played rounds</td>
                    <td id="played-rounds">0</td>
                </tr>
            </table>
        </div>
        <div>
            <table id="games-table" class="table table-striped">
                <thead>
                <td>Player 1</td>
                <td>Player 2</td>
                <td>Result</td>
                </thead>
                <tr hidden>
                </tr>
            </table>
        </div>
        <form action="javascript:restartGame()">
            <button type="submit" class="btn">Restart Game</button>
        </form>
    </div>
</div>

</body>
</html>
