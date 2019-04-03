package org.macalester.edu.comp124.hw5;

import comp124graphics.CanvasWindow;
import comp124graphics.Line;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;

/**
 * The window and user interface for drawing gestures and automatically recognizing them
 * Created by bjackson on 10/29/2016.
 */
public class GestureWindow extends CanvasWindow implements ActionListener, KeyListener, MouseMotionListener, MouseListener {

    private Recognizer recognizer;
    private IOManager ioManager;
    private JButton addTemplateButton;
    private JTextField templateNameField;
    private JLabel matchLabel;
    private List<Point> path;


    public GestureWindow() {
        super("Gesture Recognizer", 600, 600);
        recognizer = new Recognizer();
        path = new ArrayList<>();
        ioManager = new IOManager();
        setupUI();
    }

    /**
     * Create the user interface
     */
    private void setupUI() {
        setLayout(new BorderLayout());
        matchLabel = new JLabel("Match: ");
        matchLabel.setFont(new Font("SanSerif", Font.PLAIN, 24));
        add(matchLabel, BorderLayout.NORTH);
        JPanel panel = new JPanel();
        templateNameField = new JTextField(10);
        panel.add(templateNameField);
        addTemplateButton = new JButton("Add Template");
        addTemplateButton.addActionListener(this);
        panel.add(addTemplateButton);
        add(panel, BorderLayout.SOUTH);
        templateNameField.addKeyListener(this);
        addMouseListener(this);
        addMouseMotionListener(this);
        revalidate();
    }

    /**
     * Handle what happens when the add template button is pressed. This method adds the points stored in path as a template
     * with the name from the templateNameField textbox. If no text has been entered then the template is named with "no name gesture"
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addTemplateButton) {
            String name = templateNameField.getText();
            if (name.isEmpty()) {
                name = "no name gesture";
            }
            recognizer.addTemplate(name, path); // Add the points stored in the path as a template
        }
    }

    /**
     * Key listener used to save and load gestures for debugging and to write tests.
     *
     * @param e
     */
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_L && (e.getModifiers() & KeyEvent.CTRL_MASK) != 0){
            String name = templateNameField.getText();
            if (name.isEmpty()){
                name = "gesture";
            }
            List<Point> points = ioManager.loadGesture(name+".xml");
            if (points != null){
                recognizer.addTemplate(name, points);
                System.out.println("Loaded "+name);
            }
        }
        else if (e.getKeyCode() == KeyEvent.VK_S && (e.getModifiers() & KeyEvent.CTRL_MASK) != 0){
            String name = templateNameField.getText();
            if (name.isEmpty()){
                name = "gesture";
            }
            ioManager.saveGesture(path, name, name+".xml");
            System.out.println("Saved "+name);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public static void main(String[] args) {
        GestureWindow window = new GestureWindow();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        path.clear();
        removeAll();
        Point point=new Point(e.getX(), e.getY());
        path.add(point);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Point previousPoint=path.get(path.size()-1);
        Line line=new Line(previousPoint.getX(), previousPoint.getY(), e.getX(), e.getY());
        add(line);
        previousPoint=new Point(e.getX(), e.getY());
        path.add(previousPoint);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Match match=recognizer.recognize(path);
        if(match!=null && match.getTemplate()!=null){
            matchLabel.setText(match.getTemplate().getName()+" "+match.getScore());
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
