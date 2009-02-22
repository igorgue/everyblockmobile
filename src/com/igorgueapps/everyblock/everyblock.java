package com.igorgueapps.everyblock;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class everyblock extends Activity {
	
	private ListView listView;
	private RssParser parser;
	private List<Item> items;
	private ChannelAdapter channelAdapter;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rss_list);
        
        setListView((ListView)findViewById(R.id.RssAllItems));
        setParser(new RssParser("http://miami.everyblock.com/rss/locations/cities/hialeah/"));
        
        try {
        	parser.parse();
        	setTitle(getParser().getChannel().getTitle());
        	setItems(parser.getChannel().getItems());
        	setChannelAdapter(new ChannelAdapter(this, getItems()));
        	getListView().setAdapter(getChannelAdapter());
        } catch (ParserConfigurationException e) {
        	e.printStackTrace();
        } catch (SAXException e) {
        	e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

	public void setListView(ListView listView) {
		this.listView = listView;
	}

	public ListView getListView() {
		return listView;
	}

	public void setParser(RssParser parser) {
		this.parser = parser;
	}

	public RssParser getParser() {
		return parser;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setChannelAdapter(ChannelAdapter channelAdapter) {
		this.channelAdapter = channelAdapter;
	}

	public ChannelAdapter getChannelAdapter() {
		return channelAdapter;
	}
}