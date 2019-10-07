#include <Board.h>
#include <Status.h>
#include <iostream>

Hole* Board::buildBoard(int numHoles) {
    // TODO: return a vector of numHoles Hole variables
    // where one Hole has (population=0, rumba=true)
    // and all others have (population=2, rumba=false)
}

Board::Board(int numHoles): 
    holes(buildBoard(numHoles))
{
}

int Board::play(int selectedHole){
    // TODO: play (harvest and seed according to rules)
    // returns current hole index after seeding is complete.
}

void Board::printStatus(){
    std::string status = "";
    /*
    TODO:
        for hole in holes
            string += "<holeIndex>: <holePopulation>"
    (and somehow highlight current hole!)
    */
    std::cout << status;
}