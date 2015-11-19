package com.xiaoxiao.fragment;

import com.xiaoxiao.virgo.R;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;

public class RankPageFragment extends Fragment {

	private View view;
	@Override
	@Nullable
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		view = inflater.inflate(R.layout.fragment_rank_page, container,false);
		initView();
		return view;
	}
	
	private void initView()
	{
		TabHost mTabHost = (TabHost)view.findViewById(R.id.id_tabhost);
		mTabHost.setup();
		mTabHost.addTab(mTabHost.newTabSpec("tab1").setIndicator(getMenuItem("总排行")).setContent(R.id.tab1));
		mTabHost.addTab(mTabHost.newTabSpec("tab2").setIndicator(getMenuItem("日排行")).setContent(R.id.tab2));
		mTabHost.addTab(mTabHost.newTabSpec("tab3").setIndicator(getMenuItem("周排行")).setContent(R.id.tab3));
		mTabHost.addTab(mTabHost.newTabSpec("tab4").setIndicator(getMenuItem("月排行")).setContent(R.id.tab4));
		//mTabHost.addTab(mTabHost.newTabSpec("tab4").setIndicator("月排行").setContent(R.id.tab4));
	}
	
	private View getMenuItem(String tabName)
	{
		LinearLayout ll = (LinearLayout)LayoutInflater.from(getActivity()).inflate(R.layout.layout_tab_item, null);
		((TextView)ll.findViewById(R.id.id_tab)).setText(tabName);
		return ll;
	}
}
 