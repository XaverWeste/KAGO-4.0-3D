package my_project.control;

import KAGO_framework.control.Interactable;
import KAGO_framework.model.threeD.entities.EntityManager;

import java.awt.event.MouseEvent;

public class InputManager implements Interactable {

    private final EntityManager e;

    public InputManager(EntityManager e){
        this.e=e;
    }
    @Override
    public void keyPressed(int key) {
        e.update(key);
    }

    @Override
    public void keyReleased(int key) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }
}
