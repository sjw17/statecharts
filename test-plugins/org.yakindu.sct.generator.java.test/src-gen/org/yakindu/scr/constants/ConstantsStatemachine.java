package org.yakindu.scr.constants;

public class ConstantsStatemachine implements IConstantsStatemachine {
	public static final long x;
	public static final long y;
	public static final String y;
	public static final long two;

	static {
		sCInterface.x = 10;

		sCInterface.y = sCInterface.x * 2;

		sCINamed.y = "Hello World";

		sCINamed.two = 2;
	}

	private final class SCInterfaceImpl implements SCInterface {

		private boolean e;

		public void raiseE() {
			e = true;
		}

		private long result;
		public long getResult() {
			return result;
		}

		public void setResult(long value) {
			this.result = value;
		}

		public void clearEvents() {
			e = false;
		}

	}

	private SCInterfaceImpl sCInterface;
	private final class SCINamedImpl implements SCINamed {

	}

	private SCINamedImpl sCINamed;

	public enum State {
		main_region_A, main_region_B, $NullState$
	};

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	public ConstantsStatemachine() {

		sCInterface = new SCInterfaceImpl();
		sCINamed = new SCINamedImpl();
	}

	public void init() {
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}

		clearEvents();
		clearOutEvents();

		sCInterface.result = 0;
	}

	public void enter() {
		entryAction();

		enterSequenceMain_region();
	}

	public void exit() {
		exitSequenceMain_region();

		exitAction();
	}

	/**
	 * This method resets the incoming events (time events included).
	 */
	protected void clearEvents() {
		sCInterface.clearEvents();

	}

	/**
	 * This method resets the outgoing events.
	 */
	protected void clearOutEvents() {
	}

	/**
	 * Returns true if the given state is currently active otherwise false.
	 */
	public boolean isStateActive(State state) {
		switch (state) {
			case main_region_A :
				return stateVector[0] == State.main_region_A;
			case main_region_B :
				return stateVector[0] == State.main_region_B;
			default :
				return false;
		}
	}

	public SCInterface getSCInterface() {
		return sCInterface;
	}
	public SCINamed getSCINamed() {
		return sCINamed;
	}

	public void raiseE() {
		sCInterface.raiseE();
	}

	public long getX() {
		return sCInterface.getX();
	}

	public void setX(long value) {
		sCInterface.setX(value);
	}
	public long getY() {
		return sCInterface.getY();
	}

	public void setY(long value) {
		sCInterface.setY(value);
	}
	public long getResult() {
		return sCInterface.getResult();
	}

	public void setResult(long value) {
		sCInterface.setResult(value);
	}

	private boolean checkMain_region_ATr0() {
		return sCInterface.e;
	}

	private void effectMain_region_ATr0() {
		exitSequenceMain_region_A();

		enterSequenceMain_region_B();
	}

	/* Entry action for statechart 'Constants'. */
	private void entryAction() {
	}

	/* Entry action for state 'B'. */
	private void entryActionMain_region_B() {
		sCInterface.result = sCINamed.two * sCInterface.x;
	}

	/* Exit action for state 'Constants'. */
	private void exitAction() {
	}

	/* 'default' enter sequence for state A */
	private void enterSequenceMain_region_A() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_A;
	}

	/* 'default' enter sequence for state B */
	private void enterSequenceMain_region_B() {
		entryActionMain_region_B();

		nextStateIndex = 0;
		stateVector[0] = State.main_region_B;
	}

	/* 'default' enter sequence for region main region */
	private void enterSequenceMain_region() {
		reactConstants_main_region__entry_Default();
	}

	/* Default exit sequence for state A */
	private void exitSequenceMain_region_A() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state B */
	private void exitSequenceMain_region_B() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for region main region */
	private void exitSequenceMain_region() {
		switch (stateVector[0]) {
			case main_region_A :
				exitSequenceMain_region_A();
				break;

			case main_region_B :
				exitSequenceMain_region_B();
				break;

			default :
				break;
		}
	}

	/* The reactions of state A. */
	private void reactMain_region_A() {
		if (checkMain_region_ATr0()) {
			effectMain_region_ATr0();
		}
	}

	/* The reactions of state B. */
	private void reactMain_region_B() {
	}

	/* Default react sequence for initial entry  */
	private void reactConstants_main_region__entry_Default() {
		enterSequenceMain_region_A();
	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case main_region_A :
					reactMain_region_A();
					break;
				case main_region_B :
					reactMain_region_B();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}