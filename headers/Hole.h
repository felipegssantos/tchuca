#pragma once
#include <string>

class Hole {
    private:
        int population;
        bool rumba;

    public:
        Hole(int population);
        Hole(int population, bool rumba);
        bool isEmpty();
        bool isRumba();
        int harvest();
        int seed(int numSeeds);
};