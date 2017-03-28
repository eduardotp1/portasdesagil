package br.pro.hashi.ensino.desagil.lucianogic.model;

public class Switch implements Emitter {
	private boolean on;

	public Switch(boolean on) {
		this.on = on;
	}

	public void setOn(boolean on) {
		this.on = on;
	}

	@Override
	public boolean read() {
		return on;
	}
}
