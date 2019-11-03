include("./hole.jl")

struct Board
    holes::Array{BaseHole}

    function Board(numHoles::Int)
        holes = [(i > 1 ? Hole(2) : Rumba(0)) for i in 1:numHoles]
        new(holes)
    end
end

function Base.show(io::IO, board::Board)
    output = [" $(hole.population) " for hole in board.holes]
    output = join(output, "|")
    print(output)
end

function harvest&seedall(board::Board, holeIndex::Int)
    seeds = harvest(board.holes(holeIndex))
    seedall(board, nextHole(board, holeIndex))
end

function seedall(board::Board, holeIndex::Int)
    # TODO
    # Ideas: use an cyclical iterator; use an "until"-like macro;
end

nextHole(board::Board, holeIndex::Int) = (holeIndex + 1) % len(board.holes)