package chimera.epic_rpg_thing.presenter;

import java.util.List;
import java.util.ArrayList;

import chimera.epic_rpg_thing.model.Monster;
import chimera.epic_rpg_thing.model.Story;
import chimera.epic_rpg_thing.model.User;

public class CombatPresenter {
    User user = new User();
    List<Character> party = new ArrayList<Character>(3);
    Monster monster[] = new Monster[4];
    Story story;
    public void onLoad(){
    }
    public User getUser(){
        return user;
    }
}
