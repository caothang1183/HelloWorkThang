package com.example.helloworkthang;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class AddEditNoteActivity extends AppCompatActivity {
    public static final String  INTENT_ID = "INTENT_ID";
    public static final String INTENT_TITLE = "INTENT_TITLE";
    public static final String INTENT_DESCRIPTION = "INTENT_DESCRIPTION";
    private Button btnSave;
    private Button btnCancel;
    private TextView textAction;
    private EditText etTitle;
    private EditText etDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_note);
        getSupportActionBar().setTitle("NOTE");

        initView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_note_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_save_note:
                saveNote();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void saveNote() {
        String title = etTitle.getText().toString();
        String description = etDescription.getText().toString();
        if (title.trim().isEmpty() || description.trim().isEmpty()) {
            Toast.makeText(this, "Please insert title and description", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent data = new Intent();
        data.putExtra(INTENT_TITLE, title);
        data.putExtra(INTENT_DESCRIPTION, description);

        int id = getIntent().getIntExtra(INTENT_ID, -1);
        if(id != -1){
            data.putExtra(INTENT_ID, id);
        }

        setResult(RESULT_OK, data);
        finish();
    }

    private void initView() {
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);
        Intent intent = getIntent();
        textAction = findViewById(R.id.text_note_action);
        etTitle = findViewById(R.id.edit_text_title);
        etDescription = findViewById(R.id.edit_text_description);
        btnSave = findViewById(R.id.btn_save);
        btnCancel = findViewById(R.id.btn_cancel);
        if(intent.hasExtra(INTENT_ID)){
            textAction.setText(R.string.note_edit);
            etTitle.setText(intent.getStringExtra(INTENT_TITLE));
            etDescription.setText(intent.getStringExtra(INTENT_DESCRIPTION));
        }else {
            textAction.setText(R.string.note_add);
        }

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveNote();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
