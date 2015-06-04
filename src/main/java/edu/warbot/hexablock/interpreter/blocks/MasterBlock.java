package edu.warbot.hexablock.interpreter.blocks;

import edu.warbot.brains.WarBrain;
import edu.warbot.hexablock.interpreter.BlockAgent;

import java.util.LinkedList;

/**
 * Created by jimmy on 01/05/15.
 */
public class MasterBlock extends Block implements BlockAgent {

    private LinkedList<ActionBlock> listBlocks = new LinkedList<ActionBlock>();

    private String name;

    public MasterBlock(String name) {
        super(TypeBlock.MASTERBLOCK);
        this.name = name;
        setDepth(0);
    }

    public LinkedList<ActionBlock> getListBlocks() {
        return listBlocks;
    }

    public void addBlocks(ActionBlock blocks) {
        if(!listBlocks.contains(blocks))
            listBlocks.add(blocks);
    }

    public String getName(){
        return name;
    }

    @Override
    public String action() {
        return null;
    }

    @Override
    public void link(WarBrain brain) {

    }
}
