package com.example.jaspreetsingh.piechart;

import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.utils.ViewPortHandler;

/**
 * Created by jaspreet.singh on 8/6/2017.
 */

public class Formatter implements IValueFormatter {
    @Override
    public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
        // Casting value into to integer
        return "" + ((int) value);
    }
}
