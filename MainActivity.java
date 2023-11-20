package com.nikita.myapplication;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 viewPager; // Об'єкт ViewPager2 для перегляду списку зображень
    private TextView descriptionTextView; // Об'єкт TextView для відображення опису

    private List<Integer> images = new ArrayList<>(); // Список ідентифікаторів зображень
    private List<String> descriptions = new ArrayList<>(); // Список описів зображень

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Встановлення макету для активності

        viewPager = findViewById(R.id.viewPager); // Знаходження ViewPager2 за його ID
        descriptionTextView = findViewById(R.id.descriptionTextView); // Знаходження TextView за його ID

        // Додавання ідентифікаторів зображень у список
        images.add(R.drawable.screenshot1);
        images.add(R.drawable.screenshot2);
        // Додавання описів зображень у список
        descriptions.add("Nike Air Force 1 Low: Класичні кросівки...");

        // Створення об'єкта ImageAdapter і передача списків зображень та описів
        ImageAdapter adapter = new ImageAdapter(this, images, descriptions);
        viewPager.setAdapter(adapter); // Встановлення адаптера для ViewPager2

        // Реєстрація колбеку для слідкування за зміною сторінок у ViewPager2
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                // Отримання опису для поточної сторінки та встановлення його у TextView
                String description = descriptions.get(position);
                descriptionTextView.setText(description);
            }
        });
    }
}
