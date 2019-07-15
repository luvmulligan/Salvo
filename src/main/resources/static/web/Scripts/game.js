var player = '';

var enemy = '';

$(document).ready(function () {
    $("#grid1 tbody").append(
        "<tr>" + "<th></th>" + "<th>1</th>" + "<th>2</th>" + "<th>3</th>" + "<th>4</th>"
        + "<th>5</th>" + "<th>6</th>" + "<th>7</th>"
        + "<th>8</th>" + "<th>9</th>" + "<th>10</th>"+
        "</tr>" +
        //Primera fila
        "<tr>"+"<td>A</td>" + "<td id='A1'></td>" + "<td id='A2'></td>" + "<td id='A3'></td>" + "<td id='A4'></td>" + "<td id='A5'></td>" + "<td id='A6'></td>" + "<td id='A7'></td>" + "<td id='A8'></td>"+ "<td id='A9'></td>" + "<td id='A10'></td>"+
        "</tr>"+
        //Segunda fila
        "<tr>" +"<td>B</td>"+"<td id='B1'></td>" + "<td id='B2'></td>" + "<td id='B3'></td>" + "<td id='B4'></td>" + "<td id='B5'></td>" + "<td id='B6'></td>" + "<td id='B7'></td>" + "<td id='B8'></td>"+ "<td id='B9'></td>" + "<td id='B10'></td>" +
        "</tr>"+
        //Tercer fila
        "<tr>" +"<td>C</td>"+"<td id='C1'></td>" + "<td id='C2'></td>" + "<td id='C3'></td>" + "<td id='C4'></td>" + "<td id='C5'></td>" + "<td id='C6'></td>" + "<td id='C7'></td>" + "<td id='C8'></td>"+ "<td id='C9'></td>" + "<td id='C10'></td>" + +
        "</tr>"+
        //Cuarta fila
        "<tr>" +"<td>D</td>"+"<td id='D1'></td>" + "<td id='D2'></td>" + "<td id='D3'></td>" + "<td id='D4'></td>" + "<td id='D5'></td>" + "<td id='D6'></td>" + "<td id='D7'></td>" + "<td id='D8'></td>"+ "<td id='D9'></td>" + "<td id='D10'></td>" +
        "</tr>"+
        //Quinta Fila
        "<tr>" +"<td>E</td>"+"<td id='E1'></td>" + "<td id='E2'></td>" + "<td id='E3'></td>" + "<td id='E4'></td>" + "<td id='E5'></td>" + "<td id='E6'></td>" + "<td id='E7'></td>" + "<td id='E8'></td>"+ "<td id='E9'></td>" + "<td id='E10'></td>" +
         "</tr>"+
        //Sexta fila
        "<tr>" +"<td>F</td>"+"<td id='F1'></td>" + "<td id='F2'></td>" + "<td id='F3'></td>" + "<td id='F4'></td>" + "<td id='F5'></td>" + "<td id='F6'></td>" + "<td id='F7'></td>" + "<td id='F8'></td>"+ "<td id='F9'></td>" + "<td id='F10'></td>" +
        "</tr>"+
        //Septima fila
        "<tr>" +"<td>G</td>"+"<td id='G1'></td>" + "<td id='G2'></td>" + "<td id='G3'></td>" + "<td id='G4'></td>" + "<td id='G5'></td>" + "<td id='G6'></td>" + "<td id='G7'></td>" + "<td id='G8'></td>"+ "<td id='G9'></td>" + "<td id='G10'></td>" +
        "</tr>"+
        //Octava fila
        "<tr>" +"<td>H</td>"+"<td id='H1'></td>" + "<td id='H2'></td>" + "<td id='H3'></td>" + "<td id='H4'></td>" + "<td id='H5'></td>" + "<td id='H6'></td>" + "<td id='H7'></td>" + "<td id='H8'></td>"+ "<td id='H9'></td>" + "<td id='H10'></td>" +
        "</tr>"+
        //Novena fila
        "<tr>" +"<td>I</td>"+"<td id='I1'></td>" + "<td id='I2'></td>" + "<td id='I3'></td>" + "<td id='I4'></td>" + "<td id='I5'></td>" + "<td id='I6'></td>" + "<td id='I7'></td>" + "<td id='I8'></td>"+ "<td id='I9'></td>" + "<td id='I10'></td>" +
        "</tr>"+
        //Decima fila
        "<tr>" +"<td>J</td>"+"<td id='J1'></td>" + "<td id='J2'></td>" + "<td id='J3'></td>" + "<td id='J4'></td>" + "<td id='J5'></td>" + "<td id='J6'></td>" + "<td id='J7'></td>" + "<td id='J8'></td>"+ "<td id='J9'></td>" + "<td id='J10'></td>" +
        "</tr>"


    );
});

