/*
 * Name: Abhijeet Singh
 * Student ID: 1207508
 * Assignment: 3
 * Question: 2
 *
 * Description:
 * This program simulates a predator-prey ecosystem using a 20x20 grid.
 * - **Ants (o)**: Move randomly and breed every 3 time steps.
 * - **Doodlebugs (X)**: Hunt ants, breed every 8 time steps, and starve after 3 time steps without food.
 * - The simulation continues until all organisms of one type are eliminated.
 *
 * How to Run:
 * 1. Compile the program using: `javac PredatorPreySimulation.java`
 * 2. Run the program using: `java PredatorPreySimulation`
 * 3. Press Enter to advance time steps, or type "exit" to quit the simulation.
 */

import java.util.Random;
import java.util.Scanner;

// Abstract base class Organism
abstract class Organism {
    protected int x, y;
    protected int breedTime;
    protected boolean moved;

    public Organism(int x, int y) {
        this.x = x;
        this.y = y;
        this.breedTime = 0;
        this.moved = false;
    }

    // Abstract method to be overridden by derived classes
    public abstract void move(World world);

    // Abstract method for breeding
    public abstract void breed(World world);

    // Get the position
    public int getX() { return x; }
    public int getY() { return y; }

    // Mark organism as moved in current time step
    public void setMoved(boolean moved) { this.moved = moved; }
    public boolean hasMoved() { return moved; }
}

// Ant class - the prey
class Ant extends Organism {
    private static final int BREED_TIME = 3;

    public Ant(int x, int y) {
        super(x, y);
    }

    @Override
    public void move(World world) {
        if (moved) return;

        // Try to move in a random direction
        Random rand = new Random();
        int direction = rand.nextInt(4); // 0: up, 1: right, 2: down, 3: left

        int newX = x;
        int newY = y;

        switch (direction) {
            case 0: newX--; break; // Up
            case 1: newY++; break; // Right
            case 2: newX++; break; // Down
            case 3: newY--; break; // Left
        }

        // Check if move is valid
        if (world.isValid(newX, newY) && world.getOrganism(newX, newY) == null) {
            // Move the ant
            world.setOrganism(null, x, y);
            world.setOrganism(this, newX, newY);
            x = newX;
            y = newY;
        }

        breedTime++;
        moved = true;
    }

    @Override
    public void breed(World world) {
        if (breedTime >= BREED_TIME) {
            // Try to breed in an adjacent cell
            int[] dx = {-1, 0, 1, 0};
            int[] dy = {0, 1, 0, -1};

            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (world.isValid(newX, newY) && world.getOrganism(newX, newY) == null) {
                    Ant baby = new Ant(newX, newY);
                    world.setOrganism(baby, newX, newY);
                    breedTime = 0;
                    return;
                }
            }
        }
    }
}

// Doodlebug class - the predator
class Doodlebug extends Organism {
    private static final int BREED_TIME = 8;
    private static final int STARVE_TIME = 3;
    private int starveTicks;

    public Doodlebug(int x, int y) {
        super(x, y);
        starveTicks = 0;
    }

    @Override
    public void move(World world) {
        if (moved) return;

        // First try to find an adjacent ant to eat
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (world.isValid(newX, newY) && world.getOrganism(newX, newY) instanceof Ant) {
                // Move and eat the ant
                world.setOrganism(null, x, y);
                world.setOrganism(this, newX, newY);
                x = newX;
                y = newY;
                starveTicks = 0;
                breedTime++;
                moved = true;
                return;
            }
        }

        // If no ant found, move randomly like ants do
        Random rand = new Random();
        int direction = rand.nextInt(4); // 0: up, 1: right, 2: down, 3: left

        int newX = x;
        int newY = y;

        switch (direction) {
            case 0: newX--; break; // Up
            case 1: newY++; break; // Right
            case 2: newX++; break; // Down
            case 3: newY--; break; // Left
        }

        // Check if move is valid
        if (world.isValid(newX, newY) && world.getOrganism(newX, newY) == null) {
            // Move the doodlebug
            world.setOrganism(null, x, y);
            world.setOrganism(this, newX, newY);
            x = newX;
            y = newY;
        }

