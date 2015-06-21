package edu.warbot.scriptcore.interpreter.block;

import edu.warbot.scriptcore.interpreter.ScriptInterpreter;
import edu.warbot.scriptcore.interpreter.ScriptInterpreterFactory;

/**
 * Created by jimmy on 04/06/15.
 */
public class BlockScriptInterpreterFactory extends ScriptInterpreterFactory {

    public BlockScriptInterpreterFactory(){

    }

    @Override
    public ScriptInterpreter createScriptInterpreter() {
        BlockScriptInterpreter interpreter = new BlockScriptInterpreter();
        return interpreter;
    }
}
