import java.util.Collections;import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Source {

	public static void main(String[] args) {
		//example 1
	Set ts=new TreeSet();
	ts.add("Shubham");
	ts.add("Hrithik");
	ts.add("Saurabh");
//	ts.add(45);		ClassCastException
//	ts.add(6.6);	ClassCastException
//	ts.add(true);	ClassCastException
	for(Object data : ts) {
		System.out.println(data);	// sorted order
	}
	
	//Example 2
	
	Set ts1=new HashSet();
	ts1.add("Vasantha");
	ts1.add(45);
	ts1.add("Vasantha");		// ignore the duplicate element
	ts1.add(true);
//	Collections.sort(null);		// it works only with List not with set
	for(Object data : ts1) {
		System.out.println(data);	// heterogenous elements
	}

	//Example 3
	TreeSet<Integer> tsint1=new TreeSet<Integer>();
	tsint1.add(45);
	tsint1.add(560);
	
	TreeSet<Integer> tsint2=new TreeSet<Integer>();
	tsint2.add(45);
	tsint2.add(59);
	
	tsint1.addAll(tsint2);
	for(Object data : tsint1) {
		System.out.println(data);	// adding the entire collection
	}
	
	//Example 4 Working with userdefined objects
//	TreeSet<Product> tsprd=new TreeSet<Product>();
//	tsprd.add(new Product(101, "Shirts", 560, 23));
//	tsprd.add(new Product(102, "Tees", 760, 26));
//	tsprd.add(new Product(103, "Trousers", 1000, 29));
	// At runtime it throws ClassCastException if not compared(no comparable) by default
	
	//Example 5 Implementing default sorting on productid
	TreeSet<Product> tsprd=new TreeSet<Product>();
	tsprd.add(new Product(101, "Shirts", 560, 23));
	tsprd.add(new Product(102, "Tees", 760, 26));
	tsprd.add(new Product(103, "Trousers", 1000, 29));
	for(Product p : tsprd) {
		System.out.println(p);
	}
	
	//Example 6 Collection of products in decreasing order  of price
			//		IMPLEMENTING USING COMPARATOR IMPLEMENTED CLASS
//	TreeSet<Product> tsprice=new TreeSet<Product>(new SortByPrice())
	System.out.println("========= By Price in Decreasing Order=======");
	TreeSet<Product> tsprice=new TreeSet<Product>((p1,p2)->(int) p2.getPrice()-(int)p1.getPrice());
	tsprice.addAll(tsprd);
	for(Product p : tsprice) {
		System.out.println(p);
	}
	System.out.println("====== By Qty in Ascending Order=======");
	TreeSet<Product> tsqty=new TreeSet<Product>((p1,p2)->p1.getQty()-p2.getQty());
	tsqty.addAll(tsprd);
	for(Product p : tsqty) {
		System.out.println(p);
	}
	
	}

}
