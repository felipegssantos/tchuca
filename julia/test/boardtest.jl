using Test

include("../board.jl")

@testset "board building, seeding and harvesting" begin
    board = buildboard(5)
    @testset "building" begin
        @test board == [Rumba(0), Hole(2), Hole(2), Hole(2), Hole(2)]
    end
    @testset "harvesting" begin
        @test harvest(board, 2) == (2, [Rumba(0), Hole(0), Hole(2), Hole(2), Hole(2)])
    end
    @testset "nexthole to $in" for (in, out) in zip(1:5, [2,3,4,5,1])
        @test nexthole(board, in) == out
    end
    @testset "seeding" begin
        @test seed(board, 1) == [Rumba(1), Hole(2), Hole(2), Hole(2), Hole(2)]
        @test seedall(board, 1, 3) == ([Rumba(1), Hole(3), Hole(3), Hole(2), Hole(2)], 3)
    end
    @testset "all" begin
        @test harvest_then_seedall(board, 4) == ([Rumba(1), Hole(2), Hole(2), Hole(0), Hole(3)], 1)
        @test harvest_then_seedall(board, 2) == ([Rumba(0), Hole(0), Hole(3), Hole(3), Hole(2)], 4)
    end
end