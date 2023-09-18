package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
public class MainActivity extends Activity {
    Spinner spinnerCourse;
    TextView textViewSelected;
    public static String arrayCourse[]={"Lập trình Android","Lập trình IOS","Thiết Kế Web","FaceBook Ads","Google Adwords","Lập trình C#"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Kết nối truy xuất View Spinner
        ConnectView();
        //Bước 4 : Khai báo đối tượng arrayAdapter chuyển dữ liệu từ mảng arrayCourse hiển thị lên Spinner
        ArrayAdapter spinnerAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1,arrayCourse);
        spinnerAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        spinnerCourse.setAdapter(spinnerAdapter);
        spinnerCourse.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
                String Msg;
                Msg = "Đã chọn Item : "+arrayCourse[position];
                Toast.makeText(MainActivity.this,Msg,Toast.LENGTH_LONG).show();
                textViewSelected.setText(Msg);
            }
            @Override
                    public void onNothingSelected(AdapterView<?>parent){
                textViewSelected.setText("Không có Item nào được chọn");
            }
        });
    }

    private void ConnectView() {
        spinnerCourse = (Spinner) findViewById(R.id.spinnercourseId);
        textViewSelected = (TextView) findViewById(R.id.textView);
    }
}