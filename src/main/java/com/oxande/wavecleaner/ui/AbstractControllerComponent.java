package com.oxande.wavecleaner.ui;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.lang.Runnable;
import java.lang.UnsupportedOperationException;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Class created automatically -- DO NOT UPDATE MANUALLY.
 * This class has been created based on a XML file and must
 * be extended by your own code. The following code only
 * provide an easy way to obtain a basic GUI.
 */
public class AbstractControllerComponent extends JPanel {
   private JPanel jpanel1 = new JPanel();
   protected JCheckBox crackle = new JCheckBox();
   protected JSlider crackle_factor = new JSlider();
   protected JSlider crackle_average = new JSlider();
   protected JSlider crackle_window = new JSlider();
   private JLabel jlabel1 = new JLabel();
   private JLabel jlabel2 = new JLabel();
   private JLabel jlabel3 = new JLabel();
public class ChangeListener1 implements javax.swing.event.ChangeListener {

      public void stateChanged(ChangeEvent e)
      {
         crackleFactorChanged();
      }
}

public class ChangeListener2 implements javax.swing.event.ChangeListener {

      public void stateChanged(ChangeEvent e)
      {
         crackleAverageChanged();
      }
}

private class SetCrackleWindowLabelClass implements Runnable {
      private String input;

      public  SetCrackleWindowLabelClass(String input)
      {
         this.input = input;
      }

      public void run()
      {
         jlabel3.setText(String.valueOf(input));
      }
}

public class ChangeListener3 implements javax.swing.event.ChangeListener {

      public void stateChanged(ChangeEvent e)
      {
         crackleWindowChanged();
      }
}

private class SetCrackleFactorLabelClass implements Runnable {
      private String input;

      public  SetCrackleFactorLabelClass(String input)
      {
         this.input = input;
      }

      public void run()
      {
         jlabel1.setText(String.valueOf(input));
      }
}

private class SetCrackleAverageLabelClass implements Runnable {
      private String input;

      public void run()
      {
         jlabel2.setText(String.valueOf(input));
      }

      public  SetCrackleAverageLabelClass(String input)
      {
         this.input = input;
      }
}


   protected void crackleFactorChanged()
   {
      throw new UnsupportedOperationException("Not implemented");
   }

   public String getCrackleWindowLabel()
   {
      return jlabel3.getText();
   }

   public String getCrackleFactorLabel()
   {
      return jlabel1.getText();
   }

   public void setCrackleAverageLabel(String in)
   {
      SwingUtilities.invokeLater(new SetCrackleAverageLabelClass(in));
   }

   protected void crackleWindowChanged()
   {
      throw new UnsupportedOperationException("Not implemented");
   }

   protected void crackleAverageChanged()
   {
      throw new UnsupportedOperationException("Not implemented");
   }

   public String getCrackleAverageLabel()
   {
      return jlabel2.getText();
   }

   public void initComponents()
   {
      this.setLayout(new BorderLayout());
      GridBagLayout layout1 = new GridBagLayout();
      GridBagConstraints c1 = new GridBagConstraints();
      jpanel1.setLayout(layout1);
      
      crackle.setText("Decrackle");
      c1.gridy = 0;
      c1.gridx = 0;
      c1.gridheight = 2;
      c1.gridwidth = 1;
      c1.anchor = GridBagConstraints.WEST;
      c1.fill = GridBagConstraints.NONE;
      c1.weightx = 1;
      layout1.setConstraints(crackle, c1);
      jpanel1.add(crackle);
      
      crackle_factor.setMinimumSize(new java.awt.Dimension(100,50));
      crackle_factor.setMaximum(100);
      crackle_factor.setMinimum(1);
      crackle_factor.setOrientation(JSlider.HORIZONTAL);
      crackle_factor.setValue(2);
      crackle_factor.addChangeListener(new ChangeListener1());
      c1.gridy = 0;
      c1.gridx = 1;
      c1.gridheight = 1;
      c1.gridwidth = 1;
      c1.anchor = GridBagConstraints.WEST;
      c1.fill = GridBagConstraints.NONE;
      c1.weightx = 1;
      layout1.setConstraints(crackle_factor, c1);
      jpanel1.add(crackle_factor);
      
      crackle_average.setMinimumSize(new java.awt.Dimension(100,50));
      crackle_average.setMaximum(100);
      crackle_average.setMinimum(0);
      crackle_average.setOrientation(JSlider.HORIZONTAL);
      crackle_average.setValue(3);
      crackle_average.addChangeListener(new ChangeListener2());
      c1.gridy = 0;
      c1.gridx = 2;
      c1.gridheight = 1;
      c1.gridwidth = 1;
      c1.anchor = GridBagConstraints.WEST;
      c1.fill = GridBagConstraints.NONE;
      c1.weightx = 1;
      layout1.setConstraints(crackle_average, c1);
      jpanel1.add(crackle_average);
      
      crackle_window.setMinimumSize(new java.awt.Dimension(100,50));
      crackle_window.setMaximum(20000);
      crackle_window.setMinimum(1);
      crackle_window.setOrientation(JSlider.HORIZONTAL);
      crackle_window.setValue(2000);
      crackle_window.addChangeListener(new ChangeListener3());
      c1.gridy = 0;
      c1.gridx = 3;
      c1.gridheight = 1;
      c1.gridwidth = 1;
      c1.anchor = GridBagConstraints.WEST;
      c1.fill = GridBagConstraints.NONE;
      c1.weightx = 1;
      layout1.setConstraints(crackle_window, c1);
      jpanel1.add(crackle_window);
      
      jlabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
      c1.gridy = 1;
      c1.gridx = 1;
      c1.gridheight = 1;
      c1.gridwidth = 1;
      c1.anchor = GridBagConstraints.WEST;
      c1.fill = GridBagConstraints.NONE;
      c1.weightx = 1;
      layout1.setConstraints(jlabel1, c1);
      jpanel1.add(jlabel1);
      
      jlabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
      c1.gridy = 1;
      c1.gridx = 2;
      c1.gridheight = 1;
      c1.gridwidth = 1;
      c1.anchor = GridBagConstraints.WEST;
      c1.fill = GridBagConstraints.NONE;
      c1.weightx = 1;
      layout1.setConstraints(jlabel2, c1);
      jpanel1.add(jlabel2);
      
      jlabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
      c1.gridy = 1;
      c1.gridx = 3;
      c1.gridheight = 1;
      c1.gridwidth = 1;
      c1.anchor = GridBagConstraints.WEST;
      c1.fill = GridBagConstraints.NONE;
      c1.weightx = 1;
      layout1.setConstraints(jlabel3, c1);
      jpanel1.add(jlabel3);
      this.add(jpanel1, BorderLayout.CENTER);
      this.setPreferredSize(new java.awt.Dimension(600,400));
      this.setName("com.oxande.wavecleaner.ui.AbstractControllerComponent");
   }

   public void setCrackleFactorLabel(String in)
   {
      SwingUtilities.invokeLater(new SetCrackleFactorLabelClass(in));
   }

   public void setCrackleWindowLabel(String in)
   {
      SwingUtilities.invokeLater(new SetCrackleWindowLabelClass(in));
   }
}

