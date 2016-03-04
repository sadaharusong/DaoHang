package com.example.daohang;

import java.util.List;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

public class MyPagerAdapter extends PagerAdapter{

	private List<View> viewList;
	private List<String>titleList;
	public MyPagerAdapter(List<View>viewList,List<String>titleList)
	{
		this.viewList = viewList;
		this.titleList = titleList;
	}
	//���ص���ҳ��������
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return viewList.size();
	}

	//�жϵ�ǰ��View�Ƿ������ڶ���
	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		// TODO Auto-generated method stub
		return arg0 == arg1;
	}
	
	//����ҳ���ı���
	@Override
	public CharSequence getPageTitle(int position) {
		// TODO Auto-generated method stub
		return titleList.get(position);
	}
	
	//ʵ����һ��ҳ��
	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		// TODO Auto-generated method stub
		container.addView(viewList.get(position));
		return viewList.get(position);
	}
	
	//����һ��ҳ��
	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		// TODO Auto-generated method stub
		container.removeView(viewList.get(position));
	}
}
