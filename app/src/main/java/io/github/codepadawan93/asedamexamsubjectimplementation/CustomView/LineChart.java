package io.github.codepadawan93.asedamexamsubjectimplementation.CustomView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.PathShape;
import android.util.Log;
import android.view.ContextMenu;
import android.view.View;

import java.util.ArrayList;

public class LineChart extends View {
    private ArrayList<Double> xvals;
    private ArrayList<Double> yvals;
    private int width;

    public LineChart(Context context, View parent, ArrayList<Double> xvals, ArrayList<Double> yvals){
        super(context);
        this.width = parent.getWidth();
        this.xvals = xvals;
        this.yvals = yvals;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLUE);
        Path pathFigure = new Path();
        pathFigure.moveTo(0, width);
        for(int i = 0; i < xvals.size(); i++ ){
            pathFigure.lineTo(i*(width/xvals.size()), yvals.get(i).floatValue());
            Log.d("PATH", width / ((i+1)*2) + "  " + width / yvals.get(i).floatValue());
        }
        ShapeDrawable figure = new ShapeDrawable(new PathShape(pathFigure, width, width));

        Rect rect = new Rect(0, 0, width, width);
        figure.setBounds(rect);
        canvas.drawPath(pathFigure, paint);
    }
}
