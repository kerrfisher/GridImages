package com.example.gridimages;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.ArrayList;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder>{
    // Log tag
    private static final String TAG = ImageAdapter.class.getSimpleName();
    // Member variables
    private final LayoutInflater mInflater;
    private final ArrayList<String> mFilePaths;

    public ImageAdapter(Context context, ArrayList<String> filePaths) {
        this.mInflater = LayoutInflater.from(context);
        this.mFilePaths = filePaths;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View mItemView = mInflater.inflate(R.layout.item_image, parent, false);
        return new ImageViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        if(getItemCount() > 0) {
            Drawable drawable = ContextCompat.getDrawable(mInflater.getContext(), R.drawable.ic_launcher_foreground);
            holder.imagePreviewView.setImageDrawable(drawable);
        }
    }

    @Override
    public int getItemCount() {
        return mFilePaths.size();
    }

    class ImageViewHolder extends RecyclerView.ViewHolder {
        public final ImageView imagePreviewView;
        final ImageAdapter mAdapter;

        public ImageViewHolder(View imageView, ImageAdapter adapter) {
            super(imageView);
            imagePreviewView = imageView.findViewById(R.id.image_view_preview);
            this.mAdapter = adapter;
        }
    }
}