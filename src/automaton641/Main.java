package automaton641;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Main {

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Automaton");
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Automaton automaton = new Automaton(64, 64, 256, 512);
        Canvas mainComponent = new Canvas(automaton, 12);
        jFrame.add(mainComponent);
        jFrame.pack();
        jFrame.setLocationRelativeTo(null);
        jFrame.setResizable(false);
        jFrame.setVisible(true);
        while (true) {
        	mainComponent.drawAutomaton();
        	automaton.iterate();
        }
    }
}
