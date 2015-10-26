package com.xiaoxiao.fragment;

import java.util.ArrayList;
import java.util.List;

import com.xiaoxiao.virgo.R;

import android.R.color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class HomePageFragment extends Fragment {

	private View view;
	private ViewPager recommendationViewPager;
	@Override
	@Nullable
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		view = inflater.inflate(R.layout.fragment_home_page, container,false);
//		recommendationViewPager = (ViewPager)view.findViewById(R.id.id_viewPager);
		initView();
		return view;
	}
	
	private void initView()
	{
		recommendationViewPager = (ViewPager)view.findViewById(R.id.id_viewPager);
		List<View> pages = new ArrayList<View>();
		View page = LayoutInflater.from(getActivity()).inflate(R.layout.layout_pic_with_text, null);
	}
}