$(document).ready(function () {
    $("#grid2 tbody").append(
        "<tr>" + "<th></th>" + "<th>1</th>" + "<th>2</th>" + "<th>3</th>" + "<th>4</th>"
        + "<th>5</th>" + "<th>6</th>" + "<th>7</th>"
        + "<th>8</th>" + "<th>9</th>" + "<th>10</th>"+
        "</tr>" +
        //Primera fila
        "<tr>"+"<td>A</td>" + "<td id='SA1'></td>" + "<td id='SA2'></td>" + "<td id='SA3'></td>" + "<td id='SA4'></td>" + "<td id='SA5'></td>" + "<td id='SA6'></td>" + "<td id='SA7'></td>" + "<td id='SA8'></td>"+ "<td id='SA9'></td>" + "<td id='SA10'></td>"+
        "</tr>"+
        //Segunda fila
        "<tr>" +"<td>B</td>"+"<td id='SB1'></td>" + "<td id='SB2'></td>" + "<td id='SB3'></td>" + "<td id='SB4'></td>" + "<td id='SB5'></td>" + "<td id='SB6'></td>" + "<td id='SB7'></td>" + "<td id='SB8'></td>"+ "<td id='SB9'></td>" + "<td id='SB10'></td>" +
        "</tr>"+
        //Tercer fila
        "<tr>" +"<td>C</td>"+"<td id='SC1'></td>" + "<td id='SC2'></td>" + "<td id='SC3'></td>" + "<td id='SC4'></td>" + "<td id='SC5'></td>" + "<td id='SC6'></td>" + "<td id='SC7'></td>" + "<td id='SC8'></td>"+ "<td id='SC9'></td>" + "<td id='SC10'></td>" + +
            "</tr>"+
        //Cuarta fila
        "<tr>" +"<td>D</td>"+"<td id='SD1'></td>" + "<td id='SD2'></td>" + "<td id='SD3'></td>" + "<td id='SD4'></td>" + "<td id='SD5'></td>" + "<td id='SD6'></td>" + "<td id='SD7'></td>" + "<td id='SD8'></td>"+ "<td id='SD9'></td>" + "<td id='SD10'></td>" +
        "</tr>"+
        //Quinta Fila
        "<tr>" +"<td>E</td>"+"<td id='SE1'></td>" + "<td id='SE2'></td>" + "<td id='SE3'></td>" + "<td id='SE4'></td>" + "<td id='SE5'></td>" + "<td id='SE6'></td>" + "<td id='SE7'></td>" + "<td id='SE8'></td>"+ "<td id='SE9'></td>" + "<td id='SE10'></td>" +
        "</tr>"+
        //Sexta fila
        "<tr>" +"<td>F</td>"+"<td id='SF1'></td>" + "<td id='SF2'></td>" + "<td id='SF3'></td>" + "<td id='SF4'></td>" + "<td id='SF5'></td>" + "<td id='SF6'></td>" + "<td id='SF7'></td>" + "<td id='SF8'></td>"+ "<td id='SF9'></td>" + "<td id='SF10'></td>" +
        "</tr>"+
        //Septima fila
        "<tr>" +"<td>G</td>"+"<td id='SG1'></td>" + "<td id='SG2'></td>" + "<td id='SG3'></td>" + "<td id='SG4'></td>" + "<td id='SG5'></td>" + "<td id='SG6'></td>" + "<td id='SG7'></td>" + "<td id='SG8'></td>"+ "<td id='SG9'></td>" + "<td id='SG10'></td>" +
        "</tr>"+
        //Octava fila
        "<tr>" +"<td>H</td>"+"<td id='SH1'></td>" + "<td id='SH2'></td>" + "<td id='SH3'></td>" + "<td id='SH4'></td>" + "<td id='SH5'></td>" + "<td id='SH6'></td>" + "<td id='SH7'></td>" + "<td id='SH8'></td>"+ "<td id='SH9'></td>" + "<td id='SH10'></td>" +
        "</tr>"+
        //Novena fila
        "<tr>" +"<td>I</td>"+"<td id='SI1'></td>" + "<td id='SI2'></td>" + "<td id='SI3'></td>" + "<td id='SI4'></td>" + "<td id='SI5'></td>" + "<td id='SI6'></td>" + "<td id='SI7'></td>" + "<td id='SI8'></td>"+ "<td id='SI9'></td>" + "<td id='SI10'></td>" +
        "</tr>"+
        //Decima fila
        "<tr>" +"<td>J</td>"+"<td id='SJ1'></td>" + "<td id='SJ2'></td>" + "<td id='SJ3'></td>" + "<td id='SJ4'></td>" + "<td id='SJ5'></td>" + "<td id='SJ6'></td>" + "<td id='SJ7'></td>" + "<td id='SJ8'></td>"+ "<td id='SJ9'></td>" + "<td id='SJ10'></td>" +
        "</tr>"


    );
});

