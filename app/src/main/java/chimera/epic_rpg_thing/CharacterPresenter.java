package chimera.epic_rpg_thing;

import java.util.List;

public class CharacterPresenter {
    private User user;

    public CharacterPresenter(Game presenter){
        user = presenter.getUser();
    }

    public List<Character> getCharacters(){
        return user.getCharacters();
    }
}
