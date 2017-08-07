package com.example.jaspreetsingh.piechart;

;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;


import java.util.ArrayList;

import static com.github.mikephil.charting.utils.ColorTemplate.rgb;

public class MainActivity extends AppCompatActivity {


    int sales[] = {0, 12, 1, 1, 38};
    String priorityLables[] = {"Hot+", "Hot", "Warm", "Cold", "Shortfall"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create an object for Marker View
        CustomMarkerView mv = new CustomMarkerView(this, R.layout.marker_view);

        setupPieChart();
    }

    private void setupPieChart() {
        // List for the Pie chart PieEnteries
        ArrayList<PieEntry> pieEnteries = new ArrayList<>();
        for(int i = 0; i < sales.length; i++)   {
            pieEnteries.add(new PieEntry(sales[i], priorityLables[i]));
        }
        PieDataSet dataSet = new PieDataSet(pieEnteries, "");
        // Add customize Colors to the slices
        dataSet.setColors(rgb("#D50000"), rgb("#E91E63"), rgb("#FFC107"), rgb("#3F51B5"), rgb("#9E9E9E"));
        PieData data = new PieData(dataSet);

        //create an object for Marker View
        CustomMarkerView mv = new CustomMarkerView(this, R.layout.marker_view);


        // Set the text of the values
        data.setValueTextSize(16);
        // Set the color of the values
        data.setValueTextColor(Color.BLACK);
        // Disable the slice shift
        dataSet.setSelectionShift(0);
        // Formatting the value from float to integer using custom Formatter
        data.setValueFormatter(new Formatter());

        // Get the chart
        PieChart chart = (PieChart) findViewById(R.id.pie_chart);
        chart.setData(data);
        // refresh chart
        chart.invalidate();
        // Animate the pic chart build clockwise parameter is time in millisecond
        chart.animateY(2000);
        // Disable the touch rotation
        chart.setRotationEnabled(true);
        // Remove legends from pie chart
        chart.setDrawEntryLabels(false);

        chart.setMarker(mv);


        // Modifying the legends
        Legend l = chart.getLegend();
        // set the legend color size
        l.setFormSize(14);
        // set the size of the legend text
        l.setTextSize(14);


    }
}