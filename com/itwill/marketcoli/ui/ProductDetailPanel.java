package com.itwill.marketcoli.ui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Dimension;

public class ProductDetailPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public ProductDetailPanel() {
		setPreferredSize(new Dimension(390, 680));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(ProductDetailPanel.class.getResource("/images/detailProduct/사과.jpg")));
		lblNewLabel.setBounds(35, 32, 310, 310);
		add(lblNewLabel);
		

	}
}
