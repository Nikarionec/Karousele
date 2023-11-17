package com.nikita.myapplication;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 viewPager;
    private TextView descriptionTextView;

    private List<Integer> images = new ArrayList<>();
    private List<String> descriptions = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager);
        descriptionTextView = findViewById(R.id.descriptionTextView);

        images.add(R.drawable.screenshot1);
        images.add(R.drawable.screenshot2);
        images.add(R.drawable.screenshot3);
        images.add(R.drawable.screenshot4);
        images.add(R.drawable.screenshot5);
        images.add(R.drawable.screenshot6);
        images.add(R.drawable.screenshot7);
        images.add(R.drawable.screenshot8);
        images.add(R.drawable.screenshot9);
        images.add(R.drawable.screenshot10);


        descriptions.add("Nike Air Force 1 Low: Класичні кросівки з натуральної шкіри, історично популярні та зручні для повсякденного носіння.");
        descriptions.add("Nike Air Max 270: Сучасні кросівки з максимальним повітряним амортизатором та стильним дизайном для активного способу життя.");
        descriptions.add("Nike React Infinity Run Flyknit: Легкі та зручні бігові кросівки з інноваційною підошвою React, що забезпечує комфорт та підтримку.");
        descriptions.add("Nike Zoom Pegasus Turbo 2: Професійні бігові кросівки з високою віддачею енергії та легкістю для швидкого темпу.");
        descriptions.add("Nike Air Jordan 1: Легендарні кросівки, що стали іконами культури, з унікальним дизайном та відмінною якістю.");
        descriptions.add("Nike Blazer Mid '77 Vintage: Вишукані кросівки відновленої моделі з ретро-стилем та відмінною комфортністю.");
        descriptions.add("Nike Air Vapormax Flyknit: Інноваційні кросівки з повітряною підошвою, що забезпечує високу амортизацію та легкість.");
        descriptions.add("Nike Free RN 5.0: Легкі та гнучкі кросівки для тренувань, що підкреслюють природний рух стопи.");
        descriptions.add("Nike Air Zoom Structure 24: Кросівки з відмінною стабільністю та підтримкою для тренувань та бігу.");
        descriptions.add("Nike Joyride Run Flyknit: Інноваційні кросівки з унікальною технологією Joyride для максимальної амортизації та комфорту при кожному кроці.");


        ImageAdapter adapter = new ImageAdapter(this, images, descriptions);
        viewPager.setAdapter(adapter);

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                String description = descriptions.get(position);
                descriptionTextView.setText(description);
            }
        });
    }
}
