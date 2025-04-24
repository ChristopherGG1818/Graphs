import java.util.*;

public class DrawingGaprh {
    static class Node {
        String label;
        int step;

        Node(String label, int step) {
            this.label = label;
            this.step = step;
        }
    }

    public static void main(String[] args) {
        Node[] vertices = {
                new Node("I", 2),
                new Node("A", 5),
                new Node("E", 4),
                new Node("F", 2),
                new Node("T", 2),
                new Node("S", 3)
        };

        int n = vertices.length;

        Map<String, List<String>> graph = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String current = vertices[i].label;
            int step = vertices[i].step;

            int right = i + step;
            if (right >= n) {
                right = right - n;
            }
            int left = i - step;
            if (left < 0) {
                left = left + n;
            }

            graph.putIfAbsent(current, new ArrayList<>());
            graph.get(current).add(vertices[right].label);
            graph.get(current).add(vertices[left].label);
        }

        for (String key: graph.keySet()) {
            System.out.println(key + " to " + graph.get(key));
        }
    }
}
