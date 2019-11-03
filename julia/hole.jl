abstract type BaseHole end

struct Hole <: BaseHole
    diameter::Real
    population::Int

    function Hole(population::Int)
        new(1,population)
    end
end

struct Rumba <: BaseHole
    diameter::Real
    population::Int

    function Rumba(population::Int)
        new(4,population)
    end
end

function Base.show(io::IO, hole::Hole)
    print(io, " $(hole.population) ")
end

function Base.show(io::IO, hole::Rumba)
    print(io, " $(hole.population) ")
end