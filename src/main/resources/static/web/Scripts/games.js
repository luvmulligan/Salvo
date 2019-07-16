var userData = [];
var playerOne = null;

$.getJSON( "/api/games", function( data ) {
    playerOne = data.player;
    $("#games").html(data.games.map(mapGame).join(""));
    if(playerOne == null){
        $("#login-form").removeClass("hidden");
          $("#logout").addClass("hidden");

    };

    data.games.forEach(mapUsers);
    console.table(userData);



    $("#userlist").html(userData.map(mapearTabla).join(""));





});





function mapGame(game){
    var listGame = "<li>" + game.creation + "<ul>";
    game.players.forEach(function(gamePlayer){
        if(playerOne != null && playerOne.id === gamePlayer.player.id)
            listGame += "<li> " + gamePlayer.player.name + '<a href="game.html?gp=' + gamePlayer.gpid + '"><button data-name=' + gamePlayer.gpid + "> Enter Game </button></a></li>";
        else
            listGame += "<li> " + gamePlayer.player.name + "</li>";
    })
    listGame += "</ul></li>";
    return listGame;


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
  var form = evt.target.form;
  $.post("/api/login",
         { name: form["username"].value,
           pwd: form["password"].value })
   .done(function() { location.reload();});
}

function signUp(evt) {
  evt.preventDefault();
  var form = evt.target.form;
  $.post("/api/players",
         { name: form["username"].value,
           pwd: form["password"].value })
   .done(function() { location.reload(); console.log("logged in!")})
   .fail(function() { alert("name already in use")}

   );
}

function logout(evt) {
  evt.preventDefault();
  var form = evt.target.form;
 $.post("/api/logout").done(function() { console.log("logged out") });
 location.reload();

}

function createGame(event){
event.preventDefault();
var button = event.target.button;
 $.post("/api/games").done(function(data) {
    location.href = "game.html?gp=" +  data.gpid;
 })
 console.log("new game created")

 };





