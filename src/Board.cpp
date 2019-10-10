#include <Board.h>
#include <iostream>
#include <vector>

using std::cout;
using std::endl;

void Board::buildBoard(int numHoles){
    holes.push_back(Hole(0, true)); // this is the rumba
    for (int i = 1; i < numHoles; i++) {
        holes.push_back(Hole(2));
    }
}

Board::Board(int numHoles): numHoles(numHoles)
{
    buildBoard(numHoles);
}

Hole Board::getHole(int index){
    return holes[index];
}

int Board::nextHole(int currentHole) {
    // int nextHole = currentHole + 1;
    // return (nextHole >= numHoles) ? 0 : nextHole;
    return (currentHole + 1) % numHoles;
}

int Board::play(int selectedHole){
    int seeds = holes[selectedHole].harvest();
    while (seeds > 0) {
        selectedHole = nextHole(selectedHole);
        seeds = holes[selectedHole].seed(seeds);
    }
    // TODO: confirm rules - should I return nextHole(selectedHole) instead?
    return selectedHole;
}

void Board::printStatus(){
    for (int i=0; i < numHoles; i++) {
        cout << i << " : " << holes[i].getPopulation() << " | ";
    }
    cout << endl;
}

void Board::printStatus(int currentHole){
    for (int i=0; i < numHoles; i++) {
        cout << i << " : " << holes[i].getPopulation();
        if (i == currentHole) cout << "*| ";
        else cout << " | ";
    }
    cout << endl;
}

GameStatus Board::checkWinCondition(int currentHoleIndex) {
    Hole currentHole = holes[currentHoleIndex];
    if (currentHole.isRumba()) { // this is the rumba's index
        bool rumbaIsFull = currentHole.getPopulation() == 2 * (numHoles - 1);
        return rumbaIsFull ? GameStatus::Won : GameStatus::Ongoing;
    }
    else if (currentHole.wasEmpty()) return GameStatus::Lost;
    else return GameStatus::Ongoing;
}