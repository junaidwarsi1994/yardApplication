package com.example.invision.yardapplication.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by Junaid-Invision on 5/17/2016.
 */
public class Utils {



    public static Bitmap scaleBitmap (Bitmap unscaledBitmap ,int dstWidth, int dstHeight) {


        Rect srcRect = calculateSrcRect(unscaledBitmap.getWidth(), unscaledBitmap.getHeight(), dstWidth, dstHeight);
        Rect dstRect = calculateDstRect(unscaledBitmap.getWidth(), unscaledBitmap.getHeight(), dstWidth, dstHeight);
        Bitmap scaledBitmap = Bitmap.createBitmap(dstRect.width(), dstRect.height(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(scaledBitmap);
        canvas.drawBitmap(unscaledBitmap, srcRect, dstRect, new Paint(Paint.FILTER_BITMAP_FLAG));

        return scaledBitmap;

    }


    public static Rect calculateSrcRect(int srcWidth, int srcHeight, int dstWidth, int dstHeight) {
       // if (scalingLogic == ScalingLogic.CROP) {
//            final float srcAspect = (float)srcWidth / (float)srcHeight;
//            final float dstAspect = (float)dstWidth / (float)dstHeight;
//
//            if (srcAspect > dstAspect) {
//                final int srcRectWidth = (int)(srcHeight * dstAspect);
//                final int srcRectLeft = (srcWidth - srcRectWidth) / 2;
//                return new Rect(srcRectLeft, 0, srcRectLeft + srcRectWidth, srcHeight);
//            } else {
//                final int srcRectHeight = (int)(srcWidth / dstAspect);
//                final int scrRectTop = (int)(srcHeight - srcRectHeight) / 2;
//                return new Rect(0, scrRectTop, srcWidth, scrRectTop + srcRectHeight);
//            }
//        } else {
            return new Rect(0, 0, srcWidth, srcHeight);
//        }
    }

    public static Rect calculateDstRect(int srcWidth, int srcHeight, int dstWidth, int dstHeight) {
       // if (scalingLogic == ScalingLogic.FIT) {
            final float srcAspect = (float)srcWidth / (float)srcHeight;
            final float dstAspect = (float)dstWidth / (float)dstHeight;

            if (srcAspect > dstAspect) {
                return new Rect(0, 0, dstWidth, (int)(dstWidth / srcAspect));
            } else {
                return new Rect(0, 0, (int)(dstHeight * srcAspect), dstHeight);
            }
//        } else {
//            return new Rect(0, 0, dstWidth, dstHeight);
//        }
    }
}
