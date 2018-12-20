package com.mitrais.entities;

import org.springframework.stereotype.Component;

import com.mitrais.model.interfaces.Menu;


@Component
public class Makanan implements Menu{
	private String nama;
	private int harga;
	public Makanan() {
	}
	public Makanan(String nama, int harga) {
		this.nama = nama;
		this.harga = harga;
	}
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public int getHarga() {
		return harga;
	}
	public void setHarga(int harga) {
		this.harga = harga;
	}
}

//package com.mitrais.model;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//import javax.validation.constraints.NotNull;
//
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//@Table(name = "makanan")
//public class Makanan {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "makanan_id")
//	private int id;
//	@Column(name = "nama")
//	@NotNull(message = "Please provide your nama")
//	private String nama;
//	@Column(name = "harga")
//	@NotNull(message = "Please provide your harga")
//	private int harga;
//
//}