        starveTicks++;
        breedTime++;
        moved = true;
    }

    @Override
    public void breed(World world) {
        if (breedTime >= BREED_TIME) {
            // Try to breed in an adjacent cell
            int[] dx = {-1, 0, 1, 0};
            int[] dy = {0, 1, 0, -1};

            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (world.isValid(newX, newY) && world.getOrganism(newX, newY) == null) {
                    Doodlebug baby = new Doodlebug(newX, newY);
                    world.setOrganism(baby, newX, newY);
                    breedTime = 0;
                    return;
                }
            }
        }
    }

    // Check if doodlebug should starve
    public boolean starve() {
        return starveTicks >= STARVE_TIME;
    }
}

// World class to manage the grid
class World {
    private static final int SIZE = 20;
    private Organism[][] grid;

    public World() {
        grid = new Organism[SIZE][SIZE];
    }

    // Initialize world with ants and doodlebugs
    public void initialize() {
        Random rand = new Random();

        // Place 5 doodlebugs
        int doodlebugsPlaced = 0;
        while (doodlebugsPlaced < 5) {
            int x = rand.nextInt(SIZE);
            int y = rand.nextInt(SIZE);

            if (grid[x][y] == null) {
                grid[x][y] = new Doodlebug(x, y);
                doodlebugsPlaced++;
            }
        }

        // Place 100 ants
        int antsPlaced = 0;
        while (antsPlaced < 100) {
            int x = rand.nextInt(SIZE);
            int y = rand.nextInt(SIZE);

            if (grid[x][y] == null) {
                grid[x][y] = new Ant(x, y);
                antsPlaced++;
            }
        }
    }

    // Check if position is valid
    public boolean isValid(int x, int y) {
        return x >= 0 && x < SIZE && y >= 0 && y < SIZE;
    }

    // Get organism at position
    public Organism getOrganism(int x, int y) {
        if (isValid(x, y)) {
            return grid[x][y];
        }
        return null;
    }

    // Set organism at position
    public void setOrganism(Organism org, int x, int y) {
        if (isValid(x, y)) {
            grid[x][y] = org;
        }
    }

    // Display the world
    public void display() {
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                if (grid[x][y] == null) {
                    System.out.print(".");
                } else if (grid[x][y] instanceof Ant) {
                    System.out.print("o");
                } else if (grid[x][y] instanceof Doodlebug) {
                    System.out.print("X");
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    // Simulate one time step
    public void timeStep() {
        // Reset moved flag
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                if (grid[x][y] != null) {
                    grid[x][y].setMoved(false);
                }
            }
        }

        // Move doodlebugs first
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                if (grid[x][y] instanceof Doodlebug && !grid[x][y].hasMoved()) {
                    grid[x][y].move(this);
                }
            }
        }

        // Move ants
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                if (grid[x][y] instanceof Ant && !grid[x][y].hasMoved()) {
                    grid[x][y].move(this);
                }
            }
        }

        // Breed organisms
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                if (grid[x][y] != null) {
                    grid[x][y].breed(this);
                }
            }
        }

        // Starve doodlebugs
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                if (grid[x][y] instanceof Doodlebug) {
                    if (((Doodlebug)grid[x][y]).starve()) {
                        grid[x][y] = null;
                    }
                }
            }
        }
    }

    // Count organisms by type
    public int countOrganisms(Class<?> type) {
        int count = 0;
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                if (grid[x][y] != null && type.isInstance(grid[x][y])) {
                    count++;
                }
            }
        }
        return count;
    }
}

// Main simulation class
public class PredatorPreySimulation {
    public static void main(String[] args) {
        World world = new World();
        world.initialize();

        Scanner scanner = new Scanner(System.in);
        int timeStep = 0;

        while (true) {
            System.out.println("Time Step: " + timeStep);
            System.out.println("Ants: " + world.countOrganisms(Ant.class));
            System.out.println("Doodlebugs: " + world.countOrganisms(Doodlebug.class));
            world.display();

            System.out.println("Press Enter for next time step (or type 'exit' to quit)");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            world.timeStep();
            timeStep++;

            // Check if either species is extinct
            if (world.countOrganisms(Ant.class) == 0) {
                System.out.println("All ants have been eliminated!");
                break;
            }

            if (world.countOrganisms(Doodlebug.class) == 0) {
                System.out.println("All doodlebugs have been eliminated!");
                break;
            }
        }

        scanner.close();
        System.out.println("Simulation ended.");
    }
}