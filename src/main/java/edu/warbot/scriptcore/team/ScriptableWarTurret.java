package edu.warbot.scriptcore.team;

import edu.warbot.brains.brains.WarTurretBrain;
import edu.warbot.scriptcore.scriptagent.ScriptAgent;

public abstract class ScriptableWarTurret extends WarTurretBrain implements Scriptable {

    private ScriptAgent script;

    public ScriptableWarTurret() {
        super();
    }

    @Override
    public void activate() {

    }

    @Override
    public String action() {
        return getScriptAgent().action();
    }

    public ScriptAgent getScriptAgent() {
        return script;
    }

    public void setScriptAgent(ScriptAgent script) {
        this.script = script;
    }
}
