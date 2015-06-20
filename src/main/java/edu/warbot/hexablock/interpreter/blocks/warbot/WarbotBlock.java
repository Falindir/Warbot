package edu.warbot.hexablock.interpreter.blocks.warbot;

import edu.warbot.brains.WarBrain;
import edu.warbot.hexablock.interpreter.blocks.Block;
import edu.warbot.hexablock.interpreter.blocks.type.TypeBlock;

/**
 * Created by jimmy on 20/06/15.
 */
public abstract class WarbotBlock extends Block {

    private WarBrain brain;

    /**
     * Constructeur d'un bloc
     *
     * @param type : le type du block
     * @since 0.1
     */
    public WarbotBlock(TypeBlock type) {
        super(type);
    }

    public WarBrain getBrain() {
        return brain;
    }

    public void setBrain(WarBrain brain) {
        this.brain = brain;
    }
}
