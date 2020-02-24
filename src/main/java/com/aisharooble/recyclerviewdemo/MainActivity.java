package com.aisharooble.recyclerviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import com.aisharooble.recyclerviewdemo.Model.Note;
import com.aisharooble.recyclerviewdemo.adapter.MyRecycleViewAdapter;
import com.aisharooble.recyclerviewdemo.storage.FileStorage;
import com.aisharooble.recyclerviewdemo.storage.NoteStorage;
import com.aisharooble.recyclerviewdemo.view.detailActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    //private ArrayList<String> list = new ArrayList<>();

    private RecyclerView.Adapter adapter;

    private EditText editText;
    private boolean isEditing = false;
    private int currentRow = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NoteStorage.setFileStorage(new FileStorage(this));
        NoteStorage.saveNotesToFile();
        NoteStorage.readNotesFromFile();

        recyclerView = findViewById(R.id.recyclerView1);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new MyRecycleViewAdapter(getList());
        recyclerView.setAdapter(adapter);

//        editText = findViewById(R.id.editText);
//
//        recyclerView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Log.i("all", "pressed at " + position);
//                isEditing = true;
//                editText.setText(list.get(position));
//                currentRow = position;
//                viewNotes(view);
//
//            }
//        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        NoteStorage.readNotesFromFile();
        adapter.notifyDataSetChanged();//this will make the list update itself.
        Log.i("all", "onResume()...");
    }

    private ArrayList<String> getList() {
        ArrayList<String> list = new ArrayList<>();
        return list;
    }

//    public void addNote(View view) {
//        String message = editText.getText().toString();
//        if (message.length() > 0 ) {
//            if(isEditing) {
//                list.set(currentRow, message);
//                isEditing = false;
//            } else {
//                list.add(message);
//            }
//            //adapter.notifyDataSetChanged();
//            editText.getText().clear();
//        }
//    }

}
