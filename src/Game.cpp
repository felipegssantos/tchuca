#include <Board.h>
#include <Status.h>
#include <iostream>

using std::cout, std::cin;

int main(){

    cout << "Insira o número total de casas (incluindo a rumba)";
    int numHoles;
    cin >> numHoles;
    Board board = Board(numHoles);
    board.printStatus();

    int firstMove;
    cin >> firstMove;
    GameStatus status = play(board, firstMove);
    if (status == GameStatus::Won) cout << "Você ganhou!";
    else cout << "Você perdeu!";
}

GameStatus play(Board board, int holeIndex) {
    int currentHoleIndex = board.play(holeIndex);
    board.printStatus();
    // TODO: part of this logic could be inside the Board class
    Hole currentHole = board.getHole(currentHoleIndex);
    if (currentHole.isEmpty()) {
        return board.checkWinCondition();
    } else if (currentHole.isRumba()) {
        GameStatus status = board.checkWinCondition();
        if (status == GameStatus::Ongoing) {
            cout << "Insira a próxima casa que deseja colher";
            cin >> currentHoleIndex;
        } else {
            return status;
        }
    }
    return play(board, currentHoleIndex);
}