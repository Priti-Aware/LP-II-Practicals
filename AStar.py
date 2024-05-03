def print_state(state):
    for row in state:
        print(" ".join(map(str, row)))
    print()

def calculate_misplaced_tiles(state, goal_state):
    count = 0
    for i in range(len(state)):
        for j in range(len(state[i])):
            if state[i][j] != goal_state[i][j]:
                count += 1
    return count

def get_blank_position(state):
    for i in range(len(state)):
        for j in range(len(state[i])):
            if state[i][j] == 0:
                return i, j

def generate_possible_moves(state):
    i, j = get_blank_position(state)
    possible_moves = []
    if i > 0:
        possible_moves.append((i - 1, j))
    if i < len(state) - 1:
        possible_moves.append((i + 1, j))
    if j > 0:
        possible_moves.append((i, j - 1))
    if j < len(state[0]) - 1:
        possible_moves.append((i, j + 1))
    return possible_moves

def solve_puzzle(initial_state, goal_state):
    print("Initial state:")
    print_state(initial_state)
    print("Goal state:")
    print_state(goal_state)

    current_state = initial_state
    moves = 0
    while True:
        moves += 1
        print("Move:", moves)
        print("Current state:")
        print_state(current_state)
        print("Number of misplaced tiles:", calculate_misplaced_tiles(current_state, goal_state))

        if current_state == goal_state:
            print("Reached the goal state in", moves, "moves.")
            break

        possible_moves = generate_possible_moves(current_state)
        min_cost = float('inf')
        next_state = None
        for move in possible_moves:
            new_state = [row[:] for row in current_state]  # Create a deep copy of the current state
            new_state[move[0]][move[1]], new_state[get_blank_position(new_state)[0]][get_blank_position(new_state)[1]] = new_state[get_blank_position(new_state)[0]][get_blank_position(new_state)[1]], new_state[move[0]][move[1]]  # Swap tiles
            cost = moves + calculate_misplaced_tiles(new_state, goal_state)
            if cost < min_cost:
                min_cost = cost
                next_state = new_state

        current_state = next_state

# Example input (initial and goal states of the puzzle)
initial_state = [
    [1, 2, 3],
    [4, 0, 5],
    [7, 8, 6]
]

goal_state = [
    [1, 2, 3],
    [4, 5, 6],
    [7, 8, 0]
]

# Call the solve_puzzle function with the initial and goal states
solve_puzzle(initial_state, goal_state)


"""
Initial state:
1 2 3
4 0 5
7 8 6

Goal state:
1 2 3
4 5 6
7 8 0

Move: 1
Current state:
1 2 3
4 0 5
7 8 6

Number of misplaced tiles: 3
Move: 2
Current state:
1 2 3
4 5 0
7 8 6

Number of misplaced tiles: 2
Move: 3
Current state:
1 2 3
4 5 6
7 8 0

Number of misplaced tiles: 0
Reached the goal state in 3 moves.
"""