/**
 * Tower of Hanoi
 *
 * Refer to the description / example operation below
 * https://www.mathsisfun.com/games/towerofhanoi.html
 *
 * In this exercise, the "stones" are represented by integers. Larger number means bigger stone.
 * Java data structure called Stack is used. It is a collection that is suited for first-in-last-out operation,
 * very similar to a stack of things.
 */


package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Tower of Hanoi");

        int N = 3;

        List<Stack<Integer>> sites = Arrays.asList(new Stack<>(), new Stack<>(), new Stack<>());

        for (int i = N ; i > 0 ; i--) {
            sites.get(0).push(i);
        }

/*
1. Implement printAllSites and printStack functions that prints to the screen in the following format.
  Left most column is the tower number. The tower is printed out sideways. Left is ground, right is the sky.
  0 |-5-4-3-2-1-
  1 |-
  2 |-

  0 |-5-4-3-
  1 |-2-
  2 |-1-

  0 |-5-4-3-
  1 |-2-1-
  2 |-
 */
        printAllSites(sites);




/*
2. Implement verifyStack function. It checks if the given stack does not have any bigger stone on top of a
  smaller stone.
 */
        if (!verifyStack(sites.get(0))) {
            System.out.println("Tower fell down! Don't put a bigger stone on top of a smaller stone!");
        } else {
            System.out.println("Tower 0 is stable!");
        }




/*
3. Implement moveStack function that will be called from moveWholeStack function below. Following is the final output
  when N=3, a Hanoi tower with 3 stones. After each move, the new tower should be verified and this site should be
  printed when it is wrong.

Hello Tower of Hanoi
  0 |-3-2-1-
  1 |-
  2 |-
MOVE 1 from 0 to 2
  0 |-3-2-
  1 |-
  2 |-1-
MOVE 2 from 0 to 1
  0 |-3-
  1 |-2-
  2 |-1-
MOVE 1 from 2 to 1
  0 |-3-
  1 |-2-1-
  2 |-
MOVE 3 from 0 to 2
  0 |-
  1 |-2-1-
  2 |-3-
MOVE 1 from 1 to 0
  0 |-1-
  1 |-2-
  2 |-3-
MOVE 2 from 1 to 2
  0 |-1-
  1 |-
  2 |-3-2-
MOVE 1 from 0 to 2
  0 |-
  1 |-
  2 |-3-2-1-
*/
        moveWholeStack(sites, 0, 2);
    }

    private static void printAllSites(List<Stack<Integer>> sites) {
        for (Stack<Integer> site : sites) {
            printStack(site);
        }
    }

    private static void printStack(Stack<Integer> stack) {
        for (Integer i : stack) { // a way to access each element of the stack one by one
            System.out.print(i + " ");
        }
        System.out.println();
    }



    private static boolean verifyStack(Stack<Integer> stack) {

        return true;
    }


    private static void moveWholeStack(List<Stack<Integer>> stacks, int p1, int p2) {
        moveStack(stacks, stacks.get(p1).size(), p1, p2);
    }

    private static void moveStack(List<Stack<Integer>> stacks, int depth, int p1, int p2) {
        Stack<Integer> stack = stacks.get(1);

        /*
        Some useful operations on Stack...
        - push to put an element on top,
        - peek to have a peek at the top element without removing
        - pop to take the top element and remove from the stack
         */
        printStack(stack);
        stack.push(1);
        printStack(stack);
        stack.push(2);
        printStack(stack);
        System.out.println("Peek: " + stack.peek());
        printStack(stack);
        System.out.println("Pop: " + stack.pop());
        printStack(stack);


        int pt = 3 - p1 - p2; // little trick to find the temporary stack that is not p1 and also not p2
        System.out.println("moveStack: " + p1 + " -> " + p2 + " with temporary stack at " + pt);
    }
}