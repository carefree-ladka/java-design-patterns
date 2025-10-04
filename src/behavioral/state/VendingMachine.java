package behavioral.state;

public class VendingMachine {
    private State noCoinState;
    private State hasCoinState;
    private State state;

    public VendingMachine() {
        noCoinState = new NoCoinState(this);
        hasCoinState = new HasCoinState(this);
        state = noCoinState;
    }

    public void insertCoin() {
        state.insertCoin();
    }

    public void pressButton() {
        state.pressButton();
    }

    public State getNoCoinState() {
        return noCoinState;
    }

    public State getHasCoinState() {
        return hasCoinState;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
