package com.xiaoxiao.virgo;

import com.xiaoxiao.view.MyGridView;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.Button;

public class CartoonDetailPageActivity extends Activity implements OnClickListener{
	
	private int[] mChapters = {1,2,3,4,5,6,7,8,10};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_cartoon_detail_page);
		
		initView();
	}
	
	private void initView()
	{
		//显示章节
		MyGridView gridView = (MyGridView)findViewById(R.id.id_chapter_container);
		gridView.setAdapter(new ButtonAdapter(this));
		Button backBtn = (Button)findViewById(R.id.id_backbtn);
		backBtn.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int id = v.getId();
		if(id == R.id.id_backbtn)
		{
			finish();
		}
	}
	
	private class ButtonAdapter extends BaseAdapter
	{
		private Context context;
		public ButtonAdapter(Context context)
		{
			super();
			this.context = context;
		}
		
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return mChapters.length;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return mChapters[position];
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			Button view = new Button(context);
			view.setBackgroundResource(R.drawable.shape_rectangle_with_stroke);
			view.setTextColor(getResources().getColor(R.color.gray_6));
			view.setText("1话");
			
			return view;
		}
		
	}
}
