package automaton641;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

import automaton641.DirectionNode.Direction;

public class Automaton {
	public LinkedList<Walker> walkers;
	public Automaton(int width, int height, int steps, int modulus) {
		this.modulus = modulus;
        this.width = width;
        this.height = height;
        random = new Random();
        initializeCells();
        DirectionGraph graph = new DirectionGraph(random);
		graph.randomize(steps, modulus);
        this.walkers = new LinkedList<Walker>();
        this.walkers.add(new Walker(this, graph.last, height/2, width/2));
    }
    public Random random;
    public Cell[][] cells;
    public Cell[][] backCells;
    public int width;
    public int height;
    public int modulus;
    public void initializeCells() {
        cells = new Cell[height][width];
        backCells = new Cell[height][width];
        for (int row = 0; row < height; row++) {
            for (int column = 0; column < width; column++) {
                cells[row][column] = new Cell(random);
                backCells[row][column] = new Cell(random);
            }
        }
        /*
        cells[height/2][width/2].value = true;
        cells[height/2][width/2 - 1].value = true;
        cells[height/2 - 1][width/2].value = true;
        cells[height/2 - 1][width/2 - 1].value = true;
		*/
        fillBackCells();
    }
    
    public void fillBackCells() {
        for (int row = 0; row < height; row++) {
            for (int column = 0; column < width; column++) {
                backCells[row][column].value = cells[row][column].value;
            }
        }
    }
    
    public void moveDown(Position position) {
    	if (position.row == height - 1) {
    		position.row = 0;
        } else {
        	position.row++;
        }
    }
    
    public void moveRight(Position position) {
    	if (position.column == width - 1) {
    		position.column = 0;
        } else {
        	position.column++;
        }
    }
    
    public void moveUp(Position position) {
    	if (position.row == 0) {
    		position.row = height - 1;
        } else {
        	position.row--;
        }
    }
    
    public void moveLeft(Position position) {
    	if (position.column == 0) {
    		position.column = width - 1;
        } else {
        	position.column--;
        }
    }
  
    
    public void iterate() {
    	for (Iterator<Walker> iterator = walkers.iterator(); iterator.hasNext();) {
			Walker walker = iterator.next();
			for (int i = 0; i < 1; i++) {
				int floor = cells[walker.position.row][walker.position.column].value;
		        //System.out.println(walker.position);
		        //System.out.println(floor);
		        //System.out.println(walker.directionNode);
		        cells[walker.position.row][walker.position.column].value = (floor + walker.directionNode.value) % modulus;
		        walker.move();
			}
		}
        try {
			Thread.sleep(0);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void print() {
        for (int row = 0; row < height; row++) {
            for (int column = 0; column < width; column++) {
                System.out.println("[" + row + ", " + column + "] = " + cells[row][column].value);
            }
        }
    }
    
}
