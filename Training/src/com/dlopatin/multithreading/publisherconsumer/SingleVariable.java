package com.dlopatin.multithreading.publisherconsumer;

public class SingleVariable {

	private String value;
	private boolean isChanged = false;

	public synchronized String getValue() throws InterruptedException {
		while (!isChanged) {
			wait();
		}
		isChanged = false;
		notify();
		return value;
	}

	public synchronized void setValue(String value) throws InterruptedException {
		while (!isChanged) {
			wait();
		}
		this.value = value;
		isChanged = true;
		notify();
	}

}