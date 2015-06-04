package edu.warbot.hexablock.interpreter.blocks;

import java.util.Collections;
import java.util.LinkedList;

/**
 * Created by jimmy on 30/04/15.
 */
public class Blocks extends Block {

    private LinkedList<Block> blocks = new LinkedList<Block>();

    public Blocks() {
        super(TypeBlock.BLOCKS);
    }

    public void add(Block block) {
        if(!blocks.contains(block))
            blocks.add(block);
    }

    public void swap(Block b1, Block b2) {
        if(blocks.contains(b1) && blocks.contains(b2)) {
            int indexB1 = blocks.indexOf(b1);
            int indexB2 = blocks.indexOf(b2);
            Collections.swap(blocks, indexB1, indexB2);
        }
    }

    public void remove(Block block) {
        blocks.remove(block);
    }
}
