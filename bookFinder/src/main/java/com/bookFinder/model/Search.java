package com.bookFinder.model;

public class Search {

	
	private String query;	
	private String sort;
	private String sortType;
	private String sortDir;
	private int page;
	private int size;
	private String target;
	private String category;
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getSortType() {
		return sortType;
	}
	public void setSortType(String sortType) {
		this.sortType = sortType;
	}
	public String getSortDir() {
		return sortDir;
	}
	public void setSortDir(String sortDir) {
		this.sortDir = sortDir;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Search [query=" + query + ", sort=" + sort + ", sortType=" + sortType + ", sortDir=" + sortDir
				+ ", page=" + page + ", size=" + size + ", target=" + target + ", category=" + category + "]";
	}
	
	
	
	

}
