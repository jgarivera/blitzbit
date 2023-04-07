package com.blitzbit.core.input;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class InputActionManager extends InputAdapter {

    private ArrayList<ActionListener> actionListeners;
    private HashMap<Integer, ActionType> keyboardActions;

    private HashMap<Integer, ActionType> mouseActions;

    public InputActionManager() {
        actionListeners = new ArrayList<>();
        keyboardActions = new HashMap<>();
        mouseActions = new HashMap<>();

        registerKeyboardActions();
        registerMouseActions();
    }

    private void registerKeyboardActions() {
        keyboardActions.put(Input.Keys.W, ActionType.MOVE_UP);
        keyboardActions.put(Input.Keys.S, ActionType.MOVE_DOWN);
        keyboardActions.put(Input.Keys.A, ActionType.MOVE_LEFT);
        keyboardActions.put(Input.Keys.D, ActionType.MOVE_RIGHT);
    }

    private void registerMouseActions() {
        mouseActions.put(Input.Buttons.LEFT, ActionType.SPAWN_MINION);
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

    private boolean notifyListenersToEnter(ActionType action) {
        boolean isProcessed = false;

        for (ActionListener listener : actionListeners) {
            if (!isProcessed && listener.onActionEntered(action)) {
                isProcessed = true;
            }
        }

        return isProcessed;
    }

    private boolean notifyListenersToExit(ActionType action) {
        boolean isProcessed = false;

        for (ActionListener listener : actionListeners) {
            if (!isProcessed && listener.onActionExited(action)) {
                isProcessed = true;
            }
        }

        return isProcessed;
    }
}
