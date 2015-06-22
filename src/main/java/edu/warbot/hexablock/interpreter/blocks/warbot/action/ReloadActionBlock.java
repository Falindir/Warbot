package edu.warbot.hexablock.interpreter.blocks.warbot.action;

import edu.warbot.agents.actions.constants.AgressiveActions;
import edu.warbot.hexablock.interpreter.blocks.condition.DoBlock;
import edu.warbot.hexablock.interpreter.blocks.type.TypeBlock;

/**
 * Created by jimmy on 22/06/15.
 */
public class ReloadActionBlock extends BlockAction {

    /**
     * Constructeur d'un bloc
     *
     * @param father : le type du block
     * @since 0.1
     */
    public ReloadActionBlock(DoBlock father) {
        super(TypeBlock.RELOADACTIONBLOCK);
        setFather(father);
        setSameDepthIncremented(father);
    }

    @Override
    public String getAction() {
        return AgressiveActions.ACTION_RELOAD;
    }

}