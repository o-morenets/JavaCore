package stackOverflow.dijkstra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Main {
    private static final Integer INFINITY = Integer.MAX_VALUE - 10; // псевдобесконечность

    private static HashMap<String, Integer> inner(String[] Keys, Integer[] Values) {
        HashMap<String, Integer> innerMap = new HashMap<>();
        for (int i = 0; i < Keys.length; i++) {
            innerMap.put(Keys[i], Values[i]);
        }
        return innerMap;
    }

    private static String getLowestCost(Map<String, Integer> costs, List<String> processed) {
        Integer min = Integer.MAX_VALUE - 1;
        String minStr = null;
        for (Entry<String, Integer> o : costs.entrySet()) {
            if (o.getValue() < min && (!processed.contains(o.getKey()))) {
                min = o.getValue();
                minStr = o.getKey();
            }
        }
        return minStr;
    }

    public static void main(String[] args) {
        ///////////////////Заготовка////////////////
        Map<String, HashMap<String, Integer>> graph = new HashMap<>(); // Мапа графа

        /*Заполнение мапы графа через функцию, возвращающую HashMap, для вложенности*/
        graph.put("start", inner(new String[]{"A", "B"}, new Integer[]{6, 2}));
        graph.put("A", inner(new String[]{"end"}, new Integer[]{1}));
        graph.put("B", inner(new String[]{"A", "end"}, new Integer[]{3, 5}));
        graph.put("end", null);

        Map<String, Integer> costs = new HashMap<>(); // Мапа стоимостей
        costs.put("A", 6);
        costs.put("B", 2);
        costs.put("end", INFINITY);

//        Map<String, String> parents = new HashMap<>();//Мапа родителей для обратного хода (кратчайший путь)
//        parents.put("A", "start");
//        parents.put("B", "start");
//        parents.put("end", null);

        List<String> processed = new ArrayList<>();

        ////////////////// Алгоритм //////////////////////
        String node = getLowestCost(costs, processed);
        while (node != null) {
            Integer cost = costs.get(node);
            HashMap<String, Integer> neighbours = graph.get(node);
            if (neighbours != null) {
                for (String n : neighbours.keySet()) {
                    Integer newCost = cost + neighbours.get(n);
                    if (newCost < costs.get(n)) {
                        costs.put(n, newCost);
    //                    parents.put(n, node);
                    }
                }
            }
            processed.add(node);
            node = getLowestCost(costs, processed);
        }
        System.out.println("BlaBlaBla");
    }
}
