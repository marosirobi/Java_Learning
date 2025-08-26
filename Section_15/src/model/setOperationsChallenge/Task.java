package model.setOperationsChallenge;


public class Task implements Comparable<Task>{

    private String assignee;
    private String projectName;
    private String desc;
    private Status currentStatus;
    private Priority priority;

    public Task(String projectName, String desc) {
        this.projectName = projectName;
        this.desc = desc;
    }

    public String getAssignee() {
        return assignee;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getDesc() {
        return desc;
    }

    public Status getCurrentStatus() {
        return currentStatus;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setCurrentStatus(Status currentStatus) {
        this.currentStatus = currentStatus;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "%-20s %-25s %-10s %-5s".formatted(projectName,desc,String.valueOf(priority),String.valueOf(currentStatus));
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;
        return getProjectName().equals(task.getProjectName()) && getDesc().equals(task.getDesc());
    }

    @Override
    public int hashCode() {
        int result = getProjectName().hashCode();
        result = 31 * result + getDesc().hashCode();
        return result;
    }

    @Override
    public int compareTo(Task o) {
        int result = this.getProjectName().compareTo(o.getProjectName());
        if(result == 0){
            result = this.desc.compareTo(o.desc);
        }
        return result;
    }
}
