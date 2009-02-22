/**
 * ItemView.java - android view for items 
 */
package com.igorgueapps.everyblock;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * @author Igor Guerrero
 *
 */
public class ItemView extends LinearLayout {
	
	private TextView textView;
	
	public ItemView(Context context, Item item) {
		super(context);
		
		String infService = Context.LAYOUT_INFLATER_SERVICE;
		LayoutInflater lf;
		lf = (LayoutInflater)getContext().getSystemService(infService);
		lf.inflate(R.layout.rss_item, this, true);
		
		setTextView((TextView)findViewById(R.id.RssItemTitle));
		Log.i("Examples", item.getTitle());
		getTextView().setText(item.getTitle());
	}

	public void setTextView(TextView textView) {
		this.textView = textView;
	}

	public TextView getTextView() {
		return textView;
	}
}