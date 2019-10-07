#pragma once
#include <Hole.h>
#include <Status.h>

class Board {
    private:
        Hole* holes;
        Hole* buildBoard(int numHoles);
        int currentHole;

    public:
        Board(int numHoles);
        int play(int selectedHole);
        void printStatus();
        // void setCurrentHole(int i);
        // int getCurrentHole();
        GameStatus checkWinCondition();
        Hole getHole(int index);
};
