package com.kostovtd.spotifymvp.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kostovtd.spotifymvp.R;
import com.kostovtd.spotifymvp.model.Album;
import com.kostovtd.spotifymvp.model.AlbumItem;
import com.kostovtd.spotifymvp.model.Artist;
import com.kostovtd.spotifymvp.model.Image;
import com.kostovtd.spotifymvp.model.TrackItem;
import com.kostovtd.spotifymvp.model.Tracks;
import com.kostovtd.spotifymvp.util.Is;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;


public class AlbumsAdapter extends RecyclerView.Adapter<AlbumsAdapter.ViewHolder> {

    private static final String TAG = AlbumsAdapter.class.getSimpleName();

    private Context mContext;
    private List<Album> mData;


    public AlbumsAdapter(Context context, List<AlbumItem> data) {
        this.mContext = context;
        this.mData = new ArrayList<>();

        for(AlbumItem albumItem : data) {
            Album album = albumItem.getAlbum();
            mData.add(album);
        }
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.album_item, parent, false);

        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if(mData == null) {
            Log.e(TAG, "onBindViewHolder: data is NULL");
            return;
        }

        Album album = mData.get(position);

        if(album == null) {
            Log.e(TAG, "onBindViewHolder: album on position " + position + " is NULL");
            return;
        }

        // ALBUM NAME
        String albumName = album.getName();
        if(!Is.empty(albumName)) {
            holder.textAlbumName.setText(albumName);
        }

        // ARTISTS
        List<Artist> artists = album.getArtists();
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

        // NUMBER OF TRACKS
        Tracks tracks = album.getTracks();
        if(tracks != null) {
            List<TrackItem> trackItems = tracks.getItemList();
            if(trackItems != null) {
                int numberOfTracks = trackItems.size();
                holder.numberOfTracksConatiner.setVisibility(View.VISIBLE);
                holder.textNumberOfTracksValue.setText(String.valueOf(numberOfTracks));
            } else {
                holder.numberOfTracksConatiner.setVisibility(View.GONE);
            }
        } else {
            holder.numberOfTracksConatiner.setVisibility(View.GONE);
        }

        // RELEASE DATE
        String releaseDateStr = album.getReleaseDate();
        if(!Is.empty(releaseDateStr)) {
            holder.releaseDateContainer.setVisibility(View.VISIBLE);
            holder.textReleaseDateValue.setText(releaseDateStr);
        } else {
            holder.releaseDateContainer.setVisibility(View.GONE);
        }

        // POPULARITY
        int popularity = album.getPopularity();
        holder.textAlbumPopularity.setText(String.valueOf(popularity));

        // ALBUM IMAGE
        List<Image> images = album.getImages();
        if(images != null && images.size() > 0) {
            Image image = images.get(0);
            String imageUrl = image.getUrl();
            Picasso.with(mContext)
                    .load(imageUrl)
                    .placeholder(R.drawable.ic_image_grey_36dp)
                    .into(holder.imageAlbum);
        }
    }


    @Override
    public int getItemCount() {
        return mData.size();
    }


    public void setAlbums(List<AlbumItem> albumItems) {
        if(albumItems == null) {
            Log.e(TAG, "setAlbums: albumItems is NULL");
            return;
        }

        for(AlbumItem albumItem : albumItems) {
            Album album = albumItem.getAlbum();
            this.mData.add(album);
        }
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        private CardView rootContainer;
        private ImageView imageAlbum;
        private TextView textAlbumName;
        private TextView textArtists;
        private LinearLayout numberOfTracksConatiner;
        private TextView textNumberOfTracksLabel;
        private TextView textNumberOfTracksValue;
        private LinearLayout releaseDateContainer;
        private TextView textReleaseDateLabel;
        private TextView textReleaseDateValue;
        private TextView textAlbumPopularity;


        public ViewHolder(View itemView) {
            super(itemView);

            rootContainer = (CardView) itemView.findViewById(R.id.root_container);
            imageAlbum = (ImageView) itemView.findViewById(R.id.image_album);
            textAlbumName = (TextView) itemView.findViewById(R.id.text_album_name);
            textArtists = (TextView) itemView.findViewById(R.id.text_artists);
            numberOfTracksConatiner = (LinearLayout) itemView.findViewById(R.id.number_of_tracks_container);
            textNumberOfTracksLabel = (TextView) itemView.findViewById(R.id.text_number_of_tracks_label);
            textNumberOfTracksValue = (TextView) itemView.findViewById(R.id.text_number_of_tracks_value);
            releaseDateContainer = (LinearLayout) itemView.findViewById(R.id.release_date_container);
            textReleaseDateLabel = (TextView) itemView.findViewById(R.id.text_release_date_label);
            textReleaseDateValue = (TextView) itemView.findViewById(R.id.text_release_date_value);
            textAlbumPopularity = (TextView) itemView.findViewById(R.id.text_album_popularity);
        }
    }
}
