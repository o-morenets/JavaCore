package leetcode._207_Course_Schedule;

import java.util.*;

/**
 * 207. Course Schedule
 * Medium
 * Topics
 * premium lock icon
 * Companies
 * Hint
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
 * <p>
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return true if you can finish all courses. Otherwise, return false.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0. So it is possible.
 * Example 2:
 * <p>
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= numCourses <= 2000
 * 0 <= prerequisites.length <= 5000
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * All the pairs prerequisites[i] are unique.
 */
public class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] state = new int[numCourses]; // 0 - UNVISITED, 1 - VISITING, 2 - VISITED
        List<Integer>[] graph = createGraph(numCourses, prerequisites);

        for (int i = 0; i < numCourses; i++) {
            if (!canFinishDfs(graph, state, i)) {
                return false;
            }
        }

        return true;
    }

    private boolean canFinishDfs(List<Integer>[] graph, int[] state, int v) {
        state[v] = 1;

        for (int w : graph[v]) {
            if (state[w] == 1) {
                return false; // cycle
            }

            if (state[w] == 0) {
                if (!canFinishDfs(graph, state, w)) {
                    return false;
                }
            }
        }
        state[v] = 2;

        return true;
    }

    private List<Integer>[] createGraph(int numCourses, int[][] prerequisites) {
        List[] vertices = new List[numCourses];

        for (int i = 0; i < numCourses; i++) {
            vertices[i] = new ArrayList<>();
        }

        for (int[] prerequisite : prerequisites) {
            int source = prerequisite[1];
            int target = prerequisite[0];
            vertices[source].add(target);
        }

        return vertices;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canFinish(2, new int[][]{{1, 0}})); // true
        System.out.println(solution.canFinish(2, new int[][]{{1, 0}, {0, 1}})); // false (cycle)
        System.out.println(solution.canFinish(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}})); // true
    }
}
