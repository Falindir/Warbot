package edu.warbot.hexablock.interpreter.blocks.warbot.string;

import edu.warbot.hexablock.interpreter.blocks.Block;
import edu.warbot.hexablock.interpreter.blocks.type.TypeBlock;
import edu.warbot.hexablock.interpreter.blocks.warbot.WarbotBlock;

/**
 * Created by jimmy on 22/06/15.
 */
public class StringBlock extends WarbotBlock {

    public String content;

    public String contentForTest;

    /**
     * Constructeur d'un bloc
     *
     * @param father : le père du block
     * @since 0.1
     */
    public StringBlock(Block father) {
        super(TypeBlock.STRINGBLOCK);
        setFather(father);
        setSameDepthIncremented(father);
        content = "";
        contentForTest = "";
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContentForTest() {
        return contentForTest;
    }

    public void setContentForTest(String contentForTest) {
        this.contentForTest = contentForTest;
    }

    @Override
    public boolean eval() {
        return content.equals(contentForTest);
    }
}
