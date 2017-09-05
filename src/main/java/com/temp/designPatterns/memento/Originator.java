package com.temp.designPatterns.memento;

public class Originator {

	private String state;
	
	public Memento createMemento() {
		return new MementoImpl(state);
	}
	
	public void setMemento(Memento memento) {
		MementoImpl mementoImpl = (MementoImpl) memento;
		this.state = mementoImpl.getState();
	}
	
	private static class MementoImpl implements Memento {

		private String state;
		
		public MementoImpl(String state) {
			this.state = state;
		}
		
		public String getState() {
			return this.state;
		}
	}
	
}
