package edu.warbot.hexablock.interpreter.blocks.condition;

import edu.warbot.hexablock.interpreter.blocks.Block;
import edu.warbot.hexablock.interpreter.blocks.operator.BlockOperator;
import edu.warbot.hexablock.interpreter.blocks.Blocks;
import edu.warbot.hexablock.interpreter.blocks.type.TypeBlock;
import edu.warbot.hexablock.interpreter.blocks.action.ActionBlock;

/**
 * Classe qui représente un bloc de type when
 * @author Lopez Jimmy
 * @version 0.2
 */
public class WhenBlock extends Block {

    /**
     * La liste des blocs de la condition du bloc
     * @see edu.warbot.hexablock.interpreter.blocks.Blocks
     * @since 0.2
     */
    private Blocks<Block> listBLock = new Blocks<Block>();

    /**
     * Le constructeur du bloc
     * @param action : le père du bloc
     * @since 0.2
     */
    public WhenBlock(ActionBlock action) {
        super(TypeBlock.WHENBLOCK);
        setFather(action);
        setSameDepthIncremented(action);
    }

    /**
     * Permet de savoir la valeur de la condition du when
     * @return Un boolean
     * @since 0.2
     */
    public boolean getConditionValue(){
        if(listBLock.size() == 1)
            return listBLock.getElement(0).eval();
        else {
            BlockOperator operator = getLastOperator();
            return operator != null && operator.eval();
        }
    }

    /**
     * Permet de récupérer le dernier operateur de la liste de bloc
     * @return Un Block
     * @since 0.2
     */
    public BlockOperator getLastOperator() {
        BlockOperator last = null;
        for(int i = 0; i < listBLock.size(); i++)
            if(listBLock.getElement(i) instanceof BlockOperator)
                last = (BlockOperator) listBLock.getElement(i);
        return last;
    }


}
