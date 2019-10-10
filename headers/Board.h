#pragma once
#include <Hole.h>
#include <Status.h>
#include <vector>

class Board {
    private:
        std::vector<Hole> holes;
        void buildBoard(int numHoles);
        int numHoles;
        int nextHole(int currentHole);

    public:
        Board(int numHoles);
        int play(int selectedHole);
        Hole getHole(int index);
        void printStatus();
        void printStatus(int currentHole);
        GameStatus checkWinCondition();
};
