package com.kostovtd.spotifymvp.util;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by kostovtd on 13.07.17.
 */

public class SpacesItemDecoration extends RecyclerView.ItemDecoration {

    private int spaceLeft;
    private int spaceRight;
    private int spaceTop;
    private int spaceBottom;


    public SpacesItemDecoration(int spaceLeft, int spaceRight,
                                int spaceTop, int spaceBottom) {
        this.spaceLeft = spaceLeft;
        this.spaceRight = spaceRight;
        this.spaceTop = spaceTop;
        this.spaceBottom = spaceBottom;
    }


    @Override
    public void getItemOffsets(Rect outRect, View view,
                               RecyclerView parent, RecyclerView.State state) {
        parent.setClipToPadding(false);

        outRect.left = spaceLeft;
        outRect.right = spaceRight;
        outRect.bottom = spaceBottom;
        outRect.top = spaceTop;
    }
}
