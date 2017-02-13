import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;

public class ButtonExample7 extends JFrame
{
	private Container contents;
	private JLabel label;
	private List<JButton> buttons;
	String stuffTyped;
	
	public ButtonExample7()
	{
		super("This is the text in the title pane."); 
		contents = getContentPane();  
		contents.setLayout(new FlowLayout());   
		label = new JLabel("Hello World");
		
		buttons = new ArrayList<JButton>();
			
		int temp = 0;
		
		// one button for each letter of the alphabet
		String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for (int i=0; i<alpha.length(); i++)
		{
			JButton b = new JButton(alpha.substring(i,i+1));
			buttons.add(b);
			contents.add(b);
			b.addActionListener(new ButtonListener(i));
			temp = i;
			
		}
		JButton BackSpace = new JButton("Backspace");
		buttons.add(BackSpace);
		contents.add(BackSpace);
		BackSpace.addActionListener(new ButtonListener(temp+1));
		
		contents.add(label);
		
		stuffTyped = "";
		
		setSize(500,200);   
		setVisible(true);   
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	}
	
	public class ButtonListener implements ActionListener
	{
		private int buttonNum;
		
		public ButtonListener(int buttonNum)
		{
			this.buttonNum = buttonNum;
		}
		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			// what to do when button is clicked goes here
			if(buttonNum != 26)
			{
				stuffTyped += buttons.get(buttonNum).getText();
				label.setText(stuffTyped);
			}
			if(buttonNum == 26)
			{
				//I have no clue why this isn't working.
				//If I set buttonNum to 27 it just adds the word "backspace"
				//but 26 gives me an index-out-of-bounds error (which seems weird to me)
				stuffTyped = stuffTyped.substring(0,stuffTyped.length()-1);
				label.setText(stuffTyped);
			}
		}
	}

	
	public static void main(String[] args)
	{
		new ButtonExample7();
	}
}
