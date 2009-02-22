/**
 * RssParser.java - parse RSS documents
 */

package com.igorgueapps.everyblock;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * @author Igor guerrero
 *
 */
public class RssParser extends DefaultHandler {
	
	private String urlString;
	private Channel channel;
	private StringBuilder text;
	private Item item;
	private boolean imgStatus;
	
	public RssParser(String url) {
		urlString = url;
		text = new StringBuilder();
	}

	public Channel getChannel() {
		return channel;
	}
	
	public void parse() throws ParserConfigurationException, SAXException, IOException {
		InputStream urlInputStream = null;
		SAXParserFactory spf = null;
		SAXParser sp = null;
		URL url = new URL(urlString);
		
		urlInputStream = url.openConnection().getInputStream();
		spf = SAXParserFactory.newInstance();
		
		if (spf != null) {
			sp = spf.newSAXParser();
			sp.parse(urlInputStream, this);
		}
		
		if (urlInputStream != null)
			urlInputStream.close();
	}
	
	@Override
	public void startElement(String uri, String localName, String name,
			Attributes attributes) throws SAXException {
		// first check for the channel
		if (localName.equalsIgnoreCase("channel"))
			channel = new Channel();
		
		// check for a item
		if (localName.equalsIgnoreCase("item")) {
			item = new Item();
			channel.addItem(item);
		}
		
		// now lets check for an item
		if (localName.equalsIgnoreCase("item") && (channel != null))
			imgStatus = true;
	}
	
	@Override
	public void endElement(String uri, String localName, String name)
			throws SAXException {
		// check if we have a RSS feed
		if (channel == null)
			return;
		
		// check if we are at the end of an item
		if (localName.equalsIgnoreCase("item"))
			item = null;
		
		// check if we are at the end of an image
		if (localName.equalsIgnoreCase("image"))
			imgStatus = false;
		
		// now we parser which title we are in
		if (localName.equalsIgnoreCase("title")) {
			// we are an item so we set the item title
			if (item != null)
				item.setTitle(text.toString().trim());
			else // we are in an channel
				channel.setTitle(text.toString().trim());
		}
		
		// now checking for a link
		if (localName.equalsIgnoreCase("link")) {
			// check if we are in a item
			if (item != null) {
				item.setLink(text.toString().trim());
			} else if (imgStatus) {
				channel.setImage(text.toString().trim());
			} else {
				channel.setLink(text.toString().trim());
			}
		}
		
		// now checking for description
		if (localName.equalsIgnoreCase("description")) {
			// if we are in an item
			if (item != null)
				item.setDescription(text.toString().trim());
			else // we are in a channel
				channel.setDescription(text.toString().trim());
		}
		
		// now checking for category
		if (localName.equalsIgnoreCase("category"))
			channel.addCagetory(text.toString().trim());
		
		text.setLength(0);
	}
	
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		text.append(ch, start, length);
	}
	
}