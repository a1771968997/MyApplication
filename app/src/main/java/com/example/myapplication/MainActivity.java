package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Button button1,button2;
    private ImageButton imageButton;
    private CheckBox checkBox1,checkBox2;
    //private RadioButton radioButton1,radioButton2;
    private Switch aSwitch;
    private RadioGroup radioGroup;
    private ToggleButton toggleButton;
    private SeekBar seekBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textview);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        imageButton = (ImageButton) findViewById(R.id.imageButton3);
        checkBox1 = (CheckBox) findViewById(R.id.checkBox);
        checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
        radioGroup = (RadioGroup) findViewById(R.id.radiogroup);
        //radioButton1 = (RadioButton) findViewById(R.id.radioButton3);
        //radioButton2 = (RadioButton) findViewById(R.id.radioButton4);
        aSwitch = (Switch) findViewById(R.id.switch1);
        toggleButton = (ToggleButton) findViewById(R.id.toggleButton);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        //mContext = MainActivity.this;
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("Button1");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("Button2");
            }
        });
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("ImageButton");
            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
            RadioButton radioButton =  findViewById(checkedId);
            textView.setText("你选择了"+radioButton.getText());
            }
        });
        checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String choose ="";
                textView.setText(choose);
                if(checkBox1.isChecked()) choose+=checkBox1.getText().toString()+" ";
                if(checkBox2.isChecked()) choose+=checkBox2.getText().toString()+"";
                textView.setText(choose);
            }
        });
        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String choose ="";
                textView.setText(choose);
                if(checkBox1.isChecked()) choose+=checkBox1.getText().toString()+" ";
                if(checkBox2.isChecked()) choose+=checkBox2.getText().toString()+"";
                textView.setText(choose);
            }
        });
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) aSwitch.setChecked(true);
                else aSwitch.setChecked(false);
            }
        });
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) toggleButton.setChecked(true);
                else toggleButton.setChecked(false);
            }
        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textView.setText("数值为："+progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                textView.setText("按下拖动条");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                textView.setText("松开拖动条");
            }
        });
    }
}
