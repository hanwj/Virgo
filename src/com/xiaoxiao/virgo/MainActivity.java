package com.xiaoxiao.virgo;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.umeng.message.PushAgent;
import com.xiaoxiao.fragment.HomePageFragment;
import com.xiaoxiao.fragment.MyFragmentAdapter;
import com.xiaoxiao.fragment.RankPageFragment;
import com.xiaoxiao.virgo.base.BaseActivity;
import com.xiaoxiao.virgo.view.MyViewPager;

public class MainActivity extends BaseActivity {

	private List<Fragment> pageList;
    private RadioGroup mRadioGroup;
    private PushAgent mPushAgent;
    private MyViewPager mViewPager;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        
        pageList = new ArrayList<Fragment>();
        pageList.add(new HomePageFragment());
        pageList.add(new RankPageFragment());
        
        mViewPager = (MyViewPager)findViewById(R.id.viewPager);
        mViewPager.setAdapter(new MyFragmentAdapter(getSupportFragmentManager(),pageList));
        mViewPager.setScrollable(false);
        
        mRadioGroup = (RadioGroup)findViewById(R.id.id_radiogroup);
        mRadioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener(){

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				int pos = 0;
				switch(checkedId)
				{
					case R.id.rb_btn1:
						pos = 0;
						break;
					case R.id.rb_btn2:
						pos = 1;
						break;
					case R.id.rb_btn3:
						pos = 0;
						break;
					case R.id.rb_btn4:
						pos = 0;
						break;
				}
				mViewPager.setCurrentItem(pos, false);
			}
        	
        });
        
        
        initView();
    }
    private void initView()
    {
    	//initUMeng();
    }
    private void initUMeng()
    {
    	mPushAgent = PushAgent.getInstance(this);
    	mPushAgent.enable();
    	mPushAgent.onAppStart();
    }
}
