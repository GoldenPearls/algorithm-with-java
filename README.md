# Java Algorithm Study

- **목표:** 주 2회 문제 풀이 & 최적화 습관화
- **언어:** Java
- **주요 플랫폼:** LeetCode / BOJ / Programmers (자유)

---

## 🗓 스터디 운영 개요

* **빈도:** 주 1회 제출, 2개의 문제
* 일 23:59 마감
* **진행 방식(요약):**

  1. 한 주간 정해진 문제를 풀고 **기한 내 제출** (형식 자유)
  2. 각자 **최적화 요약**을 정리해 공유
  3. 모두가 요약을 읽고 **가장 도움 된 사람 1명에 투표** (팀장 제외)
  4. 스터디 종료 시 **최다 득표 2명**에게 팀원 1인당 **1만원씩 모금 → 소정 시상** (팀장 제외)

---

## ✅ 기본 진행

* 한 주간 정해진 문제를 풀고 **기한 내 제출**합니다. (형식 자유)
* 각자 **최적화한 내용**을 **요약**하여 공유합니다.
* 매주 요약 내용을 모두 읽고, **가장 도움이 된 한 명**을 각자 **선택**합니다. *(팀장 제외)*
* **스터디 종료 시**, 가장 많은 선택을 받은 **2명**에게 **1만원씩 모아** 작은 **수상식**을 합니다. *(팀장 제외)*

---

## 🧭 과제 가이드

### 1) 주차별 분량 & 목표

* **권장 분량**과 **최소 목표**가 있습니다.
* 여유가 되면 권장 분량/방법으로 진행하고, 데드라인이 임박하면 **최소 목표**를 달성하세요.

### 2) 권장되는 방법 (학습 루틴)

* **개념 읽기:** 책/레퍼런스로 개념 설명 확인 → 필요 시 자료구조·알고리즘 추가 학습
* **문제 풀이 루프:**

  * **1차:** 무조건 **직접 풀이**

    * 기록: 초기 **시간/공간 복잡도 추정** → n차 리팩터링 후 **어디가 어떻게 개선**되었는지
    * **최적화 포인트** 명시(없으면 ‘없음’으로 솔직히 기록)
  * **힌트 모드(필요 시):**

    * AI에 \*“이 문제를 해결하기 위한 **최초의 접근법 딱 하나만** 알려줘”\*로 힌트 요청
    * 막히면 **하나만 더**를 반복 (과정 모두 메모)
  * **비교 & 개선:** 레퍼런스/타 풀이와 비교해 최적화 재시도
  * **메모:** 막힌 부분/인사이트/공유 포인트를 주석/노트로 남기기
  * **난이도 Hard**는 **스킵 권장**
  * **데드라인 임박 시**: 전략적으로 최소 목표 충족
* **최소 목표**

  * 각 문제에 대해 **접근 아이디어**를 적어 보기
  * **정답을 참고하더라도** 직접 타이핑으로 **동작 코드 작성**(복붙 금지)
* **제출 전 공유**

  * 각자 정리한 코드/노트를 **스터디 시작 전에 링크 공유**
* **성능 검수**

  * LeetCode 채점 편차/AI 답변 품질 편차 고려
  * **사용자 정의 테스트 케이스를 1,000회** 이상 돌려보기(아래 예시 코드 참고)

---

## 🧪 성능 검증 예시 (Java)

**랜덤 테스트 유틸 (예: 정렬 함수 검증)**

```java
// src/test/java/util/RandomArrayGenerator.java
import java.util.*;

public class RandomArrayGenerator {
    private static final Random RND = new Random();

    public static int[] randomArray(int n, int min, int max) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = RND.nextInt(max - min + 1) + min;
        return a;
    }
}
```

**1,000회 이상 퍼지 테스트 (JUnit5)**

```java
// src/test/java/solution/SortSolutionTest.java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

public class SortSolutionTest {

    // 가정: 정렬 대상 메서드
    public int[] mySort(int[] arr) {
        // TODO: 본인 정렬 구현
        int[] copy = Arrays.copyOf(arr, arr.length);
        Arrays.sort(copy);
        return copy;
    }

    @Test
    void fuzzTest_1000cases() {
        for (int t = 0; t < 1000; t++) {
            int n = 1 + (int)(Math.random() * 200);
            int[] arr = RandomArrayGenerator.randomArray(n, -10_000, 10_000);

            int[] expected = Arrays.copyOf(arr, n);
            Arrays.sort(expected);

            int[] actual = mySort(arr);
            assertArrayEquals(expected, actual, "Mismatch at t=" + t);
        }
    }
}
```

> 문제 유형에 맞게 **경계값/특수 케이스**(빈 배열, 중복 키, 단조 증가/감소, 모두 동일, 최대/최소 범위 등)도 추가하세요.

---

## 🤖 AI 활용 팁

* **힌트 프롬프트(원칙):**

  > “**정답은 주지 말고** 이 문제를 풀기 위한 **최초의 접근법 딱 하나만** 알려줘.”
* 풀이 후

  * **최적화 방안 질의** → “현재 O(N²)인데, **시간/공간** 더 줄일 아이디어 2가지만”
  * **테스트 케이스** 생성 요청·검증
  * **다른 풀이(LeetCode Discuss 등)** 요약 비교 후 개선
  * **다양한 설명 요청**: 코드 주석, 단계별 풀이, 디버깅 로그 포인트, 시각화 등

---

## 🗳 주간 투표 & 시상

* **투표:** 각 주차 요약을 읽고 **가장 도움 된 1인**에 투표 *(팀장 제외)*
* **시상:** 스터디 종료 시 **최다 득표 2명**에게 **팀원 1인당 1만원씩** 모금해 시상 *(팀장 제외)*

