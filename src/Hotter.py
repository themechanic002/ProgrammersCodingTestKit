import heapq

def solution2(scoville, K):
    count = 0
    heapqScoville = [x for x in scoville if x < K]
    heapqScovilleOverK = [x for x in scoville if x >= K]
    heapq.heapify(heapqScoville)
    heapq.heapify(heapqScovilleOverK)

    while heapqScoville[0] < K:
        if len(heapqScoville) == 1:
            if len(heapqScovilleOverK) == 0:
                return -1
            else:
                return count + 1

        elif len(heapqScoville) == 0:
            return count

        first = heapq.heappop(heapqScoville)
        second = heapq.heappop(heapqScoville)

        if first + second == 0:
            return -1

        else:
            count += 1
            new = first + (second * 2)
            if (new < K):
                heapq.heappush(heapqScoville, new)
            elif (new >= K):
                heapq.heappush(heapqScovilleOverK, new)
                if (len(heapqScoville) == 0):
                    return count

    return count


print(solution2([1, 2, 9, 3, 10, 12], 7))