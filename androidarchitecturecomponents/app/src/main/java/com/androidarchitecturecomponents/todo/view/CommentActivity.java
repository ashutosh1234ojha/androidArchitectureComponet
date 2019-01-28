package com.androidarchitecturecomponents.todo.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.EditText;

import com.androidarchitecturecomponents.R;

/**
 * Created by Ashutosh Ojha on 1/16/19.
 */
public class CommentActivity extends AppCompatActivity {

    private EditText etComment;
    private Button btnSubmit;
    private RecyclerView rvComments;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);


        init();
    }

    private void init() {

        etComment = findViewById(R.id.etComment);
        btnSubmit = findViewById(R.id.btnSubmit);
        rvComments = findViewById(R.id.rvComments);
    }
}
