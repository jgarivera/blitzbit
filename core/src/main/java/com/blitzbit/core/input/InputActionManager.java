package com.blitzbit.core.input;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class InputActionManager extends InputAdapter {

    private final ArrayList<ActionListener> actionListeners;
    private final HashMap<Integer, ActionType> keyboardActionTypes;

    private final HashMap<Integer, ActionType> mouseActionTypes;

    public InputActionManager() {
        actionListeners = new ArrayList<>();
        keyboardActionTypes = new HashMap<>();
        mouseActionTypes = new HashMap<>();

        registerKeyboardActionTypes();
        registerMouseActionTypes();
    }

    private void registerKeyboardActionTypes() {
        keyboardActionTypes.put(Input.Keys.W, ActionType.MOVE_UP);
        keyboardActionTypes.put(Input.Keys.S, ActionType.MOVE_DOWN);
        keyboardActionTypes.put(Input.Keys.A, ActionType.MOVE_LEFT);
        keyboardActionTypes.put(Input.Keys.D, ActionType.MOVE_RIGHT);
    }

    private void registerMouseActionTypes() {
        mouseActionTypes.put(Input.Buttons.LEFT, ActionType.SPAWN_MINION);
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
