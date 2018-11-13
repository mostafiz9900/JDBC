/*
////////////// Read First Installation Instructions //////////////////////////
Code By : James Smith
My Email : james_smith73@yahoo.com
Updated Date : Oct3 , 2002 
I would be updating this code atleast once a week 
================== Directory ====================================================
step 1  : make directory james in c: , that is c:\james
step 2  : place the following files in this directory 
	a. jamessmith.java 	d.Andrew.jpg 	g.Laura.jpg       j.Nancy.jpg
	b. james.mdb	   	e.James.jpg     h.Margaret.jpg    k.Robert.jpg
	c. sidebar33.jpg   	f.Janet.jpg     i.Micheal.jpg     l.Steven.jpg
download these files from my home page
http://www.geocities.com/james_smith73/
Download Menu -----> james.zip
(sorry,  i couldnt bundle all files in a single zip and upload to planetsourcecode
due to file size restrictions)
================== c:\Autoexec.bat ==================================================
(assumption u have installed jdk in c:\jdk1.2.1 directory)
(add these lines in c:\Autoexec.bat - Restart your Computer for Settings to take effect)
(If Nesssary)
step 3  : SET classpath=
step 4  : SET PATH=c:\windows;c:\windows\command;c:\jdk1.2.1\bin;c:\
step 5  : SET JAVA_HOME=c:\jdk1.2.1
================== ODBC Settings ========================
step 6  : click control panel
step 7  : ODBC Data Sources
step 8  : click UserDSN Tab
step 9  : click ADD Button , Select Microsoft Access Driver , Finish 
step 10 : Give Datasource Name as  "james" , no double quotes
step 11 : use Select and select james.mdb from c:\james\james.mdb
click ok , ok finish
================== Compile =======================================================
step 12 : cd c:\james
step 13 : javac jamessmith.java
================= Run ============================================================
step 14 : java jamessmith
login 'a' and password 'a' for Accoutant (use this)
login 'p' and password 'p' for Principal
================================================================================
I prefer u reading this on Macromedia Homesite Editor 5.0 to Edit my java code
u may as well crack it friends ,  keep it a secret :) hahahahaha...... , 
//================================================================================
////////////// End Installation Instructions /////////////////////////////////////
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.*;

public class jamessmith extends JFrame 
{		
 		//============================================================ Start Variables ==========
		/////////////////////////////////////////////////////////////////////////////////////////
		boolean inAnApplet = true;   
		final boolean shouldFill = true;
    	final boolean shouldWeightX = true;
				
		//Login panel TAB
		final static String MYPANEL1 = " LOGIN ";
		
		//Student Detail panel TAB		
		final static String MYPANEL2 = " ADD STUDENT DETAILS ";
		
		//Modify or Delete Student Details panel TAB		
		final static String MYPANEL3 = " MODIFY / DELETE STUDENT DETAILS ";
		
		//Student Reports panel TAB		
		final static String MYPANEL4 = " STUDENT REPORTS ";
		
		//Search student details panel TAB		
		final static String MYPANEL5 = " SEARCH STUDENT DETAILS ";
		
		//View Student Details panel TAB		
		final static String MYPANEL6 = " VIEW STUDENT DETAILS ";
		
		//General Reports panel TAB		
		final static String MYPANEL7 = " GENERATE REPORTS ";
		
		//First Image to Load is declared as steam.gif to welcome user	
		String imagename = "steam.gif";
		ImageIcon ii = new ImageIcon(imagename);
		
		//I Prefer courier new fonts whereever possible		
		Font dataFont = new Font("courier new",Font.PLAIN,12);
		Font titleFont = new Font("courier new",Font.BOLD,14);
		
		//Required to handle Radio buttons Event
		ActionListener rlistener = new RadioListener();	
		
		//Required to handle Check Box Event
		CheckBoxListener myListener = new CheckBoxListener();
		
		//Required to handle Combo Box Events
		ComboBoxListener cbListener = new ComboBoxListener();
		
		//I prefer gridbag layout (more flexible to place Elements inside a Tab)
		GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();	
		GridBagConstraints c2 = new GridBagConstraints();	
		GridBagConstraints c5 = new GridBagConstraints();	
		
		//I need a Dialog Box to ask delete confirmation messages etc..
		Container contentPane = getContentPane();		
		JDialog dialog = new JDialog((Frame) null, "! DELETE CONFIRMATION !", true);
		Container dialogContentPane = dialog.getContentPane();		
		
		//Radio Buttons need to be grouped so that u check on one other gets unchecked
		ButtonGroup bg = new ButtonGroup();
		ButtonGroup bg2 = new ButtonGroup();
		ButtonGroup bgq = new ButtonGroup();
		
		// Declare All Labels i will be using somewhere or the other
		JLabel jLabel, jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7;
		JLabel jLabel77, jLabel8, jLabel9, jLabelim;
		JLabel jLabeldlg = new JLabel("Do You Really want to Delete ?");
		JLabel jLabelq1, jLabelq2;
		
		// Declare All Radiobuttons i will be using somewhere or the other
		JRadioButton jRadiobutton, Male, Female, mMale, mFemale;		
		JRadioButton jRadiobuttonq1, jRadiobuttonq2;
		
		// Declare All Checkboxes i will be using somewhere or the other
		JCheckBox jCheckbox, SSLC, PHOTO, CHARCERT, NCCCERT, mSSLC, mPHOTO, mCHARCERT, mNCCCERT;	
		JCheckBox jCheckboxq1, jCheckboxq2, jCheckboxq3, jCheckboxq4, jCheckboxq5;
		
		// Declare All Comboboxes i will be using somewhere or the other
		JComboBox jCombobox, jCombobox1, jCombobox2 ,mjCombobox1, mjCombobox2, jCombobox3;	
		JComboBox jComboboxq1, jComboboxq2;
		
		// Declare All Textboxes i will be using somewhere or the other
		JTextField jTextfield;		
		JTextField loginname = new JTextField(40);	
		JTextField loginpass = new JTextField(40);	
		JTextField adds_name = new JTextField(20);	
		JTextField adds_addr = new JTextField(20);	
		JTextField adds_imname = new JTextField(20);						
		JTextField adds_fname = new JTextField(20);		
		JTextField mods_fname = new JTextField(20);		
		JTextField mods_name = new JTextField(20);	
		JTextField mods_addr = new JTextField(20);		
				
		// All String type variables
		String driver="sun.jdbc.odbc.JdbcOdbcDriver";
		String url="jdbc:odbc:james";		
		String dialogtitle = "Student Record Added";
		String dialogf = "LOGIN FAILED";
		String dialogm = "DATABASE RECORD UPDATED";
		String dialogd = "DATABASE RECORD DELETED";
		String Sexsel = "Male";
		String Yearsel = "1st PUC";
		String Sectionsel = "Section A";
		String currname = "";
		String tempname = "";
		String qry = "";
		String condsel="No Condition", Combo1sel="StudentID", Combo2sel="=";	
		String sql, sql1, dialogmessage, sr, Namesel, reg_no;
		
		// All Integer type variables
		int SSLCsel, PHOTOsel, CHARCERTsel, NCCCERTsel, mSSLCsel, mPHOTOsel, mCHARCERTsel, mNCCCERTsel;
		int dialogtype = JOptionPane.PLAIN_MESSAGE;
		int tempcnt;
		int StudentIDsel=0,StudentNamesel=0,Addresssel=0,FathersNamesel=0,qSexsel=0;
		
		//Declaring all JPanel & Tabbed panes to be used
		JPanel jPanel, p1, p2, p3;
		JTabbedPane tabbedPane = new JTabbedPane();
		
		// Declare All Submit Buttons i will be using somewhere or the other		
		JButton login = new JButton("LOGIN");
		JButton DELETEIT = new JButton("YES DELETE");
		JButton DONTDELETE = new JButton("NO DELETE");
		JButton button, ADDREC, MODIFY, SHOW_STUDENT_LIST, DELETE;
		JButton QUERY;
		
		//Required to Build a JTable in Student Reports (also known as DataGrid by VC++ Users)
		Object[] data = new Object[5];
	   	DefaultTableModel defaulttablemodel = new DefaultTableModel();
   		JTable jtable = new JTable(defaulttablemodel);	
				
		// Declare Textarea i will be using to show query result
		JTextField givencondition;		
		JTextArea resultArea;		
												
		//------------------------------------------------------------ End Variables ------------
		/////////////////////////////////////////////////////////////////////////////////////////
		//============================================================ Start main ===============
		public static void main(String args[])
 		{
  			jamessmith app = new jamessmith();
 		}
		//------------------------------------------------------------ End main -----------------
		//============================================================ Start jamessmith =========
 		public jamessmith() 
 		{
			// Declare Title to my Application 
  			super("A TEST APPLICATION Updated October 25"); 
  			setup();
  			pack();
  			addWindowListener(new WindowEventHandler());
  			show();
 		}
		//------------------------------------------------------------ End jamessmith ------------
		//============================================================ Start setup ===============
 		void setup() 
 		{
  			setupMenuBar(); //Call "setupMenuBar()" to Build the Exit Menu
			showpane1();	//Call some method to Build the Exit Menu
			contentPane.add(tabbedPane, BorderLayout.CENTER);
  		}
		//------------------------------------------------------------ End setup -----------------
		//============================================================ Start setupMenuBar ========
 		void setupMenuBar() 
		{
  			  MenuBar menuBar = new MenuBar();
			  // Main Menu will be "File"
			  Menu fileMenu = new Menu("File");		
			  		// Sub menu under it will be "Exit"	  		
			  		MenuItem fileExit = new MenuItem("Exit");		
						// Handle this submenu item clcik event to Exit 	  			  
			  			fileExit.addActionListener(new MenuItemHandler()); 
			  			fileMenu.add(fileExit);					
			  		menuBar.add(fileMenu);
			  setMenuBar(menuBar);
 		}	
		//------------------------------------------------------------ End setupMenuBar-----------
		/////////////////////////////////////////////////////////////////////////////////////////
		//============================================================ Start showpane1 ============		
		void showpane1()
		{
			p1 = new JPanel() //LOGIN TAB
			{
	                public Dimension getPreferredSize() 
					{
	                	Dimension size = super.getPreferredSize();
						// i set width=785 & height=495 for my login TAB & OTHER TABS will use it
	                	size.width = 785;	
						size.height = 495;	
	                	return size;
	            	}
	        };	
			p1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Login Panel"));
			p1.setFont(titleFont);
			p1.setLayout(gridbag);  						
			   	jLabel1 = new JLabel("Enter Username : ");
				jLabel1.setFont(dataFont);// Make this Data Font that we declared before
				    //c.weightx = 0.0;    //Horizontal Space not required here		             						
			        c.weighty = 0.0;   	  //Vertical Space	
					c.ipady = 2;       	  //Height of Component				
					c.ipadx = 2; 		  //Width of Component
			        c.anchor = GridBagConstraints.WEST; 	
			      	c.gridwidth = 1;   	  //1 columns wide				
			        c.gridx = 0;       	  //aligned with button 0  -- Very Important 					   
			        c.gridy = 0;       	  //0th Row  -- Very Important 	
					// Add all these features to this Label "jLabel1"	
			        gridbag.setConstraints(jLabel1, c);
					// Add this featured Label "jLabel1" into out LOGIN TAB
		        p1.add(jLabel1);				
				loginname = new JTextField("                                           ");
			    	c.ipady = 2;       						
					c.ipadx = 2;       						
		        	c.weighty = 0.0;   						
		        	c.anchor = GridBagConstraints.WEST; 	
		       		c.gridwidth = 2;   						
		        	c.gridx = 1;       						    
		        	c.gridy = 0;       						
		        	gridbag.setConstraints(loginname, c);
		        p1.add(loginname);				
				jLabel2 = new JLabel("Enter Password : ");
				jLabel2.setFont(dataFont);
			        c.ipady = 2;       						
					c.ipadx = 2;       						
			        c.weighty = 0.0;   						
			        c.anchor = GridBagConstraints.WEST; 	
			        c.gridwidth = 1;   						
			        c.gridx = 0;       						     
			        c.gridy = 1;       						
			        gridbag.setConstraints(jLabel2, c);
			     p1.add(jLabel2);				
				loginpass = new JTextField("                                           ");
			    	c.ipady = 2;       						
					c.ipadx = 2;       						
		        	c.weighty = 0.0;   						
		        	c.anchor = GridBagConstraints.WEST; 	
		       		c.gridwidth = 2;   						
		        	c.gridx = 1;       						     
		        	c.gridy = 1;       						
		        	gridbag.setConstraints(loginpass, c);
		        p1.add(loginpass);				
				button = new JButton("LOGIN");
		        	c.ipady = 2;       						
					c.ipadx = 2;       						
		        	c.weighty = 0.0;   						
		        	c.anchor = GridBagConstraints.CENTER; 	        
					c.gridwidth = 1;   						
		        	c.gridx = 1;       						      
		        	c.gridy = 2;       						
		        	gridbag.setConstraints(button, c);
		        p1.add(button);										
				button.addActionListener(new ButtonHandler());  				
			tabbedPane.addTab(MYPANEL1, p1);
		}
		//------------------------------------------------------------ End__ showpane1 -----------
		//============================================================ Start showpane2 ===========
		void showpane2() //ADD STUDENT  DETAILS TAB 
		{			
				   p2 = new JPanel();
				   p2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Add Student Details"));
				   p2.setLayout(gridbag);					  		   
				   jLabel3 = new JLabel(" Student Name : ");	
						jLabel3.setFont(dataFont);		
						c.fill = GridBagConstraints.BOTH;		
						c.ipady = 2;       						
						c.ipadx = 2;  
						c.gridx = 0;       						     
			        	c.gridy = 1;       						
			        	gridbag.setConstraints(jLabel3, c);				
					p2.add(jLabel3);															
						c.ipady = 2;       						
						c.ipadx = 2;  
						c.gridx = 1;       						     
			        	c.gridy = 1;       						
			        	gridbag.setConstraints(adds_name, c);				
					p2.add(adds_name);									
					jLabel4 = new JLabel(" Student Address : ");	
						jLabel4.setFont(dataFont);				
						c.ipady = 2;       						
						c.ipadx = 2;  
						c.gridx = 0;       						     
			        	c.gridy = 2;       						
			        	gridbag.setConstraints(jLabel4, c);		
					p2.add(jLabel4);																		  
						c.ipady = 2;       						
						c.ipadx = 2;  
						c.gridx = 1;       						     
			        	c.gridy = 2;   
						gridbag.setConstraints(adds_addr, c);	
					p2.add(adds_addr);						
					jLabel5 = new JLabel(" Father's Name : ");	
						jLabel5.setFont(dataFont);				
						c.ipady = 2;       						
						c.ipadx = 2;  
						c.gridx = 0;       						     
			        	c.gridy = 3;       						
			        	gridbag.setConstraints(jLabel5, c);				
					p2.add(jLabel5);											
						c.ipady = 2;       						
						c.ipadx = 2;  
						c.gridx = 1;       						     
			        	c.gridy = 3;       						
			        	gridbag.setConstraints(adds_fname, c);				
					p2.add(adds_fname);				
					// I am checking default sex as male by using 'true' ,
					// U are free to make this false 
					Male = new JRadioButton("Male",true);
						Male.setFont(dataFont);		
						c.fill = GridBagConstraints.BOTH;
						c.ipady = 2;       						
		       			c.ipadx = 2;  
		       			c.gridx = 1;
		        		c.gridy = 4;
		        		gridbag.setConstraints(Male, c);
						Male.addActionListener(rlistener);
						bg.add(Male);
					p2.add(Male);										
	   				Female = new JRadioButton("Female",false);
						Female.setFont(dataFont);		
						c.fill = GridBagConstraints.BOTH;
						c.ipady = 2;       						
		       			c.ipadx = 2;  
		       			c.gridx = 2;
		        		c.gridy = 4;
		        		gridbag.setConstraints(Female, c);								
						Female.addActionListener(rlistener);	
						bg.add(Female);
					p2.add(Female);								
					jLabel6 = new JLabel(" Class : ");	
						jLabel6.setFont(dataFont);				
						c.ipady = 2;       						
						c.ipadx = 2;  
						c.gridx = 0;       						     
			        	c.gridy = 5;       						
			        	gridbag.setConstraints(jLabel6, c);				
					p2.add(jLabel6);													
					jCombobox1 = new JComboBox();
						// Fonts inside combo box be datafont i,e courier new 
						jCombobox1.setFont(dataFont);	
						// Adding Elements to combo box
				 		jCombobox1.addItem("1st PUC");
		    			jCombobox1.addItem("2nd PUC");
						// fill it align properly with other Elements inside TAB
		    			c.fill = GridBagConstraints.BOTH;
						c.insets = new Insets(10,0,0,30);  		
						c.ipady = 2;     						
						c.ipadx = 2;							
		       	        c.gridx = 1;							
		        		c.gridy = 5;							
						jCombobox1.addItemListener(cbListener);	
		        		gridbag.setConstraints(jCombobox1, c);
		        	p2.add(jCombobox1);							
					jCombobox2 = new JComboBox();
						jCombobox2.setFont(dataFont);	
						// Adding Elements to combo box
				 		jCombobox2.addItem("Section A");
		    			jCombobox2.addItem("Section B");
						jCombobox2.addItem("Section C");
						c.fill = GridBagConstraints.BOTH;
						c.insets = new Insets(10,0,0,30);  		
		    			c.ipady = 2;     
						c.ipadx = 2;		
		       	        c.gridx = 2;	
		        		c.gridy = 5;			
						jCombobox2.addItemListener(cbListener);			
		        		gridbag.setConstraints(jCombobox2, c);
		        	p2.add(jCombobox2);																
					SSLC = new JCheckBox("SSLC Marks Card  ");
						//Using a Check Box with some Text here
						c.fill = GridBagConstraints.BOTH;
						c.ipady = 0;       						
						c.ipadx = 0;  
						c.gridx = 1;       						     
			        	c.gridy = 6; 						
						gridbag.setConstraints(SSLC, c);
						SSLC.setFont(dataFont);
						SSLC.addItemListener(myListener);
    				p2.add(SSLC);										
					PHOTO = new JCheckBox("PHOTO (Passport Size)  ");
						c.ipady = 0;       						
						c.ipadx = 0;  
						c.gridx = 2;       						     
			        	c.gridy = 6; 
						gridbag.setConstraints(PHOTO, c);
						PHOTO.setFont(dataFont);
						PHOTO.addItemListener(myListener);
    				p2.add(PHOTO);							
					CHARCERT = new JCheckBox("Charecter Certificater");
						c.ipady = 0;       						
						c.ipadx = 0;  
						c.gridx = 1;       						     
			        	c.gridy = 7; 
						gridbag.setConstraints(CHARCERT, c);
						CHARCERT.setFont(dataFont);
						CHARCERT.addItemListener(myListener);
    				p2.add(CHARCERT);												
					NCCCERT = new JCheckBox("NCC Certificate Given");
						c.ipady = 0;       						
						c.ipadx = 0;  
						c.gridx = 2;       						     
			        	c.gridy = 7;
						gridbag.setConstraints(NCCCERT, c);
						NCCCERT.setFont(dataFont);
						NCCCERT.addItemListener(myListener);
    				p2.add(NCCCERT);	
					jLabelim = new JLabel(" Image Name : ");	
						jLabelim.setFont(dataFont);				
						c.ipady = 2;       						
						c.ipadx = 2;  
						c.gridx = 0;       						     
			        	c.gridy = 8;       						
			        	gridbag.setConstraints(jLabelim, c);				
					p2.add(jLabelim);							
							c.ipady = 2;       						
							c.ipadx = 2;  
							c.gridx = 1;       						     
			        		c.gridy = 8;   			  						
			        		gridbag.setConstraints(adds_imname, c);				
					p2.add(adds_imname);																	
					ADDREC = new JButton("SAVE RECORD");										
						c.ipady = 2;       						
						c.ipadx = 2;  
						c.gridx = 2;       						     
			        	c.gridy = 8;  
						gridbag.setConstraints(ADDREC, c);	
						// Handle "SAVERECORD" button clicked event by "ButtonHandler()"					
						ADDREC.addActionListener(new ButtonHandler());
					p2.add(ADDREC);
					jLabel7 = new JLabel(" ", ii, JLabel.CENTER);	
						c.fill = GridBagConstraints.BOTH;
						c.gridwidth = 5; 
						c.gridx = 0;       						     
			        	c.gridy = 9;       						
			        	gridbag.setConstraints(jLabel7, c);				
					p2.add(jLabel7);				   
				tabbedPane.addTab(MYPANEL2, p2);
		}
		//-------------------------------------------------------------- End showpane2 ---------
		//============================================================ Start showpane3 =========
		void showpane3() //MODIFY STUDENT DETAILS TAB
		{			  	   
				   p3 = new JPanel();
				   p3.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Modify Student Details"));
				   p3.setLayout(gridbag);	
				   jCombobox3 = new JComboBox();
				   		jCombobox3.addItem("Select Student : ");
						jCombobox3.setFont(dataFont);	
						c2.fill = GridBagConstraints.BOTH;		
						c2.ipady = 2;       						
						c2.ipadx = 2;  
						c2.gridx = 2;       						     
			        	c2.gridy = 1;       						
			        	gridbag.setConstraints(jCombobox3, c2);			
						jCombobox3.addItemListener(cbListener);		
					p3.add(jCombobox3);		
				   JLabel jl8 = new JLabel(" Student Name : ");
						jl8.setFont(dataFont);		
						c2.fill = GridBagConstraints.BOTH;		
						c2.ipady = 2;       						
						c2.ipadx = 2;  
						c2.gridx = 0;       						     
			        	c2.gridy = 1;       						
			        	gridbag.setConstraints(jl8, c2);				
					p3.add(jl8);				
					mods_name = new JTextField(20);	
						c2.ipady = 2;       						
						c2.ipadx = 2;  
						c2.gridx = 1;       						     
			        	c2.gridy = 1;       						
			        	gridbag.setConstraints(mods_name, c2);				
					p3.add(mods_name);	
					JLabel jl9 = new JLabel(" Student Address : ");
						jl9.setFont(dataFont);		
						c2.fill = GridBagConstraints.BOTH;		
						c2.ipady = 2;       						
						c2.ipadx = 2;    
						c2.gridx = 0;       						     
			        	c2.gridy = 2;       						
			        	gridbag.setConstraints(jl9, c2);				
					p3.add(jl9);		
					mods_addr = new JTextField(20);	
						c2.ipady = 2;       						
						c2.ipadx = 2;  
						c2.gridx = 1;       						     
			        	c2.gridy = 2;       						
			        	gridbag.setConstraints(mods_addr, c2);				
					p3.add(mods_addr);				
					jLabel5 = new JLabel(" Father's Name : ");	
						jLabel5.setFont(dataFont);				
						c2.ipady = 2;       						
						c2.ipadx = 2;  
						c2.gridx = 0;       						     
			        	c2.gridy = 3;       						
			        	gridbag.setConstraints(jLabel5, c2);				
					p3.add(jLabel5);											
						c2.ipady = 2;       						
						c2.ipadx = 2;  
						c2.gridx = 1;       						     
			        	c2.gridy = 3;       						
			        	gridbag.setConstraints(mods_fname, c2);				
					p3.add(mods_fname);												
					mMale = new JRadioButton("Male",true);
						mMale.setFont(dataFont);		
						c2.fill = GridBagConstraints.BOTH;
						c2.ipady = 2;       						
		       			c2.ipadx = 2;  
		       			c2.gridx = 1;
		        		c2.gridy = 4;
		        		gridbag.setConstraints(mMale, c2);
						mMale.addActionListener(rlistener);
						bg2.add(mMale);
					p3.add(mMale);										
	   				mFemale = new JRadioButton("Female",false);
						mFemale.setFont(dataFont);		
						c2.fill = GridBagConstraints.BOTH;
						c2.ipady = 2;       						
		       			c2.ipadx = 2;  
		       			c2.gridx = 2;
		        		c2.gridy = 4;
		        		gridbag.setConstraints(mFemale, c2);
						bg2.add(mFemale);		
						mFemale.addActionListener(rlistener);	
					p3.add(mFemale);								
					jLabel6 = new JLabel(" Class : ");	
						jLabel6.setFont(dataFont);				
						c2.ipady = 2;       						
						c2.ipadx = 2;  
						c2.gridx = 0;       						     
			        	c2.gridy = 5;       						
			        	gridbag.setConstraints(jLabel6, c2);				
					p3.add(jLabel6);													
					mjCombobox1 = new JComboBox();
						mjCombobox1.setFont(dataFont);	
				 		mjCombobox1.addItem("1st PUC");
		    			mjCombobox1.addItem("2nd PUC");
		    			c2.fill = GridBagConstraints.BOTH;
						c2.insets = new Insets(10,0,0,30);  		
						c2.ipady = 2;     						
						c2.ipadx = 2;							
		       	        c2.gridx = 1;							
		        		c2.gridy = 5;							
						mjCombobox1.addItemListener(cbListener);	
		        		gridbag.setConstraints(mjCombobox1, c2);
		        	p3.add(mjCombobox1);							
					mjCombobox2 = new JComboBox();
						mjCombobox2.setFont(dataFont);	
				 		mjCombobox2.addItem("Section A");
		    			mjCombobox2.addItem("Section B");
						mjCombobox2.addItem("Section C");
						c2.fill = GridBagConstraints.BOTH;
						c2.insets = new Insets(10,0,0,30);  		
		    			c2.ipady = 2;     
						c2.ipadx = 2;		
		       	        c2.gridx = 2;	
		        		c2.gridy = 5;			
						mjCombobox2.addItemListener(cbListener);			
		        		gridbag.setConstraints(mjCombobox2, c2);
		        	p3.add(mjCombobox2);										
						mSSLC = new JCheckBox("SSLC Marks Card  ");
						c2.fill = GridBagConstraints.BOTH;
						c2.ipady = 0;       						
						c2.ipadx = 0;  
						c2.gridx = 1;       						     
			        	c2.gridy = 6; 						
						gridbag.setConstraints(mSSLC, c2);
						mSSLC.setFont(dataFont);
						mSSLC.addItemListener(myListener);
    					p3.add(mSSLC);										
						mPHOTO = new JCheckBox("PHOTO (Passport Size)  ");
						c2.ipady = 0;       						
						c2.ipadx = 0;  
						c2.gridx = 2;       						     
			        	c2.gridy = 6; 
						gridbag.setConstraints(mPHOTO, c2);
						mPHOTO.setFont(dataFont);
						mPHOTO.addItemListener(myListener);
    					p3.add(mPHOTO);							
						mCHARCERT = new JCheckBox("Charecter Certificater");
						c2.ipady = 0;       						
						c2.ipadx = 0;  
						c2.gridx = 1;       						     
			        	c2.gridy = 7; 
						gridbag.setConstraints(mCHARCERT, c2);
						mCHARCERT.setFont(dataFont);
						mCHARCERT.addItemListener(myListener);
    					p3.add(mCHARCERT);												
						mNCCCERT = new JCheckBox("NCC Certificate Given");
						c2.ipady = 0;       						
						c2.ipadx = 0;  
						c2.gridx = 2;       						     
			        	c2.gridy = 7; 
						gridbag.setConstraints(mNCCCERT, c2);
						mNCCCERT.setFont(dataFont);
						mNCCCERT.addItemListener(myListener);
    					p3.add(mNCCCERT);	
					DELETE = new JButton("DELETE RECORD");										
						c2.ipady = 2;       						
						c2.ipadx = 2;  
						c2.gridx = 1;       						     
			        	c2.gridy = 8;  
						gridbag.setConstraints(DELETE, c2);
						p3.add(DELETE);
						DELETE.addActionListener(new ButtonHandler());											
					MODIFY = new JButton("MODIFY RECORD");										
						c2.ipady = 2;       						
						c2.ipadx = 2;  
						c2.gridx = 2;       						     
			        	c2.gridy = 8;  
						gridbag.setConstraints(MODIFY, c2);
						p3.add(MODIFY);
						MODIFY.addActionListener(new ButtonHandler());					
					jLabel7 = new JLabel(" ", ii, JLabel.CENTER);	
						c2.fill = GridBagConstraints.BOTH;
						c2.gridwidth = 5; 
						c2.gridx = 0;       						     
			        	c2.gridy = 10;       						
			        	gridbag.setConstraints(jLabel7, c2);				
					p3.add(jLabel7);					
			tabbedPane.addTab(MYPANEL3, p3);	
			accessDBinit();
		}
		//-------------------------------------------------------------- End showpane3 ---------
		//============================================================ Start showpane4 =========
		void showpane4() // REPORTS TAB WITH JTABLE
		{
			  JPanel p4 = new JPanel();			
			  p4.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Student Reports"));
			  try
			  {			  					
					Class.forName(driver);					
			   		Connection connection=DriverManager.getConnection(url);
			   		Statement statement = connection.createStatement();	
					String query = "SELECT StudentID, Name, Address, FName FROM student_det";
					ResultSet rs = statement.executeQuery(query);	
					ResultSetMetaData rmeta = rs.getMetaData();
					int numColumns=rmeta.getColumnCount();					
					for(int i=1;i<=numColumns;++i) 
					{
   						if(i<=numColumns)
						{
							defaulttablemodel.addColumn(rmeta.getColumnName(i));
						}   					
  					}					
					while(rs.next())
					{   						
						for(int i=1;i<=numColumns;++i)   
						{		
							if(i<=numColumns)
							{				 	
								tempname = rs.getString(i);
								tempcnt=i-1;
								data[tempcnt] = tempname;		
							}			
	   					}   
						defaulttablemodel.addRow(data);						
   					}
			  }
			  catch(Exception ex)
			  {
			  		//
			  }
	        p4.add(new JScrollPane(jtable));
			tabbedPane.addTab(MYPANEL4, p4);
		}		
		//------------------------------------------------------------ End showpane4 ------------
		//============================================================ Start showpane5 =========
		void showpane5() // DYNAMIC QUERY BUILDER TAB
		{
			JPanel p5 = new JPanel();				
				p5.setLayout(gridbag);		
				p5.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Dynamic Query Builder"));
					jCheckboxq1 = new JCheckBox("Student ID");	
					jCheckboxq1.setFont(dataFont);
        	   		c5.gridx = 0;        
        	   		c5.gridy = 0;	
					c5.fill = GridBagConstraints.BOTH;						
        	   		gridbag.setConstraints(jCheckboxq1, c5);
					jCheckboxq1.addItemListener(myListener);
        	   	p5.add(jCheckboxq1);				
				jRadiobuttonq1 = new JRadioButton("No Condition",true);
					jRadiobuttonq1.setFont(dataFont);
			    	c5.gridx = 1;       						
		        	c5.gridy = 0;  
					c5.fill = GridBagConstraints.BOTH;			
		        	gridbag.setConstraints(jRadiobuttonq1, c5);
					jRadiobuttonq1.addActionListener(rlistener);
					bgq.add(jRadiobuttonq1);
		        p5.add(jRadiobuttonq1);				
				jLabelq1 = new JLabel("   WHERE    ");
					jLabelq1.setFont(titleFont);
			    	c5.gridx = 2;       						
		        	c5.gridy = 0; 
					c5.fill = GridBagConstraints.BOTH;	    						
		        	gridbag.setConstraints(jLabelq1, c5);					
		        p5.add(jLabelq1);				
				jComboboxq1 = new JComboBox();
				 		jComboboxq1.addItem("StudentID");
		    			jComboboxq1.addItem("Name"); 
		    			jComboboxq1.addItem("Address");
		    			jComboboxq1.addItem("FName");
						jComboboxq1.addItem("Sex");
						jComboboxq1.setFont(dataFont);
		       	 		c5.gridx = 3;					
		        		c5.gridy = 0;	
						c5.fill = GridBagConstraints.BOTH;	
						jComboboxq1.addItemListener(cbListener);   				
		        		gridbag.setConstraints(jComboboxq1, c5);
		        p5.add(jComboboxq1);				
				jComboboxq2 = new JComboBox();
				 		jComboboxq2.addItem("=");
		    			jComboboxq2.addItem(">");
		    			jComboboxq2.addItem(">=");
		    			jComboboxq2.addItem("<");
						jComboboxq2.addItem("<=");
						jComboboxq2.addItem("!=");
						jComboboxq2.addItem("LIKE");
						jComboboxq2.addItem("NOT LIKE");
						jComboboxq2.setFont(dataFont);
		       	 		c5.gridx = 4;					
		        		c5.gridy = 0;	
						c5.fill = GridBagConstraints.BOTH;	       				
		       			gridbag.setConstraints(jComboboxq2, c5);
						jComboboxq2.addItemListener(cbListener);  
		        p5.add(jComboboxq2);	    		
				givencondition = new JTextField("                                           ");
		        	c5.gridx = 5;       						    
		        	c5.gridy = 0;       						
		        	gridbag.setConstraints(givencondition, c5);
		        p5.add(givencondition);					
				jCheckboxq2 = new JCheckBox("Student Name");	
					jCheckboxq2.setFont(dataFont);
        	   		c5.gridx = 0;        
        	   		c5.gridy = 1;	
					c5.fill = GridBagConstraints.BOTH;	 
        	   		gridbag.setConstraints(jCheckboxq2, c5);
					jCheckboxq2.addItemListener(myListener);
        	   	p5.add(jCheckboxq2);				
				jRadiobuttonq2 = new JRadioButton("Set Condition",false);
					jRadiobuttonq2.setFont(dataFont);
			    	c5.gridx = 1;       						
		        	c5.gridy = 1;  
					c5.fill = GridBagConstraints.BOTH;			
		        	gridbag.setConstraints(jRadiobuttonq2, c5);
					jRadiobuttonq2.addActionListener(rlistener);
					bgq.add(jRadiobuttonq2);
		        p5.add(jRadiobuttonq2);				
				jCheckboxq3 = new JCheckBox("Address");	
					jCheckboxq3.setFont(dataFont);
        	   		c5.gridx = 0;        
        	   		c5.gridy = 2;	
					c5.fill = GridBagConstraints.BOTH;						
        	   		gridbag.setConstraints(jCheckboxq3, c5);
					jCheckboxq3.addItemListener(myListener);
        	   	p5.add(jCheckboxq3);				
				jCheckboxq4 = new JCheckBox("Fathers Name");	
					jCheckboxq4.setFont(dataFont);
        	   		c5.gridx = 0;        
        	   		c5.gridy = 3;	
					c5.fill = GridBagConstraints.BOTH;						
        	   		gridbag.setConstraints(jCheckboxq4, c5);
					jCheckboxq4.addItemListener(myListener);
        	   	p5.add(jCheckboxq4);				
				jCheckboxq5 = new JCheckBox("Sex");	
					jCheckboxq5.setFont(dataFont);
        	   		c5.gridx = 0;        
        	   		c5.gridy = 4;	
					c5.fill = GridBagConstraints.BOTH;						
        	   		gridbag.setConstraints(jCheckboxq5, c5);
					jCheckboxq5.addItemListener(myListener);
        	   	p5.add(jCheckboxq5);												
				QUERY = new JButton("QUERY");										
						c5.gridx = 5;       						     
			        	c5.gridy = 4;  
						gridbag.setConstraints(QUERY, c5);						
						gridbag.setConstraints(QUERY, c5);
						QUERY.addActionListener(new ButtonHandler());	
				p5.add(QUERY);				
				jLabelq2 = new JLabel(" Query Result ");
					jLabelq2.setFont(dataFont);
					c5.weighty = 1.0;
		        	c5.gridx = 0;       						
		        	c5.gridy = 5;  
					c5.gridwidth = 6;     						
		        	gridbag.setConstraints(jLabelq2, c5);
		        p5.add(jLabelq2);
				resultArea = new JTextArea(10,60);
					resultArea.setFont(dataFont);
        	   		c5.gridx = 0;        
        	   		c5.gridy = 6;	
					c5.fill = GridBagConstraints.BOTH;		
					c5.gridwidth = 6;  				
        	   		gridbag.setConstraints(resultArea, c5);
        	   		p5.add(resultArea);
				tabbedPane.addTab(MYPANEL5, p5);
		}
		//------------------------------------------------------------ End showpane5 ------------
		//============================================================= Start showpane6 =========
		void showpane6()	//FOR FUTURE USE BY USER PRINCIPAL
		{			
			JPanel p6 = new JPanel();
				jLabel = new JLabel(" Inside Panel 6 ");	
				p6.add(jLabel);
			tabbedPane.addTab(MYPANEL6, p6);
		}
		//------------------------------------------------------------ End showpane6 ------------
		//============================================================= Start showpane7 =========
		void showpane7()  //FOR FUTURE USE BY USER PRINCIPAL
		{
			JPanel p7 = new JPanel();
				jLabel = new JLabel(" Inside Panel 7 ");	
				p7.add(jLabel);
			tabbedPane.addTab(MYPANEL7, p7);
		}
		//------------------------------------------------------------ End showpane7 ------------
		void showpane2345() // ACCOUNTANT LOGGEDIN
		{	
			showpane2();
			showpane3();
			showpane4();
			showpane5();
		}
		void showpane67()	// PRINCIPAL LOGGEDIN
		{	
			showpane6();
			showpane7();
		}	
		/////////////////////////////////////////////////////////////////////////////////////////
		//========================================================== Start accessDB() =============	
		void accessDB() 
		{		 	
			  try
			  {			   		
					String var1 =  loginname.getText();
						   var1 =  var1.trim();
					String var2 =  loginpass.getText();
						   var2 =  var2.trim();		
					//JDBC step 1 :  Write your SQL (structured query language)			
					sql = "SELECT * FROM login WHERE username='"+var1+"' AND password='"+var2+"'";
					//JDBC step 2 : using driver="sun.jdbc.odbc.JdbcOdbcDriver"; for MSACCESS
					Class.forName(driver);
					//JDBC step 3 : using driver="sun.jdbc.odbc.JdbcOdbcDriver";
			   		Connection connection=DriverManager.getConnection(url);
					//JDBC step 4 : url="jdbc:odbc:james";	ODBC Comes into picture here
			   		Statement statement = connection.createStatement();
					//JDBC step 5 : Get JDBC connection
					boolean hasResults = statement.execute(sql);
					//JDBC step 6 : Execute your SQL (see if it has any results)
			   		if(hasResults)
					{
			    		ResultSet result = statement.getResultSet();
						//JDBC step 7 : if there are results Get the "SET" 
			    		if(result!=null)
						{ 	
							//take this "SET" of results from "SQL"
							//call this method "isplayResults(ResultSet r)" and pass ResultSet to it 
							displayResults(result);
			   			}
						//JDBC step 8 : Close Database Connection u Established
						connection.close();
			  		}				
			  }
			  catch(Exception ex)
			  {

			  }
		}	
		void displayResults(ResultSet r) throws SQLException 
		{
  				ResultSetMetaData rmeta = r.getMetaData();
				//Get Metadata from resultset 
				int foundrec = 0;
  				int numColumns=rmeta.getColumnCount();  
				while(r.next())
				{								
						String param3 = r.getString(3).trim();
						// 3rd field in the table 'login' , database 'james.mdb'						
						if (param3.equals("Accounts")) 
						{
							// for login 'a' , password 'a' , if his deparment is "Accounts"
						    // u found record , so set foundrecord = 1
							foundrec = 1;
							//remove login TAB
							tabbedPane.removeTabAt(0);
							// Show other panes 2-3-4-5
							showpane2345();	
						}
						else if(param3.equals("Principal"))
						{
							// for login 'p' , password 'p' , if his deparment is "Principal" 
							// u found record , so set foundrecord = 1
							foundrec = 1;
							//remove login TAB (TAB 0)
							tabbedPane.removeTabAt(0);
							showpane67();	
						}		
  				}		
				if(foundrec==0)
				{
					//if foundrecord is zero , invalid login
					dialogmessage = "Please Re-Login";
					dialogtype = JOptionPane.INFORMATION_MESSAGE;
					//show message
					JOptionPane.showMessageDialog((Component) null, dialogmessage, dialogf, dialogtype);
					//make login and password textboxes empty
					loginname.setText(" ");
					loginpass.setText(" ");
				}	
		}	
		//------------------------------------------------------------------- End accessDB() -------	
		//=================================================================== Start accessDBADD()====
		void accessDBADD() 
		{
		 	  try
			  {			  
					Class.forName(driver);					
			   		Connection connection=DriverManager.getConnection(url);
			   		Statement statement = connection.createStatement();	
					//Generate new register number
					String query = "SELECT * FROM student_det";
					ResultSet rs = statement.executeQuery(query);
					int cnt = 0;
					while (rs.next()) 
					{
    					cnt++;      					
					}
					cnt = cnt+1;
					char ys = Yearsel.charAt(0);
					char ss =  Sectionsel.charAt(8);
					reg_no = "02-PCM-"+ys+""+ss+"-"+cnt; 
					//insert data with new reg no and other details
					sql = "INSERT INTO student_det (StudentID, Name, Address, FName, Sex, Yearsel, Sectionsel, SSLC, PHOTO,  CHARCERT, NCCCERT, imagename) VALUES ('"+reg_no+"','"+adds_name.getText()+"','"+adds_addr.getText()+"','"+adds_fname.getText()+"','"+Sexsel+"','"+Yearsel+"','"+Sectionsel+"',"+SSLCsel+","+PHOTOsel+","+CHARCERTsel+","+NCCCERTsel+",'"+adds_imname.getText()+"')"; 
					statement.executeUpdate(sql);	
					connection.close();	
					// add this new record to our JTable too (DATAGRID)									
					data[0] = reg_no;		
					data[1] = adds_name.getText();	
					data[2] = adds_addr.getText();		
					data[3] = adds_fname.getText();			 
					defaulttablemodel.addRow(data);
					dialogmessage = " "+adds_name.getText().toUpperCase()+" has Registration Number : "+reg_no;
					dialogtype = JOptionPane.INFORMATION_MESSAGE;
					//show user the new register number and new record holder name
					JOptionPane.showMessageDialog((Component) null, dialogmessage, dialogtitle, dialogtype);
					//rollback combobox selection
					jCombobox1.setSelectedIndex(0);  //section 
					jCombobox2.setSelectedIndex(0);  //standard 
					
					String snametemp = adds_name.getText();
					jCombobox3.addItem(adds_name.getText());
					// add name to combobox in modify names TAB
					
					//set other textboxes black to enable new record entry
					adds_name.setText(" ");
					adds_addr.setText(" ");
					adds_fname.setText(" ");
					adds_imname.setText(" ");
					
					// uncheck checkboxes if they are checked while adding data
					SSLC.setSelected(false);
					PHOTO.setSelected(false);
					NCCCERT.setSelected(false);
					CHARCERT.setSelected(false);
					
					//click on the radiobutton male , to make it default again
					Male.doClick();		
			  }
			  catch(Exception ex)
			  {

			  }
		}
		//------------------------------------------------------------------- End accessDBADD() -------	
		//=============================================================== Start accessDBMod() ========	
		void accessDBMod(String nsel) 
		{		 	
			  try
			  {			   	
					sql = "SELECT * FROM student_det WHERE Name='"+nsel+"'";
					Class.forName(driver);
			   		Connection connection=DriverManager.getConnection(url);
			   		Statement statement = connection.createStatement();
					boolean hasResults = statement.execute(sql);
			   		if(hasResults)
					{
			    		ResultSet result = statement.getResultSet();
			    		if(result!=null)
						{ 		
							displayResultsMod(result);
			   			}
						connection.close();
			  		}						
			  }
			  catch(Exception ex)
			  {

			  }
		}	
		void displayResultsMod(ResultSet r) throws SQLException 
		{
  				ResultSetMetaData rmeta = r.getMetaData();
				int foundrec = 0;
  				int numColumns=rmeta.getColumnCount();
				String text2="";	
				String text3="";	
				String text4="";	
				String text5="";	
				String text6="";	
				String text7="";	
				String text8="";	
				int int9=0;
				int int10=0;
				int int11=0;
				int int12=0;
				while(r.next())
				{
					reg_no=r.getString(2);
  					text3+=r.getString(3);
					text4+=r.getString(4);
					text5+=r.getString(5);
					text6+=r.getString(6);
					text7+=r.getString(7);
					text8+=r.getString(8);
					int9=r.getInt(9);
					int10=r.getInt(10);
					int11=r.getInt(11);
					int12=r.getInt(12);		
					imagename=r.getString(13);
  				}
				jLabel7.setIcon(new ImageIcon(imagename));
				currname = text3;				
				mods_name.setText(text3);
				mods_addr.setText(text4);
				mods_fname.setText(text5);				
				text6 = text6.trim();
				if (text6.equals("Male")) 
				{
					mMale.doClick();						
				}
				else
				{
					mFemale.doClick();
				}	
				text7 = text7.trim();
				if (text7.equals("2nd PUC")) 
				{
					mjCombobox1.setSelectedIndex(1); 			
				}
				else
				{
					mjCombobox1.setSelectedIndex(0); 
				}				
				text8 = text8.trim();
				if (text8.equals("Section A")) 
				{
					mjCombobox2.setSelectedIndex(0); 			
				}
				else if(text8.equals("Section B"))
				{
					mjCombobox2.setSelectedIndex(1); 
				}				
				else
				{
					mjCombobox2.setSelectedIndex(2); 
				}		
				if(int9==1)
				{
					mSSLC.setSelected(true);
				}
				else
				{
					mSSLC.setSelected(false);
				}
				if(int10==1)
				{
					mPHOTO.setSelected(true);
				}
				else
				{
					mPHOTO.setSelected(false);
				}
				if(int11==1)
				{
					mCHARCERT.setSelected(true);
				}
				else
				{
					mCHARCERT.setSelected(false);
				}
				if(int12==1)
				{
					mNCCCERT.setSelected(true);
				}
				else
				{
					mNCCCERT.setSelected(false);
				}
		}
		//------------------------------------------------------------- End accessDBMod() --------	
		//============================================================= Start accessDBinit()=======
		void accessDBinit() 
		{
		 	  try
			  {			  		
					sql = "SELECT Name FROM student_det ORDER BY Name"; 
					Class.forName(driver);
			   		Connection connection=DriverManager.getConnection(url);
			   		Statement statement = connection.createStatement();
					boolean hasResults = statement.execute(sql);
					if(hasResults)
					{
			    		ResultSet result = statement.getResultSet();
			    		if(result!=null)
						{ 							
							displayResultsinit(result);
						}						
			   			connection.close();
			  		}
				
			  }
			  catch(Exception ex)
			  {
			   		
			  }
		}
		void displayResultsinit(ResultSet r) throws SQLException 
		{
  				ResultSetMetaData rmeta = r.getMetaData();
  				int numColumns=rmeta.getColumnCount(); 
				while(r.next())
				{	
					for(int i=1;i<=numColumns;++i) 
					{
    					if(i<=numColumns)
						{
							jCombobox3.addItem(r.getString(i));
						}
   					}   					 
  				}	
		}
		//------------------------------------------------------------- End accessDBinit() --------		
		//============================================================= Start accessDBDel()========
		void accessDBDel(String nsel) 
		{		 	
			  try
			  {					  					
					Class.forName(driver);					
			   		Connection connection=DriverManager.getConnection(url);
			   		Statement statement = connection.createStatement();	
					sql = "DELETE FROM student_det WHERE Name='"+nsel+"'";
					statement.executeUpdate(sql);					
					connection.close();			
					mjCombobox1.setSelectedIndex(0);		 
					mjCombobox2.setSelectedIndex(0);			 
					mods_name.setText(" ");					
					mods_addr.setText(" ");			
					mods_fname.setText(" ");			
					mSSLC.setSelected(false);			
					mPHOTO.setSelected(false);			
					mNCCCERT.setSelected(false);		
					mCHARCERT.setSelected(false);		
					mMale.doClick();						
			  }
			  catch(Exception ex)
			  {

			  }
		}	
		//---------------------------------------------------------------- End accessDBDel()-------
		//================================================================= Start updateDB() ======	
		void updateDB() 
		{
		 	  try
			  {
			  		sql = "UPDATE student_det SET Name='"+mods_name.getText()+"', Address='"+mods_addr.getText()+"', FName='"+mods_fname.getText()+"', Sex='"+Sexsel+"', Yearsel='"+Yearsel+"', Sectionsel='"+Sectionsel+"', SSLC="+mSSLCsel+", PHOTO="+mPHOTOsel+", CHARCERT="+mCHARCERTsel+", NCCCERT="+mNCCCERTsel+"  WHERE StudentID='"+reg_no+"'"; 
					Class.forName(driver);
			   		Connection connection=DriverManager.getConnection(url);
			   		Statement statement = connection.createStatement();
					statement.executeUpdate(sql);	
		   			connection.close();
					dialogmessage = " "+mods_name.getText().toUpperCase()+" Record is Updated ";
					dialogtype = JOptionPane.INFORMATION_MESSAGE;
					JOptionPane.showMessageDialog((Component) null, dialogmessage, dialogm, dialogtype);
			  }
			  catch(Exception ex)
			  {
			  		
			  }			  
		}		
		//----------------------------------------------------------------- End updateDB() ---------
		//============================================================  Start handleQuery() =======
		void handleQuery()
		{
				qry="SELECT";
				int cnt=0;
				if(StudentIDsel==1)
				{
					cnt++;
					qry+=" StudentID,";
				}
				if(StudentNamesel==1)
				{
					cnt++;
					qry+=" Name,";
				}
				if(Addresssel==1)
				{
					cnt++;
					qry+=" Address,";
				}
				if(FathersNamesel==1)
				{
					cnt++;
					qry+=" FName,";
				}
				if(qSexsel==1)
				{
					cnt++;
					qry+=" Sex,";
				}		
				int slen=qry.length();
				int tempslen = slen-1;
				qry = qry.substring(0,tempslen);
				qry+=" FROM student_det";
				if(condsel=="Set Condition")
				{
					qry+=" WHERE "+Combo1sel+" "+Combo2sel+" "+givencondition.getText().trim();
				}
				jLabelq2.setText(qry);
				accessDBquery(qry); 
		}		
		//------------------------------------------------------------  End handleQuery() --------
		//============================================================== Start accessDBquery() ===
		void accessDBquery(String sqlq) 
		{
  			try
			{
   				Class.forName(driver);
	   			Connection connection=DriverManager.getConnection(url);
	   			Statement statement = connection.createStatement();
	   			boolean hasResults = statement.execute(sqlq);
	   			if(hasResults)
				{
	    			ResultSet result = statement.getResultSet();
		    		if(result!=null) 
					{
						displayResultsQ(result);
					}
					else 
					{
						resultArea.setText("");
					}   				
				}
				connection.close();
  			}
			catch(Exception ex)
			{
   				resultArea.setText(ex.toString());
  			}
 		}
		void displayResultsQ(ResultSet r) throws SQLException 
		{
	  		ResultSetMetaData rmeta = r.getMetaData();
	  		int numColumns=rmeta.getColumnCount();
	  		String text="";
	  		for(int i=1;i<=numColumns;++i) 
			{
	   		if(i<numColumns)
	    		text+=rmeta.getColumnName(i)+" | ";
	   		else
	    		text+=rmeta.getColumnName(i);
	  		}
	  		text+="\n";
	  		while(r.next())
			{
	   			for(int i=1;i<=numColumns;++i) 
				{
	    			if(i<numColumns)
	     				text+=r.getString(i)+" | ";
	    			else
	     				text+=r.getString(i).trim();
	   			}
	   			text+="\n";
	  		}
	  		resultArea.setText(text);
	 	}
		//---------------------------------------------------------------- End accessDBquery() ---
		/////////////////////////////////////////////////////////////////////////////////////////
		//============================================================= Start ButtonHandler ========
 		class ButtonHandler implements ActionListener 
		{
  			public void actionPerformed(ActionEvent ev)
			{
   				String s=ev.getActionCommand(); 	
				//see which button is click accordingly call its method			
				if(s=="LOGIN") 
				{
					// call method accessDB();
					accessDB();					
				}  
				else if(s=="SAVE RECORD")
				{
					accessDBADD();
					String snametemp = adds_name.getText();
				}	
				else if(s=="MODIFY RECORD")
				{					
					String temp_mname = mods_name.getText().trim();
					String temp_currname = currname.trim();
					if(temp_mname.equals(temp_currname))
					{
						
					}
					else
					{
						jCombobox3.addItem(mods_name.getText());	
					}					
					updateDB();					
				}
				else if(s=="DELETE RECORD")
				{
					dialogContentPane.setLayout(new FlowLayout());					
					dialogContentPane.add(jLabeldlg);
					jLabeldlg.setFont(titleFont);
					dialogContentPane.add(DELETEIT);
					DELETEIT.addActionListener(new ButtonHandler());		
					dialogContentPane.add(DONTDELETE);
					DONTDELETE.addActionListener(new ButtonHandler());
					//Boundry for this dialog box
					dialog.setBounds(300, 200, 250, 120);
					//show delete confirmation dialog
					dialog.show();
				}
				else if(s=="YES DELETE")
				{
					dialog.dispose();
					Namesel = jCombobox3.getSelectedItem().toString();
  					accessDBDel(Namesel);
				}
				else if(s=="NO DELETE")
				{
					dialog.dispose();
				}
				else if(s=="QUERY") 
				{
					handleQuery();					
				}				
			}
 		}
		//------------------------------------------------------------- End ButtonHandler --------	
		//=========================================================== START MenuItemHandler ======
 		class MenuItemHandler implements ActionListener 
		{
  			public void actionPerformed(ActionEvent ev)
			{
   				String s=ev.getActionCommand();
   				if(s=="Exit")
				{
					//close window on menuitem exit
    				System.exit(0);
   				}								
  			}					
 		}
		//----------------------------------------------------------- END__ MenuItemHandler ------
		//=========================================================== START WindowEventHandler ===
 		class WindowEventHandler extends WindowAdapter 
		{
  			public void windowClosing(WindowEvent e)
			{
				//close window on exit
   				System.exit(0);
  			}
 		}
		//----------------------------------------------------------- END__ WindowEventHandler ---
		//=========================================================== START RadioListener ========
		class RadioListener implements ActionListener 
		{
      		public void actionPerformed(ActionEvent e) 
			{
				  Sexsel = e.getActionCommand();
				  condsel = e.getActionCommand();
		    }
		}
		//----------------------------------------------------------- END__ RadioListener --------
		//=========================================================== START RadioListener ========
		class ComboBoxListener implements ItemListener  
		{
      		public void itemStateChanged(ItemEvent e) 
			{				
		    	sr = (String)e.getItem();
				if (e.getSource().equals(jCombobox1))
    			{
    				Yearsel = jCombobox1.getSelectedItem().toString();
    			}
				if (e.getSource().equals(mjCombobox1))
    			{
    				Yearsel = mjCombobox1.getSelectedItem().toString();
    			}
    			if (e.getSource().equals(jCombobox2))
    			{
    				Sectionsel = jCombobox2.getSelectedItem().toString();
    			}
				if (e.getSource().equals(mjCombobox2))
    			{
    				Sectionsel = mjCombobox2.getSelectedItem().toString();
    			}
				if (e.getSource().equals(jCombobox3))
    			{					
					Namesel = jCombobox3.getSelectedItem().toString();					
  					accessDBMod(Namesel);					
    			}
				if (e.getSource().equals(jComboboxq1))
    			{
					Combo1sel = jComboboxq1.getSelectedItem().toString();
    			}
				if (e.getSource().equals(jComboboxq2))
    			{
					Combo2sel = jComboboxq2.getSelectedItem().toString();
    			}
		    }
		}
		//----------------------------------------------------------- END__ RadioListener --------
		//=========================================================== START CheckBoxListener =====		
		class CheckBoxListener implements ItemListener 
		{
    		
			public void itemStateChanged(ItemEvent e) 
    		{
        		Object source = e.getItemSelectable();
				if ((e.getStateChange() == ItemEvent.SELECTED) && (source==SSLC))
       			{
					SSLCsel = 1;
      			}
				if ((e.getStateChange() == ItemEvent.DESELECTED)  && (source==SSLC))
       			{
					SSLCsel = 0;
      			}					
				if ((e.getStateChange() == ItemEvent.SELECTED)  && (source==PHOTO))
       			{
					PHOTOsel = 1;
      			}
				if ((e.getStateChange() == ItemEvent.DESELECTED)  && (source==PHOTO))
       			{
					PHOTOsel = 0;
      			}					
				if ((e.getStateChange() == ItemEvent.SELECTED) && (source==NCCCERT))
       			{
					NCCCERTsel = 1;
      			}
				if ((e.getStateChange() == ItemEvent.DESELECTED)  && (source==NCCCERT))
       			{
					NCCCERTsel = 0;
      			}					
				if ((e.getStateChange() == ItemEvent.SELECTED)  && (source==CHARCERT))
       			{
					CHARCERTsel = 1;
      			}
				if ((e.getStateChange() == ItemEvent.DESELECTED)  && (source==CHARCERT))
       			{
					CHARCERTsel = 0;
      			}						
				if ((e.getStateChange() == ItemEvent.SELECTED) && (source==mSSLC))
       			{
					mSSLCsel = 1;
      			}
				if ((e.getStateChange() == ItemEvent.DESELECTED)  && (source==mSSLC))
       			{
					mSSLCsel = 0;
      			}					
				if ((e.getStateChange() == ItemEvent.SELECTED)  && (source==mPHOTO))
       			{
					mPHOTOsel = 1;
      			}
				if ((e.getStateChange() == ItemEvent.DESELECTED)  && (source==mPHOTO))
       			{
					mPHOTOsel = 0;
      			}					
				if ((e.getStateChange() == ItemEvent.SELECTED) && (source==mNCCCERT))
       			{
					mNCCCERTsel = 1;
      			}
				if ((e.getStateChange() == ItemEvent.DESELECTED)  && (source==mNCCCERT))
       			{
					mNCCCERTsel = 0;
      			}					
				if ((e.getStateChange() == ItemEvent.SELECTED)  && (source==mCHARCERT))
       			{
					mCHARCERTsel = 1;
      			}
				if ((e.getStateChange() == ItemEvent.DESELECTED)  && (source==mCHARCERT))
       			{
					mCHARCERTsel = 0;
      			}		
				if ((e.getStateChange() == ItemEvent.SELECTED) && (source==jCheckboxq1))
       			{
					StudentIDsel = 1;
      			}
				if ((e.getStateChange() == ItemEvent.DESELECTED)  && (source==jCheckboxq1))
       			{
					StudentIDsel = 0;
      			}	
				if ((e.getStateChange() == ItemEvent.SELECTED) && (source==jCheckboxq2))
       			{
					StudentNamesel = 1;
      			}
				if ((e.getStateChange() == ItemEvent.DESELECTED)  && (source==jCheckboxq2))
       			{
					StudentNamesel = 0;
      			}	
				if ((e.getStateChange() == ItemEvent.SELECTED) && (source==jCheckboxq3))
       			{
					Addresssel = 1;
      			}
				if ((e.getStateChange() == ItemEvent.DESELECTED)  && (source==jCheckboxq3))
       			{
					Addresssel = 0;
      			}	
				if ((e.getStateChange() == ItemEvent.SELECTED) && (source==jCheckboxq4))
       			{
					FathersNamesel = 1;
      			}
				if ((e.getStateChange() == ItemEvent.DESELECTED)  && (source==jCheckboxq4))
       			{
					FathersNamesel = 0;
      			}	
				if ((e.getStateChange() == ItemEvent.SELECTED) && (source==jCheckboxq5))
       			{
					qSexsel = 1;
      			}
				if ((e.getStateChange() == ItemEvent.DESELECTED)  && (source==jCheckboxq5))
       			{
					qSexsel = 0;
      			}	
										
    		}			
		}
		//---------------------------------------------------------- END CheckBoxListener -------
		//STILL NOT CLEAR MAIL ME ? :) james_smith73@yahoo.com
		/////////////////////////////////////////////////////////////////////////////////////////
}
