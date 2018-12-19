// From leetcode: https://leetcode.com/problems/clone-graph/description/

// Q.Clone Graph
//Definition for undirected graph.
class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;

    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
};
