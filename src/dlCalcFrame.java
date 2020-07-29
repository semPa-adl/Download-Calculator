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
    static JLabel displayResult;
    static JTextField spdInputField;
    static JTextField szeInputField;


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
        jpContainer.add(Box.createRigidArea(new Dimension(0, 10)));
        jpContainer.add(calcPanel());
        jpContainer.add(Box.createRigidArea(new Dimension(0, 10)));
        jpContainer.add(resultPanel());

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

    //JPanel to hold the mode radio buttons, only one can be selected at once.
    //Switching between them changes the mode variable for the dlCalculator instance
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

    //JPanel to hold the input fields
    private JPanel inputPnl()
    {
        JPanel jpInputPnl = new JPanel();
        jpInputPnl.setMaximumSize(new Dimension(300, 300));
        jpInputPnl.setLayout(new GridLayout(0,3));
        spdLbl = new JLabel("Speed (MB/s): ");
        spdInputField = new JTextField("0");
        spdInputField.setHorizontalAlignment(SwingConstants.RIGHT);
        Border border = BorderFactory.createTitledBorder("Input");
        jpInputPnl.setBorder(border);

        jpInputPnl.add(spdLbl);
        jpInputPnl.add(Box.createRigidArea(new Dimension(80, 0)));
        jpInputPnl.add(spdInputField);

        szeLbl = new JLabel("File Size: ");
        szeInputField = new JTextField("0");
        szeInputField.setHorizontalAlignment(SwingConstants.RIGHT);

        jpInputPnl.add(szeLbl);
        jpInputPnl.add(Box.createRigidArea(new Dimension(80, 0)));
        jpInputPnl.add(szeInputField);

        return jpInputPnl;
    }

    //JPanel to hold the calculate button. Pressing this button will perform the calculation by calling the
    //calculate function using the values input into the fields.
    private JPanel calcPanel()
    {
        JPanel cbPanel = new JPanel();

        JButton calcButton = new JButton("Calculate");
        calcButton.addActionListener(this::jButtonCalculate);
        cbPanel.add(calcButton);

        return cbPanel;
    }

    private JPanel resultPanel()
    {
        JPanel resPanel = new JPanel();

        displayResult = new JLabel("Download will take ");
        resPanel.add(displayResult);

        return resPanel;
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

    //Listener for the calculate button
    private void jButtonCalculate(ActionEvent e)
    {
        double speed = Double.parseDouble(spdInputField.getText());
        double size = Double.parseDouble(szeInputField.getText());
        int timeSecs;

        switch (calc.getMode())
        {
            case 0:
                timeSecs = calc.mbCalc(size, speed);
                displayResult.setText("Download will take " + timeCalc.convert(timeSecs));
                break;
            case 1:
                timeSecs = calc.gbCalc(size, speed);
                displayResult.setText("Download will take " + timeCalc.convert(timeSecs));
                break;
            default:
                break;
        }
    }
}
