package com.xiaoxiao.virgo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.RadioGroup;
import android.widget.SimpleAdapter;

public class MainActivity extends ListActivity {

    private RadioGroup mRadioGroup;
    
    private String[] listTitle = {"name","id"};
    private int[]  itemId = {R.id.id_user_name,R.id.id_user_id};
    String[] userName = {"zhangsan","lisi","wangwu","zhaoliu"};
    String[] userId = {"1001","1002","1003","1004"};
    List<HashMap<String,String>> listData = null;
    HashMap<String,String> map = null;
    
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        
        mRadioGroup = (RadioGroup)findViewById(R.id.id_radiogroup);
        
        listData = new ArrayList<HashMap<String,String>>();
        for(int i=0;i<4;i++)
        {
        	map = new HashMap<String,String>();
        	map.put("id", userId[i]);
        	map.put("name", userName[i]);
        	listData.add(map);
        }
        
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,listData,R.layout.list_item,listTitle,itemId);
        setListAdapter(simpleAdapter);
    }
}
