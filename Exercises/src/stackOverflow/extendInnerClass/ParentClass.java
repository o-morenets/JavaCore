package stackOverflow.extendInnerClass;

public class ParentClass {

    public State currentState;

    public void setState(int stateID) {
        if (stateID == 0) currentState = new State() {
            @Override
            public void action() {
                // action for Born state
            }
        };

        if (stateID == 1) currentState = new State() {
            @Override
            public void action() {
                // action for Life state
            }
        };

        if (stateID == 2) currentState = new State() {
            @Override
            public void action() {
                // action for Dead state
            }
        };
    }

    ///уделяем объекту внимание
    public void Action() {
        currentState.action();
    }

    //состояние объекта
    public class State {
        public void action() {
        }
    }
}