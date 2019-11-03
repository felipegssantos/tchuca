include("./hole.jl")

using Base.Iterators

buildboard(numHoles::Int) = [(i > 1 ? Hole(2) : Rumba(0)) for i in 1:numHoles]

function Base.show(io::IO, board::Array{BaseHole})
    output = [" $(hole.population) " for hole in board]
    output = join(output, "|")
    print(output)
end

function harvest&seedall(board::Array{BaseHole}, holeIndex::Int)
    seeds = harvest(board[holeIndex])
    seedall(board, nextHole(board, holeIndex) seeds)
end

function seedall(board::Array{BaseHole}, holeIndex::Int, numSeeds::Int)
    # TODO
    # Ideas: use an cyclical iterator; use an "until"-like macro; use recursion
end

function seed(board::Array{BaseHole}, holeIndex::Int)
    [i == holeIndex ? seed(hole) : hole for hole, i in enumerate(board)]
end

nextHole(board::Array{BaseHole}, holeIndex::Int) = (holeIndex + 1) % size(board)[1]