function getParameterByName(name) {
    var match = RegExp('[?&]' + name + '=([^&]*)').exec(window.location.search);
    return match && decodeURIComponent(match[1].replace(/\+/g, ' '));
}

var gpID = getParameterByName("gp");

fetch( "/api/game_view/"+gpID).then(function(response) {
    if (response.ok) {
        // add a new promise to the chain
        return response.json();
    }
    // signal a server error to the chain
    throw new Error(response.statusText);

}).then(function(json) {
    if(json.Ships.length <= 0){
        createGrid(false);
        grid.addWidget($('<div id="Battleship"><div class="grid-stack-item-content BattleshipHorizontal"></div><div/>'),
                          0, 0, 4, 1, true);
        grid.addWidget($('<div id="PatrolBoat"><div class="grid-stack-item-content PatrolBoatHorizontal"></div><div/>'),
                                  0, 0, 2, 1, true);
        grid.addWidget($('<div id="Carrier"><div class="grid-stack-item-content CarrierHorizontal"></div><div/>'),
                          0, 0, 5, 1, true);
        grid.addWidget($('<div id="Destroyer"><div class="grid-stack-item-content DestroyerHorizontal"></div><div/>'),
                                  0, 0, 4, 1, true);
        grid.addWidget($('<div id="Submarine"><div class="grid-stack-item-content SubmarineHorizontal"></div><div/>'),
                                  0, 0, 3, 1, true);
        addWidgetEvents(grid);
    }else {
        createGrid(true);
        selectShips(json.Ships);
    }

    gamePlayers(json.Gameplayers);
    shotFired(json.Salvos);

    //shotTaken(json.Salvos);

//Obtain ship locations and print them in the grid

}).catch(function(error) {
    console.log( "Request failed: " + error.message );
});

document.getElementById("date").innerHTML = new Date().toDateString();



function selectShips (Ships){
    Ships.forEach(function(ship){
        console.log(ship);


        ship.locations.forEach(function (location) {
            console.log(location);
            document.getElementById(location).classList.add("selected");

        })
          addWidget(ship);

    })
    addWidgetEvents(grid);
}

function shotFired(Salvos){

    Salvos.forEach(function(salvo){
        console.log(salvo);
        if (player.username == salvo.player.username){
            salvo.locations.forEach(function (location){
                console.log(location);
                    document.getElementById('S'+location).classList.add("fired");

            })
        }else{
            salvo.locations.forEach(function (location){
                console.log(location);
                document.getElementById(location).classList.add("fired");

            })
        }
    })
}



//Obtain players usernames and print in title

function gamePlayers (Gameplayers){
    Gameplayers.forEach(function(gameplayer){
        console.log(gameplayer);
        if(gameplayer.gpid == gpID){
            console.log(gameplayer.player)
            player = gameplayer.player;

            document.getElementById("username1").innerHTML = gameplayer.player.name;
        } else {
            enemy = gameplayer.player;
            document.getElementById("username2").innerHTML = gameplayer.player.name;
        }


})

}


function logout(evt) {
  evt.preventDefault();
  var form = evt.target.form;
 $.post("/api/logout").done(function() { console.log("logged out") });
  window.open("/web/games.html", "_self");


}


function createGrid(staticGrid) {
    var options = {
        //grilla de 10 x 10
        width: 10,
        height: 10,
        //separacion entre elementos (les llaman widgets)
        verticalMargin: 0,
        //altura de las celdas
        cellHeight: 45,
        //desabilitando el resize de los widgets
        disableResize: true,
        //widgets flotantes
		float: true,
        //removeTimeout: 100,
        //permite que el widget ocupe mas de una columna
        disableOneColumnMode: true,
        //false permite mover, true impide
        staticGrid: staticGrid,
        //activa animaciones (cuando se suelta el elemento se ve más suave la caida)
        animate: true
    }
    //se inicializa el grid con las opciones
    $('.grid-stack').gridstack(options);
      grid = $('#grid').data('gridstack');
        //agregando un elmento(widget) desde el javascript


}

