package edu.warbot.scriptcore.interpreter.block;

import edu.warbot.agents.enums.WarAgentType;
import edu.warbot.hexablock.interpreter.blocks.Block;
import edu.warbot.hexablock.interpreter.blocks.action.ActionBlock;
import edu.warbot.hexablock.interpreter.blocks.condition.DoBlock;
import edu.warbot.hexablock.interpreter.blocks.master.MasterBlock;
import edu.warbot.hexablock.interpreter.blocks.warbot.NothingBlock;
import edu.warbot.hexablock.interpreter.blocks.warbot.action.BlockAction;
import edu.warbot.hexablock.interpreter.blocks.warbot.action.IdleActionBlock;
import edu.warbot.hexablock.interpreter.blocks.warbot.action.MoveActionBlock;
import edu.warbot.hexablock.interpreter.blocks.warbot.view.ViewBlock;
import edu.warbot.scriptcore.interpreter.ScriptInterpreter;
import edu.warbot.scriptcore.script.BlockScript;
import edu.warbot.scriptcore.script.Script;
import edu.warbot.scriptcore.scriptagent.ScriptAgent;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.*;
import java.util.*;

/**
 * Created by jimmy on 04/06/15.
 */
public class BlockScriptInterpreter implements ScriptInterpreter {

    protected SAXBuilder builder = new SAXBuilder();

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

        Script script = scripts.get(agent);
        Document document = null;
        MasterBlock master;

        try {
            document = createDocument(script);
        } catch (JDOMException | IOException e) {
                e.printStackTrace();
        }

        return createTreeBlock(document, agent);
    }

    public Document createDocument(Script script) throws JDOMException, IOException {
        byte[] bytes = script.getCodeAgent().toString().getBytes();
        InputStream inputStream = new ByteArrayInputStream(bytes);
        return builder.build(inputStream);
    }

    public MasterBlock createTreeBlock(Document document, WarAgentType type) {

        Element racine = document.getRootElement();

        List<Element> listAction = racine.getChildren("actionUser");

        MasterBlock master = new MasterBlock(type);

        for (Element elementAction : listAction) {

            ActionBlock action = new ActionBlock(master);

            master.addBlocks(action);

            List<Element> whenChild = elementAction.getChild("when").getChildren();

            for(Element node : whenChild)
                action.getWhenB().add(createBlock(action.getWhenB(), node));


            List<Element> doChild = elementAction.getChild("do").getChildren();

            for(Element node : doChild)
                action.getDoB().add(createBlock(action.getDoB(), node));
        }

        return master;
    }

    public Block createBlock(Block father, Element element) {

        switch (XmlBlock.valueOf(element.getName().toUpperCase()))
        {
            case VIEW:

            case ACTION :

                String s = element.getChildren().get(0).getName().toUpperCase();

                if(s.equals(BlockAction.MOVE))
                    return new MoveActionBlock((DoBlock) father);
                else
                    return new IdleActionBlock((DoBlock) father);

            case CREATE:

            default:
                return new NothingBlock(father);
        }
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
