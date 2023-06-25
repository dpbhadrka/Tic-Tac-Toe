let boxs = document.getElementsByClassName("box");
let player1 = "X";
let player2 = "0";
var gameOver = false;
const gameBoard = ["", "", "", "", "", "", "", "", ""];
let move = 0;
let currentPlayer = player1;
document.getElementById("status").innerHTML = currentPlayer;

for (item of boxs) {
  item.addEventListener("click", (e) => {
    move++;
    if (e.target.innerHTML != player1 && e.target.innerHTML != player2) {
      e.target.innerHTML = currentPlayer;
      gameBoard[e.target.id] = currentPlayer;
      hasWon(currentPlayer);

      if (currentPlayer == player1) {
        currentPlayer = player2;
      } else {
        currentPlayer = player1;
      }
      document.getElementById("status").innerHTML = currentPlayer;
    }
    //   gameOver = true;
  });
}
const winningCombos = [
  [0, 1, 2],
  [3, 4, 5],
  [6, 7, 8],
  [0, 3, 6],
  [1, 4, 7],
  [2, 5, 8],
  [0, 4, 8],
  [2, 4, 6],
];
function hasWon(currentPlayer) {
  let winner = null;
  for (let i = 0; i < winningCombos.length; i++) {
    let condition = winningCombos[i];
    let one = condition[0];
    let two = condition[1];
    let three = condition[2];

    if (
      gameBoard[one] != "" &&
      gameBoard[one] == gameBoard[two] &&
      gameBoard[one] == gameBoard[three]
    ) {
      console.log(winner);
      document.querySelector("#result").classList.add("result");
      winner = currentPlayer;
      document.getElementById("winner").innerHTML = "Winner is " + winner + ".";
      document.getElementById("congratulation").innerHTML = "Congratulation !!";
      document.querySelector("main").style.opacity = "0";
      setTimeout(reset, 1500);
    }
  }

  for (let j = 0; j < gameBoard.length; j++) {
    if (gameBoard[j] != "" && move == 9 && winner == null) {
      document.querySelector("main").style.opacity = "0";
      document.querySelector("#result").classList.add("result");
      document.getElementById("winner").innerHTML = "Well played....";
      document.getElementById("congratulation").innerHTML = "Tie!! ";
      setTimeout(reset, 1500);
    }
  }
}

function reset() {
  document.querySelector("#result").classList.remove("result");
  document.querySelector("main").style.opacity = "1";
  document.getElementById("winner").innerHTML = "";
  document.getElementById("congratulation").innerHTML = "0";
  document.getElementById("congratulation").innerHTML = "";
  currentPlayer = player1;
  move = 0;
  document.getElementById("status").innerHTML = currentPlayer;
  for (var n = 0; n < gameBoard.length; n++) {
    gameBoard[n] = "";
  }
  for (item of boxs) {
    item.innerHTML = "";
  }
}
