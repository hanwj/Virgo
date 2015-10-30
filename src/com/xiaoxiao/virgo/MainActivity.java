package com.xiaoxiao.virgo;

import java.util.ArrayList;
import java.util.List;

import com.umeng.message.PushAgent;
import com.xiaoxiao.fragment.HomePageFragment;
import com.xiaoxiao.fragment.MyFragmentAdapter;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.RadioGroup;

public class MainActivity extends FragmentActivity {

	private List<Fragment> pageList;
    private RadioGroup mRadioGroup;
    private PushAgent mPushAgent;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        
        mRadioGroup = (RadioGroup)findViewById(R.id.id_radiogroup);
        pageList = new ArrayList<Fragment>();
        pageList.add(new HomePageFragment());
        
        ViewPager viewPager = (ViewPager)findViewById(R.id.viewPager);
        viewPager.setAdapter(new MyFragmentAdapter(getSupportFragmentManager(),pageList));
        initView();
    }
    
    private void initView(){
    	mPushAgent = PushAgent.getInstance(this);
    	mPushAgent.enable();
    	mPushAgent.onAppStart();
    }
}
