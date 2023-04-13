package com.blitzbit.api.input.action;

import com.badlogic.gdx.InputAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class ActionManager extends InputAdapter {

    private final ArrayList<ActionListener> actionListeners;
    private final HashMap<Integer, ActionType> keyboardActionTypes;

    private final HashMap<Integer, ActionType> mouseActionTypes;

    public ActionManager() {
        actionListeners = new ArrayList<>();
        keyboardActionTypes = new HashMap<>();
        mouseActionTypes = new HashMap<>();

        registerKeyboardActions();
        registerMouseActions();
    }

    protected abstract void registerKeyboardActions();

    protected abstract void registerMouseActions();

    public void addKeyboardAction(int keycode, ActionType actionType) {
        keyboardActionTypes.put(keycode, actionType);
    }

    public void addMouseAction(int pointer, ActionType actionType) {
        mouseActionTypes.put(pointer, actionType);
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
        if (keyboardActionTypes.containsKey(keycode)) {
            return notifyListenersToEnter(keyboardActionTypes.get(keycode));
        } else {
            return false;
        }
    }

    @Override
    public boolean keyUp(int keycode) {
        if (keyboardActionTypes.containsKey(keycode)) {
            return notifyListenersToExit(keyboardActionTypes.get(keycode));
        } else {
            return false;
        }
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if (mouseActionTypes.containsKey(button)) {
            return notifyListenersToEnter(mouseActionTypes.get(button));
        } else {
            return false;
        }
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        if (mouseActionTypes.containsKey(button)) {
            return notifyListenersToExit(mouseActionTypes.get(button));
        } else {
            return false;
        }
    }

    private boolean notifyListenersToEnter(ActionType actionType) {
        boolean isProcessed = false;

        for (ActionListener listener : actionListeners) {
            if (!isProcessed && listener.onActionEntered(actionType)) {
                isProcessed = true;
            }
        }

        return isProcessed;
    }

    private boolean notifyListenersToExit(ActionType actionType) {
        boolean isProcessed = false;

        for (ActionListener listener : actionListeners) {
            if (!isProcessed && listener.onActionExited(actionType)) {
                isProcessed = true;
            }
        }

        return isProcessed;
    }
}
