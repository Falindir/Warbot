package edu.warbot.hexablock.interpreter.blocks;

import java.util.Collections;
import java.util.LinkedList;

/**
 * Permet de représenter une liste de bloc, paramétré par un type
 * @param <T> : le type de bloc contenu dans la liste de bloc
 * @author Lopez Jimmy
 * @version 0.2
 */
public class Blocks<T extends Block> extends Block {

    /**
     * La liste de bloc
     * @see java.util.LinkedList
     * @since 0.1
     */
    private LinkedList<T> blocks = new LinkedList<T>();

    /**
     * Constructeur de la liste de bloc
     * @since 0.1
     */
    public Blocks() {
        super(TypeBlock.BLOCKS);
    }

    /**
     * Permet d'ajouter un nouveau block à la liste de bloc
     * @param block : le bloc à ajouter
     * @since 0.2
     */
    public void add(T block) {
        if(!blocks.contains(block)) {
            Block o = blocks.getLast();
            blocks.add(block);
            block.setSameDepthIncremented(o);
        }
    }

    /**
     * Permet d'échanger la place de deux block dans la liste de block
     * @param b1 : le premier bloc
     * @param b2 : le deuxième bloc
     * @since 0.2
     */
    public void swap(T b1, T b2) {
        if(blocks.contains(b1) && blocks.contains(b2)) {
            int depthB1 = b1.getDepth();
            Collections.swap(blocks, blocks.indexOf(b1), blocks.indexOf(b2));
            b1.setDepth(b2.getDepth());
            b2.setDepth(depthB1);
        }
    }

    /**
     * Permet de supprimer un bloc de la list
     * @param block : le block à supprimer de la list de bloc
     * @since 0.1
     */
    public void remove(T block) {
        blocks.remove(block);
    }
}
