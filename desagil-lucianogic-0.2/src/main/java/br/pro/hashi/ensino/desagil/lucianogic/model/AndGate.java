package br.pro.hashi.ensino.desagil.lucianogic.model;

public class AndGate extends Gate {
	private NandGate nandGate;
	private NandGate nandGate1;

	public AndGate() {
		super(2);
		nandGate = new NandGate();
		nandGate1 = new NandGate();
	}

	@Override
	public boolean read() {
		return nandGate1.read();
	}

	@Override
	protected void doConnect(Emitter emitter, int index) {
		if(index==0){
			nandGate.connect(emitter, 0);
		}
		if(index==1){
			nandGate.connect(emitter, 1);
			nandGate1.connect(new MockEmitter(nandGate.read()), 0);
			nandGate1.connect(new MockEmitter(nandGate.read()), 1);
		}
	}
}