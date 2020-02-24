package com.aisharooble.recyclerviewdemo.view;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aisharooble.recyclerviewdemo.R;
import com.aisharooble.recyclerviewdemo.storage.NoteStorage;

public class ViewHolder extends RecyclerView.ViewHolder{

    public static final String rowKey = "ROW_KEY";

    public TextView textView;

    public ImageView imageView;

    public Button button;

    public int rowNumber = -1; //number, which corresponds to the item's position on the list.

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        LinearLayout linearLayout = (LinearLayout) itemView;
        textView = linearLayout.findViewById(R.id.textView1);
        imageView = linearLayout.findViewById(R.id.imageView);
        button = linearLayout.findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("all", "you clicked " + rowNumber);
                NoteStorage.getNote(rowNumber).toggleLike();
                if(NoteStorage.getNote(rowNumber).getLiked()) {
                    button.setText("Liked");
                } else {
                    button.setText("Like");
                }
            }
        });

        setTextViewListener();
    }

    public void setTextViewListener() {
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), detailActivity.class);
                intent.putExtra(rowKey, rowNumber);
                view.getContext().startActivity(intent);
            }
        });
    }

    public void setData(int row) {
        rowNumber = row;
        textView.setText(NoteStorage.getNote(rowNumber).headline);
        imageView.setImageResource(getImageId());
    }

    private int getImageId() {
        switch (rowNumber) {
            case 0: return R.drawable.image0;
            case 1: return R.drawable.image1;
            case 2: return R.drawable.image2;
            case 3: return R.drawable.image3;
            case 4: return R.drawable.image4;
            case 5: return R.drawable.image5;
            case 6: return R.drawable.image6;
            case 7: return R.drawable.image7;
            case 8: return R.drawable.image8;
            case 9: return R.drawable.image9;
        }
        return R.drawable.image8;
    }

}
