package com.loc.coffemanager.Until;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.squareup.picasso.Transformation;

/**
 * Created by loc on 06/10/2015.
 */
public class CircleTransform implements Transformation {

    @Override
    public Bitmap transform(Bitmap source) {
        // laays gais tri chieeu dai
        int size = Math.min(source.getWidth(), source.getHeight());
        // o day cai bitmap co the la cai hinhh
        int x = (source.getWidth() - size) / 2;
        int y = (source.getHeight() - size) / 2;

        //  gou mot bittap va khoii tao mot bien bitnap truyen cais hinh vao lay vij tri x va y va truyen cai size
        Bitmap squaredBitmap = Bitmap.createBitmap(source, x, y, size, size);
        if (squaredBitmap != source) {
            source.recycle();
        }
        Bitmap bitmap = Bitmap.createBitmap(size, size, source.getConfig());
        // can vas
        Canvas canvas = new Canvas(bitmap);
        // tqaoj mot pain
        Paint paint = new Paint();
        BitmapShader shader = new BitmapShader(squaredBitmap, BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP);
        paint.setShader(shader);
        paint.setAntiAlias(true);
        // ban kinh bang chieu dai chia 2f
        float r = size / 2f;
        // truyen ba n kunh
        canvas.drawCircle(r, r, r, paint);
        //
        squaredBitmap.recycle();
        return bitmap;
    }

    @Override
    public String key() {
        return "circle";
    }

}
