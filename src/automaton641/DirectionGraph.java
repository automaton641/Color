package automaton641;

import java.util.Random;

import automaton641.DirectionNode.Direction;

public class DirectionGraph {
	public DirectionNode first;
	public DirectionNode last;
	public Random random;
	public DirectionGraph(Random random) {
		this.random = random;
	}
	public void addDirection(Direction direction, int value) {
		DirectionNode directionNode = new DirectionNode();
		directionNode.direction = direction;
		directionNode.value = value;
		if (first == null) {
			directionNode.next = directionNode;
			directionNode.previous = directionNode;
			first = directionNode;
			last = directionNode;
		} else if (first == last) {
			last = directionNode;
			first.next = last;
			first.previous = last;
			last.next = first;
			last.previous = first;
		} else {
			last.next = directionNode;
			first.previous = directionNode;
			directionNode.previous = last;
			directionNode.next = first;
			last = directionNode;
		}
	}
	public void randomize(int size, int modulus) {
		for (int i = 0; i < size; i++) {
			this.addDirection(DirectionNode.generateRandomDirection(random), random.nextInt(modulus));
		}
	}
}
