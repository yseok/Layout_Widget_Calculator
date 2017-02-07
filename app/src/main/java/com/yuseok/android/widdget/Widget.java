package com.yuseok.android.widdget;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Widget extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener{

    ToggleButton tb;
    CheckBox cbApple;
    CheckBox cbBanana;
    CheckBox cbCherry;
    RadioGroup rd;
    Spinner spinner;
    SeekBar seekBar;
    TextView seekTv;


     // String  months [] = {"JAN", "FEB", "MAR"};
    // String  months [];
    ArrayList<String> months = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widget);

        // 1.컴파운드 계열 버튼 작성
        tb = (ToggleButton) findViewById(R.id.tb);
        cbApple = (CheckBox) findViewById(R.id.cbApple);
        cbBanana = (CheckBox) findViewById(R.id.cbBanana);
        cbCherry = (CheckBox) findViewById(R.id.cbCherry);

        // 1-1 컴파운드 계열 리스너 등록
        tb.setOnCheckedChangeListener(this);
        cbApple.setOnCheckedChangeListener(this);
        cbBanana.setOnCheckedChangeListener(this);
        cbCherry.setOnCheckedChangeListener(this);

        // 2. 라디오
        rd = (RadioGroup) findViewById(R.id.rd);
        // 2.1 라디오 그룹 리스너 생성 및 등록 같이하기
        rd.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rdAnaconda:
                        Toast.makeText(Widget.this, "Anaconda 라디오 버튼", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rdBear:
                        Toast.makeText(Widget.this, "Bear 라디오 버튼", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rdCat:
                        Toast.makeText(Widget.this, "Cat 라디오 버튼", Toast.LENGTH_SHORT).show();
                        break;
                }

                /*
                swhich(checkedId) {
                case 몇번째;
                break;
                 */
            }
        });

        // 3. 스피너
        spinner = (Spinner) findViewById(R.id.spinner);

        // 3.pre 스피너에 들어갈 데이터를 동적으로 정의하세요/
        // 데이터는 올해부터 ~ 100년전까지
        // months.add("2017")
        for(int index = 2017; index < 2017-100; index--) {
            months.add(index + " ");

        }


        // 3.1 스피너 데이터 아답터 등록
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_dropdown_item_1line, months
                //컨텍스트,             스피너에서 사용할 레이아웃,  배열 데이터
        );
        // 3.2 스피너에 adapter등록
        spinner.setAdapter(adapter);
        // 3.3 스피너 리스너 등록
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Widget.this, "선택된아이템 ="+months.get(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekTv = (TextView) findViewById(R.id.seekTv);

        // 4.1 seekbar에 리스너를 등록한다.
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            // 4.1.2 seekbar를 움직이면 호출되는 함수
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekTv.setText(progress + " ");

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    public void onCheckedChanged(CompoundButton cd, boolean flag) {
        switch(cd.getId()) {
            case R.id.tb :
                Toast.makeText(this, "토글됨 = " + flag, Toast.LENGTH_SHORT).show();
                break;
            case R.id.cbApple :
                Toast.makeText(this, "사과 체크됨 = " + flag, Toast.LENGTH_SHORT).show();
                break;
            case R.id.cbBanana :
                Toast.makeText(this, "바나나 체크됨 = " + flag, Toast.LENGTH_SHORT).show();
                break;
            case R.id.cbCherry :
                Toast.makeText(this, "체리 체크됨 = " + flag, Toast.LENGTH_SHORT).show();
                break;
        }

    }

    /*
    // 토글 버튼용 리스너
    CompoundButton.OnCheckedChangeListener toggleListen = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            Toast.makeText(Widget.this, "토글됨 = " + b, Toast.LENGTH_SHORT).show();
        }
    };
    */


}
