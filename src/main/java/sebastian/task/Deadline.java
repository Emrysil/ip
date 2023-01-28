package sebastian.task;

import java.time.LocalDate;

import sebastian.time.EndTime;



/**
 * Class representing a deadline
 */
public class Deadline extends Task {

    private static final String taskType = "D";

    private EndTime endTime;

    /**
     * Constructor
     * @param isCompleted whether the deadline is completed; 0 for not completed, 1 for completed
     * @param taskDescription description of the deadline
     * @param endTime the time the deadline is due
     */
    public Deadline(int isCompleted, String taskDescription, EndTime endTime) {
        super(taskDescription, isCompleted);
        this.endTime = endTime;
    }

    /**
     * Checked if the deadline is on the same day as the provided date
     * @param ld a date
     * @return whether the deadline is on the same day as the provided date
     */
    public boolean isOnSameDay(LocalDate ld) {
        return endTime.isSameDay(ld);
    }

    @Override
    public String toString() {
        return "[" + taskType + "]" + super.toString() + " " + this.endTime.toString();
    }

    /**
     * Format the deadline into a suitable String representation to be written to the hard disk
     * @return the formatted String representation
     */
    @Override
    public String formatForSave() {
        return taskType + "<>" + super.formatForSave() + "<>" + endTime.formatForSave();
    }
}
