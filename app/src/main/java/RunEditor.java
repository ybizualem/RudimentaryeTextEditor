/**
 * A way to invoke the editor from the command line.
 */
public class RunEditor {
    /**
     * The main entry point
     *
     * @param args No parameters expected.
     */
    public static void main(String[] args) {
        SimpleTextEditor editor = new MyTextEditor();
        String[] expected = EditorUtilities.readResourceFile("final.txt");

        // Load content into editor
        for (String line : expected) {
       editor.insertAfterCursor(line);
        }
        System.out.println(editor);
    }
}
