package chimera.epic_rpg_thing.model;

public class AOEFactory {
    public static AOEBaseSkill create(String skillName, int hpCost, int manaCost, int effectAmount, Benefit benefit, ElementalEffect effect, String description, int maxTargets){
        if(skillName.equals("AOEDamage")){

        }else if(skillName.equals("AOEHeal")){
            return new AOEHeal(hpCost, manaCost, effectAmount, effect, maxTargets, description);
        }else if(skillName.equals("AOEBuff")){

        }else if(skillName.equals("AOEDebuff")){

        }else if(skillName.equals("AOEDamage_Debuff")){

        }
        return null;
    }
}
