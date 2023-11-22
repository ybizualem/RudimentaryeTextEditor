import list.ArraySequence;

public class MyTextEditor implements SimpleTextEditor{
   private final ArraySequence<String> text;
   private int cursor;
    public MyTextEditor(){
     this.text = new ArraySequence<>();
     this.cursor = -1;
    }
    /**
     * Returns true if the text is completely empty (and cursor is at line -1).
     *
     * @return true if the text is empty and false otherwise
     */
    @Override
    public boolean isEmpty() {

        return text.isEmpty() && cursor == -1;
    }

    /**
     * Returns the current number of lines of text.
     *
     * @return the current number of lines
     */
    @Override
    public int size() {
       return text.size();
    }

    /**
     * Returns true if the cursor is at the last line in the text or the text
     * is empty.
     *
     * @return true if the cursor is at the last line and false otherwise.
     */
    @Override
    public boolean isCursorAtLastLine() {
        return (cursor == text.size()) || text.isEmpty();
    }

    /**
     * Sets the cursor to be the text line after its current position.
     *
     * @throws IndexOutOfBoundsException if the current line is size()-1
     */
    @Override
    public void cursorDown() throws IndexOutOfBoundsException {
        if(cursor == text.size()){
            throw new IndexOutOfBoundsException("Index out of bound");
        }
        cursor++;
    }

    /**
     * Sets the cursor to be the text line before its current position.
     *
     * @throws IndexOutOfBoundsException if the current line is 0
     */
    @Override
    public void cursorUp() throws IndexOutOfBoundsException {
        if(cursor == 0){
            throw new IndexOutOfBoundsException("Index out of bound");
        }
        cursor --;
    }

    /**
     * Sets the cursor to be the line ranked i (the first line is line 0).
     *
     * @param line The target line number.
     * @throws IndexOutOfBoundsException if the index is negative or greater
     *                                   than size()-1
     */
    @Override
    public void moveCursorToLine(int line) throws IndexOutOfBoundsException {
        if(line < 0 || line > text.size()-1){
            throw new IndexOutOfBoundsException("Index out of bound");
        }
        cursor = line;
    }

    /**
     * Returns the line number (rank) of the current cursor line.
     */
    @Override
    public int cursorLineNum() {
        return  cursor;
    }

    /**
     * Inserts a given string in the line after the current cursor, moving the
     * cursor to the line inserted.
     *
     * @param insertion The string to be inserted.
     */
    @Override
    public void insertAfterCursor(String insertion) {
      text.add(cursor+1,insertion);
      cursor++;
    }

    /**
     * Inserts the given string in the line before the current cursor, moving the
     * cursor to the line inserted.
     *
     * @param insertion The string to be inserted.
     */
    @Override
    public void insertBeforeCursor(String insertion) {
        text.add(cursor-1,insertion);
        cursor--;
    }

    /**
     * Get the current line at the cursor.
     *
     * @return The line of text at the cursor.
     */
    @Override
    public String getAtCursor() {
      return text.get(cursor);
    }

    /**
     * Replaces the string at the current cursor with the given string, keeping
     * the cursor at this line.
     *
     * @param replacement The string to be inserted.
     */
    @Override
    public void replaceAtCursor(String replacement) {
       text.set(cursor,replacement);


    }

    /**
     * Removes the entire line at the current cursor, setting the cursor to now
     * be the position of the next line, unless the cursor was the last line,
     * in which case the cursor should move to the new last line.
     */
    @Override
    public void removeAtCursor() {
        int currentLine = text.size() -1;
        text.remove(cursor);
        if( currentLine == cursor) {
            cursorDown();
        }
    }
    @Override
    public String toString(){
        StringBuilder store = new StringBuilder();
        for(int i = 0; i < text.size();i++){
            store.append(text.get(i));
            if(i < text.size()-1){
                store.append("\n");
            }
        }

        return String.valueOf(store);
    }

}