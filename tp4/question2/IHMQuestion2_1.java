package question2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JButton;

public class IHMQuestion2_1 extends JApplet {
private JButton boutonA = new JButton("A");
    private JButton boutonB = new JButton("B");
    private JButton boutonC = new JButton("C");
    private boolean testSouris = false; // ne pas modifier cette déclaration, 
                                        // installer le paramètre de cette applette Nom : mouse Valeur : oui,   
                                        // sa prise en compte est à la ligne 37-39

    private TextArea contenu = new TextArea(60, 80);

    /**
     * Appelée par le navigateur ou le visualiseur afin de signaler à l'Applet
     * qu'il est maintenant pris en charge par le système. Il est garanti que
     * ceci précédera le premier appel de la méthode start.
     */
    public void init() {
        JRootPane rootPane = this.getRootPane();
        rootPane.putClientProperty("defeatSystemEventQueueCheck", Boolean.TRUE);
        try {
            testSouris = getParameter("mouse").equals("oui"); // le paramètre issu de la page HTML
        } catch (Exception e) {
        }
        JPanel enHaut = new JPanel();
        enHaut.add(boutonA);
        enHaut.add(boutonB);
        enHaut.add(boutonC);
        setLayout(new BorderLayout(5, 5));
        add("North", enHaut);
        add("Center", contenu); // contenu sera transmis aux observateurs, voir
                                // la description des constructeurs
        if (testSouris)
            enHaut.setBackground(Color.magenta);
        else
            enHaut.setBackground(Color.blue);

        // le bouton A a 3 observateurs jbo1, jbo2 et jbo3
        boutonA.addActionListener(new JButtonObserver("jbo1", contenu));
        boutonA.addActionListener(new JButtonObserver("jbo2", contenu));
        boutonA.addActionListener(new JButtonObserver("jbo3", contenu));
        // le bouton B a 2 observateurs jbo1 et jbo2
        boutonB.addActionListener(new JButtonObserver("jbo1", contenu));
        boutonB.addActionListener(new JButtonObserver("jbo2", contenu));

        // le bouton C a 1 observateur jbo1
        boutonC.addActionListener(new JButtonObserver("jbo1", contenu));

        if (testSouris) { // à compléter en q2.2
            // le bouton A a 1 observateur jmo1
            boutonA.addMouseListener(new JMouseObserver("jmo1", contenu));
            // le bouton B a 1 observateur jmo2
            boutonB.addMouseListener(new JMouseObserver("jmo2", contenu));
            // le bouton C a 1 observateur jmo3
            boutonC.addMouseListener(new JMouseObserver("jmo3", contenu)); 
        }
    }
}