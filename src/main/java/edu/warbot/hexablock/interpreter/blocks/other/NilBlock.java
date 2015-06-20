package edu.warbot.hexablock.interpreter.blocks.other;

import edu.warbot.hexablock.interpreter.blocks.Block;
import edu.warbot.hexablock.interpreter.blocks.type.TypeBlock;

/**
 * Created by jimmy on 01/05/15.
 */
public class NilBlock extends Block {

    public NilBlock() {
        super(TypeBlock.NILBLOCK);
    }

    @Override
    public boolean eval() {
        return false;
    }
}
