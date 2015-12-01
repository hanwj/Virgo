package com.xiaoxiao.virgo.view;

import java.text.AttributedCharacterIterator.Attribute;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class MyViewPager extends ViewPager {
	
	private Boolean scrollable = true;
	
	public MyViewPager(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	public MyViewPager(Context context,AttributeSet attrs){
		super(context,attrs);
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent arg0) {
		// TODO Auto-generated method stub
		if(!scrollable)
		{
			return true;
		}
		return super.onTouchEvent(arg0);
	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent arg0) {
		// TODO Auto-generated method stub
		if(!scrollable)
		{
			return false;
		}
		return super.onInterceptTouchEvent(arg0);
	}

	public Boolean getScrollable() {
		return scrollable;
	}

	public void setScrollable(Boolean scrollable) {
		this.scrollable = scrollable;
	}
	
	
	
}
