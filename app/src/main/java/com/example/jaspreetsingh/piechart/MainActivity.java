package com.example.jaspreetsingh.piechart;

;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    float sales[] = {30f, 20f, 40f, 6f, 4f};
    String priorityLables[] = {"Hot+", "Hot", "Warm", "Cold", "Shortfall"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        setupPieChart();
    }

    private void setupPieChart() {
        // List for the Pie chart PieEnteries
        ArrayList<PieEntry> pieEnteries = new ArrayList<>();
        for(int i = 0; i < sales.length; i++)   {
            pieEnteries.add(new PieEntry(sales[i], priorityLables[i]));
        }
        PieDataSet dataSet = new PieDataSet(pieEnteries, "");
        // Add Colors to the slices
        dataSet.setColors(ColorTemplate.VORDIPLOM_COLORS);
        PieData data = new PieData(dataSet);

        // Get the chart
        PieChart chart = (PieChart) findViewById(R.id.pie_chart);
        chart.setData(data);
        // for redraw
        chart.invalidate();
        // Animate the pic chart build clockwise parameter is time in millisecond
        chart.animateY(2000);
    }
}