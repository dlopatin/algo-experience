from encodings import undefined


def lcp_recursive(P, Q, i, j):
    if i < 0 or j < 0:
        return 0
    if P[i] == Q[j]:
        return 1 + lcp_recursive(P, Q, i - 1, j - 1)
    return max(lcp_recursive(P, Q, i - 1, j), lcp_recursive(P, Q, i, j - 1))


def lcp_dp(P, Q, i, j):
    dp = [[undefined for x in range(j + 1)] for y in range(i + 1)]
    return _lcp_dp_internal(P, Q, i, j, dp)


def _lcp_dp_internal(P, Q, i, j, dp):
    if dp[i][j] != undefined:
        return dp[i][j]
    if i < 0 or j < 0:
        return 0
    if P[i] == Q[j]:
        return 1 + _lcp_dp_internal(P, Q, i - 1, j - 1, dp)
    tmp = max(_lcp_dp_internal(P, Q, i - 1, j, dp), _lcp_dp_internal(P, Q, i, j - 1, dp))
    dp[i][j] = tmp
    return tmp
