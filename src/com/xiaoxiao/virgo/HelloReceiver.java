package com.xiaoxiao.virgo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class HelloReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		String action = intent.getAction();
		Toast.makeText(context,"Receive action:"+action,Toast.LENGTH_LONG).show();
	}

}
