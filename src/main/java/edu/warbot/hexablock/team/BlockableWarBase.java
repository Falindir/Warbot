package edu.warbot.hexablock.team;

import edu.warbot.brains.brains.WarBaseBrain;
import edu.warbot.hexablock.interpreter.BlockAgent;
import edu.warbot.scriptcore.scriptagent.ScriptAgent;

/**
 * Created by jimmy on 04/06/15.
 */
public abstract class BlockableWarBase extends WarBaseBrain implements Blockable {

    private BlockAgent block;

    public BlockableWarBase() {
        super();
    }

    @Override
    public void activate() {
    }

    @Override
    public String action() {
        return getBlock().action();
    }

    public BlockAgent getBlock() {
        return block;
    }

    public void setScriptAgent(BlockAgent block) {

        this.block = block;
    }
}
