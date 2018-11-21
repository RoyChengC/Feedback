package com.feedback.state;

public class PageQueryState {
	private int curPage = 0;
	private int lastPage = 0;
	
	public PageQueryState() {

	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getLastPage() {
		return lastPage;
	}

	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}
}
