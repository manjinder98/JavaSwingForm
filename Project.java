import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.InputMismatchException;

public class Project implements ActionListener{
    JFrame f;
    JLabel l1,l2,l3,l4,l5,l6,l7;
    JTextField t1,t2,t3,t4;
    JButton b1,b2;
    JTextArea a1;
    JRadioButton r1,r2;
    JCheckBox c1;
    JComboBox cb1;
    ButtonGroup bg;
    Project(){
        bg = new ButtonGroup();
        f = new JFrame("Add New Employee");
        l1 = new JLabel("Name");
        l2 = new JLabel("Phone");
        l3 = new JLabel("Email");
        l4 = new JLabel("Address");
        l5 = new JLabel("Gender");
        l6 = new JLabel("Occupation");
        l7 = new JLabel("Salary");
        c1 = new JCheckBox("Is Manager");
        String options[] = {"Select","Teacher","Engineer","Doctor","Student","Others"};
        cb1 = new JComboBox(options);
        b1 = new JButton("Submit");
        b2 = new JButton("Clear");
        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();
        a1 = new JTextArea();
        r1 = new JRadioButton("Male");
        r2 = new JRadioButton("Female");
        
        l1.setBounds(35,45,50,25);
        l2.setBounds(35,95,50,25);
        l3.setBounds(35,145,50,25);
        l4.setBounds(35,195,50,25);
        l5.setBounds(35,272,50,25);
        l6.setBounds(35,325,70,25);
        l7.setBounds(35,460,50,25);
        t1.setBounds(100,50,150,20);
        t2.setBounds(100,100,150,20);       
        t3.setBounds(100,150,300,20);
        a1.setBounds(100,200,250,50);
        r1.setBounds(100,275,100,20);
        r2.setBounds(200,275,100,20);
        cb1.setBounds(125,327,200,20);
        t4.setBounds(100,465,100,25);
        c1.setBounds(105,500,100,20);
        b1.setBounds(35,550,100,20);
        b2.setBounds(325,550,100,20);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        bg.add(r1);bg.add(r2);
        f.add(t1);f.add(t2);f.add(t3);
        f.add(l1);f.add(l2);f.add(l3);f.add(l4);f.add(l5);f.add(l6);f.add(l7);
        f.add(a1);f.add(r1);f.add(r2);f.add(cb1);f.add(t4);f.add(c1);
        f.add(b1);f.add(b2);
        f.setSize(475,650);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e){
		if(e.getSource() == b1){
			if (t1.getText().trim().isEmpty() || t2.getText().trim().isEmpty() || t3.getText().trim().isEmpty() || t4.getText().trim().isEmpty() || a1.getText().trim().isEmpty() || bg.isSelected(null) || (cb1.getSelectedIndex() == 0))
		        {
		        	JOptionPane.showMessageDialog(f,"Please fill up all the boxes!"); 
		        }
			else{
		    	String name, address, occupation, gender;
		    	int phone = 0;
		    	float salary = 0;
		    	try {
		    		salary = Float.parseFloat(t4.getText());
		    	}
		    	catch(NumberFormatException b){
		    		JOptionPane.showMessageDialog(f,"Enter a valid salary");
		        	return;
		    	}
		        boolean isManager = false;
		        name = t1.getText();	
		        try {
		        	phone = Integer.parseInt(t2.getText());
		        }
		        catch(NumberFormatException a) {
		        	JOptionPane.showMessageDialog(f,"Enter a valid phone number");
		        	return;
		        }
		        boolean status = EmailValidator.emailValidation(t3.getText());
		        String email = t3.getText();
		        while(!status) {
			        if (status == true) {
			        	 email = t3.getText();
			        }
			        else {
			        	JOptionPane.showMessageDialog(f,"Enter a valid email");
			        	return;
			        }
		        }
		        address = a1.getText();
		        occupation = (String)cb1.getSelectedItem();
		        if(r1.isSelected()){
		            gender = "male";
		        }
		        else{
		            gender = "female";
		        }
		        if(c1.isSelected()){
		            isManager = true;
		        }
		        Employee emp = new Employee(name,phone,address,email,occupation,gender,salary,isManager);
		    	SimpleWriter print = new SimpleWriter();
		    	try {
					print.constructNewFile(emp.toString(),"C:\\Users\\user\\Desktop\\Uni Material\\SS 2018\\Object Oriented Programming\\Project\\Employees.txt");
					JOptionPane.showMessageDialog(f,emp.toString()); 
		    	} catch (IOException e1) {
					new IOException();
				}
			}
		}
		if(e.getSource() == b2){
		    t1.setText("");
		    t2.setText("");
		    t3.setText("");
		    t4.setText("");
		    a1.setText("");
		    bg.clearSelection();
		    cb1.setSelectedIndex(0);
		    c1.setSelected(false);
		}
    } 
    public static void main(String[] args){
        new Project();
    }
}