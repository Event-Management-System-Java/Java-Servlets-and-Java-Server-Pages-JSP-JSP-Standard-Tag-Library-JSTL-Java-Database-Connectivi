package event.service;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import Staff.staffne;

import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;




//import com.itextpdf.text.Document;
//import com.itextpdf.text.DocumentException;
//import com.itextpdf.text.Element;
//import com.itextpdf.text.Paragraph;
//import com.itextpdf.text.pdf.PdfPCell;
//import com.itextpdf.text.pdf.PdfPTable;
//import com.itextpdf.text.pdf.PdfWriter;



public class staffne extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	private JTextField textField_referance;
	private JTextField txtPleaseEnterCharacter;
	private JTextField txtEnterMemberAddress;
	private JTextField txtTypeDateLike_1;
	private JTextField txtPleaseEnterTelephone;
	private  static JTable table;
	private JTextField txtTypeReferenceNo;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField txtTypeDateLike;
	private JTextField txtTypeRateLike;
	private JTextField txtTypeSalaryLike;
	/**
	 * Launch the application.
	 */
	JFrame hh;
	static staffne yy;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					staffne frame = new staffne();
					frame.setVisible(true);
					loadDatatotable();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public staffne() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,1442,918);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new MatteBorder(14, 14, 14, 14, (Color) new Color(95, 158, 160)));
		panel.setBounds(12, 13, 1412,845);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new MatteBorder(14, 14, 14, 14, (Color) new Color(95, 158, 160)));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(39, 25, 1334, 146);
		panel.add(panel_1);
		
		JLabel lblStaffMembership = new JLabel("Staff Membership");
		lblStaffMembership.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblStaffMembership.setBounds(319, 21, 579, 97);
		panel_1.add(lblStaffMembership);
		
		txtTypeReferenceNo = new JTextField();
		txtTypeReferenceNo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				
try {
					
					String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
							"databaseName=ITP_Project;integratedSecurity=true;";

					Connection con = null;
					Statement stmt = null;
					
					
					ResultSet rs = null;
					
					
					// Establish the connection.
		    		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		        		con = DriverManager.getConnection(connectionUrl);
		        
		        		// Create and execute an SQL statement that returns some data.
		        		
		        		String sql2 = "select * from staff where name like '"+txtTypeReferenceNo.getText()+"%'";
		        		stmt = con.createStatement();
		        		rs=stmt.executeQuery(sql2);	
		        		
		        		DefaultTableModel dtm =(DefaultTableModel) table.getModel();
		        		dtm.setRowCount(0);
		        		while (rs.next()) {
							
		        			Vector vv = new Vector();
		        			
							vv.add(rs.getString(1));
							vv.add(rs.getString(2));
							vv.add(rs.getString(3));
							vv.add(rs.getString(4));
							vv.add(rs.getString(5));
							vv.add(rs.getString(6));
							vv.add(rs.getString(7));
							vv.add(rs.getString(8));
							vv.add(rs.getString(9));
							vv.add(rs.getString(10));
							vv.add(rs.getString(11));
							vv.add(rs.getString(12));
		        			
		        			dtm.addRow(vv);
						}
		        		
		        		
					
				} catch (Exception e2) {
				e2.printStackTrace();
				}
				
			}
		});
				
		
		txtTypeReferenceNo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtTypeReferenceNo.setText("");
			}
		});
		txtTypeReferenceNo.setHorizontalAlignment(SwingConstants.CENTER);
		txtTypeReferenceNo.setText("Type Reference No To Search...");
		txtTypeReferenceNo.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtTypeReferenceNo.setColumns(10);
		txtTypeReferenceNo.setBounds(850, 56, 366, 40);
		panel_1.add(txtTypeReferenceNo);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(staffne.class.getResource("/Staff/bg.png")));
		lblNewLabel_2.setBounds(12, 13, 1310, 120);
		panel_1.add(lblNewLabel_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new MatteBorder(14, 14, 14, 14, (Color) new Color(95, 158, 160)));
		panel_2.setBackground(new Color(176, 224, 230));
		panel_2.setBounds(39, 178, 517, 489);
		panel.add(panel_2);
		
		textField_referance = new JTextField();
		textField_referance.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyTyped(KeyEvent arg0) {
				/*
				//error enter character
				char c=arg0.getKeyChar();
				if(! Character.isDigit(c) ) {
					arg0.consume();
					JOptionPane.showMessageDialog(Staff.this, "Please Enter Valid Number", "ok", JOptionPane.ERROR_MESSAGE);
				}
			*/	
			}
		});
		
		
		textField_referance.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField_referance.setBounds(252, 30, 199, 22);
		panel_2.add(textField_referance);
		textField_referance.setColumns(10);
		
		txtPleaseEnterCharacter = new JTextField();
		txtPleaseEnterCharacter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				txtPleaseEnterCharacter.setText("");
			}
		});
		txtPleaseEnterCharacter.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				
				char c=arg0.getKeyChar();
				if(! Character.isLetter(c) ) {
					arg0.consume();
					JOptionPane.showMessageDialog(staffne.this, "Please Enter Valid Name", "ok", JOptionPane.ERROR_MESSAGE);
				}
				
				
				
			}
		});
		txtPleaseEnterCharacter.setColumns(10);
		txtPleaseEnterCharacter.setBounds(252, 67, 199, 22);
		panel_2.add(txtPleaseEnterCharacter);
		
		txtEnterMemberAddress = new JTextField();
		txtEnterMemberAddress.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				
