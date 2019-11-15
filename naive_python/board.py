from holes import Hole, Rumba


class Board:

    def __init__(self, num_holes):
        # Rumba MUST BE zeroth element of self.holes
        self.holes = [Rumba() if i == 0 else Hole()
                      for i in range(num_holes)]

    def _harvest(self, hole_index):
        hole = self.holes[hole_index]
        seeds = hole.harvest()
        if seeds == 0:
            raise RuntimeError("Cannot harvest an empty hole!")
        return seeds

    def _seed(self, hole_index, seeds):
        # Spread seeds around the board
        while seeds > 0:
            self.holes[hole_index].seed()
            seeds -= 1
            hole_index = self._next(hole_index)
        # Get last seeded hole
        last_hole_index = hole_index - 1
        if last_hole_index == -1:
            last_hole_index = len(self.holes) - 1
        return last_hole_index

    def harvest_and_seed(self, hole_index):
        seeds = self._harvest(hole_index)
        last_hole_index = self._seed(self._next(hole_index), seeds)
        return last_hole_index

    def _next(self, hole_index):
        return hole_index + 1 if hole_index < len(self.holes)-1 else 0
