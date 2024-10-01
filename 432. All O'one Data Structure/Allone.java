import java.util.HashMap;
import java.util.HashSet;

class AllOne {

    private class Node {
        int count;
        HashSet<String> keys;
        Node prev;
        Node next; 

        public Node(int count){
            this.count = count;
            this.keys = new HashSet<>();
        }
    }

    private Node head, tail;
    private HashMap<String, Node> keyNodeMap;

    public AllOne() {
        head = new Node(Integer.MIN_VALUE); // Dummy head
        tail = new Node(Integer.MAX_VALUE); // Dummy tail
        head.next = tail;
        tail.prev = head;
        keyNodeMap = new HashMap<>();
    }
    
    public void inc(String key) {
        if (!keyNodeMap.containsKey(key)) {
            if (head.next.count != 1) {
                addNodeAfter(new Node(1), head);
            }
            head.next.keys.add(key);
            keyNodeMap.put(key, head.next);
        } else {
            Node curNode = keyNodeMap.get(key);
            curNode.keys.remove(key);
            if (curNode.next.count != curNode.count + 1) {
                addNodeAfter(new Node(curNode.count + 1), curNode);
            }
            curNode.next.keys.add(key);
            keyNodeMap.put(key, curNode.next);
            if (curNode.keys.isEmpty()) {
                removeNode(curNode);
            }
        }
    }
    
    public void dec(String key) {
        if (!keyNodeMap.containsKey(key)) {
            return;
        }
        Node curNode = keyNodeMap.get(key);
        curNode.keys.remove(key);
        if (curNode.count > 1) {
            if (curNode.prev.count != curNode.count - 1) {
                addNodeAfter(new Node(curNode.count - 1), curNode.prev);
            }
            curNode.prev.keys.add(key);
            keyNodeMap.put(key, curNode.prev);
        } else {
            keyNodeMap.remove(key);
        }
        if (curNode.keys.isEmpty()) {
            removeNode(curNode);
        }
    }
    
    public String getMaxKey() {
        return tail.prev == head ? "" : tail.prev.keys.iterator().next();
    }
    
    public String getMinKey() {
        return head.next == tail ? "" : head.next.keys.iterator().next();
    }

    private void addNodeAfter(Node newNode, Node prevNode) {
        newNode.prev = prevNode;
        newNode.next = prevNode.next;
        prevNode.next.prev = newNode;
        prevNode.next = newNode;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}
