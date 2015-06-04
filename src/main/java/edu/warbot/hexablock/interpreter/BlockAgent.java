package edu.warbot.hexablock.interpreter;

import edu.warbot.brains.WarBrain;

/**
 * Created by jimmy on 04/06/15.
 */
public interface BlockAgent {

    public String action();

    public void link(WarBrain brain);
}
