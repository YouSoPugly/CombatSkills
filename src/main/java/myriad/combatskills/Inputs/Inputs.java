package myriad.combatskills.Inputs;

import java.util.LinkedList;
import java.util.Queue;

public class Inputs {

    private Queue<Input> inputs = new LinkedList<>();

    public Inputs(Input i) {
        inputs.add(i);
    }

    public Inputs() {
    }

    public Inputs addInput(Input i) {
        inputs.add(i);
        return this;
    }

    public Inputs clear() {
        inputs = new LinkedList<>();
        return this;
    }

    public String toString() {

        StringBuilder out = new StringBuilder();
        out.append(" ");

        Queue<Input> queue = new LinkedList<>();
        queue.addAll(inputs);

        for (Input i : inputs) {
            switch (i) {
                case RCLICK:
                    out.append("r ");
                    break;
                case LCLICK:
                    out.append("l ");
                    break;
                case CROUCH:
                    out.append("c ");
            }
        }
        return out.toString();
    }

    public int size() {
        return inputs.size();
    }

    public boolean isMatch(Queue<Input> queue) {
        if (inputs.size() == 0)
            return false;

        Input[] inputArr = inputs.toArray(new Input[inputs.size()]);
        if (queue.size() != inputArr.length)
            return false;

        for (Input i : inputArr) {
            if (queue.poll() != i) {
                return false;
            }
        }
        return true;
    }


}
