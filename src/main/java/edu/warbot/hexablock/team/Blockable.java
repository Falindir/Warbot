package edu.warbot.hexablock.team;

import edu.warbot.hexablock.interpreter.BlockAgent;

/**
 * Created by jimmy on 04/06/15.
 */
public interface Blockable {
    public BlockAgent getBlockAgent();

    public void setBlockAgent(BlockAgent agent);
}
