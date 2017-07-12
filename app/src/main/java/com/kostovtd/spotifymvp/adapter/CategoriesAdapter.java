package com.kostovtd.spotifymvp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.kostovtd.spotifymvp.R;
import com.kostovtd.spotifymvp.model.Album;
import com.kostovtd.spotifymvp.model.AlbumItem;
import com.kostovtd.spotifymvp.model.Categories;
import com.kostovtd.spotifymvp.model.Category;
import com.kostovtd.spotifymvp.model.Image;
import com.kostovtd.spotifymvp.util.Is;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by kostovtd on 12.07.17.
 */
public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.ViewHolder> {

    private static final String TAG = CategoriesAdapter.class.getSimpleName();

    private Context mContext;
    private List<Category> mData;
    private CategoriesAdapterListener listener;


    public CategoriesAdapter(Context context, List<Category> data) {
        this.mContext = context;
        this.mData = data;
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.category_item, parent, false);

        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if(mContext == null) {
            Log.e(TAG, "onBindViewHolder: context is NULL");
            return;
        }


        if(mData == null) {
            Log.e(TAG, "onBindViewHolder: data is NULL");
            return;
        }


        final Category category = mData.get(position);

        if(category == null) {
            Log.e(TAG, "onBindViewHolder: category is NULL");
            return;
        }


        // CATEGORY IMAGE
        List<Image> icons = category.getIcons();
        if(icons != null) {
            Image icon = icons.get(0);

            if(icon != null) {
                String imageUrlStr = icon.getUrl();
                Picasso.with(mContext)
                        .load(imageUrlStr)
                        .into(holder.imageCategory);
            } else {
                Log.e(TAG, "onBindViewHolder: No icon set for item " + position);
            }
        } else {
            Log.e(TAG, "onBindViewHolder: No icon set for item " + position);
        }


        // CATEGORY NAME
        String categoryName = category.getName();
        if(!Is.empty(categoryName)) {
            holder.textCategoryName.setText(categoryName);
        } else {
            Log.e(TAG, "onBindViewHolder: No name set for item " + position);
        }


        // CLICK EVENT
        holder.rootContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null) {
                    listener.onCategorySelected(category);
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return mData.size();
    }


    public void setListener(CategoriesAdapterListener listener) {
        this.listener = listener;
    }


    public void setCategories(List<Category> categories) {
        if(categories == null) {
            Log.e(TAG, "setCategories: categories is NULL");
            return;
        }

        if(mData == null) {
            Log.e(TAG, "setCategories: data is NULL");
            return;
        }

        this.mData.clear();
        this.mData.addAll(categories);
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        private FrameLayout rootContainer;
        private ImageView imageCategory;
        private TextView textCategoryName;


        public ViewHolder(View itemView) {
            super(itemView);

            rootContainer = (FrameLayout) itemView.findViewById(R.id.root_container);
            imageCategory = (ImageView) itemView.findViewById(R.id.image_category);
            textCategoryName = (TextView) itemView.findViewById(R.id.text_category_name);
        }
    }
}
