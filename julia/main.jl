abstract type BaseHole end

mutable struct Hole <: BaseHole
    diameter::Real
    population::Integer

    function Hole(population::Integer)
        new(1,population)
    end
end

mutable struct Rumba <: BaseHole
    diameter::Real
    population::Integer

    function Rumba(population::Integer)
        new(4,population)
    end
end

mutable struct Board
    holes::Array{BaseHole}

    function Board(numHoles::Integer)
        holes = [(i > 1 ? Hole(2) : Rumba(0)) for i in 1:numHoles]
        new(holes)
    end
end

function Base.show(io::IO, hole::Hole)
    print(io, " $(hole.population) ")
end

function Base.show(io::IO, hole::Rumba)
    print(io, " $(hole.population) ")
end

function Base.show(io::IO, board::Board)
    output = [" $(hole.population) " for hole in board.holes]
    output = join(output, "|")
    print(output)
end

# TODO: print board highlighting current hole
# TODO: implement the rest of the game
board = Board(5)
show(board)
