import java.util.*;

public class Pathlength {
    static class Side {
        int to, weight;
        Side(int t, int w) {
            to = t;
            weight = w;
        }
    }

    static Map<Integer, List<Side>> graph = new HashMap<>();
    static List<Integer> currentPath = new ArrayList<>();

    public static void target(int current, int target,
                              int currentWeight, Set<Integer> visited) {
        if (currentWeight > 7) return;

        if (current == target && currentWeight == 7) {
            System.out.println(currentPath);
            return;
        }

        for (Side edge : graph.getOrDefault(current, new ArrayList<>())) {
            if (!visited.contains(edge.to)) {
                visited.add(edge.to);
                currentPath.add(edge.to);
                target(edge.to, target, currentWeight
                        + edge.weight, visited);
                currentPath.remove(currentPath.size() - 1);
                visited.remove(edge.to);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int edges = sc.nextInt();

        for (int i = 0; i < edges; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int weight = sc.nextInt();

            if (!graph.containsKey(from)) {
                graph.put(from, new ArrayList<Side>());
            }
            graph.get(from).add(new Side(to, weight));
        }

        int start = sc.nextInt();
        int end = sc.nextInt();

        currentPath.add(start);
        target(start, end, 0, new HashSet<>(Set.of(start)));
    }
}
