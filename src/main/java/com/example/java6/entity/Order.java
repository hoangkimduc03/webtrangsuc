package com.example.java6.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnore;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "Orders")
public class Order  implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private	Long id;
	private	String address;
	@Temporal(TemporalType.DATE)
	@Column(name = "Createdate")
	private	Date createDate = new Date();
	@ManyToOne
	@JoinColumn(name = "Username")
	private	Account account;
	
	@JsonIgnore
	@OneToMany(mappedBy = "order")
	private	List<OrderDetail> orderDetails;
}