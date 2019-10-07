#pragma once
#include <string>

class Hole {
    private:
        int population;
        bool rumba;

    public:
        Hole()=default;
        Hole(int population);
        Hole(int population, bool rumba);
        bool isEmpty() const { return population > 0; };
        bool isRumba() const { return rumba; };
        int getPopulation() const { return population; };
        int harvest();
        int seed(int numSeeds);
};