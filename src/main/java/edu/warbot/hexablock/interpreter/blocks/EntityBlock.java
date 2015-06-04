package edu.warbot.hexablock.interpreter.blocks;

/**
 * Created by jimmy on 01/05/15.
 */
public class EntityBlock extends Block {

    private String entity;

    public EntityBlock(String entity) {
        super(TypeBlock.ENTITYBLOCK);
        this.entity = entity;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }
}
