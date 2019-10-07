#include <Hole.h>

bool Hole::isEmpty(){
    return (population > 0);
}

int Hole::harvest(){
    int currentPopulation = population;
    population = 0;
    return currentPopulation;
}

int Hole::seed(int numSeeds){
    population += 1;
    return numSeeds - 1;
}

bool Hole::isRumba(){
    return rumba;
}

Hole::Hole(int population): population(population), rumba(false)
{
}

Hole::Hole(int population, bool rumba):
    population(population), rumba(rumba)
{
}
