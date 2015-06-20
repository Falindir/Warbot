package edu.warbot.hexablock;

import edu.warbot.agents.teams.ScriptedTeam;
import edu.warbot.brains.WarBrain;

import edu.warbot.hexablock.interpreter.BlockInterpreter;

import javax.swing.*;
import java.util.HashMap;

/**
 * Created by jimmy on 04/06/15.
 */
public class BlockTeam extends ScriptedTeam {

    protected BlockInterpreter interpreter;

    /**
     * @param teamName    Le nom d'une équipe
     * @param description La description d'une équipe
     * @param imageIcon   Le logo d'une équipe
     */
    public BlockTeam(String teamName, String description, ImageIcon imageIcon) {
        super(teamName, description, imageIcon);
    }

    public BlockInterpreter getInterpreterBlock() {
        return interpreter;
    }

    public void setInterpreter(BlockInterpreter interpreter) {
        this.interpreter = interpreter;
    }
}
