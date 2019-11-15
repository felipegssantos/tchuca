class AbstractHole:

    def __init__(self, population, diameter):
        self.diameter = diameter
        self.population = population

    def harvest(self):
        old_population = self.population
        self.population = 0
        return old_population

    def seed(self):
        self.population += 1


class Hole(AbstractHole):

    def __init__(self):
        super().__init__(2, 2)


class Rumba(AbstractHole):

    def __init__(self):
        super().__init__(0, 5)
