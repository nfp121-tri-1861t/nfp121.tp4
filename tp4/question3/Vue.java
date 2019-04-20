package question3;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import java.util.Observable;
import java.util.Observer;

/**
 * DÃ©crivez votre classe Controleur ici.
 * 
 * @author (votre nom)
 * @version (un numÃ©ro de version ou une date)
 */
public class Vue extends JPanel implements Observer {

    private JLabel etatPile;
    private PileModele<Integer> pile;
    /**La Vue s'inscrit auprès du modèle comme observateur.*/
    public Vue(PileModele<Integer> pile) {
        super();
        this.pile = pile;
        this.etatPile = new JLabel("entrez des nombres entiers");
        setLayout(new FlowLayout(FlowLayout.LEFT));
        add(etatPile);
        setBackground(Color.green);
        
        // inscription auprès du modèle comme observateur
        pile.addObserver(this);
    }
    /**Mise à jour de la vue*/
    public void update(Observable obs, Object arg) {
        etatPile.setText(pile.toString()); // ou obs.toString()
    }

}