//
//				char c=arg0.getKeyChar();
//				if(! Character.isLetter(c) ) {
//					arg0.consume();
//					JOptionPane.showMessageDialog(staffne.this, "Please Enter Valid Address", "ok", JOptionPane.ERROR_MESSAGE);
//				}
				
				
			}
		});
		txtEnterMemberAddress.setColumns(10);
		txtEnterMemberAddress.setBounds(252, 103, 199, 22);
		panel_2.add(txtEnterMemberAddress);
		
		txtTypeDateLike_1 = new JTextField();
		txtTypeDateLike_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				/*
				char c=e.getKeyChar();
				if(! Character.isDigit(c) ) {
					e.consume();
					JOptionPane.showMessageDialog(Staff.this, "Please Enter Valid Age", "ok", JOptionPane.ERROR_MESSAGE);
				}
				
				*/
				
				
			}
		});
		txtTypeDateLike_1.setColumns(10);
		txtTypeDateLike_1.setBounds(252, 137, 199, 22);
		panel_2.add(txtTypeDateLike_1);
		
		txtPleaseEnterTelephone = new JTextField();
		txtPleaseEnterTelephone.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				
				char c=e.getKeyChar();
				if(! Character.isDigit(c) ) {
					e.consume();
					JOptionPane.showMessageDialog(staffne.this, "Please Enter Valid Number", "ok", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		txtPleaseEnterTelephone.setColumns(10);
		txtPleaseEnterTelephone.setBounds(252, 173, 199, 22);
		panel_2.add(txtPleaseEnterTelephone);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"", "A", "N"}));
		comboBox_1.setBounds(252, 311, 199, 22);
		panel_2.add(comboBox_1);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBorder(new MatteBorder(14, 14, 14, 14, (Color) new Color(95, 158, 160)));
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(0, 0, 517, 489);
		panel_2.add(panel_5);
		
		JLabel label = new JLabel("Staff ID");
		label.setFont(new Font("Tahoma", Font.PLAIN, 22));
		label.setBounds(37, 12, 167, 57);
		panel_5.add(label);
		
		JLabel label_1 = new JLabel("Name");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		label_1.setBounds(37, 47, 121, 57);
		panel_5.add(label_1);
		
		JLabel label_2 = new JLabel("Address");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		label_2.setBounds(37, 83, 121, 57);
		panel_5.add(label_2);
		
		JLabel label_3 = new JLabel("Date of Birth");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 22));
		label_3.setBounds(37, 117, 186, 57);
		panel_5.add(label_3);
		
		JLabel label_4 = new JLabel("Telephone");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 22));
		label_4.setBounds(37, 153, 121, 57);
		panel_5.add(label_4);
		
		JLabel label_5 = new JLabel("Membership Type");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 22));
		label_5.setBounds(37, 291, 186, 57);
		panel_5.add(label_5);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField.setColumns(10);
		textField.setBounds(252, 30, 199, 22);
		panel_5.add(textField);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(252, 67, 199, 22);
		panel_5.add(textField_2);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(252, 103, 199, 22);
		panel_5.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(252, 137, 199, 22);
		panel_5.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(252, 173, 199, 22);
		panel_5.add(textField_8);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(252, 311, 199, 22);
		panel_5.add(comboBox);
		
		JLabel label_6 = new JLabel("Joined Date");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 22));
		label_6.setBounds(37, 187, 121, 57);
		panel_5.add(label_6);
		
		JLabel label_7 = new JLabel("Per day Rate");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 22));
		label_7.setBounds(37, 221, 167, 57);
		panel_5.add(label_7);
		
		JLabel label_8 = new JLabel("Full Salary");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 22));
		label_8.setBounds(37, 257, 121, 57);
		panel_5.add(label_8);
		
		txtTypeDateLike = new JTextField();
		txtTypeDateLike.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				
				
				
				
			}
		});
		txtTypeDateLike.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				txtTypeDateLike.setText("");
			}
		});
		txtTypeDateLike.setText("Type Date LIke yyyy-MM-dd");
		txtTypeDateLike.setColumns(10);
		txtTypeDateLike.setBounds(252, 208, 199, 22);
		panel_5.add(txtTypeDateLike);
		
		txtTypeRateLike = new JTextField();
		txtTypeRateLike.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				
				
				char c=arg0.getKeyChar();
				if(! Character.isDigit(c) ) {
					arg0.consume();
					JOptionPane.showMessageDialog(staffne.this, "Please Enter Valid Number", "ok", JOptionPane.ERROR_MESSAGE);
				}

				
			}
		});
		txtTypeRateLike.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				txtTypeRateLike.setText("");;
			}
		});
		txtTypeRateLike.setText("Type Rate Like Number");
		txtTypeRateLike.setColumns(10);
		txtTypeRateLike.setBounds(252, 243, 199, 22);
		panel_5.add(txtTypeRateLike);
		
		txtTypeSalaryLike = new JTextField();
		txtTypeSalaryLike.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {

				char c=arg0.getKeyChar();
				if(! Character.isDigit(c) ) {
					arg0.consume();
					JOptionPane.showMessageDialog(staffne.this, "Please Enter Valid Number", "ok", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		txtTypeSalaryLike.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				txtTypeSalaryLike.setText("");
			}
		});
		txtTypeSalaryLike.setText("Type Salary Like Number");
		txtTypeSalaryLike.setColumns(10);
		txtTypeSalaryLike.setBounds(252, 276, 199, 22);
		panel_5.add(txtTypeSalaryLike);
		
		JButton btnDemo = new JButton("Demo");
		btnDemo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				 textField_referance.setText("S123");
				 txtPleaseEnterCharacter.setText("Kamal Weerasinghe");
				 txtEnterMemberAddress.setText("12/20A Matara");
				 txtTypeDateLike_1.setText("1997-09-29");
				 txtPleaseEnterTelephone.setText("0718772549");
				 txtTypeDateLike.setText("2012-02-3");
				txtTypeRateLike.setText("1200");
				txtTypeSalaryLike.setText("25000");
				comboBox_1.setToolTipText("A");
			}
		});
		btnDemo.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnDemo.setBounds(302, 404, 149, 47);
		panel_5.add(btnDemo);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.setBounds(71, 407, 169, 40);
		panel_5.add(btnPrint);
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg1) {
				
//				try
//				{
//					table.print();
//				}
//				catch(java.awt.print.PrinterException e) {
//					
//					System.err.format("No Printer found", e.getMessage());
//				}
//				
				
				 try{
					 DefaultTableModel dtm =(DefaultTableModel) table.getModel();
					
				        Document  doc = new Document();
				      PdfWriter.getInstance(doc, new FileOutputStream("Malith.pdf"));
				      doc.open();
				      Image image = Image.getInstance("download.jpg");
				      //doc.add(new Paragraph("image"));
				      doc.add(image);
				      doc.add(new Paragraph("Staff Members Datails",FontFactory.getFont(FontFactory.TIMES_ROMAN,18,Font.BOLD)));
				      doc.add(new Paragraph(new Date().toString()));
				      doc.add(new Paragraph("------------------------------------------------------------------"));
				      PdfPTable table = new PdfPTable(9);
				  //    PdfPCell cell = new PdfPCell(new Paragraph("Teacher name & Stage"));
				    //  cell.setColspan(4);
				   ////   cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				     // cell.setBackgroundColor(BaseColor.GREEN);
				//      table.addCell(cell);
				     
				   
				      
				    
		                table.setWidthPercentage(100);
		                table.setSpacingBefore(10f);
		                table.setSpacingAfter(10f);

		                float[] colWidth={2f,2f,2f,2f,2f,2f,2f,2f,2f};
		                table.setWidths(colWidth);
		                PdfPCell c1= new PdfPCell(new Paragraph(" Staff ID"));
		                PdfPCell c2= new PdfPCell(new Paragraph("Name"));
		                PdfPCell c3= new PdfPCell(new Paragraph("Address"));
		                PdfPCell c4= new PdfPCell(new Paragraph("Birth"));
		                PdfPCell c5= new PdfPCell(new Paragraph("Phone"));
		                PdfPCell c6= new PdfPCell(new Paragraph("Joined Date"));
		                PdfPCell c7= new PdfPCell(new Paragraph("Rate"));
		                PdfPCell c8= new PdfPCell(new Paragraph("Full Salary"));
		                PdfPCell c9= new PdfPCell(new Paragraph("Type"));
//		                PdfPCell c10= new PdfPCell(new Paragraph("User Name"));
//		                PdfPCell c11= new PdfPCell(new Paragraph("Lib"));
//		                PdfPCell c12= new PdfPCell(new Paragraph("Hostel"));

		                table.addCell(c1);
		                table.addCell(c2);
		                table.addCell(c3);
		                table.addCell(c4);
		                table.addCell(c5);
		                table.addCell(c6);
		                table.addCell(c7);
		                table.addCell(c8);
		                table.addCell(c9);
//		                table.addCell(c10);
//		                table.addCell(c11);
//		                table.addCell(c12);
		               // table.addCell(c13);
		                
		                
		                
						
						
		                for(int i=0;i<dtm.getRowCount();i++){
					PdfPCell p0= new PdfPCell(new Paragraph(dtm.getValueAt(i, 0).toString()));
						PdfPCell p1= new PdfPCell(new Paragraph(dtm.getValueAt(i, 1).toString()));
						PdfPCell p2= new PdfPCell(new Paragraph(dtm.getValueAt(i, 2).toString()));
						PdfPCell p3= new PdfPCell(new Paragraph(dtm.getValueAt(i, 3).toString()));
						PdfPCell p4= new PdfPCell(new Paragraph(dtm.getValueAt(i, 4).toString()));
						PdfPCell p5= new PdfPCell(new Paragraph(dtm.getValueAt(i, 5).toString()));
						PdfPCell p6= new PdfPCell(new Paragraph(dtm.getValueAt(i, 6).toString()));
						PdfPCell p7= new PdfPCell(new Paragraph(dtm.getValueAt(i, 7).toString()));
						PdfPCell p8= new PdfPCell(new Paragraph(dtm.getValueAt(i, 8).toString()));
					//	PdfPCell p9= new PdfPCell(new Paragraph(dtm.getValueAt(i, 9).toString()));
					//	PdfPCell p10= new PdfPCell(new Paragraph(dtm.getValueAt(i, 10).toString()));
					//	PdfPCell p11= new PdfPCell(new Paragraph(dtm.getValueAt(i, 11).toString()));
		               
						
						table.addCell(p0);
						table.addCell(p1);
		                table.addCell(p2);
		                table.addCell(p3);
		                table.addCell(p4);
		                table.addCell(p5);
		                table.addCell(p6);
		                table.addCell(p7);
		                table.addCell(p8);
		         //       table.addCell(p9);
		          //      table.addCell(p10);
		          //      table.addCell(p11);


		                }
		            	
					

							 
//	                    PdfPCell p2= new PdfPCell(new Paragraph(.getModel().getValueAt(i, 1).toString()));
//		                    PdfPCell p3= new PdfPCell(new Paragraph(empcnt2.getModel().getValueAt(i, 2).toString()));
//	                    PdfPCell p4= new PdfPCell(new Paragraph(empcnt2.getModel().getValueAt(i, 3).toString()));
//	                    PdfPCell p5= new PdfPCell(new Paragraph(empcnt2.getModel().getValueAt(i, 4).toString()));
//
//		                    table.addCell(p1);
//		                    table.addCell(p2);
//	                    table.addCell(p3);
//		                    table.addCell(p4);
//		                    table.addCell(p5);
		                
		                    
		                    doc.add(table);
				      
//		                    Image image1 = Image.getInstance("HY04BODHAGURU.jpg");
//						      //doc.add(new Paragraph("image"));
//						      doc.add(image1);
//				      
				      
				      JOptionPane.showMessageDialog(null, "Report Saved!");
				      doc.close();
				      
		                
		                  }catch(Exception e){
				         e.printStackTrace();
				     }
				 }
		});
		btnPrint.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel label_9 = new JLabel("New label");
		label_9.setBounds(-308, -202, 416, 257);
		panel_5.add(label_9);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon(staffne.class.getResource("/Staff/bg.png")));
		lblNewLabel_4.setBounds(12, 13, 493, 463);
		panel_5.add(lblNewLabel_4);
		
		JLabel lblFirstname = new JLabel("Name");
		lblFirstname.setBounds(66, 46, 121, 57);
		panel_5.add(lblFirstname);
		lblFirstname.setFont(new Font("Tahoma", Font.BOLD, 22));
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(76, 82, 121, 57);
		panel_5.add(lblAddress);
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 22));
		
		JLabel lblNewLabel = new JLabel("Staff ID");
		lblNewLabel.setBounds(73, 12, 167, 57);
		panel_5.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		JLabel lblPostCode = new JLabel("Date of Birth");
		lblPostCode.setBounds(76, 117, 186, 57);
		panel_5.add(lblPostCode);
		lblPostCode.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel lblTelephone = new JLabel("Telephone");
		lblTelephone.setBounds(37, 153, 121, 57);
		panel_5.add(lblTelephone);
		lblTelephone.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel lblJoinedDate = new JLabel("Joined Date");
		lblJoinedDate.setBounds(83, 187, 121, 57);
		panel_5.add(lblJoinedDate);
		lblJoinedDate.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel lblPerDayRate = new JLabel("Per day Rate");
		lblPerDayRate.setBounds(47, 223, 186, 57);
		panel_5.add(lblPerDayRate);
		lblPerDayRate.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		JLabel lblFullSalary = new JLabel("Full Salary");
		lblFullSalary.setBounds(47, 257, 121, 57);
		panel_5.add(lblFullSalary);
		lblFullSalary.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel lblMembershipType = new JLabel("Membership Type");
		lblMembershipType.setBounds(54, 290, 186, 57);
		panel_5.add(lblMembershipType);
		lblMembershipType.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new MatteBorder(14, 14, 14, 14, (Color) new Color(95, 158, 160)));
		panel_3.setBackground(new Color(176, 224, 230));
		panel_3.setBounds(39, 680, 1334, 135);
		panel.add(panel_3);
				/*
				DefaultTableModel model=(DefaultTableModel) table.getModel();
				model.addRow(new Object[] {
						textField_referance.getText(),
						textField_1.getText(),
					//	textField_2.getText(),
						textField_3.getText(),
						textField_4.getText(),
						textField_5.getText(),
						
					//	comboBox_ID.getSelectedItem(),
						comboBox_1.getSelectedItem(),
						
						
						
				});
				if(table.getSelectedRow() == -1) {
					if(table.getRowCount() == 0) {
						JOptionPane.showMessageDialog(null,"Membership update confirmed","Membership Management System",JOptionPane.OK_OPTION);
					}
				}*/
		
		JButton btnReset = new JButton("Edit");
		btnReset.setIcon(new ImageIcon(staffne.class.getResource("/Staff/WhatsApp Image 2019-10-02 at 11.05.51.jpeg")));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			/*	textField_referance.setText("");
				textField_1.setText("");
		//		textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				
		//		comboBox_ID.setSelectedItem("Make a Selection");
				comboBox_1.setSelectedItem("Make a Selection");
				*/

				try {
					
					DefaultTableModel dtm =(DefaultTableModel) table.getModel();
					//System.out.print(jtable1.getSelectedRow());
					int i = table.getSelectedRow();
					
					
					String staffID = (String)table.getValueAt(i, 0);
					
					String name = (String)table.getValueAt(i, 1);
					String address1 = (String)table.getValueAt(i, 2);
					String dob1 = (String)table.getValueAt(i, 3);
					String mobileNo1 = (String)table.getValueAt(i, 4);
					String joinedDate1 = (String)table.getValueAt(i, 5);
					String perDayRate = (String)table.getValueAt(i, 6);
					
					
					String fullSalar1y = (String)table.getValueAt(i, 7);
					
					String Type1 = (String)table.getValueAt(i, 8);
//					System.out.print(name);
//					System.out.print(address1);
//					System.out.print(dob1);
//					System.out.print(mobileNo1);
//					System.out.print(joinedDate1);
//					System.out.print(perDayRate);
//					System.out.print(fullSalar1y);
					
					
					
					String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
							"databaseName=ITP_Project;integratedSecurity=true;";

					Connection con = null;
					Statement stmt = null;
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            		con = DriverManager.getConnection(connectionUrl);
            		
            		String sqlupd = "update staff set name='"+name+"',address='"+address1+"',dob='"+dob1+"',mobileNo='"+mobileNo1+"',joinedDate='"+joinedDate1+"',perDayRate='"+perDayRate+"',fullSalary='"+fullSalar1y+"',Type='"+Type1+"' where staffID='"+staffID+"'";
            		stmt = con.createStatement();
            		stmt.executeUpdate(sqlupd);
					
            		JOptionPane.showMessageDialog(null, "Data Updated", "Done", JOptionPane.OK_OPTION);
            		
            		
            		staffne.this.dispose();
            		new staffne().setVisible(true);
					
				} catch (Exception e) {
					//e.printStackTrace();
					
					JOptionPane.showMessageDialog(null, "Invalid Details", "Please Enter Valid Records To Update Data..!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		
	
		
		
		
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnReset.setBounds(241, 25, 169, 63);
		panel_3.add(btnReset);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame =new JFrame();
				if(JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit","Membership Registration System",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
				
				
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnExit.setBounds(827, 25, 169, 63);
		panel_3.add(btnExit);
		
		JButton btnAttendance = new JButton("Attendance");
		btnAttendance.setBounds(1044, 25, 169, 63);
		panel_3.add(btnAttendance);
		btnAttendance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				staffne.this.dispose();
				new attendance().setVisible(true);
			}
		});
		btnAttendance.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JButton btnNewButton = new JButton("Add Record");
		btnNewButton.setBounds(39, 25, 169, 63);
		panel_3.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arq4) {
				
				String staffID = textField_referance.getText();
				String name = txtPleaseEnterCharacter.getText();
				String address1 = txtEnterMemberAddress.getText();
				String dob1 = txtTypeDateLike_1.getText();
				String mobileNo1 = txtPleaseEnterTelephone.getText();
				String joinedDate1=txtTypeDateLike.getText();
				String perDayRate=txtTypeRateLike.getText();
				String fullSalar1y=txtTypeSalaryLike.getText();
				String Type1=comboBox_1.getSelectedItem().toString();
				
				
				
				if(staffID.equals("") || name.equals("")|| address1.equals("")|| dob1.equals("")|| mobileNo1.equals("")|| joinedDate1.equals("")|| perDayRate.equals("")|| fullSalar1y.equals("")|| Type1.equals("")  ) {
					JOptionPane.showMessageDialog(null,"Please Fill All Feilds To Continue","Membership Management System",JOptionPane.ERROR_MESSAGE);
				}
				
				
				else {

	try {
						
						
						String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
								"databaseName=ITP_Project;integratedSecurity=true;";

						Connection con = null; 
						Statement stmt = null;
						Statement stmt2 = null;
						ResultSet rs = null;
						
						// Establish the connection.
		        		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		            		con = DriverManager.getConnection(connectionUrl);
		            
		            		String sql2="select * from staff where staffID='"+staffID+"'";
		            		stmt2=con.createStatement();
		            		rs=stmt2.executeQuery(sql2);
		            		
		            		if(rs.next()) {
		            			JOptionPane.showMessageDialog(null,"This staffID is already Registered..!","Error",JOptionPane.ERROR_MESSAGE);
		            		}
		            		else {
		            			
		            		
		        
		            		
		            		
		            		
		            		
		            		// Create and execute an SQL statement that returns some data.
		            		String SQL = "INSERT INTO staff (staffID, name, address, dob, mobileNo,joinedDate,perDayRate,fullSalary,Type)\r\n" + 
		            				"VALUES ('"+staffID+"', '"+name+"', '"+address1+"','"+dob1+"', '"+mobileNo1+"','"+joinedDate1+"','"+perDayRate+"', '"+fullSalar1y+"','"+Type1+"');";
		            		stmt = con.createStatement();
		            		
		            		
		            		stmt.executeUpdate(SQL);
		            		JOptionPane.showMessageDialog(null, "Data Saved", "Done", JOptionPane.INFORMATION_MESSAGE);
		            		
		            		
		            		textField_referance.setText("");
		            		txtPleaseEnterCharacter.setText("");
		            		txtEnterMemberAddress.setText("");
		            		
		            		
		            		txtTypeDateLike_1.setText("");
		            		txtPleaseEnterTelephone.setText("");
		            		txtTypeDateLike.setText("");
		            		txtTypeRateLike.setText("");
		            		txtTypeSalaryLike.setText("");;
		            		
		            		textField_referance.grabFocus();
		            		
		            		
		            		
		            		
		            		
		            		}
					} catch (Exception e) {
	            		JOptionPane.showMessageDialog(null, "Please Type Valid Date", "Error", JOptionPane.ERROR_MESSAGE);
	            		txtTypeDateLike_1.grabFocus();

					}
					
					
					
				
					//Thread.sleep(500);
					
				}

				
			
			}
		});
		
		
		
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(465, 25, 169, 63);
		panel_3.add(btnDelete);
		btnDelete.setIcon(new ImageIcon(staffne.class.getResource("/Staff/WhatsApp Image 2019-10-02 at 11.05.50.jpeg")));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				if(table.getSelectedRow() == -1) {
					if(table.getRowCount()==0) {
						
						JOptionPane.showMessageDialog(null, "No data to delete","Membership Management System",JOptionPane.OK_OPTION);
					
					
				}else{
					 JOptionPane.showMessageDialog(null, "Select a row to delete","Membership Management System",JOptionPane.OK_OPTION);
				}
				
				}
				
		else {
					model.removeRow(table.getSelectedRow());
				}
				*/
