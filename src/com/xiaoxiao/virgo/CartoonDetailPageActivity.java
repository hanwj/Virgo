package com.xiaoxiao.virgo;

import com.xiaoxiao.view.MyGridView;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.transition.Visibility;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class CartoonDetailPageActivity extends Activity implements OnClickListener{
	
	private int[] mChapters = {1,2,3,4,5,6,7,8,10};
	private TextView introText;
	private ImageView moreView;
	private Boolean introFlag = false; //标记介绍是否展开
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
		String name = "海贼王";
		//title
		((TextView)findViewById(R.id.id_title)).setText(name);
		
		TextView nameText = (TextView)findViewById(R.id.id_name);
		String nameHtml = "<font color='red'>[完]</font><font color='black'>" + name +"</font>";
		nameText.setText(Html.fromHtml(nameHtml));
		((TextView)findViewById(R.id.id_autor)).setText("作者：蔡潇潇");
		
		//intro
		int maxLines = 2;
		introText = (TextView)findViewById(R.id.id_introduction);
		introText.setText("介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍");
		int lines = introText.getLineCount();
		moreView = (ImageView)findViewById(R.id.id_more_btn);
		//new MyOpenTask().execute(100);
		//显示章节
		MyGridView gridView = (MyGridView)findViewById(R.id.id_chapter_container);
		gridView.setAdapter(new ButtonAdapter(this));
		Button backBtn = (Button)findViewById(R.id.id_backbtn);
		backBtn.setOnClickListener(this);
		gridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				for (int i = 0; i < parent.getChildCount(); i++) {
					View v = parent.getChildAt(i);
					v.setBackgroundResource(R.drawable.selector_chapter_bg);
				}
				view.setBackgroundResource(R.drawable.shape_chapter_bg_focused);
			}
			
		});
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int id = v.getId();
		if(id == R.id.id_backbtn)
		{
			finish();
		}
		else if(id == R.id.id_downloadbtn)
		{
			//下载
		}
		else if(id == R.id.id_giftbtn)
		{
			//礼物
		}
		else if(id == R.id.id_more_btn)
		{
			if (introFlag)
			{
				introText.setEllipsize(TextUtils.TruncateAt.END);
				introText.setMaxLines(2);
				moreView.setRotation(0);
			}
			else
			{
				introText.setEllipsize(null);
				introText.setMaxLines(Integer.MAX_VALUE);
				moreView.setRotation(180);
			}
			introFlag = !introFlag;
		}
	}
	
	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		// TODO Auto-generated method stub
		super.onWindowFocusChanged(hasFocus);
		int lines = introText.getLineCount();
		if(lines > 2)
		{
			introText.setMaxLines(2);
			introText.setEllipsize(TextUtils.TruncateAt.END);
			moreView.setVisibility(View.VISIBLE);
			moreView.setOnClickListener(CartoonDetailPageActivity.this);
		}
		else
		{
			moreView.setVisibility(View.GONE);
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
			View view = LayoutInflater.from(CartoonDetailPageActivity.this).inflate(R.layout.layout_chapter_item, null);
			((TextView)view.findViewById(R.id.id_title)).setText("1话");
			return view;
		}
		
	}
	
	private class MyOpenTask extends AsyncTask<Integer, Integer, Integer>
	{

		@Override
		protected Integer doInBackground(Integer... params) {
			// TODO Auto-generated method stub
			
			return null;
		}

		@Override
		protected void onPostExecute(Integer result) {
			// TODO Auto-generated method stub
			int lines = introText.getLineCount();
			if(lines > 2)
			{
				introText.setMaxLines(2);
				introText.setEllipsize(TextUtils.TruncateAt.END);
				moreView.setVisibility(View.VISIBLE);
				moreView.setOnClickListener(CartoonDetailPageActivity.this);
			}
			else
			{
				moreView.setVisibility(View.GONE);
			}
			super.onPostExecute(result);
		}
		
	}
}
