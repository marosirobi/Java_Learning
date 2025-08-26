package model.setOperationsChallenge;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TaskData {

    public static Set<Task> getTask(String whichEmployee) throws FileNotFoundException {

        Set<Task> setOfTasks = new HashSet<>();
        List<String> allTasks = new ArrayList<>();
        Scanner sc = new Scanner(new File("C:\\Users\\maros\\IdeaProjects\\Java_Learning\\Section_15\\src\\model\\setOperationsChallenge\\SetsOperationsData.csv"));

        int firstTaskIndex = 1;


        while(sc.hasNextLine()){
            String line = sc.nextLine();
            if(line.contains(whichEmployee))
                firstTaskIndex = allTasks.size() + 1;
            if(!line.trim().isEmpty())
                allTasks.add(line);
        }

        int lastTaskIndex = allTasks.size();

        for(int i = firstTaskIndex; i < allTasks.size(); i++){
            if(allTasks.get(i).contains("'s Tasks")){
                lastTaskIndex = i;
                break;
            }
        }

        for(int i = firstTaskIndex; i < lastTaskIndex; i++){
            String[] array = allTasks.get(i).split(",");
            Arrays.asList(array).replaceAll(String::trim);
            Task newTask = new Task(array[0],array[1]);
            String name = allTasks.get(firstTaskIndex - 1).split(" ")[0].trim();
            newTask.setAssignee(name.contains("'s") ? name.substring(0,name.length()-2) : name);

            if(array.length >= 3)
                newTask.setPriority(Priority.valueOf(array[2].toUpperCase()));
            if (array.length >= 4) {
                newTask.setCurrentStatus(array[3].contains("In Progress") ? Status.IN_PROGRESS : null);
            }else{
                newTask.setCurrentStatus(newTask.getAssignee().equals("All") ? Status.NOT_YET_ASSIGNED : Status.ASSIGNED);
            }

            setOfTasks.add(newTask);
        }

        return setOfTasks;
    }
}
