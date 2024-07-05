import java.util.Arrays;

public class TaskManager {
    private static final int MAX_TASKS = 100;
    private String[] developers = new String[MAX_TASKS];
    private String[] taskNames = new String[MAX_TASKS];
    private int[] taskIDs = new int[MAX_TASKS];
    private int[] taskDurations = new int[MAX_TASKS];
    private String[] taskStatuses = new String[MAX_TASKS];
    private int numTasks = 0;

    public void addTask(String developer, String taskName, int taskDuration, String taskStatus) {
        developers[numTasks] = developer;
        taskNames[numTasks] = taskName;
        taskIDs[numTasks] = numTasks + 1;
        taskDurations[numTasks] = taskDuration;
        taskStatuses[numTasks] = taskStatus;
        numTasks++;
    }

    // Method to display all tasks with status "Done"
    public void displayDoneTasks() {
        System.out.println("Tasks with status 'Done':");
        for (int i = 0; i < numTasks; i++) {
            if (taskStatuses[i].equalsIgnoreCase("Done")) {
                System.out.println("Developer: " + developers[i] + ", Task Name: " + taskNames[i] + ", Duration: " + taskDurations[i]);
            }
        }
    }

    public void displayTaskWithLongestDuration() {
        int longestDuration = -1;
        int longestIndex = -1;
        for (int i = 0; i < numTasks; i++) {
            if (taskDurations[i] > longestDuration) {
                longestDuration = taskDurations[i];
                longestIndex = i;
            }
        }
        if (longestIndex != -1) {
            System.out.println("Developer with longest duration: " + developers[longestIndex] + ", Duration: " + taskDurations[longestIndex]);
        }
    }

    // Method to search for a task by name and display details
    public void searchTaskByName(String taskName) {
        for (int i = 0; i < numTasks; i++) {
            if (taskNames[i].equalsIgnoreCase(taskName)) {
                System.out.println("Task Name: " + taskNames[i] + ", Developer: " + developers[i] + ", Status: " + taskStatuses[i]);
                return;
            }
        }
        System.out.println("Task with name '" + taskName + "' not found.");
    }

    public void searchTasksByDeveloper(String developer) {
        System.out.println("Tasks assigned to " + developer + ":");
        for (int i = 0; i < numTasks; i++) {
            if (developers[i].equalsIgnoreCase(developer)) {
                System.out.println("Task Name: " + taskNames[i] + ", Status: " + taskStatuses[i]);
            }
        }
    }

    public void deleteTaskByName(String taskName) {
        for (int i = 0; i < numTasks; i++) {
            if (taskNames[i].equalsIgnoreCase(taskName)) {
                // Shift elements to the left to overwrite the deleted task
                for (int j = i; j < numTasks - 1; j++) {
                    developers[j] = developers[j + 1];
                    taskNames[j] = taskNames[j + 1];
                    taskIDs[j] = taskIDs[j + 1];
                    taskDurations[j] = taskDurations[j + 1];
                    taskStatuses[j] = taskStatuses[j + 1];
                }
                numTasks--;
                System.out.println("Entry '" + taskName + "' successfully deleted.");
                return; // Assuming task names are unique, exit after deleting the first match
            }
        }
        System.out.println("Task with name '" + taskName + "' not found.");
    }

    public void displayFullReport() {
        System.out.println("Full Task Report:");
        for (int i = 0; i < numTasks; i++) {
            System.out.println("Task ID: " + taskIDs[i] + ", Developer: " + developers[i] + ", Task Name: " + taskNames[i] + ", Duration: " + taskDurations[i] + ", Status: " + taskStatuses[i]);
        }
    }

    public String[] getDevelopers() {
        return Arrays.copyOf(developers, numTasks);
    }

    public int[] getTaskDurations() {
        return Arrays.copyOf(taskDurations, numTasks);
    }

    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();

        taskManager.addTask("Mike Smith", "Create Login", 5, "To Do");
        taskManager.addTask("Edward Harrison", "Create Add Features", 8, "Doing");
        taskManager.addTask("Samantha Paulson", "Create Reports", 2, "Done");
        taskManager.addTask("Glenda Oberholzer", "Add Arrays", 11, "To Do");

        System.out.println("Displaying tasks with status 'Done':");
        taskManager.displayDoneTasks();

        System.out.println("\nDisplaying developer and duration of the task with longest duration:");
        taskManager.displayTaskWithLongestDuration();

        System.out.println("\nSearching for task with name 'Create Login':");
        taskManager.searchTaskByName("Create Login");

        System.out.println("\nSearching for all tasks assigned to developer 'Samantha Paulson':");
        taskManager.searchTasksByDeveloper("Samantha Paulson");

        System.out.println("\nDeleting task with name 'Create Reports':");
        taskManager.deleteTaskByName("Create Reports");

        System.out.println("\nDisplaying full task report:");
        taskManager.displayFullReport();
    }
}
