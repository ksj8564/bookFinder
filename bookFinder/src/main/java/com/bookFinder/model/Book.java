package com.bookFinder.model;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "book_id")
	private int book_id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "contents")
	private String contents;
	
	@Column(name = "url")
	private String url;
	
	@Column(name = "isbn")
	private String isbn;
	
	@Column(name = "datetime")
	private String datetime;
	
	@Column(name = "authors")
	private String authors;
	
	@Column(name = "publisher")
	private String publisher;
	
	@Column(name = "translators")
	private String translators;
	
	@Column(name = "price")
	private int price;
	
	@Column(name = "sale_price")
	private int sale_price;
	
	@Column(name = "sale_yn")
	private String sale_yn;
	
	@Column(name = "category")
	private String category;
	
	@Column(name = "thumbnail")
	private String thumbnail;
	
	@Column(name = "barcode")
	private String barcode;

	@Column(name = "ebook_barcode")
	private String ebook_barcode;
	
	@Column(name = "status")
	private String status;

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public String getAuthors() {
		return authors;
	}

	public void setAuthors(String authors) {
		this.authors = authors;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getTranslators() {
		return translators;
	}

	public void setTranslators(String translators) {
		this.translators = translators;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getSale_price() {
		return sale_price;
	}

	public void setSale_price(int sale_price) {
		this.sale_price = sale_price;
	}

	public String getSale_yn() {
		return sale_yn;
	}

	public void setSale_yn(String sale_yn) {
		this.sale_yn = sale_yn;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getEbook_barcode() {
		return ebook_barcode;
	}

	public void setEbook_barcode(String ebook_barcode) {
		this.ebook_barcode = ebook_barcode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Book [book_id=" + book_id + ", title=" + title + ", contents=" + contents + ", url=" + url + ", isbn="
				+ isbn + ", datetime=" + datetime + ", authors=" + authors + ", publisher=" + publisher
				+ ", translators=" + translators + ", price=" + price + ", sale_price=" + sale_price + ", sale_yn="
				+ sale_yn + ", category=" + category + ", thumbnail=" + thumbnail + ", barcode=" + barcode
				+ ", ebook_barcode=" + ebook_barcode + ", status=" + status + "]";
	}

	public Book(int book_id, String title, String contents, String url, String isbn, String datetime, String authors,
			String publisher, String translators, int price, int sale_price, String sale_yn, String category,
			String thumbnail, String barcode, String ebook_barcode, String status) {
		super();
		this.book_id = book_id;
		this.title = title;
		this.contents = contents;
		this.url = url;
		this.isbn = isbn;
		this.datetime = datetime;
		this.authors = authors;
		this.publisher = publisher;
		this.translators = translators;
		this.price = price;
		this.sale_price = sale_price;
		this.sale_yn = sale_yn;
		this.category = category;
		this.thumbnail = thumbnail;
		this.barcode = barcode;
		this.ebook_barcode = ebook_barcode;
		this.status = status;
	}

	public Book() {
		super();
	}



	
	
	 
	
}
