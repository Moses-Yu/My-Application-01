package com.example.myapplication01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

//    메뉴가 생성되어야 할 때 저절로 호출되는 메소드이다.
//    액티비티 클래스에서 이 메소드를 재정의(override)해서, 메뉴 생성 코드를 구현해야 한다.
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

//    메뉴 항목이 클릭되면 저절로 호출되는 메소드이다.
//    액티비티 클래스에서 이 메소드를 재정의(override)해서, 메뉴가 클릭되었을 때 해야할 일을 구현해야 한다.
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id == R.id.action_signUp){
            Toast.makeText(this, "회원가입 메뉴 클릭", Toast.LENGTH_SHORT).show();
            return true;
        }else if(id == R.id.action_memo){
            Toast.makeText(this, "메모장 메뉴 클릭", Toast.LENGTH_SHORT).show();
            return true;
        }else if(id == R.id.action_spinners){
            //Activity 실행
            Intent intent = new Intent(this, SpinnersActivity.class);
            startActivity(intent);
            //
            return true;
        }else if(id == R.id.action_alerts){
            Intent intent = new Intent(this, AlertsActivity.class);
            startActivity(intent);
            return true;
        }
        return onOptionsItemSelected(item);
    }

    public void btnListView_clicked(View view){
        Intent intent = new Intent(this, ListViewActivity.class);
        startActivity(intent);
    }
    public void btnRecyclerView1_clicked(View view){
        Intent intent = new Intent(this, RecyclerView1Activity.class);
        startActivity(intent);
    }
    public void btnRecyclerView2_clicked(View view){
        Intent intent = new Intent(this, RecyclerView2Activity.class);
        startActivity(intent);
    }
    public void btnMemo3_clicked(View view){
        Intent intent = new Intent(this, Memo3Activity.class);
        startActivityForResult(intent, 0);
    }

    public void btnRecyclerView3_clicked(View view){
        Intent intent = new Intent(this,RecyclerView3Activity.class);
        startActivityForResult(intent, 0);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (resultCode == RESULT_OK) {
            Memo3 memo = (Memo3)intent.getSerializableExtra("MEMO");
            String s = String.format(
                    "<h1>%s</h1><p>%s</p><p style='color: blue'>%s</p>",
                    memo.getTitle(), memo.getDateFormatted(), memo.getContent());
            TextView textView = findViewById(R.id.textView);
            textView.setText(Html.fromHtml(s));
        }
    }

}