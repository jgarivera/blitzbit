package com.blitzbit.core.input;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class InputActionManager extends InputAdapter {

    private ArrayList<ActionListener> actionListeners;
    private HashMap<Integer, InputAction> keyboardActions;

    private HashMap<Integer, InputAction> mouseActions;

    public InputActionManager() {
        actionListeners = new ArrayList<>();
        keyboardActions = new HashMap<>();
        mouseActions = new HashMap<>();

        registerKeyboardActions();
        registerMouseActions();
    }

    private void registerKeyboardActions() {
        keyboardActions.put(Input.Keys.W, InputAction.MOVE_UP);
        keyboardActions.put(Input.Keys.S, InputAction.MOVE_DOWN);
        keyboardActions.put(Input.Keys.A, InputAction.MOVE_LEFT);
        keyboardActions.put(Input.Keys.D, InputAction.MOVE_RIGHT);
    }

    private void registerMouseActions() {
        mouseActions.put(Input.Buttons.LEFT, InputAction.SPAWN_MINION);
    }

    /**
     * Recently subscribed listener gets top priority.
     *
     * @param listener - action listener
     */
    public void subscribe(ActionListener listener) {
        actionListeners.add(0, listener);
    }

    public void unsubscribe(ActionListener listener) {
        actionListeners.remove(listener);
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keyboardActions.containsKey(keycode)) {
            return notifyListenersToEnter(keyboardActions.get(keycode));
        } else {
            return false;
        }
    }

    @Override
    public boolean keyUp(int keycode) {
        if (keyboardActions.containsKey(keycode)) {
            return notifyListenersToExit(keyboardActions.get(keycode));
        } else {
            return false;
        }
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if (mouseActions.containsKey(button)) {
            return notifyListenersToEnter(mouseActions.get(button));
        } else {
            return false;
        }
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        if (mouseActions.containsKey(button)) {
            return notifyListenersToExit(mouseActions.get(button));
        } else {
            return false;
        }
    }

    private boolean notifyListenersToEnter(InputAction action) {
        boolean isProcessed = false;

        for (ActionListener listener : actionListeners) {
            if (!isProcessed && listener.onActionEntered(action)) {
                isProcessed = true;
            }
        }

        return isProcessed;
    }

    private boolean notifyListenersToExit(InputAction action) {
        boolean isProcessed = false;

        for (ActionListener listener : actionListeners) {
            if (!isProcessed && listener.onActionExited(action)) {
                isProcessed = true;
            }
        }

        return isProcessed;
    }
}
