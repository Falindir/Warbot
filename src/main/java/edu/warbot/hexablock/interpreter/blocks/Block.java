package edu.warbot.hexablock.interpreter.blocks;

/**
 * Classe qui représente un bloc de manière générique (abstract)
 * @author Lopez Jimmy
 * @version 0.3
 */

public abstract class Block implements Evaluable {

    /**
     * Le père du bloc. Ce père peut être modifié.
     * @see edu.warbot.hexablock.interpreter.blocks.Block
     * @since 0.1
     */
    private Block father;

    /**
     * Le type du bloc. Ce type ne peut être modifié.
     * @see edu.warbot.hexablock.interpreter.blocks.TypeBlock
     * @since 0.1
     */
    private TypeBlock type;

    /**
     * La profondeur du bloc. Cette profondeur indique la position dans l'arbre du bloc.
     * Cette profondeur peut être modifié
     * @see int
     * @since 0.1
     */
    private int depth = -1;

    /**
     * Constructeur d'un bloc
     * @param type : le type du block
     * @since 0.1
     */
    public Block(TypeBlock type) {
        this.type = type;
    }

    /**
     * Permet de récupérer le père du bloc
     * @return Une instance de Block
     * @since 0.1
     */
    public Block getFather() {
        return father;
    }

    /**
     * Permet de modifier le père du bloc
     * @param father : le nouveau père du bloc
     * @since 0.1
     */
    public void setFather(Block father) {
        this.father = father;
    }

    /**
     * Permet de récupérer le type du block
     * @return Une instance de TypeBlock
     * @since 0.1
     */
    public TypeBlock getType() {
        return type;
    }

    /**
     * Permet de savoir si deux bloc sont du même type
     * @param other : Un autre bloc
     * @return Un boolean
     * @since 0.1
     */
    public boolean isSameType(Block other) {
        return this.type.equals(other.getType());
    }

    /**
     * Permet de récupérer la profondeur du bloc
     * @return Un int
     * @since 0.1
     */
    public int getDepth() {
        return depth;
    }

    /**
     * Permet de modfier la profondeur du bloc
     * @param depth : la nouvelle profondeur du bloc
     * @since 0.1
     */
    public void setDepth(int depth) {
        this.depth = depth;
    }

    /**
     * Permet d'incrémenter de 1 la profondeur du bloc
     * @since 0.2
     */
    public void incrementDepth() {
        this.depth++;
    }

    /**
     * Permet de décrémenter de 1 la profondeur du bloc
     * @since 0.2
     */
    public void decrementDepth() {
        this.depth--;
    }

    /**
     * Permet de savoir si ce bloc à la même profondeur qu'un autre bloc
     * @param other : Un autre bloc
     * @return Un boolean
     * @since 0.2
     */
    public boolean isSameDepth(Block other) {
        return this.depth == other.getDepth();
    }

    /**
     * Permet de prendre la meme profondeur que le bloc other, plus 1
     * @param other : Un autre bloc
     * @since 0.3
     */
    public void setSameDepthIncremented(Block other) {
        setDepth(other.getDepth());
        incrementDepth();
    }

    /**
     * Permet de prendre la meme profondeur que le bloc other, moins 1
     * @param other : Un autre bloc
     * @since 0.3
     */
    public void setSameDepthDecremented(Block other) {
        setDepth(other.getDepth());
        decrementDepth();
    }
}
