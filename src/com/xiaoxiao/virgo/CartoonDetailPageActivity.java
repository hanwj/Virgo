package com.xiaoxiao.virgo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class CartoonDetailPageActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_cartoon_detail_page);
	}

}
