package edu.warbot.hexablock.interpreter.blocks.warbot.view;

import edu.warbot.agents.enums.WarAgentType;
import edu.warbot.agents.percepts.WarAgentPercept;
import edu.warbot.brains.WarBrain;
import edu.warbot.hexablock.interpreter.blocks.Block;
import edu.warbot.hexablock.interpreter.blocks.condition.DoBlock;
import edu.warbot.hexablock.interpreter.blocks.condition.WhenBlock;
import edu.warbot.hexablock.interpreter.blocks.type.TeamBlock;
import edu.warbot.hexablock.interpreter.blocks.type.TypeBlock;
import edu.warbot.hexablock.interpreter.blocks.warbot.WarbotBlock;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jimmy on 19/06/15.
 */
public class ViewBlock extends WarbotBlock {

    private WarAgentType agentType;

    private TeamBlock agentTeam;

    private List<WarAgentPercept> percept;

    /**
     * Constructeur d'un bloc
     *
     * @param type : le type du block
     * @since 0.1
     */
    public ViewBlock(WhenBlock father, WarAgentType type, TeamBlock team) {
        super(TypeBlock.VIEWBLOCK);
        setFather(father);
        setSameDepthIncremented(father);
        setBrain((WarBrain) getFather().getFather().getFather().getWrapper());
        agentType = type;
        agentTeam = team;
        percept = new ArrayList<WarAgentPercept>();
    }

    public WarAgentType getAgentType() {
        return agentType;
    }

    @Override
    public boolean eval() {
        if(agentType != null || agentTeam != null) {
            if(agentTeam.equals(TeamBlock.ALLY))
                percept.addAll(getBrain().getPerceptsAlliesByType(agentType));
            else if (agentTeam.equals(TeamBlock.ENEMY))
                percept.addAll(getBrain().getPerceptsEnemiesByType(agentType));
            else
                percept.addAll(getBrain().getPerceptsResources());
        }
        else
            percept.addAll(getBrain().getPercepts());

        return percept.size() > 0;
    }
}
