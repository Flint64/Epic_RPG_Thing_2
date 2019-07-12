package chimera.epic_rpg_thing.model.Single_Skills;

import chimera.epic_rpg_thing.model.Benefit;
import chimera.epic_rpg_thing.model.ElementalEffect;

public class SingleBuff extends SingleBaseSkill {
    Benefit buff;

    public Benefit getBuff() {
        return buff;
    }

    public void setBuff(Benefit buff) {
        this.buff = buff;
    }

    /**
     * SingleBuff Default Constructor
     */
    public SingleBuff(){
        setName("DEFAULT");
        setHpCost(0);
        setManaCost(0);
        setBuff(new Benefit());
        setElementalEffect(new ElementalEffect());
        setDescription(null);
    }

    /**
     * SingleBuff Non-Default Constructor
     * @param hpCost
     * @param manaCost
     * @param buff
     * @param effect
     * @param description
     */
    public SingleBuff(String name, int hpCost, int manaCost, Benefit buff, ElementalEffect effect, String description){
        setName(name);
        setHpCost(hpCost);
        setManaCost(manaCost);
        setBuff(buff);
        setElementalEffect(effect);
        setDescription(description);
    }

    @Override
    public void effectBuff() {
        getTarget().effectBuff(buff);
    }
    public void effectHP(){return;}
}
