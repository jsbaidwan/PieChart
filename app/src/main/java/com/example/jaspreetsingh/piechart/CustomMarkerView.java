package com.example.jaspreetsingh.piechart;

import android.content.Context;
import android.widget.TextView;

import com.github.mikephil.charting.components.MarkerView;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.utils.MPPointF;

/**
 * Created by jaspreet.singh on 8/7/2017.
 */

public class CustomMarkerView extends MarkerView {

     TextView tvContent;
    /**
     * Constructor. Sets up the MarkerView with a custom layout resource.
     *
     * @param context
     * @param layoutResource the layout resource to use for the MarkerView
     */
    public CustomMarkerView(Context context, int layoutResource) {
        super(context, layoutResource);
        tvContent = (TextView) findViewById (R.id.marker_text);
    }

    // callbacks every time the MarkerView is redrawn, can be used to update the
    // content (user-interface)
    @Override
    public void refreshContent(Entry e, Highlight highlight) {
        // set the entry-value as the display text
        tvContent.setText("" + (int) e.getY());
        // this will perform necessary layout
        super.refreshContent(e, highlight);
    }

    /**
     * To set the alignment of the marker view
     *
     */
    private MPPointF mOffset;

    @Override
    public MPPointF getOffset() {

        if(mOffset == null) {
            // center the marker horizontally and vertically
            mOffset = new MPPointF(-(getWidth() ), -getHeight() );
        }

        return mOffset;
    }
}
