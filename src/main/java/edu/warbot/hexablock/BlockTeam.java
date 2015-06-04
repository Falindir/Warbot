package edu.warbot.hexablock;

import edu.warbot.agents.ControllableWarAgent;
import edu.warbot.agents.WarAgent;
import edu.warbot.agents.WarBuilding;
import edu.warbot.agents.WarProjectile;
import edu.warbot.agents.enums.WarAgentType;
import edu.warbot.brains.WarBrain;
import edu.warbot.game.Team;
import edu.warbot.hexablock.interpreter.BlockInterpreter;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by jimmy on 04/06/15.
 */
public class BlockTeam extends Team {

    protected BlockInterpreter interpreter;

    public BlockTeam (String name, HashMap<String, Class<? extends WarBrain>> brainControllers) {
        super(name);
        for (String agentName : brainControllers.keySet())
            addBrainControllerClassForAgent(agentName, brainControllers.get(agentName));
    }

    public BlockTeam(String nom, Color color, ImageIcon logo,
                        String description,
                        ArrayList<ControllableWarAgent> controllableAgents,
                        ArrayList<WarProjectile> projectiles,
                        ArrayList<WarBuilding> buildings,
                        HashMap<WarAgentType, Integer> nbUnitsLeft,
                        HashMap<String, Class<? extends WarBrain>> brainControllers,
                        ArrayList<WarAgent> dyingAgents) {
        super(nom, color, logo, description, controllableAgents, projectiles,
                buildings, brainControllers, nbUnitsLeft, dyingAgents);
    }

    @Override
    public Team duplicate(String name) {
        BlockTeam blockteam = new BlockTeam(name,
                ((this.getColor() == null) ? null : (new Color(this.getColor().getRGB()))),
                this.getImage(),
                this.getDescription(),
                new ArrayList<>(this.getControllableAgents()),
                new ArrayList<>(this.getProjectiles()),
                new ArrayList<>(this.getBuildings()),
                new HashMap<>(this.getAllNbUnitsLeft()),
                new HashMap<>(this.getAllBrainControllers()),
                new ArrayList<>(this.getDyingAgents())
        );

        blockteam.setInterpreter(this.getInterpreter());

        return blockteam;

    }

    public BlockInterpreter getInterpreter() {
        return interpreter;
    }

    public void setInterpreter(BlockInterpreter interpreter) {
        this.interpreter = interpreter;
    }
}
