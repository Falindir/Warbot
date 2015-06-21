package edu.warbot.scriptcore.script;

import edu.warbot.scriptcore.interpreter.ScriptInterpreterLanguage;

/**
 * Created by jimmy on 21/06/15.
 */
public class BlockScript extends Script {

    public BlockScript(StringBuilder file) {
        super(ScriptInterpreterLanguage.BLOCK);
        setCodeAgent(file);
    }
}
