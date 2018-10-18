# backpack problem known as Knapsack
import time

v = [1, 4, 2, 5, 7, 4, 2, 5, 7, 4, 2, 5, 7, 4, 2, 5, 7, 4, 2, 5, 7, 4, 2, 5, 7, 4, 2]  # values - higher is better
w = [2, 3, 4, 1, 3, 3, 4, 1, 3, 3, 4, 1, 3, 3, 4, 1, 3, 3, 4, 1, 3, 3, 4, 1, 3, 3, 4]  # weights
C = 17  # capacity of the backpack


def KS_recursive(current_index, C, a_visited):
    if current_index < 0 or C == 0:
        result = 0
    elif w[current_index] > C:
        result = KS_recursive(current_index - 1, C, a_visited)  # check another possible cases
    else:
        # will see what happened if we do not take current element
        v1 = a_visited.copy()
        v2 = a_visited.copy()
        tmp1 = KS_recursive(current_index - 1, C, v1)

        # will see what happened if we do take current element
        v2[current_index] = True
        tmp2 = v[current_index] + KS_recursive(current_index - 1, C - w[current_index], v2)
        a_visited.clear()
        a_visited.extend(v1.copy() if tmp1 > tmp2 else v2.copy())
        result = max(tmp1, tmp2)
    return result


dp = [[None for x in range(C + 1)] for y in range(len(w))]


def KS_dp(current_index, C):
    if dp[current_index][C] is not None: return dp[current_index][C]
    if current_index < 0 or C == 0:
        result = 0
    elif w[current_index] > C:
        result = KS_dp(current_index - 1, C)  # check another possible cases
    else:
        # will see what happened if we do not take current element
        tmp1 = KS_dp(current_index - 1, C)

        # will see what happened if we do take current element
        tmp2 = v[current_index] + KS_dp(current_index - 1, C - w[current_index])
        result = max(tmp1, tmp2)
    dp[current_index][C] = result
    return result


# Recursive
start = time.time()
visited = [False for x in range(len(w))]
recursive = KS_recursive(len(w) - 1, C, visited)
end = time.time()
print("Recursive: {}, time={}".format(recursive, end - start))
print(visited)

# Dynamic
start = time.time()
dp = KS_dp(len(w) - 1, C)
end = time.time()
print("DP: {}, time={}".format(dp, end - start))
