package chimera.epic_rpg_thing.model;

import java.util.ArrayList;
import java.util.List;

public class CharacterStorage {
    List<String> names;
    public CharacterStorage(){
        names = new ArrayList<>();
    }
    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }
}
