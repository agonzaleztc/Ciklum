var rounds = new Array();

function play() {
    var url = "/play";
    $.ajax({
        url: url,
        success: function (data) {
            rounds.push($("#round-results").val());
            $("#played-rounds").html(rounds.length);
            $("#games-table").append("<tr class='round'>" +
                "<td>" + data.player1 + "</td>" +
                "<td>" + data.player2 + "</td>" +
                "<td>" + data.roundStatus + "</td>" +
                "</tr>");
            showRound(data);
        },
        error: function (jqXHR) {
            alert("Error" + jqXHR)
        }
    });
}

function showRound(roundResults) {
    $("#round").html('<table class="table table-bordered">' +
        '<thead>' +
        '<td>Player 1</td>' +
        '<td>Player 2</td>' +
        '<td>Result</td>' +
        '</thead>' +
        '<tr>' +
        '<td>' + roundResults.player1 + '</td>' +
        '<td>' + roundResults.player2 + '</td>' +
        '<td>' + roundResults.roundStatus + '</td>' +
        '</tr>' +
        '</table>');
}

function restartGame() {
    rounds = new Array();
    $("#played-rounds").html("0");
    $(".round").remove();
}