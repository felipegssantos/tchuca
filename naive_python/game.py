from board import Board


def play(board, hole_index):
    last_hole_index = board.harvest_and_seed(hole_index)
    if is_rumba(last_hole_index):
        if check_win_condition(board):
            return "You won!"
        else:
            hole_index = int(input("Please input a hole_index"))
            play(board, hole_index)
    elif was_empty_hole(board.holes[hole_index]):
        return "Game over! You lost!"
    else:
        play(board, last_hole_index)


def is_rumba(hole_index):
    return hole_index == 0


def check_win_condition(board):
    total_seeds = 2 * (len(board.holes) - 1)
    return board.holes[0].population == total_seeds


def was_empty_hole(hole):
    return hole.population == 1


if __name__ == '__main__':
    board = Board(5)
    hole_index = int(input("Please input a hole_index"))
    game_status = play(board, hole_index)
    print(game_status)
