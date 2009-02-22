/**
 * Channel.java - represent the XML feed
 */
package com.igorgueapps.everyblock;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Igor Guerrero
 *
 */
public class Channel {
	
	private int id;
	private String title;
	private String description;
	private String link;
	private long pubDate;
	private long lastBuildDate;
	private List<String> categories;
	private List<Item> items;
	private String image;
	
	public Channel() {
		setCategories(new ArrayList<String>());
		setItems(new ArrayList<Item>());
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setPubDate(long pubDate) {
		this.pubDate = pubDate;
	}

	public long getPubDate() {
		return pubDate;
	}

	public void setLastBuildDate(long lastBuildDate) {
		this.lastBuildDate = lastBuildDate;
	}

	public long getLastBuildDate() {
		return lastBuildDate;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public List<Item> getItems() {
		return items;
	}
	
	public void addItem(Item item) {
		items.add(item);
	}

	public void setCategories(List<String> categories) {
		this.categories = categories;
	}

	public List<String> getCategories() {
		return categories;
	}
	
	public void addCagetory (String category) {
		categories.add(category);
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getImage() {
		return image;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getLink() {
		return link;
	}
	
}