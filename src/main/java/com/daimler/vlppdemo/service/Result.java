package com.daimler.vlppdemo.service;

import java.io.Serializable;

public class Result implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int nr;
	private long elapsed;
	private boolean error;
	public int getNr() {
		return nr;
	}
	public void setNr(int nr) {
		this.nr = nr;
	}
	public long getElapsed() {
		return elapsed;
	}
	public void setElapsed(long elapsed) {
		this.elapsed = elapsed;
	}
	public boolean isError() {
		return error;
	}
	public void setError(boolean error) {
		this.error = error;
	}

}
