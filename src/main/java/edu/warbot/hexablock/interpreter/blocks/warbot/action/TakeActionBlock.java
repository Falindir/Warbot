package edu.warbot.hexablock.interpreter.blocks.warbot.action;

import edu.warbot.agents.actions.constants.AgressiveActions;
import edu.warbot.agents.actions.constants.PickerActions;
import edu.warbot.hexablock.interpreter.blocks.condition.DoBlock;
import edu.warbot.hexablock.interpreter.blocks.type.TypeBlock;

/**
 * Created by jimmy on 22/06/15.
 */
public class TakeActionBlock extends BlockAction {

    /**
     * Constructeur d'un bloc
     *
     * @param father : le type du block
     * @since 0.1
     */
    public TakeActionBlock(DoBlock father) {
        super(TypeBlock.TAKEACTIONBLOCK);
        setFather(father);
        setSameDepthIncremented(father);
    }

    @Override
    public String getAction() {
        return PickerActions.ACTION_TAKE;
    }

}