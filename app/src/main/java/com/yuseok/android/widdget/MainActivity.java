package com.yuseok.android.widdget;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    // 1.위젯을 선언한다.
    Button btn, cal, widget, unit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // R은 안드로이드 리소스의 약자

        // 2.정의된 위젯변수에 xml의 위젯 id를 가져와서 담아준다.
        btn = (Button)findViewById(R.id.btnGrid);
        cal = (Button)findViewById(R.id.cal);
        widget = (Button)findViewById(R.id.widget);
        unit = (Button)findViewById(R.id.unit);


        // 3. 변수(위젯)을 리스너에 달아준다.
        btn.setOnClickListener(this);
        cal.setOnClickListener(this);
        widget.setOnClickListener(this);
        unit.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.btnGrid:
                // 안드로이드 메이저 컴포넌트를 로드하기 위해서는
                // intent 를 통해서 로드할 컴포넌트를 지정해야 한다.
                intent = new Intent(this, Grid.class);
                                        // ^ 대상이 되는 컴포넌트
                startActivity(intent);
                break;

            case R.id.cal:
                intent = new Intent(this, CalculatorActivity.class);
                startActivity(intent);
                break;

            case R.id.widget:
                intent = new Intent(this, Widget.class);
                startActivity(intent);
                break;

            case R.id.unit:
                intent = new Intent(this, unitActivity.class);
                startActivity(intent);
                break;
        }
    }

}
