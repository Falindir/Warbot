package edu.warbot.hexablock.interpreter.blocks.warbot.action;

import edu.warbot.hexablock.interpreter.blocks.Block;
import edu.warbot.hexablock.interpreter.blocks.type.TypeBlock;

/**
 * Created by jimmy on 19/06/15.
 */
public abstract class BlockAction extends Block {

    public static String MOVE   = "MOVE";
    public static String IDLE   = "IDLE";
    public static String FIRE   = "FIRE";
    public static String RELOAD = "RELOAD";
    public static String TAKE   = "TAKE";
    public static String EAT    = "EAT";
    public static String GIVE   = "GIVE";

    /**
     * Constructeur d'un bloc
     *
     * @param type : le type du block
     * @since 0.1
     */
    public BlockAction(TypeBlock type) {
        super(type);
    }

    public abstract String getAction();
}
