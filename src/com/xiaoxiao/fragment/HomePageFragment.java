package com.xiaoxiao.fragment;

import java.util.ArrayList;
import java.util.List;

import com.xiaoxiao.virgo.R;

import android.R.color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class HomePageFragment extends Fragment {

	private View view;
	private ViewPager recommendationViewPager;
	private List<View> viewList;
	private ImageView[] indicatorImgs;
	@Override
	@Nullable
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		view = inflater.inflate(R.layout.fragment_home_page, container,false);
		viewList = new ArrayList<View>();
		initView();
		return view;
	}
	
	private void initView()
	{
		initRecommendationViewPager();
	}
	
	//首页推荐
	private void initRecommendationViewPager()
	{
		//首页推荐
		int itemNum = 4;
		recommendationViewPager = (ViewPager)view.findViewById(R.id.id_viewPager);
		LayoutInflater inflater = LayoutInflater.from(getActivity());
		View item;
		for(int i=0;i<itemNum;i++)
		{
			item = inflater.inflate(R.layout.layout_pic_with_text, null);
			ImageView img = (ImageView)item.findViewById(R.id.id_img);
			img.setImageResource(R.drawable.pic1);
			((TextView)item.findViewById(R.id.id_name)).setText("海贼王");
			final int position = i;
			img.setOnClickListener(new OnClickListener(){
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Toast.makeText(getActivity(), "viewPager "+position, Toast.LENGTH_SHORT).show();
				}
				
			});
			viewList.add(item);
		}
		PagerAdapter pageAdapter = new PagerAdapter()
		{

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
				container.addView(viewList.get(position));
				return viewList.get(position);
			}

			@Override
			public void destroyItem(ViewGroup container, int position,
					Object object) {
				// TODO Auto-generated method stub
				container.removeView(viewList.get(position));
			}
			
		};
		recommendationViewPager.setAdapter(pageAdapter);
		
		View indicatorView = view.findViewById(R.id.id_indicator);
		indicatorImgs = new ImageView[itemNum];
		ImageView img;
		for(int i=0;i<itemNum;i++)
		{
			img = new ImageView(getActivity());
			LinearLayout.LayoutParams linearParams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
			img.setLayoutParams(linearParams);
			indicatorImgs[i] = img;
			if(i == 0)
			{
				img.setImageResource(R.drawable.indicator_selected);
			}
			else
			{
				img.setImageResource(R.drawable.indicator_default);
			}
			((ViewGroup)indicatorView).addView(img);
		}
	}
}
