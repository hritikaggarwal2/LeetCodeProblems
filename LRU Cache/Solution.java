public class LRUCache {
    private class Node {
        int key;
        int value;
        Node next;
        Node prev;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            next = null;
            prev = null;
        }
    }

    private int capacity;
    private int size;
    private Node head;
    private Node tail;
    private Map<Integer, Node> store; // key -> node

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = null;
        tail = null;
        size = 0;
        store = new HashMap<>();
    }

    public int get(int key) {
        if (!store.containsKey(key)) {
            return -1;
        }

        Node toGet = store.get(key);

        if (toGet == head) {
            return toGet.value;
        }

        toGet.prev.next = toGet.next;

        if (toGet != tail) { // toGet is not a tail
            toGet.next.prev = toGet.prev;
        } else { // toGet is tail
            tail = toGet.prev;
        }

        toGet.next = head;
        toGet.prev = null;

        head.prev = toGet;
        head = toGet;

        return store.get(key).value;
    }

    public void put(int key, int value) {
        if (store.containsKey(key)) {
            store.get(key).value = value;
            get(key);
            return;
        }

        if (head == null) {
            head = new Node(key, value);
            tail = head;
            size++;
            store.put(key, head);
            return;
        } else if (capacity == 1) {
            head = new Node(key, value);
            tail = head;
            size = 1;
            store.clear();
            store.put(key, head);
            return;
        }

        if (size < capacity) {
            Node create = new Node(key, value);
            head.prev = create;
            create.next = head;
            head = create;

            size++;
            store.put(key, create);
            return;
        }

        // Remove tail
        tail.prev.next = null;
        store.remove(tail.key);
        tail = tail.prev;

        // Add head
        Node create = new Node(key, value);

        create.next = head;
        head.prev = create;
        head = create;

        store.put(key, create);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj =
 * new LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */