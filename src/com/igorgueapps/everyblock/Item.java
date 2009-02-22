/**
 * Item.java - represent the feed item 
 */

package com.igorgueapps.everyblock;

/**
 * @author Igor Guerrero
 *
 */
public class Item {
	
	private int id;
	private String title;
	private String link;
	private String Description;
	private String pubDate;
	
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
	
	public void setLink(String link) {
		this.link = link;
	}
	
	public String getLink() {
		return link;
	}
	
	public void setDescription(String description) {
		Description = description;
	}
	
	public String getDescription() {
		return Description;
	}
	
	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}
	
	public String getPubDate() {
		return pubDate;
	}
	
}