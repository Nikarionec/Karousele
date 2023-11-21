package com.nikita.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

public class ImageCarouselFragment extends Fragment {

    private ViewPager2 viewPager;
    private TextView descriptionTextView;

    private List<Integer> images = new ArrayList<>();
    private List<String> descriptions = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_image_carousel, container, false);

        viewPager = view.findViewById(R.id.viewPager);
        descriptionTextView = view.findViewById(R.id.descriptionTextView);

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

        descriptions.add("Легкі та комфортні кросівки Nike з вентиляційними отворами для збереження свіжості.");
        descriptions.add("Стильні кросівки Nike з амортизуючою підошвою для максимального комфорту при ходьбі.");
        descriptions.add("Універсальні кросівки Nike зі зносостійкою підошвою, ідеальні для щоденного використання.");
        descriptions.add("Ергономічно розроблені кросівки Nike з м'якими внутрішніми вставками для підтримки стопи.");
        descriptions.add("Інноваційні кросівки Nike з водонепроникним верхом для захисту від вологи та дощу.");
        descriptions.add("Модельні кросівки Nike з відмінним трекинговим ходом для активних видів спорту.");
        descriptions.add("Елегантні кросівки Nike з відбивними елементами для підвищення видимості у темний час доби.");
        descriptions.add("Кросівки Nike з підтримуючим верхом та м'якою подушкою для неймовірного комфорту.");
        descriptions.add("Дизайнерські кросівки Nike з максимальною гнучкістю для свободи руху під час тренувань.");
        descriptions.add("Сучасні кросівки Nike з інтегрованим амортизатором для зменшення впливу на суглоби під час бігу.");

        ImageAdapter adapter = new ImageAdapter(requireContext(), images, descriptions);
        viewPager.setAdapter(adapter);

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                String description = descriptions.get(position);
                descriptionTextView.setText(description);
            }
        });

        return view;
    }
}
