package com.example.clickerlife;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    static public int coutmoney = 0;
    static public int money = 100;
    static public int home_money = 0, city_money = 0;
    ImageButton next_day, improve;
    static public TextView textmoney, home, city;
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        next_day = (ImageButton)findViewById(R.id.next_day);
        improve = (ImageButton)findViewById(R.id.improve);
        textmoney = (TextView)findViewById(R.id.money);
        home = (TextView)findViewById(R.id.home);
        city = (TextView)findViewById(R.id.city);
        Saved.init(getApplicationContext());
        new Saved().load_save();
        Next_day();
    }
    public void restart(View v){
        money=100;
        home_money = 0;
        city_money = 0;
        coutmoney = 0;
        Improve.price1 = 500 ;
        home.setText("Потребности\n" + home_money);
        city.setText("Налоги\n"+ city_money);
        textmoney.setText(coutmoney + "");
        new Saved().save();
    }
    void Next_day(){
        next_day.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                coutmoney += money;
                textmoney.setText(coutmoney + "");
                home_money += 25;
                city_money += 50;
                home.setText("Потребности\n" + home_money);
                city.setText("Налоги\n"+city_money);
                new Saved().save();
                if(city_money>=300 | home_money>=200){
                    Toast.makeText(getApplicationContext(), "Поражение", Toast.LENGTH_SHORT).show();
                    money=100;
                    home_money = 0;
                    city_money = 0;
                    coutmoney = 0;
                    Improve.price1 = 500 ;
                    Improve.laptop.setText("Улучшить мощность компьюетра, " + Improve.price1 + " рублей");
                    home.setText("Потребности\n" + home_money);
                    city.setText("Налоги\n"+ city_money);
                    textmoney.setText(coutmoney + "");
                    new Saved().save();;
                }
                if(coutmoney>=30000){
                    Toast.makeText(getApplicationContext(), "Победа", Toast.LENGTH_SHORT).show();
                    money=100;
                    home_money = 0;
                    city_money = 0;
                    coutmoney = 0;
                    Improve.price1 = 500 ;
                    Improve.laptop.setText("Улучшить мощность компьюетра, " + Improve.price1 + " рублей");
                    home.setText("Потребности\n" + home_money);
                    city.setText("Налоги\n"+ city_money);
                    textmoney.setText(coutmoney + "");
                    new Saved().save();;
                }
            }
        });
        improve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Improve.class);
                startActivity(intent);
            }
        });
    }

}
