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
import com.kostovtd.spotifymvp.model.Image;
import com.kostovtd.spotifymvp.model.Playlist;
import com.kostovtd.spotifymvp.util.Is;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by kostovtd on 13.07.17.
 */
public class PlaylistsAdapter extends RecyclerView.Adapter<PlaylistsAdapter.ViewHolder> {

    private static final String TAG = PlaylistsAdapter.class.getSimpleName();

    private Context mContext;
    private List<Playlist> mData;
    private PlaylistsAdapterListener listener;


    public PlaylistsAdapter(Context context, List<Playlist> data) {
        this.mContext = context;
        this.mData = data;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.playlist_item, parent, false);

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


        final Playlist playlist = mData.get(position);

        if(playlist == null) {
            Log.e(TAG, "onBindViewHolder: playlist is NULL");
            return;
        }


        // CATEGORY IMAGE
        List<Image> icons = playlist.getImages();
        if(icons != null) {
            Image icon = icons.get(0);

            if(icon != null) {
                String imageUrlStr = icon.getUrl();
                Picasso.with(mContext)
                        .load(imageUrlStr)
                        .into(holder.imagePlaylist);
            } else {
                Log.e(TAG, "onBindViewHolder: No icon set for item " + position);
            }
        } else {
            Log.e(TAG, "onBindViewHolder: No icon set for item " + position);
        }


        // CATEGORY NAME
        String playlistName = playlist.getName();
        if(!Is.empty(playlistName)) {
            holder.textPlaylistName.setText(playlistName);
        } else {
            Log.e(TAG, "onBindViewHolder: No name set for item " + position);
        }


        // CLICK EVENT
        holder.rootContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null) {
                    listener.onPlaylistSelected(playlist);
                }
            }
        });

    }


    @Override
    public int getItemCount() {
        return mData.size();
    }


    public void setListener(PlaylistsAdapterListener listener) {
        this.listener = listener;
    }


    public void setPlaylists(List<Playlist> playlists) {
        if(playlists == null) {
            Log.e(TAG, "setPlaylists: playlists is NULL");
            return;
        }

        if(mData == null) {
            Log.e(TAG, "setPlaylists: data is NULL");
            return;
        }

        this.mData.clear();
        this.mData.addAll(playlists);
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        private FrameLayout rootContainer;
        private ImageView imagePlaylist;
        private TextView textPlaylistName;


        public ViewHolder(View itemView) {
            super(itemView);

            rootContainer = (FrameLayout) itemView.findViewById(R.id.root_container);
            imagePlaylist = (ImageView) itemView.findViewById(R.id.image_playlist);
            textPlaylistName = (TextView) itemView.findViewById(R.id.text_playlist_name);
        }
    }
}
