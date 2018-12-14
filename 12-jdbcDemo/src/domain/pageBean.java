package domain;

import java.util.List;

public class pageBean<T> {

	private List<T> list;	//当前页内容
	private int currPage;	//当前页数
	private int pageSize;	//每页显示的数量
	private int totalCount;  //总条数
	private int totalPage;   //总页数
	
	public pageBean() {}
	
	public pageBean(List<T> list, int currPage, int pageSize, int totalCount) {
		super();
		this.list = list;
		this.currPage = currPage;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
	}

	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public int getCurrPage() {
		return currPage;
	}
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	
	public int getTotalPage() {
		return (int)Math.ceil(totalCount*1.0/pageSize);
	}
	
	
}
