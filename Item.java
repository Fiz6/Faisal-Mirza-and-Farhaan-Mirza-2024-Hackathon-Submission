import java.util.ArrayList;

public class Item {

	String name;
	String manufacturer;
	double price;
	int stock;
	ArrayList<String> ingredients;

	public Item(String name, String manufacturer, double price, int stock, ArrayList<String> ingredients){
		this.name = name;
		this.manufacturer = manufacturer;
		this.price = price;
		this.stock = stock;
		this.ingredients = ingredients;
	}

	public Item(String name, double price, int stock) {
		this.name = name;
		this.manufacturer = "";
		this.price = price;
		this.stock = stock;
		this.ingredients = new ArrayList<String>();
	}
	
} //End of class Item.