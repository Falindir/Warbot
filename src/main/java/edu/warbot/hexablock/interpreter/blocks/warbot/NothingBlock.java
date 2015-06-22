package edu.warbot.hexablock.interpreter.blocks.warbot;

import edu.warbot.hexablock.interpreter.blocks.Block;
import edu.warbot.hexablock.interpreter.blocks.type.TypeBlock;

/**
 * Created by jimmy on 22/06/15.
 */
public class NothingBlock extends WarbotBlock {

    public NothingBlock(Block father) {
        super(TypeBlock.NOTHINGBLOCK);
        setFather(father);
        setSameDepthIncremented(father);
    }

    @Override
    public boolean eval() {
        return true;
    }

}
