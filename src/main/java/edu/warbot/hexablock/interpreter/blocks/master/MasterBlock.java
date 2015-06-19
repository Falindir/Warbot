package edu.warbot.hexablock.interpreter.blocks.master;

import edu.warbot.agents.actions.constants.IdlerActions;
import edu.warbot.brains.WarBrain;
import edu.warbot.hexablock.interpreter.BlockAgent;
import edu.warbot.hexablock.interpreter.blocks.ActionBlock;
import edu.warbot.hexablock.interpreter.blocks.Block;
import edu.warbot.hexablock.interpreter.blocks.Blocks;
import edu.warbot.hexablock.interpreter.blocks.TypeBlock;

/**
 * Classe qui représente un bloc de type maître
 * Permet de représenter un Agent Warbot en Agent Block
 * @author Lopez Jimmy
 * @version 0.2
 */
public class MasterBlock extends Block implements BlockAgent {

    /**
     * Le nom de l'agent que représente le bloc. Ne peut être modifié.
     * @see java.lang.String
     * @since 0.1
     */
    private String name;

    /**
     * Le cerveau de l'agent Warbot. Peut être modifié.
     * @see edu.warbot.brains.WarBrain
     * @since 0.2
     */
    private WarBrain brain;

    /**
     * La liste des actions pour l'agent
     * @see edu.warbot.hexablock.interpreter.blocks.Blocks
     * @since 0.2
     */
    private Blocks<ActionBlock> listBlocks = new Blocks<ActionBlock>();

    /**
     *
     * @param name : le nom de l'agent
     * @since 0.1
     */
    public MasterBlock(String name) {
        super(TypeBlock.MASTERBLOCK);
        this.name = name;
        setDepth(0);
    }

    /**
     * Permet de récupérer le nom de l'agent
     * @return Un String
     * @since 0.1
     */
    public String getName(){
        return name;
    }

    /**
     * Permet de récupérer le cerveau de l'agent correspondant au bloc
     * @return Un WarBrain
     * @since 0.2
     */
    public WarBrain getBrain() {
        return brain;
    }

    /**
     * Permet de modifier le cerveau de l'agent correspondant au bloc
     * @param brain : le nouveau cerveau de l'agent
     * @since 0.2
     */
    public void setBrain(WarBrain brain) {
        this.brain = brain;
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
        this.brain = brain;
    }
}
