package com.xiaoxiao.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.Inflater;

import com.xiaoxiao.virgo.R;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class RankPageFragment extends Fragment {

	private View view;
	private Boolean tabInit[] = {false,false,false,false};
	private int tabs[] = {R.id.tab1,R.id.tab2,R.id.tab3,R.id.tab4};
	private String tabNames[] = {"总排行","日排行","周排行","月排行"};
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
		for(int i = 0; i < tabs.length; i++)
		{
			mTabHost.addTab(mTabHost.newTabSpec(i+"").setIndicator(getMenuItem(tabNames[i])).setContent(tabs[i]));
		}
		
		//mTabHost.addTab(mTabHost.newTabSpec("tab4").setIndicator("月排行").setContent(R.id.tab4));
		mTabHost.setOnTabChangedListener(new OnTabChangeListener() {
			
			@Override
			public void onTabChanged(String tabId) {
				// TODO Auto-generated method stub
				//Toast.makeText(getActivity(), tabId, Toast.LENGTH_SHORT).show();
				int index = Integer.parseInt(tabId);
				if(!tabInit[index]){
					initListView(index);
				}
			}
		});
		initListView(0);
	}
	
	private View getMenuItem(String tabName)
	{
		LinearLayout ll = (LinearLayout)LayoutInflater.from(getActivity()).inflate(R.layout.layout_tab_item, null);
		((TextView)ll.findViewById(R.id.id_tab)).setText(tabName);
		return ll;
	}
	
	private void initListView(int index)
	{
		MyListAdapter adapter = new MyListAdapter(getListData(index));
		((ListView)view.findViewById(tabs[index])).setAdapter(adapter);
		tabInit[index] = true;
	}
	
	private List<Map<String, Object>> getListData(int index)
	{
		index = index + 1;
		List<Map<String,Object>> listData = new ArrayList<Map<String,Object>>();
		for (int i = 0; i < 10; i++) {
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("name", "魑魅魍魉"+index);
			map.put("autor", "作者：潇湘夜雨");
			map.put("state", "连载中：第345话");
			listData.add(map);
		}		
		return listData;
	}
	
	//listView adapter
	private class MyListAdapter extends BaseAdapter
	{
		private List<Map<String, Object>> listData = new ArrayList<Map<String,Object>>();
		public MyListAdapter(List<Map<String, Object>> list){
			super();
			listData = list;
		}
		
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return listData.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return listData.get(position);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			LayoutInflater inflate = LayoutInflater.from(getActivity());
			if (convertView == null){
				convertView = inflate.inflate(R.layout.layout_item_rank, null);
			}
			Map<String,Object> mapData = listData.get(position);
			((TextView)convertView.findViewById(R.id.id_autor)).setText((String)mapData.get("autor"));
			((TextView)convertView.findViewById(R.id.id_name)).setText((String)mapData.get("name"));
			((TextView)convertView.findViewById(R.id.id_state)).setText((String)mapData.get("state"));
			
			return convertView;
		}
		
	}
}
 