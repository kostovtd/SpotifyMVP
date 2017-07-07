package com.kostovtd.spotifymvp.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kostovtd.spotifymvp.R;
import com.kostovtd.spotifymvp.model.Artist;
import com.kostovtd.spotifymvp.model.TrackItem;
import com.kostovtd.spotifymvp.util.Is;

import java.util.List;

/**
 * Created by kostovtd on 07.07.17.
 */
public class TracksAdapter extends RecyclerView.Adapter<TracksAdapter.ViewHolder> {

    private static final String TAG = TracksAdapter.class.getSimpleName();

    private Context mContext;
    private List<TrackItem> mData;


    public TracksAdapter(Context context, List<TrackItem> data) {
        this.mContext = context;
        this.mData = data;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.track_item, parent, false);

        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if(mData == null) {
            Log.e(TAG, "onBindViewHolder: mData is NULL");
            return;
        }

        TrackItem trackItem = mData.get(position);

        if(trackItem == null) {
            Log.e(TAG, "onBindViewHolder: trackItem is NULL");
            return;
        }


        // TRACK NAME
        String trackName = trackItem.getName();
        if(Is.empty(trackName)) {
            holder.textTrackName.setVisibility(View.GONE);
        } else {
            holder.textTrackName.setVisibility(View.VISIBLE);
            holder.textTrackName.setText(trackName);
        }


        // ARTISTS
        List<Artist> artists = trackItem.getArtists();
        if(artists != null) {
            String artistsStr = "";
            for(Artist artist : artists) {
                if(Is.empty(artistsStr)) {
                    artistsStr += artist.getName();
                } else {
                    artistsStr += ", " + artist.getName();
                }
            }

            holder.textArtists.setText(artistsStr);
        }


        // TRACK DURATION
        long durationMs = trackItem.getDurationMs();
        String durationStr = constructTrackDuration(durationMs);
        holder.textDurationValue.setText(durationStr);


        // EXPLICIT
        boolean isExplicit = trackItem.isExplicit();
        if(isExplicit) {
            holder.textExplicit.setVisibility(View.VISIBLE);
        } else {
            holder.textExplicit.setVisibility(View.GONE);
        }
    }


    @Override
    public int getItemCount() {
        return mData.size();
    }


    public void setTrackItems(List<TrackItem> trackItems) {
        if(trackItems == null) {
            Log.e(TAG, "setTrackItems: trackItems is NULL");
            return;
        }

        this.mData.clear();
        this.mData.addAll(trackItems);
    }


    /**
     * Construct a {@link String} representation
     * of the duration of a track
     * @param durationMs Track duration in milliseconds.
     * @return
     */
    private String constructTrackDuration(long durationMs) {
        String result = "";

        long durationSeconds = (durationMs / 1000) % 60;
        long durationMin = (durationMs / 1000) / 60;

        if(durationSeconds >= 10) {
            result  = String.valueOf(durationMin) + ":" + String.valueOf(durationSeconds);
        } else {
            result = String.valueOf(durationMin) + ":0" + String.valueOf(durationSeconds);
        }

        return result;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        // include {@link View} components here

        private CardView rootContainer;
        private TextView textTrackName;
        private TextView textArtists;
        private LinearLayout durationContainer;
        private TextView textDurationLabel;
        private TextView textDurationValue;
        private TextView textExplicit;


        public ViewHolder(View itemView) {
            super(itemView);

            rootContainer = (CardView) itemView.findViewById(R.id.root_container);
            textTrackName = (TextView) itemView.findViewById(R.id.text_track_name);
            textArtists = (TextView) itemView.findViewById(R.id.text_artists);
            durationContainer = (LinearLayout) itemView.findViewById(R.id.duration_container);
            textDurationLabel = (TextView) itemView.findViewById(R.id.text_duration_label);
            textDurationValue = (TextView) itemView.findViewById(R.id.text_duration_value);
            textExplicit = (TextView) itemView.findViewById(R.id.text_explicit);
        }
    }
}
