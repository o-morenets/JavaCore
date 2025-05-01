package leetcode._997_Find_the_Town_Judge;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 997. Find the Town Judge
 * Attempted
 * Easy
 * Topics
 * Companies
 * In a town, there are n people labeled from 1 to n. There is a rumor that one of these people is secretly the town judge.
 *
 * If the town judge exists, then:
 *
 * The town judge trusts nobody.
 * Everybody (except for the town judge) trusts the town judge.
 * There is exactly one person that satisfies properties 1 and 2.
 * You are given an array trust where trust[i] = [ai, bi] representing that the person labeled ai trusts the person labeled bi. If a trust relationship does not exist in trust array, then such a trust relationship does not exist.
 *
 * Return the label of the town judge if the town judge exists and can be identified, or return -1 otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 2, trust = [[1,2]]
 * Output: 2
 * Example 2:
 *
 * Input: n = 3, trust = [[1,3],[2,3]]
 * Output: 3
 * Example 3:
 *
 * Input: n = 3, trust = [[1,3],[2,3],[3,1]]
 * Output: -1
 *
 *
 * Constraints:
 *
 * 1 <= n <= 1000
 * 0 <= trust.length <= 104
 * trust[i].length == 2
 * All the pairs of trust are unique.
 * ai != bi
 * 1 <= ai, bi <= n
 */
public class Solution {
    public int findJudge(int n, int[][] trust) {
        if (n == 1 && trust.length == 0) return 1;
        if (n == 1) return -1;

        Map<Integer, Set<Integer>> trustedBy = Arrays.stream(trust)
                .collect(Collectors.groupingBy(
                        row -> row[1],
                        Collectors.mapping(row -> row[0], Collectors.toSet())
                ));

        Set<Integer> trustingPeople = Arrays.stream(trust)
                .map(row -> row[0])
                .collect(Collectors.toSet());

        return trustedBy.entrySet().stream()
                .filter(e -> e.getValue().size() == n - 1)         // довіряють n-1 людей
                .filter(e -> !trustingPeople.contains(e.getKey())) // сам нікому не довіряє
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(-1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findJudge(1, new int[][]{})); // Output: 1
        System.out.println(solution.findJudge(2, new int[][]{{1, 2}})); // Output: 2
        System.out.println(solution.findJudge(3, new int[][]{{1, 3}, {2, 3}})); // Output: 3
        System.out.println(solution.findJudge(3, new int[][]{{1, 3}, {2, 3}, {3, 1}})); // Output: -1
        System.out.println(solution.findJudge(4, new int[][]{{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}})); // Output: 3
    }
}
