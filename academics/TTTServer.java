//final project
import java.io.*;
import java.util.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.*;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TTTServer
{

	private JFrame frame;
    private JPanel mainPanel;
    private JButton[][] buttons;
    private String player;  // keeps track of if it is X's or O's turn
	
	//Socket setup
	//Hard coding port
	static ServerSocket ss = new ServerSocket(81);
	static Socket sock = ss.accept();
	static InputStream recvStream = sock.getInputStream();
	static OutputStream sendStream = sock.getOutputStream();
	
	public static void main(String[] args) throws IOException
	{		
		//Tictactoe game
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TicTacToe();
            }
        });
		boolean end = false;
		
		while(end == false)
		{
			byte[] buffer = new byte[1024];
			recvStream.read(buffer, 0, 1024);
			System.out.println(new String(buffer, 0, 1024));
		}
		
		
		recvStream.close();
		sendStream.close();
		
		sock.close();
		ss.close();
	}
	//Tic-tac-toe stuff
	private void initialize()
    {
        mainPanel.setLayout(new GridLayout(3,3));
        mainPanel.setPreferredSize(new Dimension(200,200));
        
        // Create the 3 x 3 array of buttons and place them on screen
        buttons = new JButton[3][3];
        for (int i=0; i<3; i++)
        {
            for (int j=0; j<3; j++)
            {
                buttons[i][j] = new JButton(" ");
                buttons[i][j].setFont(new Font("Verdana", Font.BOLD, 32));
                buttons[i][j].addActionListener(new ButtonListener());
                mainPanel.add(buttons[i][j]);
            }
        }
        player = "O";    
    }
    
    private class ButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            // Figure out which button was clicked, put in X or O, and change player
            JButton button = (JButton)(e.getSource());
            if (button.getText().equals(" "))
            {
                button.setText(player);
            }
        }
    }
	
	public void TicTacToe()
    {
        frame = new JFrame("Tic Tac Toe");
        mainPanel = new JPanel();
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {}
        initialize();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.setLocationByPlatform(true);
        frame.pack();
        frame.setVisible(true);
    }
	
}