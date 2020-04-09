package automaton641;

public class Walker {
	public Automaton binary;
	public Position position;
	public DirectionNode directionNode;
	public Walker(Automaton binary, DirectionNode directionNode, int row, int column) {
		this.position = new Position(row, column);
		this.directionNode = directionNode;
		this.binary = binary;
	}
	public void moveDown() {
		binary.moveDown(position);
	}
	
	public void moveRight() {
		binary.moveRight(position);
	}
	
	public void moveUp() {
		binary.moveUp(position);

	}
	
	public void moveLeft() {
		binary.moveLeft(position);

	}
	
	public void move() {
		switch (directionNode.direction) {
		case DOWN:
			moveDown();
			break;
		case RIGHT:
			moveRight();
			break;
		case UP:
			moveUp();
			break;
		case LEFT:
			moveLeft();
			break;
		default:
			System.out.println("ERROR: Invalid direction...");
			System.exit(0);
		}
		directionNode = directionNode.next;
	}
}
