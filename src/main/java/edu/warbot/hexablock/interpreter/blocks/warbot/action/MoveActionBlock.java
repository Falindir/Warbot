package edu.warbot.hexablock.interpreter.blocks.warbot.action;

import edu.warbot.agents.actions.constants.MovableActions;
import edu.warbot.hexablock.interpreter.blocks.Block;
import edu.warbot.hexablock.interpreter.blocks.condition.DoBlock;
import edu.warbot.hexablock.interpreter.blocks.type.TypeBlock;

/**
 * Created by jimmy on 19/06/15.
 */
public class MoveActionBlock extends BlockAction {

    /**
     * Constructeur d'un bloc
     *
     * @param father : le type du block
     * @since 0.1
     */
    public MoveActionBlock(DoBlock father) {
        super(TypeBlock.MOVEACTIONBLOCK);
        setFather(father);
        setSameDepthIncremented(father);
    }

    @Override
    public String getAction() {
        return MovableActions.ACTION_MOVE;
    }

}
