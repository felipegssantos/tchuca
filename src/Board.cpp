#include <Board.h>
#include <iostream>
#include <vector>

using std::cout;
using std::endl;

void Board::buildBoard(int numHoles){
    holes[0] = Hole(0, true); // this is the rumba
    for (int i = 1; i < numHoles; i++) {
        holes[i] = Hole(2);
    }
}

Board::Board(int numHoles): numHoles(numHoles)
{
    buildBoard(numHoles);
}

int Board::nextHole(int currentHole) {
    int nextHole = currentHole + 1;
    return (nextHole >= numHoles) ? 0 : nextHole;
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