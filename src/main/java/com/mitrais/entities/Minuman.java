package com.mitrais.entities;

import org.springframework.stereotype.Component;

import com.mitrais.model.interfaces.Menu;


@Component
public class Minuman implements Menu{
	private String nama;
	private int harga;
	public Minuman() {
	}
	public Minuman(String nama, int harga) {
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
