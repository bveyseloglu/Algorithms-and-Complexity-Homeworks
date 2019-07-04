/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MazeSolver;

/**
 *
 * @author veyseloglu
 */
public interface MazeClass {
    public void ReadMazeFromFile(); // Maze file will be read
    public void SolveMaze(); // If there is a solution find
    public void PrintSolution(); // The solution will be printed
}