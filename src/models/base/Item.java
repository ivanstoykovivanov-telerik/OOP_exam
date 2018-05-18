package models.base;

public class Item implements IValidateItem  {
	private String title ; 
	private String description ;
	

	public Item(String title, String description) {
		super();
		this.title = title;
		this.description = description;
	}

	@Override
	public boolean validateTitle(String title) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean validateDescription(String description) {
		// TODO Auto-generated method stub
		return false;
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
	
	
	
	
	
}
