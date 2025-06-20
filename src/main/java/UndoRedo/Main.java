package UndoRedo;

public class Main {
    public static void main(String[] args) {
        stateHistory<String> editor = new stateHistory<>();
        editor.addState("1");
        editor.addState("2");
        editor.addState("3");
        editor.addState("4");
        editor.addState("5");

        System.out.println("Current State: " + editor.getCurrentState());

        editor.undo(); // back to "4"
        editor.undo(); // back to "3"
        System.out.println("After 2 undo: " + editor.getCurrentState());

        editor.redo(); // forward to "4"
        System.out.println("After 1 redo: " + editor.getCurrentState());

        editor.addState("6"); // clears redo history
        System.out.println("After adding new state: " + editor.getCurrentState());

        editor.undo();
        System.out.println("After undo: " + editor.getCurrentState());

        editor.redo();
        System.out.println("After redo: " + editor.getCurrentState());
    }
}
