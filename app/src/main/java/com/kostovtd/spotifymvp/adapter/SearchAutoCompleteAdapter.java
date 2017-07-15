package com.kostovtd.spotifymvp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.kostovtd.spotifymvp.R;
import com.kostovtd.spotifymvp.model.Artist;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kostovtd on 15.07.17.
 */

public class SearchAutoCompleteAdapter extends BaseAdapter implements Filterable {

    private static final String TAG = SearchAutoCompleteAdapter.class.getSimpleName();

    private static final int MAX_RESULTS = 10;

    private Context context;
    private List<Artist> resultList;



    public SearchAutoCompleteAdapter(Context context) {
        this.context = context;
        this.resultList = new ArrayList<>();
    }



    @Override
    public int getCount() {
        return resultList.size();
    }


    @Override
    public Object getItem(int position) {
        return resultList.get(position);
    }


    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(context == null) {
            return null;
        }

        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
        }

        String artistName = resultList.get(position).getName();
        ((TextView) convertView.findViewById(android.R.id.text1)).setText(artistName);

        return convertView;
    }


    @Override
    public Filter getFilter() {
        return null;
    }
}
