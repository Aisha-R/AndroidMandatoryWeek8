package com.aisharooble.recyclerviewdemo.storage;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileStorage {

    private Context context;

    public FileStorage(Context context) {
        this.context = context;
    }

    public void saveToFile(Object object, String fileName) {
        try {
            FileOutputStream fos = new FileOutputStream(getFileObject(fileName));
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(object);
            oos.close();
            Log.i("all", "OK, writing...");
        } catch (Exception e) {
            Log.i("all", "error writing." + e.getMessage());
        }
    }

    public Object readFromFile(String fileName) {
        Object object;
        try {
            FileInputStream fis = new FileInputStream(getFileObject(fileName));
            ObjectInputStream ois = new ObjectInputStream(fis);
            object = ois.readObject();
            ois.close();
            Log.i("all", "OK, reading...");
        } catch (Exception e) {
            Log.i("all", "error reading." + e.getMessage());
        }
        return null;
    }

    private File getFileObject(String fileName) {
        File path = context.getFilesDir();
        return new File(path, fileName);
    }

}

