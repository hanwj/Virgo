package com.xiaoxiao.virgo;

import java.util.ArrayList;

import com.xiaoxiao.fragment.ContentFragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {

	private ArrayList<View> viewList;
    private Button btn1,btn2;
    private ContentFragment contentFragment;
    
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        btn1 = (Button)findViewById(R.id.id_btn1);
        btn2 = (Button)findViewById(R.id.id_btn2);
        
        OnClickListener clickListener = new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				TextView textView = (TextView)contentFragment.getView().findViewById(R.id.id_content);
				switch(v.getId())
				{
				case R.id.id_btn1:
					textView.setText("button 1");
					break;
				case R.id.id_btn2:
					textView.setText("button 2");
				}
			}
        	
        };
        btn1.setOnClickListener(clickListener);
        btn2.setOnClickListener(clickListener);
        setDefaultFragment();
        //initView();
    }
    private void setDefaultFragment()
    {
    	FragmentManager fm = getSupportFragmentManager();
    	FragmentTransaction transaction = fm.beginTransaction();
    	contentFragment = new ContentFragment();
    	transaction.replace(R.id.id_content,contentFragment);
    	transaction.commit();
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
