package game.rpg_engine.entity;
import game.rpg_engine.enums.Direction;
import game.rpg_engine.feature.Feature;
import game.rpg_engine.world.map.Map;
import game.rpg_engine.world.coordinates.RelativeCord;

import java.util.*;


public abstract class PathfindingEntity extends Entity implements Ticker
{
    PathfindingEntity(char ch, RelativeCord cord, double health, double maxHealth, int x, int y){
        super(ch, cord, health, maxHealth, x, y);

    }

    protected PathfindingEntity(char ch, RelativeCord cord, double health, double maxHealth, int x){
        this(ch, cord, health, maxHealth, x, x);

    }

    public boolean canWalkTo(RelativeCord newCord){
        Map map = cord.getMap();
        return map.canWalkTo(newCord);
    }

    public List<RelativeCord> pathFind(RelativeCord target) {
        Map map = cord.getMap();

        PriorityQueue<Node> nodes = new PriorityQueue<>(Comparator.comparingInt((Node n) -> n.f));
        HashMap<RelativeCord, Integer> bestG = new HashMap<>();

        nodes.offer(new Node(cord, null, 0, RelativeCord.manhattenDist(cord, target)));
        bestG.put(cord, 0);

        while (!nodes.isEmpty()) {
            Node current = nodes.poll();

            if (current.g > bestG.get(current.cord)) continue;

            if (current.cord.equals(target)) {
                return buildPath(current);
            }

            for (Direction dir : Direction.values()) {
                RelativeCord neighbor = current.cord.getCordBy(dir);

                if (neighbor.equals(current.cord)) continue;

                Optional<Feature> feature = map.getFeatureAt(neighbor);
                if (feature.isEmpty()) continue;

                if (!neighbor.equals(target) && !feature.get().canWalkOn()) continue;

                int newG = current.g + feature.get().getTileCost();

                Integer known = bestG.get(neighbor);
                if (known == null || newG < known) {
                    bestG.put(neighbor, newG);
                    nodes.offer(new Node(neighbor, current, newG,
                            RelativeCord.manhattenDist(neighbor, target)));
                }
            }
        }
        return new ArrayList<>();
    }

    private List<RelativeCord> buildPath(Node end) {
        List<RelativeCord> path = new ArrayList<>();
        for (Node n = end; n.parent != null; n = n.parent) {
            path.add(n.cord);
        }
        Collections.reverse(path);
        return path;
    }



    private static class Node{
        RelativeCord cord;
        Node parent;
        int g;
        int h;
        int f;
        Node(RelativeCord cord, Node node, int g, int h){
            this.cord = cord;
            this.parent = node;
            this.g = g;
            this.h = h;
            f = g + h;
        }
    }
}
