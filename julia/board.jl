include("./hole.jl")

using Base.Iterators

buildboard(numHoles::Int) = [(i > 1 ? Hole(2) : Rumba(0)) for i in 1:numHoles]

function Base.show(io::IO, board::Array{BaseHole})
    output = [" $(hole.population) " for hole in board]
    output = join(output, "|")
    print(output)
end

function harvest_then_seedall(board::Array{BaseHole}, holeindex::Int)
    seeds, newboard = harvest(board, holeindex)
    seedall(newboard, nexthole(newboard, holeindex), seeds)
end

function harvest(board::Array{BaseHole}, holeindex::Int)
    hole = board[holeindex]
    seeds = harvest(hole)
    HoleType = typeof(hole)
    newboard = [i == holeindex ? HoleType(0) : board[i] for i in eachindex(board)]
    seeds, newboard
end

function seedall(board::Array{BaseHole}, holeindex::Int, numSeeds::Int)
    newboard = seed(board, holeindex)
    if numSeeds > 1
        nextindex = nexthole(board, holeindex)
        seedall(newboard, nextindex, numSeeds - 1)
    elseif numSeeds > 0
        (newboard, holeindex)
    else
        error("Number of seeds must be positive; found $numSeeds")
    end
end

function seed(board::Array{BaseHole}, holeindex::Int)
    [i == holeindex ? seed(hole) : hole for (i, hole) in enumerate(board)]
end

nexthole(board::Array{BaseHole}, holeindex::Int) = holeindex < size(board)[1] ? holeindex + 1 : 1