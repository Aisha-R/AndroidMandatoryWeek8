package com.aisharooble.recyclerviewdemo.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.aisharooble.recyclerviewdemo.R;
import com.aisharooble.recyclerviewdemo.storage.NoteStorage;

public class detailActivity extends AppCompatActivity {

    private TextView textView;
    private EditText editText;
    private int row = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        int row = getIntent().getIntExtra(ViewHolder.rowKey, 0);

        textView.findViewById(R.id.headline);
        editText.findViewById(R.id.detailText);

        textView.setText(NoteStorage.getNote(row).headline);
        editText.setText(NoteStorage.getNote(row).body);
    }

    @Override
    protected void onPause() {
        super.onPause();
        NoteStorage.getNote(row).headline = textView.getText().toString();
        NoteStorage.getNote(row).body = editText.getText().toString();
    }

}
