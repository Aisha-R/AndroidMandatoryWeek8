package com.aisharooble.recyclerviewdemo.storage;

import android.util.Log;

import com.aisharooble.recyclerviewdemo.Model.Note;

import java.util.ArrayList;
import java.util.List;

public class NoteStorage {

    private static List<Note> list;

    private static FileStorage fileStorage;
    private static final String fileName = "data.dat";

    static { // static block, used to initialise static variables
        list = new ArrayList<>();
        Note note = new Note("Note 1", "Body 1");
        Note note2 = new Note("Note 2", "Body 2");
        Note note3 = new Note("Note 3", "Body 3");
        list.add(note);
        list.add(note2);
        list.add(note3);

    }

    public static void setFileStorage(FileStorage fs) {
        fileStorage = fs;
    }

    public static void saveNotesToFile() {
        fileStorage.saveToFile(list, fileName);
    }

    public static void readNotesFromFile() {
        Object object = fileStorage.readFromFile(fileName);
        if(object != null) {
            list = (List<Note>)object;
            Log.i("all", "size: " + list.size());
        }
    }

    public static Note getNote(int index) {
        return list.get(index);
    }

    public static int getLength() {
        return list.size();
    }

}
