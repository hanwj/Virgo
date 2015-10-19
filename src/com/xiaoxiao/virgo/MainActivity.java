package com.xiaoxiao.virgo;

import java.util.ArrayList;
import java.util.List;

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
    
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main_back2);
        
        mRadioGroup = (RadioGroup)findViewById(R.id.id_radiogroup);
        pageList = new ArrayList<Fragment>();
        
        
        initView();
    }
    
    private void initView(){
    	ViewPager viewPager = (ViewPager)findViewById(R.id.viewPager);
    	
    }
}
