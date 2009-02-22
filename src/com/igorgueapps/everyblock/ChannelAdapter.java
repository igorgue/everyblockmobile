/**
 * ChannelAdapter.java - fills the view with items
 */

package com.igorgueapps.everyblock;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * @author Igor Guerrero
 *
 */
public class ChannelAdapter extends BaseAdapter {
	
	private Context context;
	private List<Item> items;
	
	public ChannelAdapter(Context context, List<Item> items) {
		setContext(context);
		setItems(items);
	}
	
	public int getCount() {
		return getItems().size();
	}

	public Object getItem(int position) {
		return getItems().get(position);
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		ItemView view =null;
		Item item = (Item)getItem(position);
		
		if (convertView == null)
			view = new ItemView(getContext(), item);
		else
			view = (ItemView)convertView;
		
		return view;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setContext(Context context) {
		this.context = context;
	}

	public Context getContext() {
		return context;
	}
	
}