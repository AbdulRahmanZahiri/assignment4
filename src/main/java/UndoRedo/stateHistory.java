package UndoRedo;

public class stateHistory<T> {
    private Node<T> head;
    private Node<T> current;

    public stateHistory() {
        this.head = null;
        this.current = null;
    }

    public void addState(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            current = head;
        } else {
            if (current != null) current.next = null;

            current.next = newNode;
            newNode.prev = current;
            current = newNode;
        }
    }

    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
        }
    }

    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
        }
    }

    public T getCurrentState() {
        return current != null ? current.data : null;
    }
}
