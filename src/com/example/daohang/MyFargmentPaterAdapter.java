package com.example.daohang;

import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MyFargmentPaterAdapter extends FragmentPagerAdapter{
	
	private List<Fragment> fraglist;
	private List<String> titleList;
	public MyFargmentPaterAdapter(FragmentManager fm, List<Fragment> fragList, List<String> titleList) {
		super(fm);
		// TODO Auto-generated constructor stub
		this.fraglist = fragList;
		this.titleList = titleList;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		// TODO Auto-generated method stub
		return titleList.get(position);
	}
	
	@Override
	public Fragment getItem(int arg0) {
		// TODO Auto-generated method stub
		return fraglist.get(arg0);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return fraglist.size();
	}
	

}
