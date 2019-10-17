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
        bool wasEmpty() const { return population == 1; };
        bool isRumba() const { return rumba; };
        int getPopulation() const { return population; };
        int harvest();
        int seed(int numSeeds);
};