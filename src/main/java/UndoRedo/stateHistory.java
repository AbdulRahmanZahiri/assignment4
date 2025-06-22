package UndoRedo;

/**
 * A class that manages the history of states with undo/redo functionality
 * using a doubly linked list.
 */
public class stateHistory<T> {
    private Node<T> head;     // First state in the list
    private Node<T> current;  // Current active state

    // Constructor initializes an empty state history
    public stateHistory() {
        this.head = null;
        this.current = null;
    }

    // Adds a new state to the history and clears any future (redo) states
    public void addState(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            current = head;
        } else {
            // Clear redo history
            if (current != null) current.next = null;

            current.next = newNode;
            newNode.prev = current;
            current = newNode;
        }
    }

    // Moves back to the previous state (undo)
    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
        }
    }

    // Moves forward to the next state (redo)
    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
        }
    }

    // Returns the current state
    public T getCurrentState() {
        return current != null ? current.data : null;
    }
}
