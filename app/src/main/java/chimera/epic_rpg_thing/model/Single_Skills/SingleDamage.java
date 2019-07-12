package chimera.epic_rpg_thing.model.Single_Skills;

import chimera.epic_rpg_thing.model.ElementalEffect;

public class SingleDamage extends SingleBaseSkill {
    int damageAmount;

    /**
     * Gets the skills damage amount
     * @return
     */
    public int getDamageAmount() {
        return damageAmount;
    }

    /**
     * Sets the skills damage amount
     * @param damageAmount
     */
    public void setDamageAmount(int damageAmount) {
        if(damageAmount < 0) return;
        this.damageAmount = damageAmount;
    }

    public SingleDamage(){
        setName("DEFAULT");
        setHpCost(0);
        setManaCost(0);
        setDamageAmount(0);
        setElementalEffect(new ElementalEffect());
        setDescription("DEFAULT");
    }

    public SingleDamage(String name, int hpCost, int manaCost, int damageAmount, ElementalEffect effect, String description){
        setName(name);
        setHpCost(hpCost);
        setManaCost(manaCost);
        setDamageAmount(damageAmount);
        setElementalEffect(effect);
        setDescription(description);
    }
    @Override
    public void effectHP() {
        getTarget().effectHp(-damageAmount, getElementalEffect(), true);
    }
    @Override
    public void effectBuff() {return;}
}
