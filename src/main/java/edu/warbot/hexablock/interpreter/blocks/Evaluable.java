package edu.warbot.hexablock.interpreter.blocks;

/**
 * Permet de rendre évaluable d'un objet
 * @author Lopez Jimmy
 * @version 0.2
 */
public interface Evaluable {

    /**
     * Permet d'évaluer un objet qui implémente cette interface
     * @return
     */
    public boolean eval();
}
