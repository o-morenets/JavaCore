package leetcode._1971_Find_if_Path_Exists_in_Graph;

import java.util.*;

/**
 * 1971. Find if Path Exists in Graph
 * Solved
 * Easy
 * Topics
 * Companies
 * There is a bi-directional graph with n vertices, where each vertex is labeled from 0 to n - 1 (inclusive). The edges in the graph are represented as a 2D integer array edges, where each edges[i] = [ui, vi] denotes a bi-directional edge between vertex ui and vertex vi. Every vertex pair is connected by at most one edge, and no vertex has an edge to itself.
 *
 * You want to determine if there is a valid path that exists from vertex source to vertex destination.
 *
 * Given edges and the integers n, source, and destination, return true if there is a valid path from source to destination, or false otherwise.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: n = 3, edges = [[0,1],[1,2],[2,0]], source = 0, destination = 2
 * Output: true
 * Explanation: There are two paths from vertex 0 to vertex 2:
 * - 0 → 1 → 2
 * - 0 → 2
 * Example 2:
 *
 *
 * Input: n = 6, edges = [[0,1],[0,2],[3,5],[5,4],[4,3]], source = 0, destination = 5
 * Output: false
 * Explanation: There is no path from vertex 0 to vertex 5.
 *
 *
 * Constraints:
 *
 * 1 <= n <= 2 * 105
 * 0 <= edges.length <= 2 * 105
 * edges[i].length == 2
 * 0 <= ui, vi <= n - 1
 * ui != vi
 * 0 <= source, destination <= n - 1
 * There are no duplicate edges.
 * There are no self edges.
 */
public class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, Set<Integer>> vertices = new HashMap<>();
        for (int[] edge : edges) {
            vertices.computeIfAbsent(edge[0], k -> new HashSet<>()).add(edge[1]);
            vertices.computeIfAbsent(edge[1], k -> new HashSet<>()).add(edge[0]);
        }
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(source);
        while (!stack.isEmpty()) {
            var current = stack.pop();
            if (current == destination) {
                return true;
            }
            var neighbours = vertices.remove(current);
            if (neighbours == null) {
                continue;
            }
            for (var neighbour : neighbours) {
                stack.push(neighbour);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.validPath(3, new int[][]{{0, 1}, {1, 2}, {2, 0}}, 0, 2)); // true
        System.out.println(solution.validPath(3, new int[][]{{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}}, 0, 5)); // false
    }
}
