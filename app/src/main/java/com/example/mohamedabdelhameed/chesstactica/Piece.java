package com.example.mohamedabdelhameed.chesstactica;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Paint;

public class Piece {

	int posx, posy;
	Paint p;
	Bitmap b;
	
	public Piece(Resources r, int posx, int posy) {
		p = new Paint(Paint.ANTI_ALIAS_FLAG);
		b = BitmapFactory.decodeResource(r, R.drawable.bk);
		this.posx = posx;
		this.posy = posy;
	}

}
