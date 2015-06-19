package edu.warbot.hexablock.interpreter.blocks;

import edu.warbot.hexablock.interpreter.blocks.master.MasterBlock;

/**
 * Created by jimmy on 29/05/15.
 */
public class ActionBlock extends Block {

    private WhenBlock whenB = new WhenBlock();
    private Blocks condition = new Blocks();
    private DoBlock doB = new DoBlock();
    private Blocks instruction = new Blocks();

    public ActionBlock(MasterBlock father) {
        super(TypeBlock.ACTIONBLOCK);
        setFather(father);
        setDepth(getFather().getDepth() + 1);
        this.whenB.setFather(this);
        this.condition.setFather(this);
        this.doB.setFather(this);
        this.instruction.setFather(this);
    }


    public WhenBlock getWhenB() {
        return whenB;
    }

    public Blocks getCondition() {
        return condition;
    }

    public DoBlock getDoB() {
        return doB;
    }

    public Blocks getInstruction() {
        return instruction;
    }

    public String getAction() {
        return null;
    }
}
