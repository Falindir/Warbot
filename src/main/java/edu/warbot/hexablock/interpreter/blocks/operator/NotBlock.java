package edu.warbot.hexablock.interpreter.blocks.operator;


import edu.warbot.hexablock.interpreter.blocks.BlockBoolean;
import edu.warbot.hexablock.interpreter.blocks.BlockOperator;
import edu.warbot.hexablock.interpreter.blocks.Block;
import edu.warbot.hexablock.interpreter.blocks.TypeBlock;

/**
 * Created by jimmy on 29/05/15.
 */
public class NotBlock extends Block implements BlockOperator {

    private BlockBoolean block;

    public NotBlock(BlockBoolean block) {
        super(TypeBlock.NOTBLOCK);
        this.block = block;
    }

    @Override
    public boolean getValue() {
        if(haveBlocks())
            return !block.getValue();
        else
            return false;
    }

    @Override
    public boolean haveBlocks() {
        return block != null;
    }
}
