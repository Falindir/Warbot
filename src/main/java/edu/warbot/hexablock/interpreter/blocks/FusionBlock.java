package edu.warbot.hexablock.interpreter.blocks;

/**
 * Created by jimmy on 30/04/15.
 */
public class FusionBlock extends Block {

    private Block block1;
    private Block block2;

    public FusionBlock(Block b1, Block b2) {
        super(TypeBlock.FUSIONBLOCK);
        this.block1 = b1;
        this.block2 = b2;
    }

    public Block getBlock1() {
        return block1;
    }

    public Block getBlock2() {
        return block2;
    }
}
