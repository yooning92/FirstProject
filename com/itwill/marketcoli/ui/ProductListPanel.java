package com.itwill.marketcoli.ui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.List;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTabbedPane;

import com.itwill.marketcoli.dto.Product;
import com.itwill.marketcoli.service.ProductService;

import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Font;

public class ProductListPanel extends JPanel {
	
	private ProductService productService;

	private JPanel pItemPanel;
	private JPanel pItemListPanel;
	private JPanel pListPanel;
	private JTabbedPane productTabbedPane;
	private JLabel productImageLB;
	private JLabel productNameLB;
	private JLabel productPriceNB;
	private JLabel productExpLB;
	private JScrollPane pScrollPane;

	/**
	 * Create the panel.
	 */
	public ProductListPanel() {
		setLayout(new BorderLayout(390, 680));

		productTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		add(productTabbedPane, BorderLayout.CENTER);

		pListPanel = new JPanel();
		productTabbedPane.addTab("전체상품보기", null, pListPanel, null);
		pListPanel.setLayout(new BorderLayout(0, 0));

		pScrollPane = new JScrollPane();
		pListPanel.add(pScrollPane, BorderLayout.CENTER);
		
		pItemListPanel = new JPanel();
		pItemListPanel.setPreferredSize(new Dimension(10, 2600));
		pScrollPane.setViewportView(pItemListPanel);
		pItemListPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		/**********************************************************/
		pItemPanel = new JPanel();
		pItemPanel.setBackground(new Color(230, 230, 250));
		pItemPanel.setPreferredSize(new Dimension(390, 155));
		pItemListPanel.add(pItemPanel);
		pItemPanel.setLayout(null);

		productImageLB = new JLabel("");
		productImageLB.setIcon(new ImageIcon(ProductListPanel.class.getResource("/images/listProduct/사과.jpg")));
		productImageLB.setBounds(12, 10, 135, 135);
		pItemPanel.add(productImageLB);
		
		productNameLB = new JLabel("사과");
		productNameLB.setFont(new Font("굴림", Font.BOLD, 13));
		productNameLB.setBounds(173, 27, 57, 15);
		pItemPanel.add(productNameLB);
				
		productPriceNB = new JLabel("가격");
		productPriceNB.setBounds(173, 52, 57, 15);
		pItemPanel.add(productPriceNB);
		
		productExpLB = new JLabel("설명");
		productExpLB.setBounds(173, 77, 205, 68);
		pItemPanel.add(productExpLB);
		/**********************************************************/

		productService = new ProductService();
		try {
			productListDisplay();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	/**************** productListDisplay 메소드 ******************/
	public void productListDisplay() throws Exception {
		List<Product> productList = productService.productList();
		pItemListPanel.removeAll();
		for (int i = 0; i < productList.size(); i++) {
			Product product = productList.get(i);

			pItemPanel = new JPanel();
			pItemPanel.setBackground(new Color(230, 230, 250));
			pItemPanel.setPreferredSize(new Dimension(390, 155));
			pItemListPanel.add(pItemPanel);
			pItemPanel.setLayout(null);

			productImageLB = new JLabel("");
			productImageLB.setIcon(new ImageIcon(ProductListPanel.class.getResource("/images/listProduct/"+product.getP_name()+".jpg")));
			productImageLB.setBounds(12, 10, 135, 135);
			pItemPanel.add(productImageLB);
			
			productNameLB = new JLabel(product.getP_name());
			productNameLB.setFont(new Font("굴림", Font.BOLD, 13));
			productNameLB.setBounds(173, 27, 57, 15);
			pItemPanel.add(productNameLB);
					
			productPriceNB = new JLabel(product.getP_price()+"");
			productPriceNB.setBounds(173, 52, 57, 15);
			pItemPanel.add(productPriceNB);
			
			productExpLB = new JLabel(product.getP_exp());
			productExpLB.setBounds(173, 77, 205, 68);
			pItemPanel.add(productExpLB);

		}
	}
}
