
$.getJSON( "http://localhost:8080/api/games", function( data ) {
    $("#games").html(data.map(mapGame).join(""));
    $("#userlist").html(data.map(mapUsers).join(""));
    $("#scores").html(data.map(mapear).join(""));





});

function mapGame(game){
    return "<li>" + game.creation + ", " + game.players[0].player.username+ ", " + game.players[1].player.username+ "</li>"
}

function mapUsers(game){
    return "<li>" + game.players[0].player.username + "</li>"
}

function mapScore(game){
    return console.log(game)


}


function mapear(game) {

    var jugadores = game.players;

    for (var i = 0; i < jugadores.length; i++) {
        console.log(jugadores)
    }




}
