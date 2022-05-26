package com.example.clickerlife;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Improve extends AppCompatActivity {
    public static Button laptop, home_price, city_price;
    public static int price1 = 500;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_improve);
        laptop = (Button) findViewById(R.id.laptop);
        home_price = (Button) findViewById(R.id.home_price);
        city_price = (Button) findViewById(R.id.city_price);
        laptop.setText("Улучшить мощность компьютера, " + price1 + " рублей");
        laptop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (MainActivity.coutmoney >= price1) {
                    MainActivity.money += 100;
                    MainActivity.coutmoney -= price1;
                    price1+=200;
                    MainActivity.textmoney.setText(MainActivity.coutmoney + "");
                    laptop.setText("Улучшить мощность компьютера, " + price1 + " рублей");
                    new Saved().save();
                }
            }
        });
        city_price.setText("Оплатить налоги " + MainActivity.city_money);
        city_price.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (MainActivity.coutmoney >= MainActivity.city_money){
                    MainActivity.coutmoney -= MainActivity.city_money;
                    MainActivity.city_money = 0;
                    MainActivity.city.setText("Налоги\n" + MainActivity.city_money);
                    city_price.setText("Оплатить налоги " + MainActivity.city_money);
                    MainActivity.textmoney.setText(MainActivity.coutmoney + "");
                    new Saved().save();
                }
            }
        });
        home_price.setText("Заказать еду " + MainActivity.home_money);
        home_price.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (MainActivity.coutmoney >= MainActivity.home_money){
                    MainActivity.coutmoney -= MainActivity.home_money;
                    MainActivity.home_money = 0;
                    home_price.setText("Заказать еду " + MainActivity.home_money);
                    MainActivity.home.setText("Потребности\n" +  MainActivity.home_money);
                    MainActivity.textmoney.setText(MainActivity.coutmoney + "");
                    new Saved().save();
                }
            }
        });
    }
}
