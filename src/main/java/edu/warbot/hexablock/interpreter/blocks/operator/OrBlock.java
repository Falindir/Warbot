package edu.warbot.hexablock.interpreter.blocks.operator;

import edu.warbot.hexablock.interpreter.blocks.Block;
import edu.warbot.hexablock.interpreter.blocks.type.TypeBlock;

/**
 * Created by jimmy on 30/04/15.
 */
public class OrBlock extends Block implements BlockOperator {

    private Block b1;
    private Block b2;

    public OrBlock(Block b1, Block b2) {
        super(TypeBlock.ORBLOCK);
        this.b1 = b1;
        this.b2 = b2;
    }

    public Block getB1() {
        return b1;
    }

    public Block getB2() {
        return b2;
    }

    @Override
    public boolean eval() {
        return b1 != null && b2 != null && (b1.eval() || b2.eval());
    }
}
