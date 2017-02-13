import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TicTacToe
{
    private JFrame frame;
    private JPanel mainPanel;
    private JButton[][] buttons;
    private String player;  // keeps track of if it is X's or O's turn

    public TicTacToe()
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

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TicTacToe();
            }
        });
    }
    
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
        player = "X";    
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
                player = player.equals("O") ? "X" : "O";
            }
        }
    }
}