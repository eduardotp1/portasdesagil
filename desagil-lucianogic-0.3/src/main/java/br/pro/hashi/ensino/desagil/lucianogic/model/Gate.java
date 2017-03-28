package br.pro.hashi.ensino.desagil.lucianogic.model;

public abstract class Gate implements Receiver, Emitter {
	private int size;
	private String name;

	protected Gate(int size,String name) {
		this.size = size;
		this.name = name;
	}
	
	public int getSize(){
		return this.size;
	}

	@Override
	public void connect(Emitter emitter, int index) {
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		doConnect(emitter, index);
	}
	
	@Override
	public String toString(){
		return this.name;
	}

	protected abstract void doConnect(Emitter emitter, int index);
}
