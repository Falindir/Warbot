package edu.warbot.hexablock.interpreter.blocks.warbot.agent;

import edu.warbot.agents.enums.WarAgentType;
import edu.warbot.hexablock.interpreter.blocks.Block;
import edu.warbot.hexablock.interpreter.blocks.type.TypeBlock;

/**
 * Created by jimmy on 01/05/15.
 */
public class EntityBlock extends Block {

    private WarAgentType agentType;

    public EntityBlock(Block father, WarAgentType type) {
        super(TypeBlock.ENTITYBLOCK);
        setFather(father);
        setSameDepthIncremented(father);
        agentType = type;
    }

    public WarAgentType getEntity() {
        return agentType;
    }

    public void setEntity(WarAgentType entity) {
        this.agentType = entity;
    }
}
