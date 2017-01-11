package com.example.puya_.colectionarimonedeproject;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import android.widget.Toast;

import java.util.List;

/**
 * Created by rusuvalentin on 11/01/2017.
 */

public class ColumnChart extends View {

    private List<LicitatiiJavaClass> listaLicitatiiChart;
    public ColumnChart(Context context, List<LicitatiiJavaClass> lista) {
        super(context);
        this.listaLicitatiiChart=lista;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int nr_totalLicitatii = 0;
        for(LicitatiiJavaClass l :listaLicitatiiChart){
            nr_totalLicitatii += Integer.parseInt(l.getPretPornire());
        }
        int[] culori = new int[]{Color.RED,Color.GREEN,Color.BLUE,Color.YELLOW,Color.GRAY};

        int left=100;
        int maxim=0;
        if(!listaLicitatiiChart.isEmpty()) {
            maxim = Integer.parseInt(listaLicitatiiChart.get(0).getPretPornire());
        }
        else{
            Toast.makeText(getContext(),"Nici o licitatie introdusa",Toast.LENGTH_SHORT);
        }
        for(LicitatiiJavaClass l :listaLicitatiiChart){
            if(maxim < Integer.parseInt(l.getPretPornire())){
                maxim= Integer.parseInt(l.getPretPornire());
            }
        }
        int i=0;
        int right=150;

        for(LicitatiiJavaClass l : listaLicitatiiChart){
            Paint paint = new Paint();
            paint.setColor(culori[i++]);

            canvas.drawRect(left,maxim- Integer.parseInt(l.getPretPornire()),right,500,paint);
            left+=50;
            right+=50;
        }
    }
}
