package com.joner.mnbj.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;

import com.joner.mnbj.entity.CircularDataEntity;

import java.util.ArrayList;

public class CircularExhibitionView extends View {

    private Context context;
    private int width;
    private int height;
    private int cirX;
    private int cirY;
    private int cirR;
    private static final int MAX_HEIGHT = 300;
    private static final int MAX_WIDTH = 600;
    private static final int RADIUS_LENGTH = 30;
    private float startAngle = 0f;
    private float textSize = 20f;
    private float animatedValue = 0f;
    private Paint mCircularPaint;
    private Paint mTextPaint;
    private ArrayList<CircularDataEntity> circularData;
    private CircularExhibitionClickListener circularExhibitionClickListener;

    public CircularExhibitionView(Context context) {
        this(context, null);
    }

    public CircularExhibitionView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    public CircularExhibitionView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs);
    }

    private void init() {
        mCircularPaint = new Paint();
        mCircularPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mCircularPaint.setColor(Color.BLUE);
        mCircularPaint.setAntiAlias(true);
        mTextPaint = new Paint();
        mTextPaint.setTextSize(textSize);
        mTextPaint.setAntiAlias(true);
        mTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    }

    public void setData(ArrayList<CircularDataEntity> data) {
        this.circularData = data;
        initAnimator();
    }

    public void setOnClickListener(CircularExhibitionClickListener circularExhibitionClickListener) {
        this.circularExhibitionClickListener = circularExhibitionClickListener;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMeasureModel = MeasureSpec.getMode(widthMeasureSpec);
        int heightMeasureModel = MeasureSpec.getMode(heightMeasureSpec);
        switch (widthMeasureModel) {
            case MeasureSpec.EXACTLY:
                width = MeasureSpec.getSize(widthMeasureSpec);
                break;
            case MeasureSpec.AT_MOST:
            case MeasureSpec.UNSPECIFIED:
                width = Math.min(MeasureSpec.getSize(widthMeasureSpec), MAX_WIDTH);
                break;
        }

        switch (heightMeasureModel) {
            case MeasureSpec.EXACTLY:
                height = MeasureSpec.getSize(heightMeasureSpec);
                break;
            case MeasureSpec.AT_MOST:
            case MeasureSpec.UNSPECIFIED:
                height = Math.min(MeasureSpec.getSize(heightMeasureSpec), MAX_HEIGHT);
                break;
        }
        setMeasuredDimension(width, height);

    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        cirY = (height + getTop()) / 2;
        cirX = (width + getLeft()) / 2;
        cirR = Math.min(cirX - RADIUS_LENGTH, cirY - RADIUS_LENGTH);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(cirX, cirY);
        RectF rectF = new RectF(-cirR, -cirR, cirR, cirR);
        if (circularData != null && circularData.size() > 0) {
            for (CircularDataEntity entity : circularData) {
                float sweepAngele = entity.getArcPercent() * 360;
                float cTX = 0;
                float cTY = 0;
                mCircularPaint.setColor(entity.getBackColor());
                if (Math.min(sweepAngele, animatedValue - startAngle) >= 0) {
                    canvas.drawArc(rectF, startAngle, Math.min(sweepAngele, animatedValue - startAngle),
                            true, mCircularPaint);

                    canvas.save();
                    if (startAngle + sweepAngele / 2 <= 90) {
                        cTX += cirR / 2 * Math.cos(Math.toRadians(sweepAngele / 2 + startAngle));
                        cTY += cirR / 2 * Math.sin(Math.toRadians(sweepAngele / 2 + startAngle));
                    } else if (startAngle + sweepAngele / 2 <= 180) {
                        cTX -= cirR / 2 * Math.sin(Math.toRadians(sweepAngele / 2 + startAngle - 90));
                        cTY += cirR / 2 * Math.cos(Math.toRadians(sweepAngele / 2 + startAngle - 90));
                    } else if (startAngle + sweepAngele / 2 <= 270) {
                        cTX -= cirR / 2 * Math.cos(Math.toRadians(sweepAngele / 2 + startAngle - 180));
                        cTY -= cirR / 2 * Math.sin(Math.toRadians(sweepAngele / 2 + startAngle - 180));
                    } else if (startAngle + sweepAngele / 2 <= 360) {
                        cTX += cirR / 2 * Math.sin(Math.toRadians(sweepAngele / 2 + startAngle - 270));
                        cTY -= cirR / 2 * Math.cos(Math.toRadians(sweepAngele / 2 + startAngle - 270));
                    }
                    mTextPaint.setColor(entity.getTextColor());
                    canvas.drawText(entity.getArcName(), cTX, cTY, mTextPaint);
                }
                startAngle += sweepAngele;
                startAngle = startAngle >= 360f ? startAngle - 360f : startAngle;
            }
        }
    }

    private void initAnimator() {
        ValueAnimator anim = ValueAnimator.ofFloat(0, 360);
        anim.setDuration(10000);
        anim.setInterpolator(new AccelerateDecelerateInterpolator());
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                animatedValue = (float) valueAnimator.getAnimatedValue();
                invalidate();
            }
        });
        anim.start();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        float x = event.getX() - cirX;
        float y = event.getY() - cirY;
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                int position = getClickPosition(x, y);
                if (position >= 0) {
                    if (circularExhibitionClickListener != null) {
                        circularExhibitionClickListener.onClick(position);
                    }
                } else {

                }
        }
        return true;
    }

    private int getClickPosition(float x, float y) {
        double angle = -startAngle;
        if (x >= cirR || x <= -cirR || y >= cirR || y <= -cirR) {
            return -2;
        } else {
            if (x > 0 && y > 0) {
                angle += Math.toDegrees(Math.atan(Math.abs(y) / Math.abs(x)));
            } else if (x < 0 && y > 0) {
                angle += Math.toDegrees(Math.atan(Math.abs(x) / Math.abs(y))) + 90;
            } else if (x < 0 && y < 0) {
                angle += Math.toDegrees(Math.atan(Math.abs(y) / Math.abs(x))) + 180;
            } else if (x > 0 && y < 0) {
                angle += Math.toDegrees(Math.atan(Math.abs(x) / Math.abs(y))) + 270;
            }
        }
        double sumAngle = startAngle;
        for (int i = 0; i < circularData.size(); i++) {
            CircularDataEntity entity = circularData.get(i);
            sumAngle += entity.getArcPercent() * 360;
            if (angle < sumAngle) {
                return i;
            }
        }
        return -1;
    }

}