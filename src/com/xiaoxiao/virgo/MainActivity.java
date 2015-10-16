package com.xiaoxiao.virgo;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

public class MainActivity extends FragmentActivity {

	private ArrayList<View> viewList;
    
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        
        //initView();
    }
    
    private void initView(){
    	ViewPager viewPager = (ViewPager)findViewById(R.id.viewPager);
    	LayoutInflater lf = getLayoutInflater().from(this);
    	View view1 = lf.inflate(R.layout.layout1,null);
    	
    	viewList = new ArrayList<View>();
    	viewList.add(view1);
    	
    	PagerAdapter pagerAdapter = new PagerAdapter(){

			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return viewList.size();
			}

			@Override
			public boolean isViewFromObject(View arg0, Object arg1) {
				// TODO Auto-generated method stub
				return arg0 == arg1;
			}

			@Override
			public Object instantiateItem(ViewGroup container, int position) {
				// TODO Auto-generated method stub
				return viewList.get(position);
			}
    		
    	};
    	viewPager.setAdapter(pagerAdapter);
    }
}
