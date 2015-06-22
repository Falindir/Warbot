package edu.warbot.hexablock.interpreter.blocks.warbot.action;

import edu.warbot.agents.actions.constants.ControllableActions;
import edu.warbot.agents.actions.constants.PickerActions;
import edu.warbot.hexablock.interpreter.blocks.condition.DoBlock;
import edu.warbot.hexablock.interpreter.blocks.type.TypeBlock;

/**
 * Created by jimmy on 22/06/15.
 */
public class EatActionBlock extends BlockAction {

    /**
     * Constructeur d'un bloc
     *
     * @param father : le type du block
     * @since 0.1
     */
    public EatActionBlock(DoBlock father) {
        super(TypeBlock.EATACTIONBLOCK);
        setFather(father);
        setSameDepthIncremented(father);
    }

    @Override
    public String getAction() {
        return ControllableActions.ACTION_EAT;
    }

}