function addWidget (ship){
    var searchChar = ship.locations[0].slice(0, 1);
           var secondChar = ship.locations[1].slice(0, 1);
           if ( searchChar === secondChar ) {
               ship.position = "Horizontal";
           } else {
               ship.position = "Vertical";
           }
           for (var i=0; i < ship.locations.length; i++) {
               ship.locations[i] = ship.locations[i].replace(/A/g, '0');
               ship.locations[i] = ship.locations[i].replace(/B/g, '1');
               ship.locations[i] = ship.locations[i].replace(/C/g, '2');
               ship.locations[i] = ship.locations[i].replace(/D/g, '3');
               ship.locations[i] = ship.locations[i].replace(/E/g, '4');
               ship.locations[i] = ship.locations[i].replace(/F/g, '5');
               ship.locations[i] = ship.locations[i].replace(/G/g, '6');
               ship.locations[i] = ship.locations[i].replace(/H/g, '7');
               ship.locations[i] = ship.locations[i].replace(/I/g, '8');
               ship.locations[i] = ship.locations[i].replace(/J/g, '9');
           }
           var yInGrid = parseInt(ship.locations[0].slice(0, 1));
           var xInGrid = parseInt(ship.locations[0].slice(1, 3)) - 1;



                       if (ship.type === "PatrolBoat") {
                       if (ship.position === "Horizontal") {
                       grid.addWidget($('<div id="PatrolBoat"><div class="grid-stack-item-content PatrolBoatHorizontal"></div><div/>'),
                       xInGrid, yInGrid, 2, 1, false);
                       } else if (ship.position === "Vertical") {
                       grid.addWidget($('<div id="PatrolBoat"><div class="grid-stack-item-content PatrolBoatVertical"></div><div/>'),
                       xInGrid, yInGrid, 1, 2, false);
                        }
                     }

                       if (ship.type === "Destroyer") {
                       if (ship.position === "Horizontal") {
                        grid.addWidget($('<div id="Destroyer"><div class="grid-stack-item-content DestroyerHorizontal"></div><div/>'),
                        xInGrid, yInGrid, 3, 1, false);
                        } else if (ship.position === "Vertical") {
                         grid.addWidget($('<div id="Destroyer"><div class="grid-stack-item-content DestroyerVertical"></div><div/>'),
                         xInGrid, yInGrid, 1, 3, false);
                         }
                        }
                        if (ship.type === "Battleship") {
                        if (ship.position === "Horizontal") {
                        grid.addWidget($('<div id="Battleship"><div class="grid-stack-item-content BattleshipHorizontal"></div><div/>'),
                        xInGrid, yInGrid, 4, 1, false);
                        } else if (ship.position === "Vertical") {
                        grid.addWidget($('<div id="Battleship"><div class="grid-stack-item-content BattleshipVertical"></div><div/>'),
                        xInGrid, yInGrid, 1, 4, false);
                   }
                   }
                   if (ship.type === "Submarine") {
                   if (ship.position === "Horizontal") {
                   grid.addWidget($('<div id="Submarine"><div class="grid-stack-item-content SubmarineHorizontal"></div><div/>'),
                   xInGrid, yInGrid, 3, 1, false);
                   } else if (ship.position === "Vertical") {
                  grid.addWidget($('<div id="Submarine"><div class="grid-stack-item-content SubmarineVertical"></div><div/>'),
                 xInGrid, yInGrid, 1, 3, false);
               }
               }
               if (ship.type === "Carrier") {
                if (ship.position === "Horizontal") {
                 grid.addWidget($('<div id="Carrier"><div class="grid-stack-item-content CarrierHorizontal"></div><div/>'),
                  xInGrid, yInGrid, 5, 1, false);
                } else if (ship.position === "Vertical") {
                grid.addWidget($('<div id="Carrier"><div class="grid-stack-item-content CarrierVertical"></div><div/>'),
                xInGrid, yInGrid, 1, 5, false);
             }
             }

}
function addWidgetEvents(grid){
    $(".grid-stack-item").click(function() {
       var h = parseInt($(this).attr("data-gs-height"));
       var w = parseInt($(this).attr("data-gs-width"));
       var posX = parseInt($(this).attr("data-gs-x"));
       var posY = parseInt($(this).attr("data-gs-y"));

       // Rotate Ships Mechanics...

       if (w>h) {
           if ( grid.isAreaEmpty(posX, posY+1, h, w-1) && posX+h<=10 && posY+w<=10 ) {
               grid.update($(this), posX, posY, h, w);
               $(this).children('.grid-stack-item-content').removeClass($(this).attr("id") + 'Horizontal');
                              $(this).children('.grid-stack-item-content').addClass($(this).attr("id") + 'Vertical');
           }

       }
       else if (grid.isAreaEmpty(posX + 1, posY, w, h - 1) && posX + w <= 10 && posY + h <= 10) {
                           grid.update($(this), posX, posY, h, w);
                           $(this).children('.grid-stack-item-content').removeClass($(this).attr("id") + 'Vertical');
                                          $(this).children('.grid-stack-item-content').addClass($(this).attr("id") + 'Horizontal');
                       }

           })

}


