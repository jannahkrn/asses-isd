//pake haspmap udah
//pake bfs udah
//pake dfs udah

import java.util.*;

public class GrafBurger {
    static Map<String, List<String>> graph = new HashMap<>();

    public static void main(String[] args) {
        addEdge("preheat oven", "bake bread");
        addEdge("preheat oven", "preheat pan");
        addEdge("bake bread", "serve bread");
        addEdge("serve bread", "eat");
        addEdge("serve bread", "add some pickles");
        addEdge("preheat pan", "add krabby patty");
        addEdge("add krabby patty", "serve patty");
        addEdge("add krabby patty", "add tartar sauce");
        addEdge("serve patty", "pour sauce over patty");
        addEdge("pour sauce over patty", "eat");
        addEdge("add tartar sauce", "eat");
        addEdge("add some pickles", "eat");
        addEdge("preheat pan", "set plate");
        addEdge("set plate", "eat");

        System.out.println("Munculkan seluruh langkah, jika langkah-langkah yang berdekatan ditampilkan terlebih dahulu: ");
        bfs("preheat oven");
        
        System.out.println("\nMunculkan seluruh langkah, jika langkah-langkah yang semakin menjauh ditampilkan terlebih dahulu: ");
        Set<String> visited = new HashSet<>();
        dfs("preheat oven", visited);
    }

    static void addEdge(String from, String to) {
        graph.putIfAbsent(from, new ArrayList<>());
        graph.get(from).add(to);
    }

    static void bfs(String start) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            System.out.println(current);

            List<String> neighbors = graph.getOrDefault(current, new ArrayList<>());
            for (String neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }

    static void dfs(String node, Set<String> visited) {
        visited.add(node);
        System.out.println(node);

        List<String> neighbors = graph.getOrDefault(node, new ArrayList<>());
        for (String neighbor : neighbors) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, visited);
            }
        }
    }
}
