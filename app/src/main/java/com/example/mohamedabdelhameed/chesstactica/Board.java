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
		boardSize = canvas.getWidth();
		squareSide = boardSize / 8;
		drawBoard(canvas);
	}
	
	public void drawBoard(Canvas c) {
		for (int i = 0; i < boardSize; i += squareSide) {
			isSet = !isSet;
			for (int j = 0; j < boardSize; j += squareSide) {
				color.setColor(isSet ? Color.BLACK : Color.WHITE);
				c.drawRect(new Rect(i, j, i + squareSide, j + squareSide), color);
				isSet = !isSet;
			}
		}
	}

	public Board(Context context) {
		super(context);
		setFocusable(true);
		setFocusableInTouchMode(true);
		requestFocus();
		color = new Paint(Paint.ANTI_ALIAS_FLAG);
		color.setColor(Color.BLACK);
	}

    public Board(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        color = new Paint(Paint.ANTI_ALIAS_FLAG);
        color.setColor(Color.BLACK);
    }
}
