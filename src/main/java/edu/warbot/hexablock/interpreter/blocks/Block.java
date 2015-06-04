package edu.warbot.hexablock.interpreter.blocks;


/**
 * Created by jimmy on 30/04/15.
 */
public abstract class Block implements Evaluable, BlockBoolean {

    private Block father;

    private TypeBlock type;

    private int depth = -1;

    private boolean isRealBooleanBlock = false;

    public Block(TypeBlock type) {
        this.type = type;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public void incrementDepth() {
        this.depth++;
    }

    public void decrementDepth() {
        this.depth--;
    }

    public boolean isSameDepth(Block other) {
        return this.depth == other.getDepth();
    }


    public TypeBlock getType() {
        return type;
    }

    public boolean isSameBlock(Block other) {
        return this.type.equals(other.getType());
    }

    public Block getFather() {
        return father;
    }

    public void setFather(Block father) {
        this.father = father;
    }

    @Override
    public boolean getValue() {
        return false;
    }

    @Override
    public boolean isRealBooleanBlock() {
        return false;
    }

    @Override
    public void setSituation(boolean value) {
        isRealBooleanBlock = value;
    }
}
