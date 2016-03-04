package com.example.daohang;

import java.util.ArrayList;
import java.util.List;

import android.R.color;
import android.R.id;
import android.R.string;
import android.app.Activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends FragmentActivity implements OnPageChangeListener{
	private List<View> viewList;
	private ViewPager pager;
	private PagerTabStrip tab;
	private List<String> titleList;
	private List<Fragment>fragList;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		viewList = new ArrayList<View>();
		
		View view1 = View.inflate(this, R.layout.view1, null);
		View view2 = View.inflate(this, R.layout.view2, null);
		View view3 = View.inflate(this, R.layout.view3, null);
		View view4 = View.inflate(this, R.layout.view4, null);
		
		viewList.add(view1);
		viewList.add(view2);
		viewList.add(view3);
		viewList.add(view4);
		//通过Fragment作为ViewPager的数据源
		
		
		
		fragList = new ArrayList<Fragment>();
		fragList.add(new Fragment1());
		fragList.add(new Fragment2());
		fragList.add(new Fragment3());
		fragList.add(new Fragment4());
		
		
		//为页卡设置标题
		titleList = new ArrayList<String>();
		titleList.add("第一页");
		titleList.add("第二页");
		titleList.add("第三页");
		titleList.add("第四页");
		
		//为PagerTabStrip设置一些属性
		tab = (PagerTabStrip) findViewById(R.id.tap);
		tab.setBackgroundColor(Color.WHITE);
		tab.setTextColor(Color.BLACK);
		tab.setDrawFullUnderline(false);
		tab.setTabIndicatorColor(Color.GREEN);
		
		pager = (ViewPager)findViewById(R.id.pager);
		//创建PagerAdapter的适配器
		MyPagerAdapter adapter = new MyPagerAdapter(viewList,titleList);
		
		//配饰适配器
		//pager.setAdapter(adapter);
		MyFargmentPaterAdapter adapter2 = new MyFargmentPaterAdapter(getSupportFragmentManager(),fragList,titleList);
		pager.setAdapter(adapter2);
		pager.setOnPageChangeListener(this);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageSelected(int arg0) {
		// TODO Auto-generated method stub
		Toast.makeText(this, "当前是第" + (arg0+1) + "个页面", Toast.LENGTH_SHORT).show();
	}
}
