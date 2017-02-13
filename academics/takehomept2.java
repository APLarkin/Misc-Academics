//I couldn't make the checkbox work.
//I made it into a button instead. It works, but I get errors when using that part.
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.awt.Image;
import java.awt.Color;
import java.awt.Graphics;
import java.util.*;
import java.io.*;

import java.awt.Insets;
import java.awt.Dimension;
import java.awt.Checkbox;

public class takehomept2 extends JFrame
{
	private Container contents;
	private JLabel output;
	private JButton CheckButton;
	private JButton check;
	private JTextField field;
	private String FieldText;
	private Scanner Wordlist;
	private List<String> wortliste = new ArrayList<String>();
	private List<String> bigWordList = new ArrayList<String>();
	private boolean bigwordlistthing = false;
	
	public takehomept2()
	{
		super("Word Checker");
		contents = getContentPane();
		contents.setLayout(null);
		CheckButton = new JButton("Check word");
		output = new JLabel("Welcome to the word-checker");
		check = new JButton("One");
		field = new JTextField(20);
		
		contents.add(CheckButton);
		contents.add(output);
		contents.add(check);
		contents.add(field);
		try{
			Wordlist = new Scanner(new File("wordlist.txt"));
		}catch(Exception FileNotFoundException){}
		
		while(Wordlist.hasNext())
		{
			wortliste.add(Wordlist.nextLine());
		}
		Wordlist.close();
		
			try{
				Wordlist = new Scanner(new File("crazywordlist.txt"));
			}catch(Exception FileNotFoundException){}
				
			while(Wordlist.hasNext())
			{
				bigWordList.add(Wordlist.nextLine());
			}
			Wordlist.close();
		
		check.setAction(new AbstractAction("Use big list")
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				bigwordlistthing = true;
			}
		
		});
		
		CheckButton.setAction(new AbstractAction("Check word")
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String text = field.getText();
				if(bigwordlistthing == false)
				{
					for(int i = 0; i < wortliste.size(); i++)
					{
						String text2 = wortliste.get(i);
						if(text.equals(text2))
						{
							output.setText(text + " is a word.");
						}
				
					}
				
				}
				
				if(bigwordlistthing == true)
				{
					for(int i = 0; i < wortliste.size(); i++)
					{
						String text2 = wortliste.get(i);
						String text3 = bigWordList.get(i);
						if(text.equals(text2) || text.equals(text3))
						{
							output.setText(text + " is a word.");
						}
				
					}	
				
				}
			}
		
		});
		
		Insets insets = contents.getInsets();
		Dimension size = CheckButton.getPreferredSize();
		CheckButton.setBounds(400+insets.left,300+insets.top,size.width,size.height);
		
		size = output.getPreferredSize();
		output.setBounds(425+insets.left, -100+insets.top,500,500);
		
		size = check.getPreferredSize();
		check.setBounds(550+insets.left,300+insets.top,size.width,size.height);
		size = field.getPreferredSize();
		field.setBounds(400, 250,size.width,size.height);
		
		setSize(1000,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args)
	{
		new takehomept2();
		
	}
}