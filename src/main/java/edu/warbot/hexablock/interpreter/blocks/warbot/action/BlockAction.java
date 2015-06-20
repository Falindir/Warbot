package edu.warbot.hexablock.interpreter.blocks.warbot.action;

import edu.warbot.hexablock.interpreter.blocks.Block;
import edu.warbot.hexablock.interpreter.blocks.type.TypeBlock;

/**
 * Created by jimmy on 19/06/15.
 */
public abstract class BlockAction extends Block {

    /**
     * Constructeur d'un bloc
     *
     * @param type : le type du block
     * @since 0.1
     */
    public BlockAction(TypeBlock type) {
        super(type);
    }

    public abstract String getAction();
}
