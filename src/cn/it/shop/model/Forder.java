package cn.it.shop.model;

import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.List;

/**
 * Forder entity. @author MyEclipse Persistence Tools
 * 容器的关闭并不会导致session的销毁
 * 当对象存储到硬盘的时候，就需要实现序列化接口，序列化的功能就是添加了一个唯一的ID(类主键)
 * 这样在反序列化(从硬盘又加载到内存)的时候就可以成功找到相应的对象
 * 唯一的UID改变会导致反序列化失败
 */

public class Forder implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private String phone;
	private String remark;
	private Timestamp date;
	private Double total;
	private String post;
	private String address;
	private User user;
	private Status status;
	
	private List<Sorder> sorderList=new ArrayList<Sorder>();

	public Forder(List<Sorder> sorderList) {
		super();
		this.sorderList = sorderList;
	}

	public List<Sorder> getSorderList() {
		return sorderList;
	}

	public void setSorderList(List<Sorder> sorderList) {
		this.sorderList = sorderList;
	}

	public Forder() {
	}
	
	public Forder(Integer id, String name, String phone, String remark,
			Timestamp date, Double total, String post, String address,
			User user, Status status, List<Sorder> sorderList) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.remark = remark;
		this.date = date;
		this.total = total;
		this.post = post;
		this.address = address;
		this.user = user;
		this.status = status;
		this.sorderList = sorderList;
	}

	/** minimal constructor */
	public Forder(Timestamp date) {
		this.date = date;
	}
	
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

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Timestamp getDate() {
		return this.date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public Double getTotal() {
		return this.total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public String getPost() {
		return this.post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}