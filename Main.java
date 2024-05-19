/*************************************************************************
Program Name: 2024 FHS Hackathon Submission - Faisal Mirza & Farhaan Mirza
Programmed by: Faisal M & Farhaan M
*************************************************************************/
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
	
public class Main {

	static ArrayList<Item> Inventory = new ArrayList<Item>();
	static Scanner one = new Scanner(System.in);
	static String entered = "";
	static BufferedWriter export;
	
	public static void main(String[] args) throws InterruptedException {
	
		System.out.println("Please enter inputs when prompted. If presented with options, please enter the number corresponding to the option choice.\n______________________________\n");

		do {
			System.out.println("\n______________________________\nWhat would you like to do?");
			System.out.println("\t1). Inventory Management");
			System.out.println("\t2). Export Data");
			System.out.println("\t3). Import Data");
			System.out.println("\t4). Quit Program");

			entered = one.next();
			one.nextLine();

			while(!entered.equals("1") && !entered.equals("2") && !entered.equals("3") && !entered.equals("4") && !entered.equals("5")) {
				System.out.println("\nPlease enter a valid integer input");
				entered = one.next();
				one.nextLine();
			}

			if(entered.equals("1")) { manageInventory(); }
			else if(entered.equals("2")) { exportData(); }
			else if(entered.equals("3")) { importData(); }
			else if(entered.equals("4")) { entered = "*END*"; }
			
		} while(!entered.equals("*END*"));
		
	} //End of main().

			//Methods

		//Enter the inventory management menu.
	public static void manageInventory() {
		do {
			System.out.println("\nPlease select your operation.");
			System.out.println("\t1). List Inventory");
			System.out.println("\t2). Access/Manage Item Information");
			System.out.println("\t3). Total Item Count");
			System.out.println("\t4). Add New Listing.");
			System.out.println("\t5). Remove Listing.");
			System.out.println("\t6). Exit to previous menu.");
			entered = one.next();
			one.nextLine();
	
			while(!entered.equals("1") && !entered.equals("2") && !entered.equals("3") && !entered.equals("4") && !entered.equals("5") && !entered.equals("6")) {
				System.out.println("\nPlease enter a valid integer input");
				entered = one.next();
				one.nextLine();
			}
	
			if(entered.equals("1")) {
				System.out.println("\nThe current items listed in the Inventory are:");
				for(int x = 0; x < Inventory.size(); x++) {
					Item n = Inventory.get(x);
					System.out.println("\t" + (x+1) + "). " + n.name + " (" + n.stock + " in stock)");
				}
	
				if(Inventory.size() <= 0) { System.out.println("There are no items in the Inventory."); }
			}
			else if(entered.equals("2")) { manageItems(); }
			else if(entered.equals("3")) {
				int totalListings = 0;
				int totalSingular = 0;
				for(Item n : Inventory) {
					totalListings++;
					totalSingular += n.stock;
				}
				System.out.println("\nThe total amount of items listed in the inventory is: " + totalListings);
				System.out.println("\nThe total amount of items stored is: " + totalSingular);
				
			}
			else if(entered.equals("4")) {
				String name = "";
				String manufacturer = "";
				double price = 0.0;
				int stock = 0;
				ArrayList<String> stuffToAdd = new ArrayList<String>();
				
				System.out.println("\nPlease enter the name of the Item:");
				name = one.nextLine();
				System.out.println("\nPlease enter the manufacturer of the Item:");
				manufacturer = one.nextLine();
				System.out.println("\nPlease enter the price of the Item:");
				entered = one.next();
				one.nextLine();

				try {
					price = Double.parseDouble(entered);
				} catch(Exception e) {
					System.out.println("\nThe input was invald. Price was set to 0.0 and can be managed through the item management menu.");
					price = 0.0;
				}

				System.out.println("\nPlease enter the stock amount of the Item:");
				entered = one.next();
				one.nextLine();

				try {
					stock = Integer.parseInt(entered);
				} catch(Exception e) {
					System.out.println("\nThe input was invald. Stock was set to 0 and can be managed through the item management menu.");
					stock = 0;
				}

				System.out.println("\nPlease enter the ingredients, pressing enter after each one. Submit 'ENDINPUT' to signify the end of the ingredients list.");
					while(!entered.equals("ENDINPUT")) {
						entered = one.nextLine();
						if(!entered.equals("ENDINPUT")) { stuffToAdd.add(entered); }
					}

				Inventory.add(new Item(name, manufacturer, price, stock, stuffToAdd));
				System.out.println("\nThe listing has been created and added to the Inventory.");
				
			}
			else if(entered.equals("5")) {
				System.out.println("Please enter the name of the listing you would like to remove");

				String toRemove = one.nextLine();
				int spot = 0;

				for(Item now : Inventory) {
					if(now.name.equals(toRemove)) { break; }
					else { spot++; }
				}

				Inventory.remove(spot);
				
			} else if(entered.equals("6")) { entered = "*ExitInv*"; }
			
		} while(!entered.equals("*ExitInv*"));
	} //End of manageInventory().

