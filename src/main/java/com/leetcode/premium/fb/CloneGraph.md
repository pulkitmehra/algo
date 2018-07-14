#Clone Graph

```
public class Solution {
    
    
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node==null){
            return node;
        }
        
        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
        UndirectedGraphNode head = new UndirectedGraphNode(node.label);
        map.put(node.label, head);
        
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        q.offer(node);
        
        while(!q.isEmpty()){
            
            UndirectedGraphNode u = q.poll();
            UndirectedGraphNode clone = map.get(u.label);
            
            for(UndirectedGraphNode v : u.neighbors){
                if(!map.containsKey(v.label)){
                    q.offer(v);
                    map.put(v.label, new UndirectedGraphNode(v.label));
                }
                clone.neighbors.add(map.get(v.label));
            }
            
        }
        return head;
        
    }
}

```