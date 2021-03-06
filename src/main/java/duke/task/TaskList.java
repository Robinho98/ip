package duke.task;

import java.util.ArrayList;

import duke.common.DukeException;

/**
 * Represents all of the users tasks in a list.
 */
public class TaskList {
    private ArrayList<Task> tasks;

    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Adds a task to the task list.
     * @param task The task to be added.
     */
    public void addTask(Task task) {
        tasks.add(task);
    }

    /**
     * Deletes a task to the task list.
     * @param taskindex The index of the task to be deleted in the task list.
     */
    public void deleteTask(int taskindex) {
        tasks.remove(taskindex);
    }

    /**
     * Marks a task in the task list as done.
     * @param taskindex The index of the task in the task list that is to be marked as done.
     */
    public void markAsDone(int taskindex) {
        tasks.get(taskindex).markAsDone();
    }

    /**
     * Adds a tag to a task.
     * @param taskindex The index of the task in the task list that a tag is to be added to.
     */
    public void setTag(int taskindex, String tagDescription) {
        tasks.get(taskindex).setTag(tagDescription);
    }

    /**
     * Returns current task list.
     * @return current task list.
     */
    public ArrayList<Task> getList() {
        return tasks;
    }

    /**
     * Gets a task to the task list.
     * @param taskindex The index of the task to get in the task list.
     */
    public Task getTask(int taskindex) {
        return tasks.get(taskindex);
    }

    /**
     * Returns number of tasks in the task list.
     * @return number of tasks.
     */
    public int getSize() {
        return tasks.size();
    }

    /**
     * Returns if task list is empty or not.
     * @return boolean if task list is empty or not.
     */
    public boolean isEmpty() {
        return tasks.isEmpty();
    }

    /**
     * Filters for tasks that contain the keyword.
     * @return tasks that contains the keyword in an array list.
     */
    public ArrayList<Task> findTask(String keyword) throws DukeException {
        ArrayList<Task> result = new ArrayList<>();
        if (!keyword.isEmpty()) {
            for (Task task : tasks) {
                if (task.hasKeyword(keyword)) {
                    result.add(task);
                }
            }
        } else {
            throw new DukeException("Keyword is left blank.");
        }
        return result;
    }
}
