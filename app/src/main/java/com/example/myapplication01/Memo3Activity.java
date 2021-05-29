package com.example.myapplication01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Date;

public class Memo3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo3);

        EditText editText_title = (EditText) findViewById(R.id.editText_title);
        EditText editText_content = (EditText) findViewById(R.id.editText_content);
        Memo3 memo = (Memo3)getIntent().getSerializableExtra("MEMO");
        if (memo != null) {
            editText_title.setText(memo.getTitle());
            editText_content.setText(memo.getContent());
        }

        Button button = (Button) findViewById(R.id.btnSave);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = editText_title.getText().toString();
                if (TextUtils.isEmpty(title)) {
                    editText_title.setError("제목을 입력하세요");
                    return;
                }

                String content = editText_content.getText().toString();
                if (TextUtils.isEmpty(content)) {
                    editText_content.setError("내용을 입력하세요");
                    return;
                }

                Memo3 memo = new Memo3(title, content, new Date());
                Intent intent = new Intent();
                intent.putExtra("MEMO", memo);
                setResult(RESULT_OK, intent);
                finish();
            }
        };
        button.setOnClickListener(listener);
    }
}

