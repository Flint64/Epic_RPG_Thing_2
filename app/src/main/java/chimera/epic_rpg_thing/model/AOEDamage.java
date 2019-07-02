package chimera.epic_rpg_thing.model;

public class AOEDamage extends AOEBaseSkill {
    int damageAmount;
    AOEDamage(int hpCost, int manaCost, int damageAmount, ElementalEffect effect, int maxTargets, String description){
        this.setHpCost(hpCost);
        this.setManaCost(manaCost);
        this.damageAmount = damageAmount;
        this.setElementalEffect(effect);
        this.setMaxTargets(maxTargets);
        this.setDescription(description);
    }
    @Override
    public void effectTargets() {
        for(Creature c : this.getTargets()){

        }
    }
}
