package edu.warbot.scriptcore.interpreter.block;

import edu.warbot.agents.enums.WarAgentType;
import edu.warbot.hexablock.interpreter.blocks.master.MasterBlock;
import edu.warbot.scriptcore.interpreter.ScriptInterpreter;
import edu.warbot.scriptcore.script.BlockScript;
import edu.warbot.scriptcore.script.Script;
import edu.warbot.scriptcore.scriptagent.ScriptAgent;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by jimmy on 04/06/15.
 */
public class BlockScriptInterpreter implements ScriptInterpreter {

    protected Map<WarAgentType, Script> scripts = new HashMap<>();

    public BlockScriptInterpreter() {

    }

    @Override
    public void addScript(InputStream file, WarAgentType agent) throws IOException {
        Scanner scanner = new Scanner(file);
        StringBuilder sb = new StringBuilder();
        while (scanner.hasNext()) {
            sb.append(scanner.nextLine());
            sb.append("\n");
        }
        addScript(sb, agent);
        scanner.close();
    }

    @Override
    public void addScript(StringBuilder file, WarAgentType agent) {
        BlockScript blockScript = new BlockScript(file);
        scripts.put(agent, blockScript);
    }

    @Override
    public void addScript(Script script, WarAgentType agent) {
        BlockScript blockScript = new BlockScript(new StringBuilder());
        blockScript.addCodeToAgent(script);
        scripts.put(agent, blockScript);
    }

    @Override
    public Map<WarAgentType, Script> getScripts() {
        return scripts;
    }

    @Override
    public Script getScript(WarAgentType agent) {
        return scripts.get(agent);
    }

    @Override
    public ScriptAgent giveScriptAgent(WarAgentType agent) {

        Script s = scripts.get(agent);

        MasterBlock agentBlock = new MasterBlock(agent);

        // TODO eval code

        return agentBlock;
    }

    @Override
    public Script createScript(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        StringBuilder sb = new StringBuilder();

        while (scanner.hasNext()) {
            sb.append(scanner.nextLine());
            sb.append("\n");
        }
        scanner.close();

        return new BlockScript(sb);
    }

    @Override
    public ScriptAgent giveScriptAgent(Script script, String agentName) {

        WarAgentType type = WarAgentType.valueOf(agentName);

        MasterBlock agentBlock = new MasterBlock(type);

        // TODO eval code

        return agentBlock;
    }

    @Override
    public Object giveScriptToolsAgent(Script script, String toolName) {

        // TODO

        return null;
    }

    @Override
    public Script createScript(InputStream file) throws IOException {
        Scanner scanner = new Scanner(file);
        StringBuilder sb = new StringBuilder();
        while (scanner.hasNext()) {
            sb.append(scanner.nextLine());
            sb.append("\n");
        }
        Script script = new BlockScript(sb);
        scanner.close();
        return script;
    }
}
