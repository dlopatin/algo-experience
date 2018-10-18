import time

from com.dlopatin.lcp import lcp_recursive, lcp_dp

P = "BAAHEAPBAAHEAPBAAHBAAHEAPBAAHEAPBAAH"
Q = "ABJVUAPABJVUAPAABJVUAPABJVUAPA"
# start = time.time()
# res = lcp_rec(P, Q, len(P) - 1, len(Q) - 1)
# end = time.time()
# print("Recursive: {}, time={}".format(res, end-start))

start = time.time()
dp = lcp_dp(P, Q, len(P) - 1, len(Q) - 1)
end = time.time()
print("DP: {}, time={}".format(dp, end - start))
