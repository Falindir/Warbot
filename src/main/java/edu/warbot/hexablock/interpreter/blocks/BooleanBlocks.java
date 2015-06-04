package edu.warbot.hexablock.interpreter.blocks;

/**
 * Created by jimmy on 01/05/15.
 */
public class BooleanBlocks extends Blocks implements BlockBoolean {

    public BooleanBlocks() {

    }

    @Override
    public boolean getValue() {
        return false;
    }
}
