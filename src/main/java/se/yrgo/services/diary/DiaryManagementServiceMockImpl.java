package se.yrgo.services.diary;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import se.yrgo.domain.Action;

public class DiaryManagementServiceMockImpl implements DiaryManagementService {

    private final Set<Action> allActions = new HashSet<Action>();

    @Override
    public void recordAction(Action action) {
        System.out.println("Call diary: " + action.getDetails());
        allActions.add(action);
    }

    //Hint:
    //Create a list<Action>
    //In the for each loop going through the list use this condition: "if(action.getOwningUser().equals(requiredUser) && !action.isComplete())" to add a new action to the list.
    public List<Action> getAllIncompleteActions(String requiredUser) {
        List<Action> incompleteActions = new ArrayList<>();

        for (Action action : allActions) {
            if (action.getOwningUser().equals(requiredUser) && !action.isComplete()) {
                incompleteActions.add(action);
            }
        }
        return incompleteActions;
    }

}
