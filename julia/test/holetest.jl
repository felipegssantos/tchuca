using Test

include("../hole.jl")

@testset "hole harvesting and seeding $HoleType" for HoleType in [Hole, Rumba]
    @test harvest(HoleType(2)) == 2
    @test seed(HoleType(0)) == HoleType(1)
end