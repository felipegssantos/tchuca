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