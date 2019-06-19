package chimera.epic_rpg_thing.presenter;

import java.util.ArrayList;
import java.util.List;

import chimera.epic_rpg_thing.model.Character;
import chimera.epic_rpg_thing.model.Skill;
import chimera.epic_rpg_thing.model.User;
import chimera.epic_rpg_thing.model.WarriorClass;

public class CharacterPresenter {
    private User user;

    public CharacterPresenter(GamePresenter presenter){
        user = presenter.getUser();
    }

    public List<Character> getCharacters(){
        return user.getCharacters();
    }

    public void addCharacter(Character c) { user.addCharacter(c);}

    List<Skill> list = new ArrayList<>();
    WarriorClass warriorClass = new WarriorClass();
    Character character = new Character(list, (short)10, (short) 5, (short) 0, "Kal-El", warriorClass );
}
