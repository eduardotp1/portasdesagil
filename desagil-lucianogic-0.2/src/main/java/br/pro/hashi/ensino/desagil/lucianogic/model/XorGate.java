package br.pro.hashi.ensino.desagil.lucianogic.model;

public class XorGate extends Gate {
	private NandGate nandGate;
	private NandGate nandGate1;
	private NandGate nandGate2;
	private NandGate nandGate3;

	public XorGate() {
		super(2);
		nandGate = new NandGate();
		nandGate1 = new NandGate();
		nandGate2 = new NandGate();
		nandGate3 = new NandGate();
	}

	@Override
	public boolean read() {
		return nandGate3.read();
	}

	@Override
	protected void doConnect(Emitter emitter, int index) {
		if(index==0){
			nandGate.connect(emitter, 0);
			nandGate1.connect(emitter, 0);
		}
		if(index==1){
			nandGate.connect(emitter, 1);
			nandGate2.connect(emitter, 1);
			nandGate1.connect(new MockEmitter(nandGate.read()), 1);
			nandGate2.connect(new MockEmitter(nandGate.read()), 0);
			nandGate3.connect(new MockEmitter(nandGate1.read()), 0);
			nandGate3.connect(new MockEmitter(nandGate2.read()), 1);
		}
	}
}