package edu.warbot.hexablock.interpreter.blocks.operator;

import edu.warbot.hexablock.interpreter.blocks.Block;
import edu.warbot.hexablock.interpreter.blocks.type.TypeBlock;

/**
 * Created by jimmy on 29/05/15.
 */
public class NotBlock extends Block implements BlockOperator {

    private Block block;

    public NotBlock(Block block) {
        super(TypeBlock.NOTBLOCK);
        this.block = block;
    }

    @Override
    public boolean eval() {
        return block != null && !block.eval();
    }
}
