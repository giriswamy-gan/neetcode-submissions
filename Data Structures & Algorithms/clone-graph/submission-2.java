/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Map<Node, Node> map = new HashMap<>();
        Deque<Node> q = new LinkedList<>();
        map.put(node, new Node(node.val));
        q.add(node);

        while(!q.isEmpty()) {
            Node cur = q.poll();
            for(Node neigh : cur.neighbors) {
                if(!map.containsKey(neigh)) {
                    map.put(neigh, new Node(neigh.val));
                    q.add(neigh);
                }
                map.get(cur).neighbors.add(map.get(neigh));
            }
        }
        return map.get(node);
    }
}