package edu.warbot.hexablock.interpreter;

import org.python.core.PyObject;

/**
 * Created by jimmy on 19/06/15.
 */
public class BlockWrapper<T extends Object> {

    /**
     * L'objet accessible
     */
    private T object;

    /**
     * Contructeur
     *
     * @param object l'objet à rendre accessible
     */
    public BlockWrapper(T object) {
            this.object = object;
        }

    /**
     * Contructeur par recopie
     *
     * @param copy
     */
    public BlockWrapper(BlockWrapper<T> copy) {
        this.object = copy.get();
    }

    /**
     * Getter
     *
     * @return l'objet java
     */
    public T get() {
            return object;
        }

    /**
     * Setter
     *
     * @param object
     */

    public void set(T object) {
            this.object = object;
        }
}
