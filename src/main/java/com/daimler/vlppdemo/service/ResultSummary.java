package com.daimler.vlppdemo.service;

import java.io.Serializable;
import java.util.List;

public class ResultSummary implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int count;
	private long average;
	private List<Result> results;
	private String query;

	public long getAverage() {
		return average;
	}

	public void setAverage(long average) {
		this.average = average;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public List<Result> getResults() {
		return results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}
	
	
}
