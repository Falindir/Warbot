package edu.warbot.hexablock.interpreter.blocks.condition;

import edu.warbot.hexablock.interpreter.blocks.Block;
import edu.warbot.hexablock.interpreter.blocks.Blocks;
import edu.warbot.hexablock.interpreter.blocks.type.TypeBlock;
import edu.warbot.hexablock.interpreter.blocks.action.ActionBlock;
import edu.warbot.hexablock.interpreter.blocks.warbot.action.BlockAction;
import edu.warbot.hexablock.interpreter.blocks.warbot.create.CreateBlock;

/**
 * Classe qui représente un bloc de type do
 * @author Lopez Jimmy
 * @version 0.2
 */
public class DoBlock extends Block {

    /**
     * La liste des blocs du bloc
     *
     * @see edu.warbot.hexablock.interpreter.blocks.Blocks
     * @since 0.2
     */
    private Blocks<Block> listBLock = new Blocks<Block>();

    /**
     * Le constructeur du bloc
     *
     * @param action : le père du bloc
     * @since 0.2
     */
    public DoBlock(ActionBlock action) {
        super(TypeBlock.DOBLOCK);
        setFather(action);
        setSameDepthIncremented(action);
    }


    public String getAction() {

        for (int i = 0; i < listBLock.size(); i++) {
            listBLock.getElement(i).eval();

            if (listBLock.getLastElement() instanceof BlockAction) {

                return ((BlockAction) listBLock.getLastElement()).getAction();

            }

            if (listBLock.getLastElement() instanceof CreateBlock)
                return ((CreateBlock) listBLock.getLastElement()).getAction();

        }

        return null;
    }

    public void add(Block block) {
        if(!listBLock.contains(block)) {
            listBLock.add(block);
            block.setFather(this);
            block.setSameDepthIncremented(this);
        }
    }

    public void remove (Block block) {
        if(listBLock.contains(block))
            listBLock.remove(block);
    }


}
