# RudimentaryeTextEditor
This project was omplemented in three phases
The MyTextEditor project is a Java-based text editor implementation designed for efficient manipulation of lines of text. This project follows a phased approach, providing a structured development process.

Features
# Phase 1: ArraySequence Implementation

Utilizes a dynamic array to represent a sequence of elements.
Implements the Sequence interface with methods for array-based positional lists.
Unit tests in ArraySequenceTest validate the correctness of the implementation.

# Phase 2: MyTextEditor Implementation

Introduces the MyTextEditor class, built on the ArraySequence class.
Allows the manipulation of one line of text at a time.
Features a cursor to navigate through lines.
Unit tests in EditorTest ensure the proper functioning of the editor.

# Phase 3: Transition States

Guides the transition of the editor's state from initial to middle and final states.
The applyMiddleState() and applyFinalState() methods facilitate state transitions.
Tests in EditorTest compare the editor's state against goal files.
