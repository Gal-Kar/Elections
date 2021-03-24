package Model;

import java.util.ArrayList;

public class Set<T extends Citizen> {
	
	private ArrayList<T>items;
	public Set() {
		items=new ArrayList<>();
	}
	
	public boolean exsistID(String id) {
		for(int i=0;i<items.size();i++) {
			if(items.get(i).getID().equals(id))
				return true;
		}
		return false;
	}
	
	public boolean add(T element) {
		exsistID(element.getID());
		items.add(element);
		return true;
	}
	
	public Citizen getCitizenByName(String name){
		for(int i=0;i<items.size();i++) {
			if(items.get(i).getName().equals(name))
				return items.get(i);
		}
		return null;
	}
	
	public int size() {
		return items.size();
	}
	
	public Citizen get(int i) {
		return items.get(i);
	}
	
	public String printList(){
		String str=new String();
		for(int i=0;i<items.size();i++) {
			str+=items.get(i).toString()+"\n";
		}
		return str;
	}

}