try {
					
					DefaultTableModel dtm =(DefaultTableModel) table.getModel();
					//System.out.print(jtable1.getSelectedRow());
					int i = table.getSelectedRow();
					
				
					
					
					String staffID = (String)table.getValueAt(i, 0);
					
					
					
					
					
					
					
					String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
							"databaseName=ITP_Project;integratedSecurity=true;";

					Connection con = null;
					Statement stmt = null;
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            		con = DriverManager.getConnection(connectionUrl);
            		
            	//	String sqlupd = "delete from staff  where staffID='"+staffID+"'";
            		
            		
            		
            		
            		
            	//	stmt = con.createStatement();
            	//	stmt.executeUpdate(sqlupd);
            		
            		
            		
            		
            		
            		
            		
            		
            		
            		
            		
            		
            		
            	

					
					Statement stmt2 = null;
					Statement stmt3 = null;
					Statement stmt4 = null;
					Statement stmt5 = null;
				//	Statement stmt = null;
					
					ResultSet rs2 = null;
					ResultSet rs3 = null;
					ResultSet rs4 = null;
					ResultSet rs5 = null;
					
					
				
	            
	            		// Create and execute an SQL statement that returns some data.
	            		
	            		String sql2 = "select * from staffAttendance where staffID='"+staffID+"'";
	            		stmt2 = con.createStatement();
	            		rs2=stmt2.executeQuery(sql2);	
	            		
	            		String sql23 = "select * from staffSalary where staffID='"+staffID+"'";
	            		stmt4 = con.createStatement();
	            		rs3=stmt4.executeQuery(sql23);	
	            		
	            		if(rs2.next()||rs3.next()) {
	            			JOptionPane.showMessageDialog(null, "Cannot Delete Member Beacause This Member Has Pending Books..!", "Error", JOptionPane.ERROR_MESSAGE);
	            			
	            		}else {
	            			int j = JOptionPane.showConfirmDialog(null, "Are You Sure You Want To Delete this Member?");
	            			if(j == 0) {
	            				
	            				
	            				
	            					
	            					String sqlupd2 = "delete from staff  where staffID='"+staffID+"'";
		    	            		stmt3 = con.createStatement();
		    	            		stmt3.executeUpdate(sqlupd2);
	            					
	            					String sqlupd = "update staffAttendance set staffID='null' where staffID='"+staffID+"' ";
		    	            		stmt2 = con.createStatement();
		    	            		stmt2.executeUpdate(sqlupd);
		    	            		
		    	            		
		    	            		String sqlupd1 = "update staffSalary set staffID='null' where staffID='"+staffID+"' ";
		    	            		stmt4 = con.createStatement();
		    	            		stmt4.executeUpdate(sqlupd1);
		    	            		
		    	            	
		    	            		
		    	            		
		    	            		JOptionPane.showMessageDialog(null, "Data Deleted..!", "Done", JOptionPane.INFORMATION_MESSAGE);
		    	            		staffne.this.dispose();
		    	            		new staffne().setVisible(true);
	            				
		    	            		
	            					
		    	            		
		    	            	
            	
            	/*	
            		String sqlupd1="ALTER TABLE dbo.staffSalary NOCHECK CONSTRAINT FK_salaryStaffID";
            		String sqlupd3="delete from staff  where staffID='"+staffID+"'";
            		
            		String sqlupd2="ALTER TABLE dbo.staffSalary NOCHECK CONSTRAINT FK_salaryStaffID";
            		
            		
            		
            		String sqlupd4="ALTER TABLE dbo.staffAttendance NOCHECK CONSTRAINT FK_attendanceStaffID";
            		String sqlupd6="delete from staff  where staffID='"+staffID+"'";
            		
            		String sqlup5="ALTER TABLE dbo.staffAttendance NOCHECK CONSTRAINT FK_attendanceStaffID";
            		
            		
            		stmt = con.createStatement();
            		
            		
            		stmt.executeUpdate(sqlupd1);
            		stmt.executeUpdate(sqlupd3);
            		stmt.executeUpdate(sqlupd2);
            		
            		stmt.executeUpdate(sqlupd4);
            		stmt.executeUpdate(sqlupd6);
            		stmt.executeUpdate(sqlup5);
            		
            		*/
            		
            		
            		
            		loadDatatotable();
					
            		
	            				}
	            			}
	            		


				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Select Row", "Done", JOptionPane.INFORMATION_MESSAGE);
				}
				
				
				
				
			}
		});
		
		
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon(staffne.class.getResource("/Staff/bg.png")));
		lblNewLabel_5.setBounds(12, 13, 1310, 109);
		panel_3.add(lblNewLabel_5);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(new MatteBorder(14, 14, 14, 14, (Color) new Color(95, 158, 160)));
		panel_4.setBackground(new Color(176, 224, 230));
		panel_4.setBounds(560, 180, 813, 487);
		panel.add(panel_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 33, 765, 431);
		panel_4.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Staff ID", "Name", "Address", "Birth", "Phone", "Joined_Date", "Rate", "Full Salary", "Type", "User_Name", "LibMemID", "HostlID"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true, true, true, true, true, true, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setIcon(new ImageIcon(staffne.class.getResource("/Staff/bg.png")));
		lblNewLabel_6.setBounds(12, 13, 789, 461);
		panel_4.add(lblNewLabel_6);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon(staffne.class.getResource("/Staff/bg.png")));
		lblNewLabel_3.setBounds(12, 13, 1388, 819);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(0, 0, 1441, 871);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(staffne.class.getResource("/Staff/bg.png")));
	}
	
	
	static void loadDatatotable(){
		try {
			
			String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
					"databaseName=ITP_Project;integratedSecurity=true;";

			Connection con = null;
			Statement stmt = null;
			
			
			ResultSet rs = null;
			
			
			// Establish the connection.
    		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        		con = DriverManager.getConnection(connectionUrl);
        
        		// Create and execute an SQL statement that returns some data.
        		
        		String sql2 = "select * from staff";
        		stmt = con.createStatement();
        		rs=stmt.executeQuery(sql2);	
        		
        		// default table model
        		DefaultTableModel dtm =(DefaultTableModel) table.getModel();
        		
        		while (rs.next()) {
					
        			//vector ekath haduwa aluth row ekak hadanawa
        			Vector vv = new Vector();
        			
					vv.add(rs.getString(1));
					vv.add(rs.getString(2));
					vv.add(rs.getString(3));
					vv.add(rs.getString(4));
					vv.add(rs.getString(5));
					vv.add(rs.getString(6));
					vv.add(rs.getString(7));
					vv.add(rs.getString(8));
					vv.add(rs.getString(9));
					vv.add(rs.getString(10));
					vv.add(rs.getString(11));
					vv.add(rs.getString(12));
        			
        			dtm.addRow(vv);
				}
        		
        		
			
		} catch (Exception e2) {
		e2.printStackTrace();
		}
		
		
	}
}
