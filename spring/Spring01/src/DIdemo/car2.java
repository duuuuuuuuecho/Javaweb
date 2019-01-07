package DIdemo;

public class car2 {
	private String name;
	private double price;
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	

	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
	@Override
	public String toString() {
		return "car2 [name=" + name + ", price=" + price + "]";
	}
	
}
