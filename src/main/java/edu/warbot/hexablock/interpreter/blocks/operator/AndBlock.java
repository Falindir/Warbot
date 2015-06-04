package edu.warbot.hexablock.interpreter.blocks.operator;


import edu.warbot.hexablock.interpreter.blocks.BlockBoolean;
import edu.warbot.hexablock.interpreter.blocks.BlockOperator;
import edu.warbot.hexablock.interpreter.blocks.Block;
import edu.warbot.hexablock.interpreter.blocks.TypeBlock;

/**
 * Created by jimmy on 30/04/15.
 */
public class AndBlock extends Block implements BlockOperator {

    private BlockBoolean b1;
    private BlockBoolean b2;

    public AndBlock(BlockBoolean b1, BlockBoolean b2) {
        super(TypeBlock.ANDBLOCK);
        this.b1 = b1;
        this.b2 = b2;
    }

    public BlockBoolean getB1() {
        return b1;
    }

    public BlockBoolean getB2() {
        return b2;
    }

    @Override
    public boolean getValue() {
        if(haveBlocks())
            return b1.getValue() && b2.getValue();
        else
            return false;
    }

    @Override
    public boolean haveBlocks() {
        return b1 != null && b2 != null;
    }
}
