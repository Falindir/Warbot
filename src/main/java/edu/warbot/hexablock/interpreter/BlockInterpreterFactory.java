package edu.warbot.hexablock.interpreter;

/**
 * Created by jimmy on 04/06/15.
 */
public class BlockInterpreterFactory {

    public BlockInterpreterFactory(){

    }

    public BlockInterpreter createScriptInterpreter() {
        BlockInterpreter interpreter = new BlockInterpreter();
        return interpreter;
    }
}
