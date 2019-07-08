package chimera.epic_rpg_thing.presenter;

import chimera.epic_rpg_thing.model.Monster;
import chimera.epic_rpg_thing.model.Story;
import chimera.epic_rpg_thing.model.User;

public class GamePresenter {
    User user;
    Monster monster[] = new Monster[4];
    Story story;

    public User getUser(){
        return user;
    }
}
