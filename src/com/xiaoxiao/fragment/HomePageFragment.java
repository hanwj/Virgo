package com.xiaoxiao.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xiaoxiao.view.MyGridView;
import com.xiaoxiao.virgo.CartoonDetailPageActivity;
import com.xiaoxiao.virgo.R;

import android.R.color;
import android.content.Intent;
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
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ScrollView;

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
		initRank();
		initGridView();
		((ScrollView)view.findViewById(R.id.scrollview)).scrollTo(0,0);
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
					Intent intent = new Intent(getActivity(),CartoonDetailPageActivity.class);
					getActivity().startActivity(intent);
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
	
	//前3名
	private void initRank()
	{
		int[] rankId = {R.id.id_rank1,R.id.id_rank2,R.id.id_rank3};
		int[] pics = {R.drawable.pic2,R.drawable.pic3,R.drawable.pic3};
		View rankView;
		for(int i=0;i<rankId.length;i++)
		{
			rankView = view.findViewById(rankId[i]);
			((ImageView)rankView.findViewById(R.id.id_img)).setImageResource(pics[i]);
			((TextView)rankView.findViewById(R.id.id_name)).setText("测试");
		}
		
	}
	
	//分类列出漫画
	private void initGridView()
	{
		View subContainer = view.findViewById(R.id.id_subcontainer);
		LayoutInflater inflater = LayoutInflater.from(getActivity());
		View gridLayout = inflater.inflate(R.layout.layout_gridview_with_title, null);
		((TextView)gridLayout.findViewById(R.id.id_title)).setText("精选");
		MyGridView gridView = (MyGridView)gridLayout.findViewById(R.id.id_gridview);
		String[] from = {"image","name"};
		int[] to = {R.id.id_img,R.id.id_name};
		List<Map<String,Object>> listData = new ArrayList<Map<String,Object>>();
		for(int i=0;i<10;i++)
		{
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("image", R.drawable.pic3);
			map.put("name","测试");
			listData.add(map);
		}
		gridView.setAdapter(new SimpleAdapter(getActivity(), listData, R.layout.layout_pic_with_text, from, to));
		
		LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		gridLayout.setLayoutParams(layoutParams);
		((ViewGroup)subContainer).addView(gridLayout);
	}
}
