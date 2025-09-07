# 📘 🔹 \[121] Best Time to Buy and Sell Stock

* **문제 링크:** [LeetCode 121. Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/)

> 하루에 하나의 주식을 사고, 미래의 어느 날에 팔아서 얻을 수 있는 **최대 이익**을 구하는 문제입니다.
> 단, “산 날 < 판 날” 조건을 반드시 지켜야 합니다.
> 만약 이익이 불가능하면 `0`을 반환합니다.

---

## 🥇 최초 접근 (Solution.java)

### **힌트 기반 아이디어**

* 지금까지 본 **최소 가격**을 저장해 두고,
* 현재 가격에서 그 최소 가격을 뺀 값을 **최대 이익 후보**로 갱신합니다.

---

### **풀이 요약**

1. `minSoFar` = 매우 큰 값으로 시작
2. 배열을 순회하면서

   * 현재 값이 `minSoFar`보다 작으면 최소값 갱신
   * 아니라면, `(현재 값 - minSoFar)`로 얻을 수 있는 이익을 계산 → `maxProfit`에 반영
3. 끝까지 순회한 뒤 `maxProfit` 반환

---

### **Java 코드**

```java
class Solution {
    public int maxProfit(int[] prices) {   
        int minSoFar = Integer.MAX_VALUE; // 지금까지 본 최저가
        int maxProfit = 0; // 최대 이익

        for (int p : prices) {
            if (p < minSoFar) {
                minSoFar = p; // 최저가 갱신
            } else {
                maxProfit = Math.max(maxProfit, p - minSoFar); // 현재 팔면 얻는 수익
            }
        }
        return maxProfit;
    }
}

/*
📊 복잡도 분석

시간복잡도:
- 변수 초기화: O(1)
- prices 배열 순회: 길이 N만큼 반복 → O(N)
  (루프 안 비교·대입·Math.max는 전부 O(1))
- 반환: O(1)
=> 전체 = O(N)

공간복잡도:
- 입력 배열은 제외
- 추가 변수: minSoFar, maxProfit, 루프 변수 → O(1)
=> 전체 = O(1)
*/
```

---

### **예제 입출력**

```text
Input: prices = [7,1,5,3,6,4]
Output: 5
설명: 2일차(가격=1)에 매수 → 5일차(가격=6)에 매도 → 이익=5

Input: prices = [7,6,4,3,1]
Output: 0
설명: 항상 가격이 떨어지므로 거래하지 않고 이익=0
```

---

### **Edge Cases**

* 모든 가격이 내림차순 → `0` 반환
* 모든 가격이 오름차순 → 첫 날 사서 마지막 날 파는 것이 최대 이익
* 배열 길이가 1일 경우 → 거래 불가능, 이익=0


