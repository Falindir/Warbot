package edu.warbot.scriptcore.scriptagent;

import edu.warbot.brains.WarBrain;

/**
 * Created by jimmy on 04/06/15.
 */
public interface BlockAgent extends ScriptAgent{

    @Override
    public String action();

    @Override
    public void link(WarBrain brain);

}
