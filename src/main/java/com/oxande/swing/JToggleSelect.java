package com.oxande.swing;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.oxande.wavecleaner.util.Assert;
import com.oxande.wavecleaner.util.ListenerManager;
import com.oxande.wavecleaner.util.WaveUtils;

import edu.emory.mathcs.backport.java.util.Arrays;

/**
 * Button selection.
 * 
 * @author wrey75
 *
 */
@SuppressWarnings("serial")
public class JToggleSelect extends JPanel implements MouseListener {
	private ListenerManager<ActionListener> listenerManager = new ListenerManager<>();

	private Icon btnOn;
	private Icon btnOff;
	public boolean reactOnChange = false;
	
	/**
	 * The selected component.
	 * 
	 */
	private JComponent selected = null;
	private String[] labels = new String[] {"ON", "OFF"};
	

	public JToggleSelect() {
		FlowLayout layout = new FlowLayout(FlowLayout.CENTER, 10, 10);
		this.setLayout(layout);
		this.setOpaque(false);
	}
	
	/**
	 * Set the labels (used only for ON/OFF values).
	 */
	public void setLabels(String on, String off){
		if( off == null ){
			off = on;
		}
		this.labels[0] = on;
		this.labels[1] = off;
	}

	public void addActionListener(ActionListener e) {
		listenerManager.add(e);
	}

	public void removeActionListener(ActionListener e) {
		listenerManager.remove(e);
	}

	public void setButtons(String... buttons) {
		@SuppressWarnings("unchecked")
		List<String> asList = Arrays.asList(buttons);
		setButtons(asList);
	}

	public void setButtons(List<String> buttons) {
		FlowLayout layout = new FlowLayout(FlowLayout.CENTER, 10, 10);
		this.setLayout(/* new GridLayout(1, buttons.size())*/ layout);
		
		btnOn = WaveUtils.loadIcon("btn-on.png", 20);
		btnOff = WaveUtils.loadIcon("btn-off.png", 20);

		removeAll();
		boolean first = true;
		for (String str : buttons) {
			JLabel btn = new JLabel(str);
			btn.setOpaque(false);
			this.add(btn);
			btn.setFocusable(false);
			btn.setName(str);
			btn.addMouseListener(this);
			if( btnOn != null && btnOff != null ){
				btn.setHorizontalAlignment(JLabel.LEFT);
			}
			else {
				btn.setHorizontalAlignment(JLabel.CENTER);
			}
			btn.setAlignmentY(JLabel.CENTER_ALIGNMENT);
			renderSelected(btn, first);
			if(first){
				this.selected = btn;
			}
			first = false;
		}
		invalidate();
	}

	void renderSelected( JLabel component, boolean selected ){
		Assert.isEventDispatchThread();

		if( btnOn != null && btnOff != null ){
			component.setIcon(selected ? btnOn : btnOff);
			component.setForeground(selected ? Color.BLACK : Color.DARK_GRAY);
		}
		else {
			component.setBackground(selected ? Color.DARK_GRAY : Color.LIGHT_GRAY);
			component.setForeground(selected ? Color.WHITE : Color.BLACK);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		JComponent abstractButton = (JComponent) e.getSource();
		if(abstractButton != this.selected){
			// Another button has been selected
			if(reactOnChange){
				for (Component button : getComponents()) {
					renderSelected((JLabel)button, (button == abstractButton));
				}
			}

			listenerManager.send((listener) -> {
				this.selected = abstractButton;
				ActionEvent evt = new ActionEvent(abstractButton, 0, "SELECTED");
				listener.actionPerformed(evt);
			});
		}
	}

	@Override
	public final void mouseEntered(MouseEvent e) {
	}

	@Override
	public final void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}
	
	/**
	 * Select the button. A call to this method does not generate an event.
	 * 
	 * @param btn the button name or 
	 */
	public void setSelected(String btn){
		for (Component button : getComponents()) {
			renderSelected((JLabel)button, btn.equals(button.getName()));
		}
	}
}
