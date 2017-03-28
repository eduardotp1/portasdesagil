package br.pro.hashi.ensino.desagil.lucianogic.model;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;



public class MainView extends JPanel implements ActionListener,ItemListener {
	private static final long serialVersionUID = 1L;
	Switch switch1;
	NandGate nandGate;
	AndGate andGate;
	NotGate notGate;
	OrGate orGate;
	XorGate xorGate;
	MuxGate muxGate;
	JComboBox<Gate> comboBox;
	List<JCheckBox> checkboxes;
	JPanel checkPanel;
	int actual_index;
	List<Gate> gates;
	JCheckBox output;
	boolean bol;
	public  MainView(){
			
		gateView();
	}
	
	public void gateView(){
		//switch1 =  new Switch();
		nandGate = new NandGate();
		andGate =  new AndGate();
		notGate = new NotGate();
		orGate = new OrGate();
		xorGate= new XorGate();
		muxGate =  new MuxGate();
		comboBox =new JComboBox<>();
		gates=  new LinkedList<Gate>();
		gates.add(andGate);
		gates.add(notGate);
		gates.add(orGate);
		gates.add(xorGate);
		gates.add(muxGate);
		gates.add(nandGate);
		
		for(Gate one_gate:gates){
			comboBox.addItem(one_gate);
		}	
		
		comboBox.addActionListener(this);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(comboBox);
		actualize_check_sizes();
	}

	public void actionPerformed(ActionEvent event) {
		actual_index = comboBox.getSelectedIndex();
		remove(checkPanel);
		actualize_check_sizes();
		JFrame frame = (JFrame) SwingUtilities.getRoot(this);
		frame.pack();
	}
	 public void itemStateChanged(ItemEvent e) {
		for(int i = 0; i<gates.get(actual_index).getSize() ;i++ ){
			//switch1.setOn(checkboxes.get(i).isSelected());
		    //System.out.println(checkboxes.get(i).isSelected() + "mock");
			//System.out.println(switch1.read()+ "switch");
		    gates.get(actual_index).connect(new Switch(checkboxes.get(i).isSelected()), i);
		
		}
		 bol = gates.get(actual_index).read();
		
		 output.setSelected(bol);
	 }
	 
	 public void actualize_check_sizes(){
		 checkboxes =  new LinkedList<>();
			checkPanel = new JPanel(new GridLayout(0, 1));
			
			this.add(checkPanel);
			for(int i =0; i < gates.get(actual_index).getSize() ; i++){
					if(i!=2){
						checkboxes.add(new JCheckBox("input"));
					}else{
						checkboxes.add(new JCheckBox("seletor"));
					}			
					checkboxes.get(i).setSelected(false);
					checkboxes.get(i).addItemListener(this);
					checkPanel.add(checkboxes.get(i));
		    }
		     output =new JCheckBox("Output");
			checkPanel.add( output);
			
			for(int i = 0; i<gates.get(actual_index).getSize() ;i++ ){
				//switch1.setOn(checkboxes.get(i).isSelected());	
			   // gates.get(actual_index).connect(switch1, i);
			    //gates.get(actual_index).connect(new MockEmitter(checkboxes.get(i).isSelected()), i);
				 gates.get(actual_index).connect(new Switch(checkboxes.get(i).isSelected()), i);
			}
			bol = gates.get(actual_index).read();
			output.setSelected(bol);
			output.setEnabled(false);
	 }
	 
}
