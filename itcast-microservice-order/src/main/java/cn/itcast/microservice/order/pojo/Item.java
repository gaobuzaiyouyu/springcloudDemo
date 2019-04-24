package cn.itcast.microservice.order.pojo;

/**
 <p>Title: Item</p>
 <p>Description: </p>
 <p>Company: </p>
 @author gaozhe
 @date 2019-4-16-下午8:58:31
 */
public class Item {
	
	private Long id;
	
	private String title;
	
	private String pic;
	
	private String desc;
	
	private Long price;
	
	/**
	 <p>Title: itcast-microservice-item</p>
	 <p>Description: </p>
	 <p>Company: </p>
	 @author gaozhe
	 @date 2019-4-16
	*/
	public Item(Long id, String title, String pic, String desc, Long price) {
		super();
		this.id = id;
		this.title = title;
		this.pic = pic;
		this.desc = desc;
		this.price = price;
	}
	public Item(){
		
	}
	public Long getId() {
		return  id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return  title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String toString() {
		return "Item [id=" + id + ", title=" + title + ", pic=" + pic + ", desc=" + desc + ", price=" + price + "]";
	}
}
