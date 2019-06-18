package chimera.epic_rpg_thing.presenter;

import java.util.List;

import chimera.epic_rpg_thing.model.Character;
import chimera.epic_rpg_thing.model.User;

public class CharacterPresenter {
    private User user;

    public CharacterPresenter(GamePresenter presenter){
        user = presenter.getUser();
    }

    public List<Character> getCharacters(){
        return user.getCharacters();
    }

    public void addCharacter(Character c) { user.addCharacter(c);}
}
