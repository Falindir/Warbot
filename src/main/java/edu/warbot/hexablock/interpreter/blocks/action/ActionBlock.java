package edu.warbot.hexablock.interpreter.blocks.action;

import edu.warbot.hexablock.interpreter.blocks.*;
import edu.warbot.hexablock.interpreter.blocks.condition.DoBlock;
import edu.warbot.hexablock.interpreter.blocks.condition.WhenBlock;
import edu.warbot.hexablock.interpreter.blocks.master.MasterBlock;
import edu.warbot.hexablock.interpreter.blocks.type.TypeBlock;

/**
 * Classe qui représente un bloc de type action
 * Permet de représenter un ensemble de bloc qui permettent de réaliser une action
 * @author Lopez Jimmy
 * @version 0.2
 */
public class ActionBlock extends Block {

    /**
     * Le bloc when de l'action. Peut être modifié.
     * @see edu.warbot.hexablock.interpreter.blocks.condition.WhenBlock
     * @since 0.1
     */
    private WhenBlock whenB;

    /**
     * Le bloc do de l'action. Peut être modifié.
     * @see edu.warbot.hexablock.interpreter.blocks.condition.DoBlock
     * @since 0.1
     */
    private DoBlock doB;

    /**
     * Le constructeur du bloc
     * @param father : le père du bloc
     * @since 0.2
     */
    public ActionBlock(MasterBlock father) {
        super(TypeBlock.ACTIONBLOCK);
        setFather(father);
        setSameDepthIncremented(this);
        whenB = new WhenBlock(this);
        doB = new DoBlock(this);
    }

    /**
     * Permet de récupérer le bloc when du bloc
     * @return Un WhenBlock
     * @since 0.1
     */
    public WhenBlock getWhenB() {
        return whenB;
    }

    /**
     * Permet de modifier le bloc when du bloc
     * @param whenB : le nouveau bloc when
     * @since 0.1
     */
    public void setWhenB(WhenBlock whenB) {
        this.whenB = whenB;
    }

    /**
     * Permet de récupérer le bloc do du bloc
     * @return Un DoBlock
     * @since 0.1
     */
    public DoBlock getDoB() {
        return doB;
    }

    /**
     * Permet de modifier le bloc do du bloc
     * @param doB : le nouveau bloc do
     * @since 0.1
     */
    public void setDoB(DoBlock doB) {
        this.doB = doB;
    }

    /**
     * Permet de récupérer l'action à réaliser par l'agent
     * @return Un String
     * @since 0.2
     */
    public String getAction() {
        if(whenB.getConditionValue())
            return doB.getAction();
        return null;
    }
}
