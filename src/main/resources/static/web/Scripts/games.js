var userData = [];

$.getJSON( "/api/games", function( data ) {
    $("#games").html(data.games.map(mapGame).join(""));


    data.games.forEach(mapUsers);
    console.table(userData);



    $("#userlist").html(userData.map(mapearTabla).join(""));






});





function mapGame(game){
    return "<li>" + game.creation + ", " + game.players[0].player.name+ ", " + game.players[1].player.name+ "</li>"
}


function mapUsers(game){

   game.players.forEach(function(gameplayer){

    var indiceScore = userData.findIndex(findUserData,gameplayer.player.name);
    if(indiceScore < 0){
        var score = {};

        score.mail = gameplayer.player.name;

        if(gameplayer.score == 1.0){
            score.win = 1;
            score.tie = 0;
            score.lost = 0;
            score.total = gameplayer.score;
        }else if(gameplayer.score == 0.5) {
            score.win = 0;
            score.tie = 1;
            score.lost = 0;
            score.total = gameplayer.score;
        }else if(gameplayer.score == 0){
            score.win = 0;
            score.tie = 0;
            score.lost = 1;
            score.total = gameplayer.score;
        }

        userData.push(score)
    }
    else{
        if(gameplayer.score == 1.0){
            userData[indiceScore].win += 1;
            userData[indiceScore].total += gameplayer.score;
        }else if(gameplayer.score == 0.5) {
            userData[indiceScore].tie += 1;
            userData[indiceScore].total += gameplayer.score;
        }else if(gameplayer.score == 0){
            userData[indiceScore].lost += 1;
            userData[indiceScore].total += gameplayer.score;
        }
    }

   });

}


function findUserData(userData){
    return userData.mail == this;
}

function mapearTabla(userData) {
return "<tr><td>" + userData.mail + "</td><td>" + userData.win + "</td><td>" + userData.tie + "</td><td>" + userData.lost + "</td><td>" + userData.total + "</td></tr>"
}



function login(evt) {
  evt.preventDefault();
  $.post("/api/login", { name: form["username"].value, pwd: form["password"].value}).done(function() { console.log("logged in!"); })
};


function logout(evt) {
  evt.preventDefault();
  $.post("/app/logout")
   ;
}
