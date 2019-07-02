package chimera.epic_rpg_thing.model.Classes;

import chimera.epic_rpg_thing.model.ElementalEffect;
import chimera.epic_rpg_thing.model.ElementalType;

public class WizardClass extends CharacterClass {
    private ElementalEffect preferredElement;
    public WizardClass(){
        this.classLevel = 0;
        this.setName("Wizard");
        this.addClassMod("hpMulti", 2);
        this.addClassMod("manaMulti", 10);
        this.addWeaknesses(new ElementalEffect(ElementalType.PHYSICAL, (short)1));
        initializeSkills();
    }

    public ElementalEffect getPreferredElement() {
        return preferredElement;
    }

    public void setPreferredElement(ElementalEffect preferredElement) {
        this.preferredElement = preferredElement;
    }

    /**
     * Initialize the skills fo the Wizard Class.
     */
    private void initializeSkills(){

    }
}
