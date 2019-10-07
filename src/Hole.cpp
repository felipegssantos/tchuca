#include <Hole.h>

int Hole::harvest(){
    int currentPopulation = population;
    population = 0;
    return currentPopulation;
}

int Hole::seed(int numSeeds){
    population += 1;
    return numSeeds - 1;
}

Hole::Hole(int population): population(population), rumba(false)
{
}

Hole::Hole(int population, bool rumba):
    population(population), rumba(rumba)
{
}
