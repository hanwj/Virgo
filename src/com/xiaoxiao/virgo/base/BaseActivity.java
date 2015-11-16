package com.xiaoxiao.virgo.base;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

public class BaseActivity extends FragmentActivity {

	public void toast(String msg)
	{
		Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
	}
	
	public void forward(Class<?> classObj)
	{
		Intent intent = new Intent();
		intent.setClass(this, classObj);
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		this.startActivity(intent);
	}
}
