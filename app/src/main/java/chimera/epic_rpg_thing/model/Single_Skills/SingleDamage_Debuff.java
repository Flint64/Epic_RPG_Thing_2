package chimera.epic_rpg_thing.model.Single_Skills;

import chimera.epic_rpg_thing.model.Benefit;
import chimera.epic_rpg_thing.model.ElementalEffect;

public class SingleDamage_Debuff extends SingleBaseSkill {
    private final String CLASSNAME;
    int damageAmount;
    Benefit debuff;

    public int getDamageAmount() {
        return damageAmount;
    }

    public void setDamageAmount(int damageAmount) {
        this.damageAmount = damageAmount;
    }

    public Benefit getDebuff() {
        return debuff;
    }

    public void setDebuff(Benefit debuff) {
        this.debuff = debuff;
    }
    public String getCLASSNAME(){
        return CLASSNAME;
    }
    /**
     * Default Constructor for SingleDamage_Debuff
     */
    public SingleDamage_Debuff(){
        CLASSNAME = getClass().getName();
        setName("DEFAULT");
        setHpCost(0);
        setManaCost(0);
        setDamageAmount(0);
        setDebuff(new Benefit());
        setElementalEffect(new ElementalEffect());
        setDescription("DEFAULT");
    }

    /**
     * Non-Default Constructor for the SingleDamage_Buff
     * @param hpCost
     * @param manaCost
     * @param damageAmount
     * @param debuff
     * @param effect
     * @param description
     */
    public SingleDamage_Debuff(String name, int hpCost, int manaCost, int damageAmount, Benefit debuff, ElementalEffect effect, String description){
        CLASSNAME = getClass().getName();
        setName(name);
        setHpCost(hpCost);
        setManaCost(manaCost);
        setDamageAmount(damageAmount);
        setDebuff(debuff);
        setElementalEffect(effect);
        setDescription(description);
    }

    @Override
    public void effectHP() {
        getTarget().effectHp(-damageAmount, getElementalEffect(), true);
    }
    @Override
    public void effectBuff(){
        getTarget().effectBuff(debuff);
    }
}
