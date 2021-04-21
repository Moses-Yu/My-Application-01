package com.example.myapplication01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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
        }
        return onOptionsItemSelected(item);
    }
}