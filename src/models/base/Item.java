package models.base;

public class Item implements Comparable<Item>  {
	private String title ; 
	private String description ;
	
	public Item(String title, String description) {
			this.title = title;
			this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int compareTo(Item item) {
        int firstCmp = this.getTitle().compareTo(item.getTitle());
        return firstCmp != 0 ? firstCmp :  this.getDescription().compareTo(item.getDescription());
    }
	
}
