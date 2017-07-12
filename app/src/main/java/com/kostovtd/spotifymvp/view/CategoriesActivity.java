package com.kostovtd.spotifymvp.view;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.kostovtd.spotifymvp.R;
import com.kostovtd.spotifymvp.adapter.AlbumsAdapter;
import com.kostovtd.spotifymvp.adapter.CategoriesAdapter;
import com.kostovtd.spotifymvp.adapter.CategoriesAdapterListener;
import com.kostovtd.spotifymvp.base.BaseActivity;
import com.kostovtd.spotifymvp.model.Category;
import com.kostovtd.spotifymvp.presenter.CategoriesPresenter;
import com.kostovtd.spotifymvp.presenter.CategoriesPresenterImpl;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kostovtd on 12.07.17.
 */
public class CategoriesActivity extends BaseActivity implements CategoriesView, CategoriesAdapterListener {

    private static final String TAG = CategoriesActivity.class.getSimpleName();

    private CategoriesAdapter categoriesAdapter;
    private CategoriesPresenter presenter;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.text_no_items)
    TextView textNoItems;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: hit");
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResourceId());
        setTitle(R.string.categories_screen_title);

        ButterKnife.bind(this);

        presenter = new CategoriesPresenterImpl(this, this);

        presenter.fetchCategories();
    }


    @Override
    protected void onResume() {
        Log.d(TAG, "onResume: hit");
        super.onResume();
    }


    @Override
    protected void onPause() {
        Log.d(TAG, "onPause: hit");
        super.onPause();
    }


    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy: hit");
        super.onDestroy();
    }


    @Override
    public void showCategories(List<Category> categories) {
        Log.d(TAG, "showCategories: hit");

        if(categories == null || categories.size() == 0) {
            Log.e(TAG, "showCategories: categories is NULL");
            textNoItems.setVisibility(View.VISIBLE);
            return;
        } else {
            textNoItems.setVisibility(View.GONE);
        }


        if(categoriesAdapter == null) {
            categoriesAdapter = new CategoriesAdapter(this, categories);
            categoriesAdapter.setListener(this);

            RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(categoriesAdapter);
        } else {
            categoriesAdapter.setCategories(categories);
            categoriesAdapter.notifyDataSetChanged();
        }
    }


    @Override
    public void onCategorySelected(Category category) {

    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.categories_layout;
    }


}