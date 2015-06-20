package edu.warbot.hexablock.interpreter.blocks.warbot.create;

import edu.warbot.agents.actions.constants.BuilderActions;
import edu.warbot.agents.actions.constants.CreatorActions;
import edu.warbot.agents.agents.WarBase;
import edu.warbot.agents.enums.WarAgentType;
import edu.warbot.brains.WarBrain;
import edu.warbot.brains.brains.WarBaseBrain;
import edu.warbot.brains.brains.WarEngineerBrain;
import edu.warbot.hexablock.interpreter.blocks.condition.DoBlock;
import edu.warbot.hexablock.interpreter.blocks.master.MasterBlock;
import edu.warbot.hexablock.interpreter.blocks.type.TypeBlock;
import edu.warbot.hexablock.interpreter.blocks.warbot.WarbotBlock;
import edu.warbot.hexablock.interpreter.blocks.warbot.action.BlockAction;

/**
 * Created by jimmy on 20/06/15.
 */
public class CreateBlock extends WarbotBlock {

    private WarAgentType agentType;

    /**
     * Constructeur d'un bloc
     *
     * @param type : le type du block
     * @since 0.1
     */
    public CreateBlock(DoBlock father, WarAgentType type) {
        super(TypeBlock.CREATEBLOCK);
        setFather(father);
        setSameDepthIncremented(father);
        setBrain((WarBrain) getFather().getFather().getFather().getWrapper());
        agentType = type;
    }

    public String getAction() {
        WarAgentType masterType = ((MasterBlock) getFather().getFather().getFather()).getAgentType();
        if(agentType != null){
            if(masterType.equals(WarAgentType.WarBase) && ((WarBaseBrain) getBrain()).isAbleToCreate(agentType)) {
                ((WarBaseBrain) getBrain()).setNextAgentToCreate(agentType);
                return CreatorActions.ACTION_CREATE;
            }
            else if(masterType.equals(WarAgentType.WarEngineer) && ((WarEngineerBrain) getBrain()).isAbleToCreate(agentType)) {
                if(agentType.equals(WarAgentType.Wall)) {
                    ((WarEngineerBrain) getBrain()).setNextBuildingToBuild(agentType);
                    return BuilderActions.ACTION_BUILD;
                }
                else {
                    ((WarEngineerBrain) getBrain()).setNextAgentToCreate(agentType);
                    return CreatorActions.ACTION_CREATE;
                }
            }
        }
        return null;
    }
}
