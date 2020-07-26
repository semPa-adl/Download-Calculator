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

    static JLabel spdLbl;
    static JLabel szeLbl;

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
        jpContainer.add(Box.createRigidArea(new Dimension(0, 10)));
        jpContainer.add(inputPnl());


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

        jpModeFrame.add(Box.createRigidArea(new Dimension(80, 0)));

        ButtonGroup bg = new ButtonGroup();
        bg.add(gbButton);
        bg.add(mbButton);

        //Listeners for the buttons
        mbButton.addActionListener(this::jButtonMbMode);
        gbButton.addActionListener(this::jButtonGbMode);

        return jpModeFrame;
    }

    private JPanel inputPnl()
    {
        JPanel jpInputPnl = new JPanel();
        jpInputPnl.setMaximumSize(new Dimension(300, 300));
        jpInputPnl.setLayout(new GridLayout(0,3));
        spdLbl = new JLabel("Speed (MB/s): ");
        JTextField spdInputField = new JTextField();
        Border border = BorderFactory.createTitledBorder("Input");
        jpInputPnl.setBorder(border);

        jpInputPnl.add(spdLbl);
        jpInputPnl.add(Box.createRigidArea(new Dimension(80, 0)));
        jpInputPnl.add(spdInputField);

        szeLbl = new JLabel("File Size: ");
        JTextField szeInputField = new JTextField();

        jpInputPnl.add(szeLbl);
        jpInputPnl.add(Box.createRigidArea(new Dimension(80, 0)));
        jpInputPnl.add(szeInputField);

        return jpInputPnl;
    }


    //Sets the mode to 0 for MB
    private void jButtonMbMode(ActionEvent e)
    {
        calc.setMode(0);
    }

    //Sets the mode to 1 for GB
    private void jButtonGbMode(ActionEvent e)
    {
        calc.setMode(1);
    }
}
