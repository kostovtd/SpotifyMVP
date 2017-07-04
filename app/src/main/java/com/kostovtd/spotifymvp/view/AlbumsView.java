package com.kostovtd.spotifymvp.view;

import com.kostovtd.spotifymvp.base.BaseView;
import com.kostovtd.spotifymvp.model.AlbumItem;

import java.util.List;

/**
 * Created by kostovtd on 03.07.17.
 */

public interface AlbumsView extends BaseView {

    void showAlbums(List<AlbumItem> albumItems);

}
