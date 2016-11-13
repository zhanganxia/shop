package cn.it.shop.model;

/**
 * Sorder entity. @author MyEclipse Persistence Tools
 */

public class Sorder implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Double price;
	private Integer number;
	private Product product;
	private Forder forder;
	private Integer findex;


	// Constructors

	public Integer getFindex() {
		return findex;
	}

	public void setFindex(Integer findex) {
		this.findex = findex;
	}

	public Forder getForder() {
		return forder;
	}

	public void setForder(Forder forder) {
		this.forder = forder;
	}

	/** default constructor */
	public Sorder() {
	}
	public Sorder(Integer id, String name, Double price, Integer number,
			Product product, Forder forder, Integer findex) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.number = number;
		this.product = product;
		this.forder = forder;
		this.findex = findex;
	}

	/** minimal constructor */
	public Sorder(Integer number) {
		this.number = number;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getNumber() {
		return this.number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}