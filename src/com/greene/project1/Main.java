package com.greene.project1;

import java.util.Scanner;

public class Main
{
    static String[] add(String[] tasks, String newTask)
    {
        String[] newTasks = new String[tasks.length + 1];
        for (int i = 0; i < tasks.length; i++) {
            newTasks[i] = tasks[i];
        }
        newTasks[(newTasks.length - 1)] = newTask;
        return newTasks;
    }

    static String[] remove(String[] tasks, int index) {
        if ((index < 0) || (index >= tasks.length)) {
            return tasks;
        }
        String[] newTasks = new String[tasks.length - 1];
        for (int i = 0; i < tasks.length; i++) {
            if (i < index) {
                newTasks[i] = tasks[i];
            }
            else if (i != index)
            {
                newTasks[(i - 1)] = tasks[i];
            }
        }
        return newTasks;
    }

    static void update(String[] tasks, int index, String newTask) {
        if ((index < 0) || (index >= tasks.length)) {
            return;
        }
        tasks[index] = newTask;
    }

    static void list(String[] tasks)
    {
        for (int i = 0; i < tasks.length; i++)
            System.out.println(i + ". " + tasks[i]);
    }

    public static void main(String[] args)
    {
        String[] tasks = new String[0];
        Boolean loop = Boolean.valueOf(true);
        Scanner scanner = new Scanner(System.in);

        while (loop.booleanValue()) {
            System.out.println("Please choose an option:");
            System.out.println("(1) Add a task.");
            System.out.println("(2) Remove a task.");
            System.out.println("(3) Update a task.");
            System.out.println("(4) List all tasks.");
            System.out.println("(0) Exit.");

            String input = scanner.nextLine();
            switch (input) {

                case "1":
                    System.out.println("Enter a description of the new task.");
                    String newTask = scanner.nextLine();
                    tasks = add(tasks, newTask);
                    break;

                case "2":
                    list(tasks);
                    System.out.println("Enter the index of the task to remove.");
                    int index = Integer.parseInt(scanner.nextLine());
                    tasks = remove(tasks, index);
                    break;

                case "3":
                    list(tasks);
                    System.out.println("Enter the index of the task to update.");
                    index = Integer.parseInt(scanner.nextLine());
                    System.out.println("Enter the new description of the task.");
                    newTask = scanner.nextLine();
                    update(tasks, index, newTask);
                    break;

                case "4":
                    list(tasks);
                    break;

                case "0":
                    loop = Boolean.valueOf(false);
            }
        }
    }
}