package chimera.epic_rpg_thing.model.Single_Skills;

import chimera.epic_rpg_thing.model.ElementalEffect;

public class SingleHeal extends SingleBaseSkill {
    private final String CLASSNAME;
    int healAmount;

    public int getHealAmount() {
        return healAmount;
    }

    public void setHealAmount(int healAmount) {
        this.healAmount = healAmount;
    }

    public String getCLASSNAME(){
        return CLASSNAME;
    }
    public SingleHeal(){
        CLASSNAME = getClass().getName();
        setName("DEFAULT");
        setHpCost(0);
        setManaCost(0);
        setHealAmount(0);
        setElementalEffect(new ElementalEffect());
        setDescription("DEFAULT");
    }

    public SingleHeal(String name, int hpCost, int manaCost, int healAmount, ElementalEffect effect, String description){
        CLASSNAME = getClass().getName();
        setName(name);
        setHpCost(hpCost);
        setManaCost(manaCost);
        setHealAmount(healAmount);
        setElementalEffect(effect);
        setDescription(description);
    }

    @Override
    public void effectHP() {
        getTarget().effectHp(healAmount, getElementalEffect(), false);
    }
    @Override
    public void effectBuff(){
        return;
    }
}
