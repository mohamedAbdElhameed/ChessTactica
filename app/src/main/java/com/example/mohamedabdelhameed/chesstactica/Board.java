package com.example.mohamedabdelhameed.chesstactica;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;

public class Board extends View {

    private int boardSize, squareSide;
    private boolean isSet = true;
    private Paint color;


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        final int width = canvas.getWidth();
        final int height = canvas.getHeight();
        boardSize = Math.min(width, height);
        squareSide = boardSize / 8;
        drawBoard(canvas);
    }

    public void drawBoard(Canvas c) {
        int countRow = 0;
        int countCol = 0;
        if (c.getWidth() > c.getHeight()) {
            isSet = !isSet;
        }
        for (int i = 0; i < boardSize && countCol < 8; i += squareSide) {
            isSet = !isSet;
            countCol++;
            for (int j = 0; j < boardSize && countRow < 8; j += squareSide) {
                color.setColor(isSet ? Color.BLACK : Color.WHITE);
                c.drawRect(i, j, i + squareSide, j + squareSide, color);
                isSet = !isSet;
                countRow++;
            }
            countRow = 0;
        }
    }

    public Board(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        color = new Paint();
    }
}
