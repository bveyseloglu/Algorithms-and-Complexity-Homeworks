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
public class Stack {
    
    public int[] StackX;
    public int[] StackY;
    public int stackLastElementIndex = -1;
    
    public Stack(int sizeH, int sizeW)
    {
        StackX = new int[sizeH * sizeW];
        StackY = new int[sizeW * sizeH];
    }
    
    public void push(int LocX, int LocY)
    {
        stackLastElementIndex++;
        StackX[stackLastElementIndex] = LocX;
        StackY[stackLastElementIndex] = LocY;
    }
    
    public int peekX()
    {
        return StackX[stackLastElementIndex];
    }
    
    public int peekY(boolean DecrementSP)
    {
        int ret = StackY[stackLastElementIndex];
        if (DecrementSP) stackLastElementIndex--;
        return ret;
    }
    
    public void lowerSP()
    {
        stackLastElementIndex--;
    }
    
}
