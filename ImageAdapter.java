package com.nikita.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {

    private Context context;
    private List<Integer> images; // Список ідентифікаторів зображень
    private List<String> descriptions; // Список описів зображень

    public ImageAdapter(Context context, List<Integer> images, List<String> descriptions) {
        this.context = context;
        this.images = images;
        this.descriptions = descriptions;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Створення нового елемента у списку за допомогою макету item_image
        View view = LayoutInflater.from(context).inflate(R.layout.item_image, parent, false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        int imageRes = images.get(position); // Отримання ідентифікатора зображення за позицією
        holder.imageView.setImageResource(imageRes); // Встановлення зображення для ImageView

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int adapterPosition = holder.getAdapterPosition();
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    String description = descriptions.get(adapterPosition);
                    // Виконання дій з описом (наприклад, оновлення TextView)
                    // Наприклад: descriptionTextView.setText(description);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return images.size(); // Повернення кількості зображень у списку
    }

    public static class ImageViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView; // Об'єкт ImageView для зображення

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView); // Знаходження ImageView за його ID
        }
    }
}