package restaurant;

public class Item {
	private String ID;
	 private String Name;
     private int cost;
     private int rating;
     private int qty;
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public Item(String iD, String name, int cost, int rating, int qty) {
		super();
		ID = iD;
		Name = name;
		this.cost = cost;
		this.rating = rating;
		this.qty = qty;
	}
	@Override
	public String toString() {
		return "Item [ID=" + ID + ", Name=" + Name + ", cost=" + cost + ", rating=" + rating + ", qty=" + qty + "]";
	}
	
}
