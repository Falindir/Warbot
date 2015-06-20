package edu.warbot.hexablock.interpreter.blocks.master;

import edu.warbot.agents.actions.constants.IdlerActions;
import edu.warbot.agents.enums.WarAgentType;
import edu.warbot.brains.WarBrain;
import edu.warbot.hexablock.interpreter.BlockAgent;
import edu.warbot.hexablock.interpreter.blocks.action.ActionBlock;
import edu.warbot.hexablock.interpreter.blocks.Block;
import edu.warbot.hexablock.interpreter.blocks.Blocks;
import edu.warbot.hexablock.interpreter.blocks.type.TypeBlock;

/**
 * Classe qui représente un bloc de type maître
 * Permet de représenter un Agent Warbot en Agent Block
 * @author Lopez Jimmy
 * @version 0.2
 */
public class MasterBlock extends Block implements BlockAgent {

    /**
     * Le nom de l'agent que représente le bloc. Ne peut être modifié.
     * @see edu.warbot.agents.enums.WarAgentType
     * @since 0.1
     */
    private WarAgentType type;

    /**
     * La liste des actions pour l'agent
     * @see edu.warbot.hexablock.interpreter.blocks.Blocks
     * @since 0.2
     */
    private Blocks<ActionBlock> listBlocks = new Blocks<ActionBlock>();

    /**
     * Le constructeur du bloc
     * @param type : le type de l'agent
     * @since 0.1
     */
    public MasterBlock(WarAgentType type) {
        super(TypeBlock.MASTERBLOCK);
        this.type = type;
        setDepth(0);
    }

    public WarAgentType getAgentType() {
        return type;
    }

    /**
     * Permet de récupérer le cerveau de l'agent correspondant au bloc
     * @return Un WarBrain
     * @since 0.2
     */
    public WarBrain getBrain() {
        return (WarBrain) getWrapper();
    }

    /**
     * Permet de récupérer la liste d'action du bloc
     * @return Un Blocks
     * @since 0.2
     */
    public Blocks<ActionBlock> getListBlocks() {
        return listBlocks;
    }

    /**
     * Permet d'ajouter un action au bloc
     * @param blocks : Une nouvelle action
     * @since 0.2
     */
    public void addBlocks(ActionBlock blocks) {
        if(!listBlocks.contains(blocks))
            listBlocks.add(blocks);
    }

    @Override
    public String action() {
        for(int i = 0; i < listBlocks.size(); i++) {
            String action = listBlocks.getElement(i).getAction();
            if(action != null)
                return action;
        }
        return IdlerActions.ACTION_IDLE;
    }

    @Override
    public void link(WarBrain brain) {
        setWrapper(brain);
    }
}
