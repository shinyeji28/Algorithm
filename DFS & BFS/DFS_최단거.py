# p.377
# k부터 출발해 모든 노드가 신호를 받을 수 있는 시간을 계산하라. 불가능할 경우 -1을 리턴한다. 입력값(u,v,w)는 각각 출발지,도착지,소요시간으로 구성되며, 전체 노드의 개수는 N으로 입력받는다.
# 풀이
    # 1. graph를 만들고 / Q: 최소 힙 - (소요시간, 도착지) / dist (노드, 최소 소요시간): 최소 거리를 저장
    # 2. 최소 힙의 root를 pop하여 dist에 넣고 다음 도착지의 소요시간을 계산하여 힙에 넣음
    # 3. 힙에 노드가 없을 때까지 반복
import collections
import heapq
def solution(times,N,K):
    graph = collections.defaultdict(list)
    for u,v,w in times:
        graph[u].append((v,w))
    Q =[(0,K)]
    dist = collections.defaultdict(int)
    while Q:
        time, node = heapq.heappop(Q)
        if node not in dist:
            dist[node] = time
            for v,w in graph[node]:
                alt = time + w
                heapq.heappush(Q,(alt,v))
    if len(dist) == N:
        return max(dist.values())
    return -1
print(solution([[2,1,1],[2,3,1],[3,4,1]],4,2))

# import heapq
# def solution(times,N,K):
#     graph={}
#     dist={}
#     for s, f, w in times:
#         if s not in graph:
#             graph[s]=[(f,w)]
#         else:
#             graph[s].append((f,w))
#     Q = [(0,K)]
#     while Q:
#         time, node = heapq.heappop(Q)
#         if node not in dist:
#             dist[node] = time
#             try:
#                 for f,w in graph[node]:
#                     sum_w = time + w
#                     heapq.heappush(Q,(sum_w,f))
#             except:
#                 continue
#     if len(dist) == N:
#         return max(dist.values())
#     return -1
# print(solution([[2,1,1],[2,3,1],[3,4,1]],4,2))