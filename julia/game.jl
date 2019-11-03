include("./game.jl")

# TODO: print board highlighting current hole
# TODO: implement the rest of the game
board = Board(5)
print("Escolha o primeiro buraco para colher: ")
hole_index = parse(Int, readline(stdin))
println(hole_index)
show(board)