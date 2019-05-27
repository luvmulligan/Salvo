
$.getJSON( "http://localhost:8080/api/games", function( data ) {
    $("#games").html(data.map(mapGame).join(""));
});

function mapGame(game){
    return "<li>" + game.creation + ", " + game.players[0].player.username+ ", " + game.players[1].player.username+ "</li>"
}