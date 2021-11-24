package com.example.six_sample1013;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private SeekBar seekbar;
    private CheckBox checkBox;
    //private TextView textView;
    private TextView seektext;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        LinearLayout linearlayout = (LinearLayout) findViewById(R.id.lin1);
        Spinner spinner = new Spinner(MainActivity.this);
        final String[] lunch = {"魯肉飯", "控肉飯", "雞排飯", "炸醬麵", "水餃"};
        ArrayAdapter<String> lunchList = new ArrayAdapter<>(MainActivity.this,
                android.R.layout.simple_spinner_dropdown_item,
                lunch);spinner.setAdapter(lunchList);
        linearlayout.addView(spinner);
       // textView= (TextView) findViewById(R.id.textView);
//        checkBox= (CheckBox) findViewById(R.id.checkBox);
//        checkBox.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) this);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "您選擇了:" + lunch[position], Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });



        seekbar = (SeekBar) findViewById(R.id.seekbar);

        seektext = (TextView) findViewById(R.id.seektext);

        seekbar.setMax(150);//設定SeekBar最大值

        seekbar.setProgress(80);//設定SeekBar拖移初始值

        seektext.setText("目前拖移植：" +seekbar.getProgress() + "  /  最大值："+seekbar.getMax());


        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seektext.setText("目前拖移植：" + progress + "  /  最大值："+seekbar.getMax());

            }

            @Override

            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "觸碰SeekBar", Toast.LENGTH_SHORT).show();

            }

            @Override

            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "放開SeekBar", Toast.LENGTH_SHORT).show();

            }
        });



    }

    public void CheckClick(View view) {
        CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(MainActivity.this, isChecked + "", Toast.LENGTH_SHORT).show();
            }
        });;
    }

    public void CheckClick1(View view) {

    }
}
