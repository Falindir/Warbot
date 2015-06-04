package edu.warbot.hexablock.interpreter.blocks;

/**
 * Created by jimmy on 01/05/15.
 */
public interface BlockBoolean {

    public boolean getValue();

    public boolean isRealBooleanBlock();

    public void setSituation(boolean value);
}
