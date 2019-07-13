package chimera.epic_rpg_thing.model.Single_Skills;

import chimera.epic_rpg_thing.model.Benefit;
import chimera.epic_rpg_thing.model.ElementalEffect;

public class SingleDebuff extends SingleBaseSkill {
    private final String CLASSNAME;
    Benefit debuff;

    /**
     * Gets the debuff
     * @return
     */
    public Benefit getDebuff() {
        return debuff;
    }

    /**
     * Sets the debuff
     * @param debuff
     */
    public void setDebuff(Benefit debuff) {
        this.debuff = debuff;
    }

    public SingleDebuff(){
        CLASSNAME = getClass().getName();
        setName("DEFAULT");
        setHpCost(0);
        setManaCost(0);
        setDebuff(new Benefit());
        setElementalEffect(new ElementalEffect());
        setDescription("DEFAULT");
    }

    public SingleDebuff(String name, int hpCost, int manaCost, Benefit debuff, ElementalEffect effect, String description){
        CLASSNAME = getClass().getName();
        setName(name);
        setHpCost(hpCost);
        setManaCost(manaCost);
        setDebuff(debuff);
        setElementalEffect(effect);
        setDescription(description);
    }
    public String getCLASSNAME(){
        return CLASSNAME;
    }
    @Override
    public void effectBuff() {
        getTarget().effectBuff(debuff);
    }
    @Override
    public void effectHP(){return;}
}
