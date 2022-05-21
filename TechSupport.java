package finalProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Vector;

/**
 */
public class TechSupport extends User implements Serializable{
	
	private Order order;
	public String message;
	private Manager manager;
	
	
	
    public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public TechSupport(String firstName, String midName, String lastName, String email, String password, String id) {
		super(firstName, midName, lastName, email, password, id);
	}


    public void acceptOrder(Order order) throws IOException {
//    	acceptedOrders.add(order);
    	order.setStatus(OrderStatus.ACCEPTED);
    	System.out.println("Order accepted!");
//    	orders.remove(order);
    	if(order.getOrderType() == OrderType.FROMMANAGER) {
    		this.getMessage();
    		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//    		Scanner in = new Scanner(System.in);
    		System.out.println("Write manager's emsil and your response...");
    		String emaill = in.readLine();
    		String msg = in.readLine();
    		for(int i=0;i<Database.getManagers().size();i++) {
    			if(Database.getManagers().get(i).getEmail().equals(emaill)) {
    				Database.getManagers().get(i).setMessageFromTech(msg);
    				break;
    			}
    			
    		}
    		
    	}
    }
    
    public void setMessage(String msg) {
    	this.message = msg;
    }
    
    public String getMessage() {
    	return this.message;
    }
    

    public void viewAcceptedOrders() {
    	for(int i=0;i<Database.getOrders().size();i++) {
    		if(Database.getOrders().get(i).getStatus() == OrderStatus.ACCEPTED)
    			System.out.println(Database.getOrders().get(i));
    	}
    }
    
    public void viewNotAcceptedOrders() {
    	for(int i=0;i<Database.getOrders().size();i++) {
    		if(Database.getOrders().get(i).getStatus() == OrderStatus.NOTPROCESSED)
    			System.out.println(Database.getOrders().get(i));
    	}
    }
}