		//Manage the attributes of items.
	public static int manageItems() {
		System.out.println("\nPlease enter the listing which this action will be in refrence to?:");
		entered = one.nextLine();
		String listing = entered;
		boolean exists = false;
		
		for(Item n : Inventory) {
		if(n.name.equals(listing)) { exists = true; break; }
		}
		if(exists == false) {
			System.out.println("\nInvalid listing entered. Returning to previous menu");
			return 0;
		}

		int spot = 0;
		while(Inventory.get(spot).name.equals(listing) == false) { spot++; }
		
		do {
			System.out.println("\nPlease select your operation");
			System.out.println("\t1). Change name.");
			System.out.println("\t2). Change manufacturer");
			System.out.println("\t3). Get manufacturer");
			System.out.println("\t4). Change stock amount");
			System.out.println("\t5). Get stock amount");
			System.out.println("\t6). Change price");
			System.out.println("\t7). Get price");
			System.out.println("\t8). Change ingredients");
			System.out.println("\t9). Get ingredients");
			System.out.println("\t10). Return to previous menu");

			entered = one.next();
			one.nextLine();
			
			while(!entered.equals("1") && !entered.equals("2") && !entered.equals("3") && !entered.equals("4") && !entered.equals("5") && !entered.equals("6") && !entered.equals("7") && !entered.equals("8") && !entered.equals("9") && !entered.equals("10")) {
				System.out.println("\nPlease enter a valid integer input");
				entered = one.next();
				one.nextLine();
			}

			if(entered.equals("1")) {
				System.out.println("\nPlease enter the new name of the Item:");
				Inventory.get(spot).name = one.nextLine();
				entered = "-1";
			}
			else if(entered.equals("2")) {
				System.out.println("\nPlease enter the new manufacturer of the Item:");
				Inventory.get(spot).manufacturer = one.nextLine();
				entered = "-1";
			}
			else if(entered.equals("3")) {
				System.out.println("\n"+Inventory.get(spot).manufacturer);
				entered = "-1";
			}
			else if(entered.equals("4")) {
				System.out.println("\nPlease enter the new stock amount of the Item:");
				entered = one.next();
				one.nextLine();

				try {
					Integer.parseInt(entered);
					Inventory.get(spot).stock = Integer.parseInt(entered);
				} catch(Exception e) {
					System.out.println("\nThe input was invald. Returning to previous menu.");
					entered = "*ExitItem*";
				}
			}
			else if(entered.equals("5")) {
				System.out.println("\n"+Inventory.get(spot).stock);
				entered = "-1";
			}
			else if(entered.equals("6")) {
				System.out.println("\nPlease enter the new price value of the Item:");
				entered = one.next();
				one.nextLine();

				try {
					Double.parseDouble(entered);
					Inventory.get(spot).price = Double.parseDouble(entered);
				} catch(Exception e) {
					System.out.println("\nThe input was invald. Returning to previous menu.");
					entered = "*ExitItem*";
				}
			}
			else if(entered.equals("7")) {
				System.out.println("\n"+Inventory.get(spot).price);
				entered = "-1";
			}
			else if(entered.equals("8")) {

				ArrayList<String> newStuff = new ArrayList<String>();
				
				System.out.println("Please enter the ingredients, pressing enter after each one. Submit 'ENDINPUT' to signify the end of the ingredients list.");
				while(!entered.equals("ENDINPUT")) {
					entered = one.nextLine();
					if(!entered.equals("ENDINPUT")) { newStuff.add(entered); }
				}
				Inventory.get(spot).ingredients = newStuff;
				entered = "-1";
			}
			else if(entered.equals("9")) {
				System.out.println("\nThe ingredients are:");
				for(int x = 0; x < Inventory.get(spot).ingredients.size(); x++) {
					System.out.println("\t"+(x+1)+"). " + Inventory.get(spot).ingredients.get(x));
				}
				entered = "-1";
			}
			else if(entered.equals("10")) { entered = "*ExitItem*"; }
			
		} while(!entered.equals("*ExitItem*"));
		return 1;
	} //End of manageItems().

		//Export data to the specified file or create a new file for data to be saved in.
	public static void exportData() {
		System.out.println("Please enter the name of the file you would like the data to be stored to.\nEx\"myData.txt\"\nIf the file does not exist, a new file will be created with the given name.");

		try {
		
			String fileName = one.nextLine();
			File location = new File(fileName);
			
			if(location.isFile()) { export = new BufferedWriter(new FileWriter(fileName)); }
			else { export = new BufferedWriter(new FileWriter(new File(fileName))); }

			for(Item n : Inventory) {
				export.write(n.name);
				export.newLine();
				export.write(n.manufacturer);
				export.newLine();
				export.write(""+n.stock);
				export.newLine();
				export.write(""+n.price);
				export.newLine();
				for(String part : n.ingredients) {
					export.write(part + ":_:SPLIT:_:");
				}
				export.newLine();
				export.flush();
			}

		} catch(Exception e) { System.out.println(e); }

		entered = "-1";
		
	} //End of exportData().

		//Import data from the specified file.
	public static void importData() {
		System.out.println("Please enter the name of the file you would like to import data from.\nPlease be aware that this will OVERWRITE PREVIOUS DATA that has NOT YET BEEN EXPORTED to a separate file.");

		String fileName = one.nextLine();
		File location = new File(fileName);
		ArrayList<Item> newInventory = new ArrayList<Item>();
		
		try {

			String name = "";
			String manufacturer = "";
			int stock = 0;
			double price = 0.0;
			ArrayList<String> newIngredients = new ArrayList<String>();
			
			Scanner bring = new Scanner(location);
			
			while(bring.hasNextLine()) {
				
				newIngredients = new ArrayList<String>();

				String first = bring.nextLine();
				if(!first.equals("")) {
					
					name = first;
					manufacturer = bring.nextLine();
					stock = bring.nextInt();
					bring.nextLine();
					price = bring.nextDouble();
					bring.nextLine();
	
					String[] temp = bring.nextLine().split(":_:SPLIT:_:");
					for(String now : temp) { newIngredients.add(now); }
					
					newInventory.add(new Item(name, manufacturer, price, stock, newIngredients));
				}
			}
			Inventory = newInventory;
			
		} catch(Exception e) {
			System.out.println("\n"+e);
		}
		
	} //End of importData().
} //End of class Main.