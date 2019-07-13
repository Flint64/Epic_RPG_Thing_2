package chimera.epic_rpg_thing.model.Single_Skills;

import chimera.epic_rpg_thing.model.Benefit;
import chimera.epic_rpg_thing.model.ElementalEffect;

public class SingleHeal_Buff extends SingleBaseSkill {
    private final String CLASSNAME;
    int healAmount;
    Benefit buff;

    public String getCLASSNAME(){
        return CLASSNAME;
    }
    public int getHealAmount() {
        return healAmount;
    }

    public void setHealAmount(int healAmount) {
        this.healAmount = healAmount;
    }

    public Benefit getBuff() {
        return buff;
    }

    public void setBuff(Benefit buff) {
        this.buff = buff;
    }

    @Override
    public void effectHP() {
        getTarget().effectHp(healAmount, getElementalEffect(), false);
    }
    @Override
    public void effectBuff(){
        getTarget().effectBuff(buff);
    }

    public SingleHeal_Buff(){
        CLASSNAME = getClass().getName();
        setName("DEFAULT");
        setHpCost(0);
        setManaCost(0);
        setHealAmount(0);
        setBuff(new Benefit());
        setElementalEffect(new ElementalEffect());
        setDescription("DEFAULT");
    }

    public SingleHeal_Buff(String name, int hpCost, int manaCost, int healAmount, Benefit buff, ElementalEffect effect, String description){
        CLASSNAME = getClass().getName();
        setName(name);
        setHpCost(hpCost);
        setManaCost(manaCost);
        setHealAmount(healAmount);
        setBuff(buff);
        setElementalEffect(effect);
        setDescription(description);
    }
}
