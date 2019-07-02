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
    public SingleBuff(){
        setHpCost(0);
        setManaCost(0);
        setBuff(new Benefit());
        setElementalEffect(new ElementalEffect());
        setDescription(null);
    }
    public SingleBuff(int hpCost, int manaCost, Benefit buff, ElementalEffect effect, String description){
        setHpCost(hpCost);
        setManaCost(manaCost);
        setBuff(buff);
        setElementalEffect(effect);
        setDescription(description);
    }

    @Override
    public void effectTargets() {
        getTarget().effectBuff(buff, true);
    }
}
