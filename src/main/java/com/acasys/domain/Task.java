package com.acasys.domain;

public class Task {
   public int idtask;
   public int courseid;
   public String taskname;
   public String tasktype;
   public String fromdate;
   public String enddate;
   public String detail;

    @Override
    public String toString() {
        return "Task{" +
                "idtask=" + idtask +
                ", courseid=" + courseid +
                ", task_name='" + taskname + '\'' +
                ", task_type='" + tasktype + '\'' +
                ", from_date='" + fromdate + '\'' +
                ", end_date='" + enddate + '\'' +
                ", detail='" + detail + '\'' +
                '}';
    }

    public int getIdtask() {
        return idtask;
    }

    public void setIdtask(int idtask) {
        this.idtask = idtask;
    }

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public String getTask_name() {
        return taskname;
    }

    public void setTask_name(String task_name) {
        this.taskname = task_name;
    }

    public String getTask_type() {
        return tasktype;
    }

    public void setTask_type(String task_type) {
        this.tasktype = task_type;
    }

    public String getFrom_date() {
        return fromdate;
    }

    public void setFrom_date(String from_date) {
        this.fromdate = from_date;
    }

    public String getEnd_date() {
        return enddate;
    }

    public void setEnd_date(String end_date) {
        this.enddate = end_date;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
