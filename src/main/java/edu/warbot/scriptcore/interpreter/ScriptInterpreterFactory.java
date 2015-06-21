package edu.warbot.scriptcore.interpreter;

import edu.warbot.scriptcore.interpreter.block.BlockScriptInterpreterFactory;
import edu.warbot.scriptcore.interpreter.javascript.JsScriptInterpreterFactory;
import edu.warbot.scriptcore.interpreter.python.PyScriptInterpreterFactory;

public abstract class ScriptInterpreterFactory {

    public static ScriptInterpreterFactory getInstance(ScriptInterpreterLanguage langage) {
        switch (langage) {
            case PYTHON:
                return new PyScriptInterpreterFactory();
            case JAVASCRIPT:
                return new JsScriptInterpreterFactory();
            case BLOCK:
                return new BlockScriptInterpreterFactory();
            default:

        }
        return null;
    }

    public abstract ScriptInterpreter createScriptInterpreter();
}
