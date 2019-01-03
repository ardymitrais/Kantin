package com.mitrais.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Menu {
	@Id
	@Column(name="menu_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int menuId;
	
	@Column(name="menu_name")
	@NotEmpty(message = "Nama menu tidak boleh kosong")
	private String menuName;

	@Column(name="menu_price")
	@Min(value=1, message="Harga menu tidak boleh kurang dari 1")
	private int menuPrice;

	@ManyToOne
	@JoinColumn(name="category_id")
	@NotNull(message = "kategori menu tidak boleh kosong")
	private Category category;
}
