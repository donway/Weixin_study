package com.example.wdong.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.HeaderViewListAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by wdong on 2015/9/24.
 */
public class SiderBar extends View {

    Context context;
    ListView mListView;
    private Paint paint;
    private float height;
    private TextView textView;
    private String[] extra = {"¡ü","¡î"};
    private String[] sections = new String[]{"A","B","C","D","E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z","#"};
    public SiderBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    public void setListView(ListView view) {
        mListView = view;
    }



    public void init() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.DKGRAY);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTextSize(30);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float center = getWidth() / 2;
        height = getHeight() / sections.length;
        for(int i = 0; i < sections.length; i++) {
            canvas.drawText(sections[i], center, (height *(i+1)), paint);
        }
    }

    private  int selectionForPoint(float y) {
        int index = (int)(y / height);
        if(index < 0 ) index = 0;
        if(index > sections.length -1) index = sections.length - 1;
        return index;
    }

    private  void setHeaderAndScroll(MotionEvent event) {
        if(mListView == null) return;
        String header = sections[selectionForPoint(event.getY())];
        Log.e("111111111111", "header is  " + header);
        textView.setText(header);
        HeaderViewListAdapter hv = (HeaderViewListAdapter)mListView.getAdapter();
        ContactAdapter ca = (ContactAdapter)hv.getWrappedAdapter();
//        ContactAdapter ca = (ContactAdapter)mListView.getAdapter();
        String[] adapterString = (String[])ca.getSections();
        try {
            for(int i = adapterString.length -1; i > -1; i--){
                if(adapterString[i].equals(header)) {
                    mListView.setSelection(ca.getPositionForSection(i));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("setHeaderTextAndscroll", e.getMessage());
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch ((event.getAction())) {
            case MotionEvent.ACTION_DOWN:
                if(textView == null) {
                    textView = (TextView)((View)getParent()).findViewById(R.id.floating_header);
                }
                setHeaderAndScroll(event);
                textView.setVisibility(View.VISIBLE);
                setBackgroundResource(R.drawable.siderbar_selected);
                return true;
            case MotionEvent.ACTION_MOVE:
                setHeaderAndScroll(event);
                return true;
            case MotionEvent.ACTION_UP:
                textView.setVisibility(View.INVISIBLE);
                setBackgroundColor(Color.TRANSPARENT);
                return true;
            case MotionEvent.ACTION_CANCEL:
                textView.setVisibility(View.INVISIBLE);
                setBackgroundColor(Color.TRANSPARENT);
                return true;
        }

        return super.onTouchEvent(event);
    }
}
