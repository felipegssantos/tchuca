#include <Board.h>
#include <iostream>

using std::cout, std::cin, std::endl;

GameStatus play(Board board, int holeIndex) {
    int currentHoleIndex = board.play(holeIndex);
    board.printStatus(currentHoleIndex);
    // TODO: part of this logic could be inside the Board class
    Hole currentHole = board.getHole(currentHoleIndex);
    GameStatus status = board.checkWinCondition(currentHoleIndex);
    if (status == GameStatus::Ongoing) {
        if (currentHole.isRumba()) {
            cout << "Insira a próxima casa que deseja colher: ";
            cin >> currentHoleIndex;
        }
        return play(board, currentHoleIndex);
    } else {
        return status;
    }
    // if (!(currentHole.isRumba()) && currentHole.wasEmpty()) {
    //     return board.checkWinCondition();
    // } else if (currentHole.isRumba()) {
    //     GameStatus status = board.checkWinCondition();
    //     if (status == GameStatus::Ongoing) {
    //         cout << "Insira a próxima casa que deseja colher: ";
    //         cin >> currentHoleIndex;
    //     } else {
    //         return status;
    //     }
    // }
    // return play(board, currentHoleIndex);
}

int main(){

    cout << "Insira o número total de casas (incluindo a rumba): ";
    int numHoles;
    cin >> numHoles;
    Board board = Board(numHoles);
    board.printStatus();

    cout << "Insira a primeira casa para colher: ";
    int firstMove;
    cin >> firstMove;
    GameStatus status = play(board, firstMove);
    if (status == GameStatus::Won) cout << "Você ganhou!";
    else cout << "Você perdeu!";
    cout << endl;
}
