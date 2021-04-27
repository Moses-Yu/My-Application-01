package com.example.myapplication01;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

public class AlertsActivity extends AppCompatActivity {

    int selectedAnimalIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alerts);
    }

    public void button1_clicked(View button){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.saveSuccess);
        builder.setNeutralButton(R.string.close, null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }
    public void button2_clicked(View button){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.confirm);
        builder.setMessage(R.string.doYouWantToDelete);
        builder.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //삭제작업실행
                Toast.makeText(AlertsActivity.this, "삭제 성공", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNeutralButton(R.string.no, null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }
    public void button3_clicked(View button){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.selectAnimal);
        builder.setSingleChoiceItems(R.array.animals, selectedAnimalIndex, null);
        builder.setPositiveButton(R.string.confirm, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int index) {
                ListView listView = ((AlertDialog)dialog).getListView();
                selectedAnimalIndex = listView.getCheckedItemPosition();
                String msg = (selectedAnimalIndex+1) + " 번째 항목이 선택되었습니다.";
                Toast.makeText(AlertsActivity.this, msg, Toast.LENGTH_SHORT).show();

                int drawableId = 0; // res
                switch(selectedAnimalIndex){
                    case 0:drawableId = R.drawable.animal_cat_large; break;
                    case 1:drawableId = R.drawable.animal_dog_large; break;
                    case 2:drawableId = R.drawable.animal_owl_large; break;
                }
                ImageView imageView1 = (ImageView) findViewById(R.id.imageView);
                imageView1.setImageResource(drawableId);
            }
        });
        builder.setNegativeButton(R.string.cancel, null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

}