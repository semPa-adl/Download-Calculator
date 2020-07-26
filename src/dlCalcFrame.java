import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

public class dlCalcFrame extends JFrame
{

    //Instance the calculator
    dlCalculator calc = new dlCalculator();

    //Constructor
    public dlCalcFrame()
    {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(new Dimension(650, 500));
        setResizable(false);
        initComponents();
    }

    //initiate the components
    public void initComponents()
    {
        JPanel jpContainer = new JPanel();
        jpContainer.setLayout(new BoxLayout(jpContainer, BoxLayout.Y_AXIS));
        jpContainer.setBorder(new MatteBorder(10, 10, 10, 10, Color.GRAY));
        jpContainer.add(modeFrame());


        add(jpContainer);
        pack();

    }

    //Main
    public static void main(String[] args)
    {
        //gonna have to call the creator here
        try
        {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
            {
                if ("Windows".equals(info.getName()))
                { // feel free to change this as you see fit.
                    // Available: Nimbus, CDE, Metal, Windows...
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex)
        {
            Logger.getLogger(dlCalcFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        EventQueue.invokeLater(() -> new dlCalcFrame().setVisible(true));
    }

    private JPanel modeFrame()
    {
        JPanel jpModeFrame = new JPanel();
        jpModeFrame.setMaximumSize(new Dimension(300, 300));
        jpModeFrame.setLayout(new BoxLayout(jpModeFrame, BoxLayout.X_AXIS));
        Border border = BorderFactory.createTitledBorder("Mode");
        jpModeFrame.setBorder(border);


        JRadioButton gbButton = new JRadioButton();
        gbButton.setText("GB");
        JRadioButton mbButton = new JRadioButton();
        mbButton.setText("MB");
        mbButton.setSelected(true);
        jpModeFrame.add(mbButton);
        jpModeFrame.add(gbButton);

        ButtonGroup bg = new ButtonGroup();
        bg.add(gbButton);
        bg.add(mbButton);

        //Listeners for the buttons
        mbButton.addActionListener(this::jButtonMbMode);
        gbButton.addActionListener(this::jButtonGbMode);



        return jpModeFrame;
    }



    //Sets the mode to 0 for MB
    private void jButtonMbMode(ActionEvent e)
    {
        calc.setMode(0);
        System.out.println(calc.getMode());
    }

    //Sets the mode to 1 for GB
    private void jButtonGbMode(ActionEvent e)
    {
        calc.setMode(1);
        System.out.println(calc.getMode());
    }
}
